package org.jeecg.modules.demo.dzzz.certinfo.entity;

import io.swagger.annotations.ApiModel;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 电子证照源数据
 * @Author: jeecg-boot
 * @Date: 2024-03-27
 * @Version: V1.0
 */
@ApiModel(value = "返回辅助类", description = "返回辅助类")
@Data
@NoArgsConstructor
public class ResultBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String sealCode;
	private String sealName;
	private String sealcode;
	private String sealnode;
	private String seal_code;
	private String seal_name;

	public ResultBean(String sealCode, String sealName) {
		this.sealCode = sealCode;
		this.sealName = sealName;
	}

}
