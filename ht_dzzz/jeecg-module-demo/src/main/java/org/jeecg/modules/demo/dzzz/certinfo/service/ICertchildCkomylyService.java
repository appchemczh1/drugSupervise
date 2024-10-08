package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildCkomyly;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 出口欧盟原料
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
public interface ICertchildCkomylyService extends IService<CertchildCkomyly> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchildCkomyly>
	 */
	public List<CertchildCkomyly> selectByMainId(String mainId,String glid);
}
