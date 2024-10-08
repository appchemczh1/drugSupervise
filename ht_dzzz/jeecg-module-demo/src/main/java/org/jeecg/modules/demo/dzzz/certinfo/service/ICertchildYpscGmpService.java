package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscGmp;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 药瓶生产子表gmp
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
public interface ICertchildYpscGmpService extends IService<CertchildYpscGmp> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchildYpscGmp>
	 */
	public List<CertchildYpscGmp> selectByMainId(String mainId,String glid);
}
