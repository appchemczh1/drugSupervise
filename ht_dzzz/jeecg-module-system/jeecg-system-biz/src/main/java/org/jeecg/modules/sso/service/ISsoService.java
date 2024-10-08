package org.jeecg.modules.sso.service;

import org.jeecg.modules.sso.SsoUtils;

import com.alibaba.fastjson.JSONArray;

/**
 * <p>Created by Raofeicheng on 2023/4/19.</p>
 * @author Raofeicheng
 * @version 1.0
 */
public interface ISsoService {

	String saveDepart(JSONArray array, SsoUtils.SsoContext ctx);

	String savePosition(JSONArray array, SsoUtils.SsoContext ctx);

	String saveUser(JSONArray array, SsoUtils.SsoContext ctx);

}
