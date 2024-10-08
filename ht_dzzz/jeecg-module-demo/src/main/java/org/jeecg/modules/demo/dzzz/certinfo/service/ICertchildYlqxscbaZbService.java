package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxscbaZb;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 二三类医疗机械生产子表
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
public interface ICertchildYlqxscbaZbService extends IService<CertchildYlqxscbaZb> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchildYlqxscbaZb>
	 */
	public List<CertchildYlqxscbaZb> selectByMainId(String mainId,String glid);
}
