package org.jeecg.modules.system.util;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.SpringContextUtils;
import org.jeecg.modules.system.entity.SysDepart;
import org.jeecg.modules.system.entity.SysPermission;
import org.jeecg.modules.system.service.ISysDepartService;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * <p>Created by Raofeicheng on 2022/10/31.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public class WebUtils {

	public static HttpServletRequest getRequest() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		if (null == requestAttributes) return null;
		if (!(requestAttributes instanceof ServletRequestAttributes)) return null;
		return ((ServletRequestAttributes) requestAttributes).getRequest();
	}

	public static void setCacheByRequest(String key, Object value) {
		Map<String, Object> localCache = getRequestCache();
		if (null != localCache) {
			localCache.put(key, value);
		}
	}

	@SuppressWarnings("unchecked")
	public static <T> T getCacheByRequest(String key) {
		Map<String, Object> localCache = getRequestCache();
		return null != localCache ? (T) localCache.get(key) : null;
	}

	@SuppressWarnings("unchecked")
	public static Map<String, Object> getRequestCache() {
		HttpServletRequest request = getRequest();
		Map<String, Object> localCache = null;
		if (null != request) {
			String name = WebUtils.class.getName() + "_localCache";
			localCache = (Map<String, Object>) request.getAttribute(name);
			if (null == localCache) request.setAttribute(name, localCache = new HashMap<>());
		}
		return localCache;
	}

	/**
	 * 验证当前用户是否拥有指定权限,使用时与lacksPermission 搭配使用
	 * @param permission 权限名，多个为或的关系
	 * @return 拥有权限：true，否则false
	 */
	public static boolean hasPermission(String... permission) {
		Subject subject = SecurityUtils.getSubject();
		if (ArrayUtils.isEmpty(permission) || null == subject) return false;
		for (boolean b : subject.isPermitted(permission)) {
			if (b) return true;
		}
		return false;
	}

	public static boolean hasRole(String... roleCode) {
		Subject subject = SecurityUtils.getSubject();
		if (ArrayUtils.isEmpty(roleCode) || null == subject) return false;
		for (boolean b : subject.hasRoles(Arrays.asList(roleCode))) {
			if (b) return true;
		}
		return false;
	}

	public static LoginUser getLoginUser() {
		String key = "SessionUser";
		LoginUser user = getCacheByRequest(key);
		if (null != user) return user;
		try {
			user = SecurityUtils.getSubject().getPrincipal() != null ? (LoginUser) SecurityUtils.getSubject().getPrincipal() : null;
		} catch (Exception ignore) {
		}
		if (null == user) user = new LoginUser();
		setCacheByRequest(key, user);
		return user;
	}

	public static SysDepart getSessionDepart() {
		String key = "SessionDepart";
		SysDepart depart = getCacheByRequest(key);
		if (null != depart) return depart;
		LoginUser user = getLoginUser();
		if (StringUtils.isBlank(user.getOrgCode())) {
			List<SysDepart> list = getDepartService().queryUserDeparts(user.getId());
			if (CollectionUtils.isNotEmpty(list)) depart = list.get(0);
		} else {
			depart = getDepartService().queryByOrgCode(user.getOrgCode());
		}
		if (null == depart) depart = new SysDepart();
		setCacheByRequest(key, depart);
		return depart;
	}

	/**
	 * 获取当前登录部门的单位，如果父部门均不是单位取最顶的一级返回
	 */
	public static SysDepart getSessionUnit() {
		String key = "SessionUnit";
		SysDepart depart = getCacheByRequest(key), parent;
		if (null != depart) return depart;
		depart = getSessionDepart();
		for (int i = 0; i < 10000; i++) {
			if ("1".equals(depart.getOrgCategory()) || StringUtils.isBlank(depart.getParentId())
				|| null == (parent = getDepartService().getById(depart.getParentId()))) {
				setCacheByRequest(key, depart);
				return depart;
			} else {
				depart = parent;
			}
		}
		setCacheByRequest(key, depart);
		return depart;
	}

	public static String toURLDecoder(String value) {
		if (null == value) {
			value = "";
		}
		try {
			return URLDecoder.decode(value, "UTF-8");
		} catch (Exception e) {
			return value;
		}
	}

	public static String toURLEncoder(String value) {
		if (null == value) {
			value = "";
		}
		try {
			return URLEncoder.encode(value, "UTF-8");
		} catch (Exception e) {
			return value;
		}
	}

	public static UrlParamBuilder param(String name, String value) {
		return new UrlParamBuilder().put(name, value);
	}

	public static class UrlParamBuilder {

		private final StringBuilder sb = new StringBuilder();

		public UrlParamBuilder put(String name, String value) {
			if (0 < sb.length()) {
				sb.append("&");
			}
			sb.append(name).append("=").append(toURLEncoder(value));
			return this;
		}

		public String getValue() {
			return sb.toString();
		}

		public String toString() {
			return getValue();
		}

	}

	public static ISysDepartService getDepartService() {
		if (null == departService) departService = SpringContextUtils.getBean(ISysDepartService.class);
		return departService;
	}

	public final static String X_SUB_SYS = "X-Sub-Sys";

	private static ISysDepartService departService;

}
