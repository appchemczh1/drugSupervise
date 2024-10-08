package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscWt;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 药品生产子表委托
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
public interface ICertchildYpscWtService extends IService<CertchildYpscWt> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchildYpscWt>
	 */
	public List<CertchildYpscWt> selectByMainId(String mainId,String glid);
}
