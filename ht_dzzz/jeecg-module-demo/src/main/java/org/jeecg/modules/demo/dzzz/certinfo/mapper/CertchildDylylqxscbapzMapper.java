package org.jeecg.modules.demo.dzzz.certinfo.mapper;

import java.util.List;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertchildDylylqxscbapz;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: certchild_dylylqxscbapz
 * @Author: jeecg-boot
 * @Date:   2024-07-09
 * @Version: V1.0
 */
public interface CertchildDylylqxscbapzMapper extends BaseMapper<CertchildDylylqxscbapz> {

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
   * @return List<CertchildDylylqxscbapz>
   */
	public List<CertchildDylylqxscbapz> selectByMainId(@Param("mainId") String mainId,@Param("glid") String glid);
}
