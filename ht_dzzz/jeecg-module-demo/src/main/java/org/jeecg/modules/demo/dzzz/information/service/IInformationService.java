package org.jeecg.modules.demo.dzzz.information.service;

import java.util.List;
import java.util.Map;

import org.jeecg.common.util.CollectionUtils;
import org.jeecg.common.util.StringUtils;
import org.jeecg.modules.demo.dzzz.information.entity.Information;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @Description: information1
 * @Author: jeecg-boot
 * @Date: 2024-06-24
 * @Version: V1.0
 */
public interface IInformationService extends IService<Information> {

	List<Map> getZsbh(String shxydm);

	/**
	 * 根据统一社会信用代码,查询证书数量
	 * @param shxydm
	 * @return
	 */
	Integer selectZsCount(String shxydm);

	default Information getByShxydm(String shxydm) {
		if (StringUtils.isBlank(shxydm)) return null;
		LambdaQueryWrapper<Information> query = new LambdaQueryWrapper<>();
		query.eq(Information::getEntzzjgdm, shxydm);
		List<Information> list = list(query);
		return CollectionUtils.isNotEmpty(list) ? list.get(0) : null;
	}

}
