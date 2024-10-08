package org.jeecg.modules.demo.dzzz.certinfo.service;

import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchirdYlqxlcsyba;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * @Description: 医疗器械临床试验备案
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
public interface ICertchirdYlqxlcsybaService extends IService<CertchirdYlqxlcsyba> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertchirdYlqxlcsyba>
	 */
	public List<CertchirdYlqxlcsyba> selectByMainId(String mainId,String glid);
}
