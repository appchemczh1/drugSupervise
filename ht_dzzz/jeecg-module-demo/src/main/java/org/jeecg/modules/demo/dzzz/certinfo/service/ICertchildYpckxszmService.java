package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpckxszm;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 药品出口销售证明
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
public interface ICertchildYpckxszmService extends IService<CertchildYpckxszm> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchildYpckxszm>
	 */
	public List<CertchildYpckxszm> selectByMainId(String mainId,String glid);
}
