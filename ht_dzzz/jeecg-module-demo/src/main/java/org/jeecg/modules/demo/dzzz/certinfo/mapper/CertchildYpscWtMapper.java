package org.jeecg.modules.demo.dzzz.certinfo.mapper;

import java.util.List;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildYpscWt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 药品生产子表委托
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
public interface CertchildYpscWtMapper extends BaseMapper<CertchildYpscWt> {

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
   * @return List<CertchildYpscWt>
   */
	public List<CertchildYpscWt> selectByMainId(@Param("mainId") String mainId,@Param("glid") String glid);
}
