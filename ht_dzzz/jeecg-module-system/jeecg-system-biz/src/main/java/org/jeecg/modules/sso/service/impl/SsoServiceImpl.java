package org.jeecg.modules.sso.service.impl;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.constant.CommonConstant;
import org.jeecg.common.util.TypeConvertUtils;
import org.jeecg.modules.sso.SsoUtils;
import org.jeecg.modules.sso.service.ISsoService;
import org.jeecg.modules.system.entity.SysDepart;
import org.jeecg.modules.system.entity.SysPosition;
import org.jeecg.modules.system.entity.SysUser;
import org.jeecg.modules.system.service.ISysDepartService;
import org.jeecg.modules.system.service.ISysPositionService;
import org.jeecg.modules.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * <p>Created by Raofeicheng on 2023/4/19.</p>
 * @author Raofeicheng
 * @version 1.0
 */
@Slf4j
@Service
public class SsoServiceImpl implements ISsoService {

	@Transactional
	public String saveDepart(JSONArray array, SsoUtils.SsoContext ctx) {
		Integer[] res = innerSaveDepart(null, array, ctx);
		return "新增 " + res[0] + " 条、更新 " + res[1] + " 条。";
	}

	protected Integer[] innerSaveDepart(SysDepart parent, JSONArray array, SsoUtils.SsoContext ctx) {
		Integer[] res = {0, 0};
		for (int idx = 0; null != array && idx < array.size(); idx++) {
			JSONObject item = array.getJSONObject(idx);
			SysDepart bean = ctx.getDepartByOrgCode(item.getString("orgCode"));
			boolean isNewRecord = null == bean;
			if (isNewRecord) {
				bean = new SysDepart(item.getString("id"));
				bean.setCreateBy(SsoUtils.DefaultCreateBy);
				bean.setCreateTime(new Date());
			} else {
				bean.setUpdateBy(SsoUtils.DefaultCreateBy);
				bean.setUpdateTime(new Date());
			}
			bean.setParentId(null != parent ? parent.getId() : "");
			bean.setDepartName(item.getString("departName"));
			bean.setDepartNameEn(item.getString("departNameEn"));
			bean.setDepartNameAbbr(item.getString("departNameAbbr"));
			bean.setDepartOrder(item.getInteger("departOrder"));
			bean.setDescription(item.getString("description"));
			bean.setOrgCategory(item.getString("orgCategory"));
			bean.setOrgType(item.getString("orgType"));
			bean.setOrgCode(item.getString("orgCode"));
			bean.setMobile(item.getString("mobile"));
			bean.setFax(item.getString("fax"));
			bean.setAddress(item.getString("address"));
			bean.setMemo(item.getString("memo"));
			bean.setStatus("1");
			bean.setDelFlag(CommonConstant.DEL_FLAG_0.toString());
			Date orgRemoteUpdateTime = bean.getRemoteUpdateTime();
			bean.setRemoteUpdateTime(TypeConvertUtils.toDate(item.getString("updateTime"), CommonConstant.FORMAT_DATE_TIME));
			if (isNewRecord) {
				departService.save(bean);
				ctx.departCache.put(bean.getOrgCode(), bean);
				res[0]++;
			} else if (null == orgRemoteUpdateTime || null != bean.getRemoteUpdateTime() && bean.getRemoteUpdateTime().after(orgRemoteUpdateTime)) {
				if (null == bean.getRemoteUpdateTime()) bean.setRemoteUpdateTime(new Date());
				departService.updateById(bean);
				res[1]++;
			}
			Integer[] result = innerSaveDepart(bean, item.getJSONArray("children"), ctx);
			res[0] += result[0];
			res[1] += result[1];
		}
		return res;
	}

	@Transactional
	public String savePosition(JSONArray array, SsoUtils.SsoContext ctx) {
		int add = 0, edit = 0;
		for (int idx = 0; null != array && idx < array.size(); idx++) {
			JSONObject item = array.getJSONObject(idx);
			SysPosition bean = ctx.getPositionByCode(item.getString("code"));
			boolean isNewRecord = null == bean;
			if (isNewRecord) {
				bean = new SysPosition(item.getString("id"));
				bean.setCreateBy(SsoUtils.DefaultCreateBy);
				bean.setCreateTime(new Date());
			} else {
				bean.setUpdateBy(SsoUtils.DefaultCreateBy);
				bean.setUpdateTime(new Date());
			}
			bean.setCode(item.getString("code"));
			bean.setName(item.getString("name"));
			bean.setPostRank(item.getString("postRank"));
			bean.setRemoteUpdateTime(TypeConvertUtils.toDate(item.getString("updateTime"), CommonConstant.FORMAT_DATE_TIME));
			if (isNewRecord) {
				positionService.save(bean);
				ctx.positionCache.put(bean.getCode(), bean);
				add++;
			} else {
				positionService.updateById(bean);
				edit++;
			}
		}
		return "新增 " + add + " 条、更新 " + edit + " 条。";
	}

	@Transactional
	public String saveUser(JSONArray array, SsoUtils.SsoContext ctx) {
		int add = 0, edit = 0;
		for (int idx = 0; null != array && idx < array.size(); idx++) {
			JSONObject item = array.getJSONObject(idx);
			SysUser bean = SsoUtils.findUser(item, ctx);
			Set<String> roles = new LinkedHashSet<>(), departs = new LinkedHashSet<>();
			if (null == bean) {
				SsoUtils.writeUserInfo(bean = new SysUser(), roles, departs, item, ctx);
				userService.saveUser(bean, StringUtils.join(roles, ","), StringUtils.join(departs, ","), "0");
				ctx.userUsernameCache.put(bean.getUsername(), bean);
				ctx.userIdCache.put(bean.getId(), bean);
				add++;
			} else {
				SsoUtils.writeUserInfo(bean, roles, departs, item, ctx);
				userService.editUser(bean, StringUtils.join(roles, ","), StringUtils.join(departs, ","), "0");
				edit++;
			}
		}
		return "新增 " + add + " 条、更新 " + edit + " 条。";
	}

	@Autowired
	public SsoServiceImpl(ISysDepartService departService, ISysPositionService positionService, ISysUserService userService) {
		this.departService = departService;
		this.positionService = positionService;
		this.userService = userService;
	}

	protected ISysDepartService departService;
	protected ISysPositionService positionService;
	protected ISysUserService userService;

}
