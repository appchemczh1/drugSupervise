package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscZc;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 药品生产子表自产
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
public interface ICertchildYpscZcService extends IService<CertchildYpscZc> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchildYpscZc>
	 */
	public List<CertchildYpscZc> selectByMainId(String mainId,String glid);
}
