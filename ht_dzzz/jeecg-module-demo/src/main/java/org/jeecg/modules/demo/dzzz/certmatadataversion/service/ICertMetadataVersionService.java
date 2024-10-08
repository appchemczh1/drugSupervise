package org.jeecg.modules.demo.dzzz.certmatadataversion.service;

import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadataVersion;
import com.baomidou.mybatisplus.extension.service.IService;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * @Description: 证书元数据版本
 * @Author: jeecg-boot
 * @Date:   2024-03-25
 * @Version: V1.0
 */
public interface ICertMetadataVersionService extends IService<CertMetadataVersion> {

	/**
	 * 添加一对多
	 *
	 * @param certMetadataVersion
	 * @param certMetadataList
	 */
	public void saveMain(CertMetadataVersion certMetadataVersion,List<CertMetadata> certMetadataList) ;
	
	/**
	 * 修改一对多
	 *
   * @param certMetadataVersion
   * @param certMetadataList
	 */
	public void updateMain(CertMetadataVersion certMetadataVersion,List<CertMetadata> certMetadataList);
	
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);

/*
	public void queryuseStatusForCertmetaversionlist(String certtypeid);
*/

}
