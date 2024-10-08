package org.jeecg.modules.demo.dzzz.certmatadataversion.service;

import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Description: 证书元数据表
 * @Author: jeecg-boot
 * @Date:   2024-03-25
 * @Version: V1.0
 */
public interface ICertMetadataService extends IService<CertMetadata> {

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertMetadata>
	 */
	public List<CertMetadata> selectByMainId(String mainId);

	/**
	 * 通过主表id查询子表数据
	 *
	 * @param mainId 主表id
	 * @return List<CertMetadata>
	 */
	public List<CertMetadata> querycertinfo( String lm);

	/**
	 * 根据证书类型ID查询证书源列表
	 * @param certTypeId
	 * @return
	 */
	List<CertMetadata> selectZsyByZslx(String certTypeId);

	/**
	 * 根据证书类型ID查询证书元数据表
	 * @param certTypeId
	 * @return
	 */
	List<CertMetadata> selectZsyByCertTypeId(String certTypeId);

	/**
	 * 根据参数查询证书元数据
	 * @param certTypeId
	 * @param zdmc
	 * @return
	 */
	CertMetadata selectCertMetaByParams(String certTypeId, String zdmc);

}
