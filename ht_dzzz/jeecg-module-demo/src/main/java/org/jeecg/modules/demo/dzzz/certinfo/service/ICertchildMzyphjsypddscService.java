package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildMzyphjsypddsc;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 麻醉药品和精神药品定点生产批件
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
public interface ICertchildMzyphjsypddscService extends IService<CertchildMzyphjsypddsc> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchildMzyphjsypddsc>
	 */
	public List<CertchildMzyphjsypddsc> selectByMainId(String mainId,String glid);
}
