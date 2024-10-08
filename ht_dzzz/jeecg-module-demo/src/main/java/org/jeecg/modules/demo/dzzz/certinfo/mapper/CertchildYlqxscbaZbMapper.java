package org.jeecg.modules.demo.dzzz.certinfo.mapper;

import java.util.List;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYlqxscbaZb;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 二三类医疗机械生产子表
 * @Author: jeecg-boot
 * @Date:   2024-06-17
 * @Version: V1.0
 */
public interface CertchildYlqxscbaZbMapper extends BaseMapper<CertchildYlqxscbaZb> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId,@Param("glid") String glid,@Param("zt") String zt);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<CertchildYlqxscbaZb>
   */
	public List<CertchildYlqxscbaZb> selectByMainId(@Param("mainId") String mainId,@Param("glid") String glid);
}
