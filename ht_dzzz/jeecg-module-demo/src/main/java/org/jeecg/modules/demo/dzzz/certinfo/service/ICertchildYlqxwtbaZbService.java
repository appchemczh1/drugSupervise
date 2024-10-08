package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxwtbaZb;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 第二三类医疗器械委托备案子表
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
public interface ICertchildYlqxwtbaZbService extends IService<CertchildYlqxwtbaZb> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchildYlqxwtbaZb>
	 */
	public List<CertchildYlqxwtbaZb> selectByMainId(String mainId,String glid);
}
