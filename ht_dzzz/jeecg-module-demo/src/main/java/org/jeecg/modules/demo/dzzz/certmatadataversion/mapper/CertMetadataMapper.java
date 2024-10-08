package org.jeecg.modules.demo.dzzz.certmatadataversion.mapper;

import java.util.List;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Description: 证书元数据表
 * @Author: jeecg-boot
 * @Date:   2024-03-25
 * @Version: V1.0
 */
public interface CertMetadataMapper extends BaseMapper<CertMetadata> {

	/**
	 * 通过主表id删除子表数据
	 *
	 * @param mainId 主表id
	 * @return boolean
	 */
	public boolean deleteByMainId(@Param("mainId") String mainId);

  /**
   * 通过主表id查询子表数据
   *
   * @param mainId 主表id
   * @return List<CertMetadata>
   */
	public List<CertMetadata> selectByMainId(@Param("mainId") String mainId);
	public List<CertMetadata> querycertinfo(@Param("lm") String lm ) ;

	/**
	 * 根据证书类型ID查询证书源列表
	 * @param certTypeId
	 * @return
	 */
	List<CertMetadata> selectZsyByCertTypeId(@Param("certTypeId") String certTypeId, @Param("zdmc") String zdmc);

}
