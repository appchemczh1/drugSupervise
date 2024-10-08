package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscSt;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 药品生产子表受托
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
public interface ICertchildYpscStService extends IService<CertchildYpscSt> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchildYpscSt>
	 */
	public List<CertchildYpscSt> selectByMainId(String mainId,String glid);
}
