package org.jeecg.modules.demo.dzzz.certinfo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;

import org.apache.commons.lang3.StringUtils;
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.certWarning.dto.YxqWarnReqDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.YxqWarnResDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.WgzWarnReqDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.WgzWarnResDto;
import org.jeecg.modules.demo.dzzz.certinfo.entity.*;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jeecg.modules.demo.dzzz.certinfo.vo.CertInfoPage;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certtyperole.entity.CerttypeRole;
import org.jeecg.modules.demo.dzzz.certzminfo.entity.CertZminfo;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;

import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description: 电子证照源数据
 * @Author: jeecg-boot
 * @Date:   2024-03-27
 * @Version: V1.0
 */
public interface ICertInfoService extends IService<CertInfo> {

	/**
	 * 添加一对多
	 *
	 * @param certInfo
	 * @param certchildYpscZcList
	 * @param certchildYpscWtList
	 * @param certchildYpscStList
	 */
	public void saveMain(CertInfo certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
						 List<CertchildCkomyly> certchildCkomylies,List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs,List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
						 List<CertchildYlqxscbaZb> certchildYlqxscbaZbs,List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList,List<CertchildYpckxkz> certchildYpckxkzs,
						 List<CertchildYpckxszm> certchildYpckxszms,List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
						 List<CertchildYlqxwlxsba> certchildYlqxwlxsbas,List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas
	);
	/**
	 * 修改一对多
	 *
   * @param certInfo
   * @param certchildYpscZcList
   * @param certchildYpscWtList
   * @param certchildYpscStList
	 */
	public void updateMain(CertInfo certInfo, List<CertchildYpscZc> certchildYpscZcList, List<CertchildYpscWt> certchildYpscWtList, List<CertchildYpscSt> certchildYpscStList,
						   List<CertchildCkomyly> certchildCkomylies, List<CertchildMzyphjsypddsc> certchildMzyphjsypddscs, List<CertchildYlqxcpckxs> certchildYlqxcpckxs,
						   List<CertchildYlqxscbaZb> certchildYlqxscbaZbs, List<CertchildYlqxwtbaZb> certchildYlqxwlxsbaList, List<CertchildYpckxkz> certchildYpckxkzs,
						   List<CertchildYpckxszm> certchildYpckxszms, List<CertchildDylylqxscbapz> certchildDylylqxscbapzList,
						   List<CertchildYlqxwlxsba> certchildYlqxwlxsbas, List<CertchirdYlqxlcsyba> certchirdYlqxlcsybas);
	/**
	 * 删除一对多
	 *
	 * @param id
	 */
	public void delMain (String id);

	public CertInfo getByZsid(String zsid);
	
	/**
	 * 批量删除一对多
	 *
	 * @param idList
	 */
	public void delBatchMain (Collection<? extends Serializable> idList);


	public List <CertMetadata> queryCertMetadateById(String id,String status);


	List<CertMetadata> queryCertMetadateByIdelse(String id, String status);

	String batchGz(String[] ids,String[] type, String signatureName, String keySn, HttpServletRequest request);

	Attachinfo getAttachByCertid(String id, String certmodetype, String isgz);


    String huanzheng(CertInfo certInfo, CertInfoPage certInfoPage);

	String bianGeng(CertInfo certInfo, CertInfoPage certInfoPage);


	 List<CerttypeRole> getCertlistByrole(String certtypeid, List<String> roleids) ;

	CertZminfo getzminfodata(String id);

	IPage<ZsYwxxb> selectAll( String sql,String weiba);
	int countselectAll( String sql,  String sql2);
	String weihu(CertInfoPage certInfoPage);
	String shenhe(CertInfoPage certInfoPage);

	public String Back(CertInfoPage certInfoPage);

	/**
	 * 查询有效期预警的证书列表-分页
	 * @param dto
	 * @param page
	 * @return
	 */
	IPage<YxqWarnResDto> selectYxqWarningPageList(YxqWarnReqDto dto, IPage page);

	/**
	 * 查询有效期预警的证书列表
	 * @param dto
	 * @return
	 */
	List<YxqWarnResDto> selectYxqWarningList(YxqWarnReqDto dto);

	/**
	 * 查询未盖章预警的证书列表-分页
	 * @param dto
	 * @param page
	 * @return
	 */
	IPage<WgzWarnResDto> selectWgzWarningPageList(WgzWarnReqDto dto, IPage page);

	/**
	 * 查询未盖章预警的证书列表
	 * @param dto
	 * @return
	 */
	List<WgzWarnResDto> selectWgzWarningList(WgzWarnReqDto dto);

	default List<String> findExistsIds(Collection<String> ids) {
		List<String> res = new ArrayList<>();
		List<Object> list = listObjs(new LambdaQueryWrapper<CertInfo>().in(CertInfo::getId, ids).select(CertInfo::getId));
		for (Object obj : list) {
			String str = null != obj ? obj + "" : "";
			if (StringUtils.isNotBlank(str)) res.add(str);
		}
		return res;
	}

	/**
	 * 处理过期证照
	 */
	void dealCertExpire();

	List<CertInfo> xybData();

	/**
	 * 生成电子证照
	 * @param certTypeId
	 * @param fzjgId
	 * @param version
	 * @return
	 */
	String generateElectronicLicense(String certTypeId, String fzjgId, String version);

	/**
	 * 审批系统用-根据参数获取附件
	 * @param id
	 * @return
	 */
	Attachinfo getAttachByParamsForSp(String id);

	/**
	 * 审批系统用-根据参数获取附件List
	 * @param id
	 * @return
	 */
	List<Attachinfo> getAttachListByParamsForSp(String id);

}
