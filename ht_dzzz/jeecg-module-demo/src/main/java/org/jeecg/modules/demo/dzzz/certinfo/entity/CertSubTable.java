package org.jeecg.modules.demo.dzzz.certinfo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.dzzz.util.DateUtils;


/**
 * <p>Created by Raofeicheng on 2024/8/26.</p>
 * @author Raofeicheng
 * @version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class CertSubTable extends HashMap<String, Object> implements Serializable {

	private String tableName;

	public Object put(String key, Object value) {
		String propName = oConvertUtils.camelName(key);
		if ("tableName".equals(propName)) tableName = null != value ? value + "" : " ";
		Object res = super.put(propName, value);
		if (StringUtils.equalsAny(propName, "productionscope", "productionscopef")) {
			String prop = "fullProductionScope",
				str = MapUtils.getString(this, "productionscope"),
				str2 = MapUtils.getString(this, "productionscopef");
			String[] array = {"/", "\\", "-", "~", "无", "N/A"};
			if (StringUtils.equalsAny(str, array)) str = "";
			if (StringUtils.equalsAny(str2, array)) str2 = "";
			if (StringUtils.isNotBlank(str) && StringUtils.isNotBlank(str2)) super.put(prop, str + "（" + str2 + "）");
			else if (StringUtils.isNotBlank(str)) super.put(prop, str);
			else if (StringUtils.isNotBlank(str2)) super.put(prop, str2);
		}
		return res;
	}

	public String getString(String key) {
		return MapUtils.getString(this, key);
	}

	public Date getDate(String key) {
		Object val = get(key);
		if (null == val) return null;
		if (val instanceof Date) return (Date) val;
		return DateUtils.parseDate(val + "");
	}

}
