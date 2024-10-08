package org.jeecg.modules.sso;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.exception.JeecgBootException;
import org.jeecg.common.util.OkHttpUtils;
import org.jeecg.common.util.PasswordUtil;
import org.jeecg.common.util.SpringContextUtils;
import org.jeecg.common.util.TypeConvertUtils;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.sso.service.ISsoService;
import org.jeecg.modules.system.entity.SysDepart;
import org.jeecg.modules.system.entity.SysPosition;
import org.jeecg.modules.system.entity.SysRole;
import org.jeecg.modules.system.entity.SysUser;
import org.jeecg.modules.system.service.ISysDepartService;
import org.jeecg.modules.system.service.ISysPositionService;
import org.jeecg.modules.system.service.ISysRoleService;
import org.jeecg.modules.system.service.ISysUserService;
import org.jeecg.modules.system.util.WebUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

/**
 * 交换过程为：推送角色、获取部门、获取职务、获取用户
 * <p>Created by Raofeicheng on 2023/4/17.</p>
 * @author Raofeicheng
 * @version 1.0
 */
@Slf4j
public class SsoUtils {

	public static void syncAll() {
		Result<Object> result;
		Timestamp updateTime;
		log.info("==== 同步开始 ====");
		String zsxt = "zsxt";
		String[] array = {zsxt};

		for (String subSys : array) {
			log.info("--- " + subSys + ":角色同步开始 ---");
			execLog(syncRole(subSys));
			log.info("--- " + subSys + ":角色同步结束 ---");
		}

		log.info("--- 部门同步开始 ---");
		execLog(syncDepart(zsxt));
		log.info("--- 部门同步结束 ---");

		log.info("--- 职务同步开始 ---");
		updateTime = getPositionService().getMaxRemoteUpdateTime();
		execLog(syncPosition(zsxt, updateTime));
		log.info("--- 职务同步结束 ---");

		updateTime = getUserService().getMaxRemoteUpdateTime();
		for (String subSys : array) {
			log.info("--- " + subSys + ":用户同步开始 ---");
			execLog(syncUser(subSys, updateTime));
			log.info("--- " + subSys + ":用户同步结束 ---");
		}

		log.info("==== 同步结束 ====");
	}

	public static <T> Result<T> syncRole(String subSys) {
		String error = null;
		JSONArray array = new JSONArray();
		for (SysRole item : getRoleService().list()) {
			JSONObject json = new JSONObject();
			json.put("code", item.getRoleCode());
			json.put("name", item.getRoleName());
			json.put("describes", item.getDescription());
			json.put("sort", 99);
			array.add(json);
		}
		try {
			call(subSys, "/oauth2/data/role", null, array);
			return Result.ok(subSys + "：角色成功推送 " + array.size() + " 条。");
		} catch (Exception e) {
			return Result.error(subSys + "：推送角色失败: " + StringUtils.defaultIfBlank(e.getMessage(), "接口未说明失败原因"), e);
		}
	}

	public static <T> Result<T> syncDepart(String subSys) {
		JSONObject json;
		try {
			json = call(subSys, "/oauth2/data/depart", null, null);
		} catch (Exception e) {
			return Result.error(subSys + "：调用部门接口失败: " + StringUtils.defaultIfBlank(e.getMessage(), "接口未说明失败原因"), e);
		}
		try {
			String msg = getSsoService().saveDepart(json.getJSONArray("result"), new SsoContext().initDepart());
			return Result.ok(subSys + "：部门成功同步，" + msg);
		} catch (Exception e) {
			return Result.error(subSys + "：同步部门失败: " + StringUtils.defaultIfBlank(e.getMessage(), "接口未说明失败原因"), e);
		}
	}

	public static <T> Result<T> syncPosition(String subSys, Timestamp updateTime) {
		String error = null;
		Map<String, String> params = new HashMap<>();
		if (null != updateTime) params.put("updateTime", DateFormatUtils.format(updateTime, CommonConstant.FORMAT_DATE_TIME));
		JSONObject json;
		try {
			json = call(subSys, "/oauth2/data/position", params, null);
		} catch (Exception e) {
			return Result.error(subSys + "：调用职务接口失败: " + StringUtils.defaultIfBlank(e.getMessage(), "接口未说明失败原因"), e);
		}
		try {
			String msg = getSsoService().savePosition(json.getJSONArray("result"), new SsoContext().initPosition());
			return Result.ok(subSys + "：职务成功同步，" + msg);
		} catch (Exception e) {
			return Result.error(subSys + "：同步职务失败: " + StringUtils.defaultIfBlank(e.getMessage(), "接口未说明失败原因"), e);
		}
	}

	public static <T> Result<T> syncUser(String subSys, Timestamp updateTime) {
		String error = null;
		Map<String, String> params = new HashMap<>();
		if (null != updateTime) params.put("updateTime", DateFormatUtils.format(updateTime, CommonConstant.FORMAT_DATE_TIME));
		JSONObject json;
		try {
			json = call(subSys, "/oauth2/data/user", params, null);
		} catch (Exception e) {
			return Result.error(subSys + "：调用用户接口失败: " + StringUtils.defaultIfBlank(e.getMessage(), "接口未说明失败原因"), e);
		}
		try {
			String msg = getSsoService().saveUser(json.getJSONArray("result"), new SsoContext(false, false, false, null == updateTime));
			return Result.ok(subSys + "：用户成功同步，" + msg);
		} catch (Exception e) {
			return Result.error(subSys + "：同步用户失败: " + StringUtils.defaultIfBlank(e.getMessage(), "接口未说明失败原因"), e);
		}
	}

	public static JSONObject call(String subSys, String path, Map<String, String> urlParams, JSON reqContent) {
		String url = "http://192.168.0.233/UIAS-api", appid = "1822181628894519297", secret = "IqrNvlVLGzJSIyFae7b7nSjxooxYxasz";
		if (StringUtils.isBlank(url)) throw new JeecgBootException(subSys + ":未设置的接口url");
		if (StringUtils.isBlank(appid)) throw new JeecgBootException(subSys + ":未设置的接口appid");
		if (StringUtils.isBlank(secret)) throw new JeecgBootException(subSys + ":未设置的接口secret");
		if (url.endsWith("/")) url = url.substring(0, url.length() - 1);
		if (!path.startsWith("/")) path = "/" + path;
		WebUtils.UrlParamBuilder paramBuilder = WebUtils.param("appid", appid).put("secret", secret);
		if (MapUtils.isNotEmpty(urlParams)) {
			for (Map.Entry<String, String> entry : urlParams.entrySet()) {
				paramBuilder.put(entry.getKey(), entry.getValue());
			}
		}
		url += path + "?" + paramBuilder.getValue();
		String res;
		try {
			if (null != reqContent) res = OkHttpUtils.post(url, reqContent.toJSONString(), null, null);
			else res = OkHttpUtils.getJson(url);
		} catch (Exception e) {
			throw new JeecgBootException(subSys + ":接口调用失败：" + StringUtils.defaultIfBlank(e.getMessage(), e.getClass().getName()), e);
		}
		JSONObject json;
		try {
			json = JSON.parseObject(res);
		} catch (Exception e) {
			throw new JeecgBootException(subSys + ":接口返回值解析失败：" + res, e);
		}
		if (json.getBooleanValue("success")) return json;
		throw new JeecgBootException(subSys + ":" + StringUtils.defaultIfBlank(json.getString("message"), "接口未说明失败原因"));
	}

	public static SysUser findUser(JSONObject json, SsoContext ctx) {
		SysUser bean = ctx.getUserById(json.getString("userId"));
		if (null == bean) ctx.getUserByUsername(json.getString("username"));
		return bean;
	}

	public static SysUser writeUserInfo(SysUser target, Collection<String> roles, Collection<String> departs, JSONObject json) {
		return writeUserInfo(target, roles, departs, json, null);
	}

	public static SysUser writeUserInfo(SysUser target, Collection<String> roles, Collection<String> departs, JSONObject json, SsoContext ctx) {
		if (null == ctx) ctx = new SsoContext();
		target.setUsername(json.getString("username"));
		if (StringUtils.isBlank(target.getId())) {
			target.setId(json.getString("userId"));
			target.setSalt(oConvertUtils.randomGen(8));
			target.setPassword(PasswordUtil.encrypt(target.getUsername(), "default@2022!", target.getSalt()));
			target.setCreateBy(DefaultCreateBy);
			target.setCreateTime(new Date());
		} else {
			target.setUpdateBy(DefaultCreateBy);
			target.setUpdateTime(new Date());
		}
		target.setRealname(json.getString("realname"));
		target.setAvatar(json.getString("avatar"));
		target.setBirthday(TypeConvertUtils.toDate(json.getString("birthday"), CommonConstant.FORMAT_DATE_TIME));
		target.setSex(json.getInteger("sex"));
		target.setEmail(json.getString("email"));
		target.setPhone(json.getString("phone"));
		if (StringUtils.isBlank(target.getPhone())) target.setPhone(null);
		target.setTelephone(json.getString("telephone"));
		target.setStatus(TypeConvertUtils.toInteger(json.getString("status"), 1));
		target.setDelFlag(json.getIntValue("delFlag"));
		target.setWorkNo(json.getString("workNo"));
		//target.setSort(json.getInteger("sort"));
		target.setUserIdentity(TypeConvertUtils.toInteger(json.getString("userIdentity"), 1));
		//target.setJobContent(json.getString("jobContent"));
		target.setDepartIds(json.getString("departIds"));
		target.setDelFlag(CommonConstant.DEL_FLAG_0);
		target.setRemoteUpdateTime(TypeConvertUtils.toDate(json.getString("updateTime"), CommonConstant.FORMAT_DATE_TIME));

		JSONArray array = json.getJSONArray("roleList");
		for (int idx = 0; null != array && idx < array.size(); idx++) {
			JSONObject item = array.getJSONObject(idx);
			SysRole role = ctx.getRoleByCode(item.getString("code"));
			if (null != role) roles.add(role.getId());
		}
		array = json.getJSONArray("departList");
		for (int idx = 0; null != array && idx < array.size(); idx++) {
			JSONObject item = array.getJSONObject(idx);
			SysDepart depart = ctx.getDepartByOrgCode(item.getString("orgCode"));
			if (null != depart) departs.add(depart.getId());
		}
		array = json.getJSONArray("postList");
		Set<String> positions = new LinkedHashSet<>();
		for (int idx = 0; null != array && idx < array.size(); idx++) {
			JSONObject item = array.getJSONObject(idx);
			SysPosition position = ctx.getPositionByCode(item.getString("code"));
			if (null != position) positions.add(position.getCode());
		}
		target.setPost(StringUtils.join(positions, ","));
		return target;
	}

	public static <T> boolean execLog(Result<T> result) {
		if (result.isSuccess()) log.info(result.getMessage());
		else log.error(result.getMessage(), result.getException());
		return result.isSuccess();
	}

	public static ISysDepartService getDepartService() {
		if (null == departService) departService = SpringContextUtils.getBean(ISysDepartService.class);
		return departService;
	}

	public static ISysRoleService getRoleService() {
		if (null == roleService) roleService = SpringContextUtils.getBean(ISysRoleService.class);
		return roleService;
	}

	public static ISysPositionService getPositionService() {
		if (null == positionService) positionService = SpringContextUtils.getBean(ISysPositionService.class);
		return positionService;
	}

	public static ISysUserService getUserService() {
		if (null == userService) userService = SpringContextUtils.getBean(ISysUserService.class);
		return userService;
	}

	public static ISsoService getSsoService() {
		if (null == ssoService) ssoService = SpringContextUtils.getBean(ISsoService.class);
		return ssoService;
	}

	private static ISysDepartService departService;
	private static ISysRoleService roleService;
	private static ISysPositionService positionService;
	private static ISysUserService userService;
	private static ISsoService ssoService;

	public static final String DefaultCreateBy = "_SSO_SYNC_";

	@NoArgsConstructor
	public static class SsoContext {

		public final Map<String, SysRole> roleCache = new HashMap<>();
		public final Map<String, SysDepart> departCache = new HashMap<>();
		public final Map<String, SysPosition> positionCache = new HashMap<>();
		public final Map<String, SysUser> userUsernameCache = new HashMap<>();
		public final Map<String, SysUser> userIdCache = new HashMap<>();

		public SsoContext(boolean isInit) {
			this(isInit, isInit, isInit, isInit);
		}

		public SsoContext(boolean isRole, boolean isDepart, boolean isPosition, boolean isUser) {
			if (isRole) initRole();
			if (isDepart) initDepart();
			if (isPosition) initPosition();
			if (isUser) initUser();
		}

		public SsoContext initRole() {
			roleCache.clear();
			for (SysRole item : getRoleService().list()) roleCache.put(item.getRoleCode(), item);
			return this;
		}

		public SsoContext initDepart() {
			departCache.clear();
			for (SysDepart item : getDepartService().list()) departCache.put(item.getOrgCode(), item);
			return this;
		}

		public SsoContext initPosition() {
			positionCache.clear();
			for (SysPosition item : getPositionService().list()) positionCache.put(item.getCode(), item);
			return this;
		}

		public SsoContext initUser() {
			userIdCache.clear();
			userUsernameCache.clear();
			for (SysUser item : getUserService().list()) {
				userIdCache.put(item.getId(), item);
				userUsernameCache.put(item.getUsername(), item);
			}
			return this;
		}

		public SysRole getRoleByCode(String code) {
			if (!roleCache.containsKey(code)) roleCache.put(code, getRoleService().queryByCode(code));
			return roleCache.get(code);
		}

		public SysDepart getDepartByOrgCode(String orgCode) {
			if (!departCache.containsKey(orgCode)) departCache.put(orgCode, getDepartService().queryByOrgCode(orgCode));
			return departCache.get(orgCode);
		}

		public SysPosition getPositionByCode(String code) {
			if (!positionCache.containsKey(code)) positionCache.put(code, getPositionService().getByCode(code));
			return positionCache.get(code);
		}

		public SysUser getUserByUsername(String username) {
			if (!userUsernameCache.containsKey(username))
				userUsernameCache.put(username, getUserService().getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username)));
			return userUsernameCache.get(username);
		}

		public SysUser getUserById(String id) {
			if (!userIdCache.containsKey(id)) userIdCache.put(id, getUserService().getById(id));
			return userIdCache.get(id);
		}

	}

	@Getter
	@Setter(AccessLevel.PRIVATE)
	public static class Result<T> extends org.jeecg.common.api.vo.Result<T> {

		private Throwable exception;

		public static <T> Result<T> ok() {
			return ok(null);
		}

		public static <T> Result<T> ok(String msg) {
			return ok(msg, null);
		}

		public static <T> Result<T> ok(String msg, T data) {
			return ok(null, msg, data);
		}

		public static <T> Result<T> ok(Integer code, String msg, T data) {
			Result<T> r = new Result<>();
			r.setSuccess(true);
			r.setCode(null != code ? code : CommonConstant.SC_OK_200);
			r.setMessage(msg);
			r.setResult(data);
			return r;
		}

		public static <T> Result<T> error(Throwable exception) {
			return error(null, exception.getMessage(), null, exception);
		}

		public static <T> Result<T> error(String msg) {
			return error(null, msg, null, null);
		}

		public static <T> Result<T> error(Integer code, Throwable exception) {
			return error(code, exception.getMessage(), null, exception);
		}

		public static <T> Result<T> error(String msg, Throwable exception) {
			return error(null, msg, null, exception);
		}

		public static <T> Result<T> error(Integer code, String msg, T data, Throwable exception) {
			Result<T> r = new Result<>();
			r.setSuccess(false);
			r.setCode(null != code ? code : CommonConstant.SC_INTERNAL_SERVER_ERROR_500);
			r.setMessage(msg);
			r.setResult(data);
			r.setException(exception);
			return r;
		}

	}

}
