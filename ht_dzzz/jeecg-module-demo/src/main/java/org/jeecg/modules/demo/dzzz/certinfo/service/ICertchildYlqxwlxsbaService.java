package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxwlxsba;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: certchild_ylqxwlxsba
 * @Author: jeecg-boot
 * @Date:   2024-07-09
 * @Version: V1.0
 */
public interface ICertchildYlqxwlxsbaService extends IService<CertchildYlqxwlxsba> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchildYlqxwlxsba>
	 */
	public List<CertchildYlqxwlxsba> selectByMainId(String mainId,String glid);
}
