package org.jeecg.modules.demo.dzzz.certinfo.service.impl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jeecg.common.system.vo.LoginUser;
import org.jeecg.common.util.ExceptionUtils;
import org.jeecg.common.util.StringUtils;
import org.jeecg.common.util.UUIDGenerator;
import org.jeecg.common.util.oConvertUtils;
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.attachinfo.service.IAttachinfoService;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationDetail;
import org.jeecg.modules.demo.dzzz.certInfoOperation.entity.CertInfoOperationRecord;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationDetailService;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationRecordService;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertSubTable;
import org.jeecg.modules.demo.dzzz.certinfo.entity.ResultBean;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertHandleMapper;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertInfoMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertHandleService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertSubTableService;
import org.jeecg.modules.demo.dzzz.certinfo.vo.CertInfoPage;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadataVersion;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataService;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataVersionService;
import org.jeecg.modules.demo.dzzz.certmode.entity.CertMode;
import org.jeecg.modules.demo.dzzz.certmode.service.ICertModeService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.dataExchange.service.ITYwSjXybService;
import org.jeecg.modules.demo.dzzz.dataExchange.util.YwUtil;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;
import org.jeecg.modules.demo.dzzz.sczz.ZsDto;
import org.jeecg.modules.demo.dzzz.util.BeanUtils;
import org.jeecg.modules.demo.dzzz.util.CertUtils;
import org.jeecg.modules.demo.dzzz.util.FileUtils;
import org.jeecg.modules.demo.dzzz.util.OfdUtil;
import org.jeecg.modules.demo.dzzz.util.SignatureUtil;
import org.jeecg.modules.demo.dzzz.util.XmlUtil;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.jeecg.modules.system.util.WebUtils;
import org.ofdrw.reader.OFDReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 证书操作
 * <p>Created by Raofeicheng on 2024/8/21.</p>
 * @author Raofeicheng
 * @version 1.0
 */
@Slf4j
@Getter
@Service
public class CertHandleServiceImpl extends ServiceImpl<CertInfoMapper, CertInfo> implements ICertHandleService {

	/**
	 * 批量盖章
	 * @param ids           待盖章证书 ZS_YWXXB.ID
	 * @param type          操作类型 null盖章，sczz生成证照
	 * @param signatureName 签章名称
	 * @param keySn         签章uKey
	 * @return 错误信息
	 */
	@Transactional
	public String batchGzFromWgz(String[] ids, String type, String signatureName, String keySn, HttpServletRequest request) {
		try {
			return batchGzFromWgz(zsYwxxbService.listByIds(ids), type, signatureName, keySn, request);
		} catch (Throwable e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	@Transactional
	public String batchGzFromYgz(String[] ids, String type, String signatureName, String keySn, HttpServletRequest request) {
		try {
			return batchGzFromYgz(listByIds(ids), type, signatureName, keySn, request);
		} catch (Throwable e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	@Transactional
	public String batchGzFromWgz(List<ZsYwxxb> certInfoList, String type, String signatureName, String keySn, HttpServletRequest request) {
		try {
			if (CollectionUtils.isEmpty(certInfoList)) return "无法获取证书信息";
			return innerBatchGz(certInfoList, type, signatureName, keySn, request);
		} catch (Throwable e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	@Transactional
	public String batchGzFromYgz(List<CertInfo> certInfoList, String type, String signatureName, String keySn, HttpServletRequest request) {
		try {
			if (CollectionUtils.isEmpty(certInfoList)) return "无法获取证书信息";
			return innerBatchGz(certInfoList, type, signatureName, keySn, request);
		} catch (Throwable e) {
			throw ExceptionUtils.unchecked(e);
		}
	}

	/**
	 * 注销证书
	 * @param zsid 证书id
	 * @author huke
	 * @date 2024-8-23 9:14
	 */
	@Transactional
	public void certInfoZx(String zsid) {
		Optional.ofNullable(certInfoService.list(new LambdaQueryWrapper<CertInfo>().and(qw -> {
			qw.eq(CertInfo::getZsid, zsid);
			qw.ne(CertInfo::getYxzt, "99");
		}))).orElse(new ArrayList<>()).forEach(item -> {
			item.setYxzt("50");
			CertUtils.initSyncState(item);
			certInfoService.updateById(item);
		});
	}

	@Transactional
	public String cancelGz(CertInfo cert, String qxGzyy) {
		ZsYwxxb wgzCert = zsYwxxbService.getById(cert.getId());
		if (wgzCert == null) wgzCert = new ZsYwxxb();
		LoginUser user = WebUtils.getLoginUser();
		BeanUtils.copyProperties(cert, wgzCert, "id");
		wgzCert.setZt("3");
		wgzCert.setYxzt("10");
		if (wgzCert.getId() == null) {
			wgzCert.setId(cert.getId());
			zsYwxxbService.save(wgzCert);
		} else {
			zsYwxxbService.updateById(wgzCert);
		}
		/* 子表覆盖到待盖章子表中 */
		CertType certType = certTypeService.getById(cert.getCerttypeid());
		for (CertUtils.CertSubTableEnum item : CertUtils.CertSubTableEnum.byAbbrArray(StringUtils.trimToEmpty(certType.getZszb()).split("[,]+"))) {
			subTableService.copyToCancel(item, new QueryWrapper<CertSubTable>().eq("XZSPID", cert.getId()));
		}
		CertInfoOperationRecord record = new CertInfoOperationRecord();
		record.setId(UUIDGenerator.generate());
		record.setCreateBy(user.getUsername());
		record.setCreateTime(new Date());
		record.setSysOrgCode(user.getOrgCode());
		record.setZsid(wgzCert.getZsid());
		record.setYwlx(wgzCert.getYwlb());
		record.setStutas("20");
		record.setCzryid(user.getId());
		record.setCzrxm(user.getRealname());
		record.setCzsj(record.getCreateTime());
		record.setGzstutas("1");
		record.setOperateNo((operationRecordService.getMaxOperateNoByZsid(record.getZsid(), 0) + 1) + "");
		record.setBglx("10");
		record.setIscsh("0");
		record.setOldDataFlag("1");
		record.setQxgzr(user.getRealname());
		record.setQxgzyy(qxGzyy);
		operationRecordService.save(record);
		return null;
	}

	@Transactional
	public String saveZsYwxxb(CertType certType, ZsYwxxb entity) {
		zsYwxxbService.save(entity);
		CertInfoOperationRecord record = new CertInfoOperationRecord();
		record.setId(UUIDGenerator.generate());
		record.setCreateBy("inf");
		record.setCreateTime(new Date());
		record.setZsid(entity.getZsid());
		record.setYwlx(entity.getYwlb());
		record.setSjly(entity.getJsly());
		record.setStutas("20");
		record.setCzsj(new Date());
		record.setGzstutas("0");
		record.setOperateNo("1");
		record.setBglx(entity.getYwlb());
		operationRecordService.save(record);
		return null;
	}

	@Transactional
	public String maintainApply(CertInfoPage pageEntity) {
		if (null == pageEntity.getZt()) return "证书状态不能为空";
		LoginUser user = WebUtils.getLoginUser();
		//本次维护的操作记录
		CertInfoOperationRecord record = new CertInfoOperationRecord();
		record.setId(UUIDGenerator.generate());
		record.setCzryid(user.getId());
		record.setCzrxm(user.getRealname());
		record.setCzsj(new Date());
		record.setOperateNo("0");
		record.setYwlx("7");
		record.setBgyy(pageEntity.getBgyy());
		record.setGzstutas("0");
		record.setStutas("20");
		record.setBglx("7");
		record.setWhr(pageEntity.getWhr());
		record.setWhyy(pageEntity.getWhyy());
		record.setFj(pageEntity.getFj());
		List<String> diffList = new ArrayList<>();
		List<CertInfoOperationRecord> recordList;//发生变化的操作记录
		List<CertInfoOperationDetail> detailList;//本次维护的操作记录明细
		if (3 == pageEntity.getZt()) {
			/* 未盖章数据维护时原记录改为有效状态98，避免审核过程中用户对原数据执行盖章操作 */
			ZsYwxxb bean = zsYwxxbService.getById(pageEntity.getId()), target = new ZsYwxxb();
			if (null == bean) return "未盖章记录不存在";
			if ("1".equals(bean.getIswh())) return "当前记录存在维护申请，不能再次申请";
			BeanUtils.copyProperties(bean, target);
			BeanUtils.copyProperties(pageEntity, target, "fj");
			target.setId(UUIDGenerator.generate());
			target.setZsid(target.getId());
			target.setWhid(bean.getId());
			target.setZt("3");
			target.setYxzt("99");
			record.setZsid(target.getZsid());
			detailList = CertUtils.diff(bean, target, bean.getCerttypeid(), pageEntity.getSubMap(), diffList, record);
			recordList = CertUtils.diff(operationRecordService.listBgjlByZsid(bean.getZsid(), true), pageEntity.getCertoperationrecord(), diffList, record);
			if (diffList.isEmpty()) return "数据未发生变动，无需提交申请";
			zsYwxxbService.update(new LambdaUpdateWrapper<ZsYwxxb>()
				.set(ZsYwxxb::getCzzt, "sqwh")
				.set(ZsYwxxb::getIswh, "1")
				.set(ZsYwxxb::getYxzt, "98")
				.eq(ZsYwxxb::getId, bean.getId()));
			zsYwxxbService.save(target);
		} else if (4 == pageEntity.getZt()) {
			CertInfo bean = certInfoService.getById(pageEntity.getId()), target = new CertInfo();
			if (null == bean) return "已盖章记录不存在";
			if ("1".equals(bean.getIswh())) return "当前记录存在维护申请，不能再次申请";
			List<ZsYwxxb> list = zsYwxxbService.list(new LambdaQueryWrapper<ZsYwxxb>().eq(ZsYwxxb::getZsbh, bean.getZsbh()).in(ZsYwxxb::getYxzt, "10", "98"));
			if (CollectionUtils.isNotEmpty(list)) return "未盖章中存在相同证书编号待盖章数据，不能进行维护";
			BeanUtils.copyProperties(bean, target);
			BeanUtils.copyProperties(pageEntity, target, "fj");
			target.setZt("4");
			target.setYxzt("99");
			target.setId(UUIDGenerator.generate());
			target.setZsid(target.getId());
			target.setWhid(bean.getId());
			record.setZsid(target.getZsid());
			detailList = CertUtils.diff(bean, target, bean.getCerttypeid(), pageEntity.getSubMap(), diffList, record);
			recordList = CertUtils.diff(operationRecordService.listBgjlByZsid(bean.getZsid(), true), pageEntity.getCertoperationrecord(), diffList, record);
			if (diffList.isEmpty()) return "数据未发生变动，无需提交申请";
			update(new LambdaUpdateWrapper<CertInfo>()
				.set(CertInfo::getCzzt, "sqwh")
				.set(CertInfo::getIswh, "1")
				.eq(CertInfo::getId, bean.getId()));
			save(target);
		} else return "未知记录状态[" + pageEntity.getZt() + "]";
		for (Map.Entry<String, List<CertSubTable>> item : pageEntity.getSubMap().entrySet()) {
			subTableService.saveBatch(CertUtils.CertSubTableEnum.byAbbr(item.getKey()), item.getValue(), pageEntity.getZt() + "");
		}
		record.setBgnr(StringUtils.join(diffList, "；"));
		operationRecordService.save(record);
		operationDetailService.saveBatch(detailList);
		operationRecordService.saveBatch(recordList);
		//throw new YwException(StringUtils.join(diffList, "；"));
		return "维护申请成功！请等待审核结果";
	}

	@Transactional
	public String maintainPass(CertInfoPage pageEntity) {
		String sourceZsid, whZsid;
		//修改主表为正式状态并修改原主表维护状态
		if (3 == pageEntity.getZt()) {
			ZsYwxxb bean = zsYwxxbService.getById(pageEntity.getId()), source;
			if (null == bean) return "未盖章记录不存在";
			source = zsYwxxbService.getById(bean.getWhid());
			if (null == source) return "原未盖章记录不存在";
			sourceZsid = source.getZsid();
			whZsid = bean.getZsid();
			zsYwxxbService.update(new LambdaUpdateWrapper<ZsYwxxb>()
				.set(ZsYwxxb::getCzzt, "whcg")
				.set(ZsYwxxb::getIswh, "0")
				.set(ZsYwxxb::getYxzt, "10")
				.set(ZsYwxxb::getWhid, null)
				.set(ZsYwxxb::getZsid, sourceZsid)
				.eq(ZsYwxxb::getId, bean.getId()));
			zsYwxxbService.update(new LambdaUpdateWrapper<ZsYwxxb>()
				.set(ZsYwxxb::getCzzt, null)
				.set(ZsYwxxb::getIswh, "0")
				.set(ZsYwxxb::getYxzt, "99")
				.eq(ZsYwxxb::getId, bean.getWhid()));
			//子表不动
		} else if (4 == pageEntity.getZt()) {
			CertInfo bean = certInfoService.getById(pageEntity.getId()), source;
			if (null == bean) return "已盖章记录不存在";
			source = certInfoService.getById(bean.getWhid());
			if (null == source) return "原已盖章记录不存在";
			sourceZsid = source.getZsid();
			whZsid = bean.getZsid();
			update(new LambdaUpdateWrapper<CertInfo>()
				.set(CertInfo::getCzzt, null)
				.set(CertInfo::getIswh, "0")
				.eq(CertInfo::getId, bean.getWhid()));
			//主表及子表要移到未盖章记录中
			ZsYwxxb wgzCert = zsYwxxbService.getById(source.getId());
			if (wgzCert == null) wgzCert = new ZsYwxxb();
			BeanUtils.copyProperties(bean, wgzCert, "id");
			wgzCert.setZt("3");
			wgzCert.setYxzt("10");
			wgzCert.setCzzt("whcg");
			wgzCert.setIswh("0");
			wgzCert.setWhid(null);
			wgzCert.setZsid(sourceZsid);
			if (wgzCert.getId() == null) {
				wgzCert.setId(bean.getId());
				zsYwxxbService.save(wgzCert);
			} else zsYwxxbService.updateById(wgzCert);
			/* 子表覆盖到待盖章子表中 */
			CertType certType = certTypeService.getById(wgzCert.getCerttypeid());
			QueryWrapper<CertSubTable> query = new QueryWrapper<CertSubTable>().eq("XZSPID", bean.getId());
			for (CertUtils.CertSubTableEnum em : CertUtils.CertSubTableEnum.byAbbrArray(StringUtils.trimToEmpty(certType.getZszb()).split("[,]+"))) {
				subTableService.copy(em.getTableNameZs(), em.getTableNameDgz(), query, wgzCert.getId(), true, em.getColumns());
			}
			removeById(bean);
		} else return "未知记录状态[" + pageEntity.getZt() + "]";
		//操作记录明细，修改的历史操作记录未生产明细
		operationDetailService.update(new LambdaUpdateWrapper<CertInfoOperationDetail>()
			.set(CertInfoOperationDetail::getZsid, sourceZsid)
			.eq(CertInfoOperationDetail::getZsid, whZsid));
		//操作记录主表
		certHandleMapper.mergeOperationRecordChange(new LambdaQueryWrapper<CertInfoOperationRecord>().eq(CertInfoOperationRecord::getZsid, whZsid));
		operationRecordService.remove(new LambdaQueryWrapper<CertInfoOperationRecord>().eq(CertInfoOperationRecord::getZsid, whZsid).likeRight(CertInfoOperationRecord::getId, "wh-"));
		operationRecordService.update(new LambdaUpdateWrapper<CertInfoOperationRecord>().set(CertInfoOperationRecord::getZsid, sourceZsid).eq(CertInfoOperationRecord::getZsid, whZsid));
		return "审核成功";
	}

	@Transactional
	public String maintainBack(CertInfoPage pageEntity) {
		String zsid;
		CertType certType;
		//删除主表并修改原主表维护状态
		if (3 == pageEntity.getZt()) {
			ZsYwxxb bean = zsYwxxbService.getById(pageEntity.getId());
			if (null == bean) return "未盖章记录不存在";
			zsYwxxbService.removeById(bean);
			zsYwxxbService.update(new LambdaUpdateWrapper<ZsYwxxb>()
				.set(ZsYwxxb::getCzzt, null)
				.set(ZsYwxxb::getIswh, "0")
				.set(ZsYwxxb::getYxzt, "10")
				.eq(ZsYwxxb::getId, bean.getWhid()));
			zsid = bean.getZsid();
			certType = certTypeService.getById(bean.getCerttypeid());
		} else if (4 == pageEntity.getZt()) {
			CertInfo bean = certInfoService.getById(pageEntity.getId()), target = new CertInfo();
			if (null == bean) return "已盖章记录不存在";
			removeById(bean);
			update(new LambdaUpdateWrapper<CertInfo>()
				.set(CertInfo::getCzzt, null)
				.set(CertInfo::getIswh, "0")
				.eq(CertInfo::getId, bean.getWhid()));
			zsid = bean.getZsid();
			certType = certTypeService.getById(bean.getCerttypeid());
		} else return "未知记录状态[" + pageEntity.getZt() + "]";
		//删除子表
		for (CertUtils.CertSubTableEnum em : CertUtils.CertSubTableEnum.byAbbrArray(StringUtils.trimToEmpty(certType.getZszb()).split("[,]+"))) {
			subTableService.removeByXzspId(em, pageEntity.getZt() + "", pageEntity.getId());
		}
		//删除操作记录明细
		operationDetailService.remove(new LambdaQueryWrapper<CertInfoOperationDetail>().eq(CertInfoOperationDetail::getZsid, zsid));
		//删除操作记录主表
		operationRecordService.remove(new LambdaQueryWrapper<CertInfoOperationRecord>().eq(CertInfoOperationRecord::getZsid, zsid));
		return "退回成功";
	}

	@Transactional
	public String saveOrUpdateBl(CertInfoPage pageEntity) {
		if (StringUtils.isBlank(pageEntity.getFzjg())) return "发证机关不能为空";
		boolean isAdd = StringUtils.isBlank(pageEntity.getId());
		CertInfo bean = !isAdd ? getById(pageEntity.getId()) : new CertInfo();
		if (null == bean) return "原记录不存在";
		BeanUtils.copyProperties(pageEntity, bean);
		CertType certType = certTypeService.getById(bean.getCerttypeid());
		if (null == certType) return "证书类型不存在";
		if (isAdd) {
			bean.setId(UUIDGenerator.generate());
			bean.setZsid(bean.getId());
		}
		bean.setUpdateTime(new Date());
		bean.setZt("4");
		bean.setIsxt("1");
		bean.setYxzt("10");
		bean.setZslx(certType.getZslx());
		bean.setZszt("1");
		bean.setFzjgid(YwUtil.fzjgValid(bean.getFzjg(), deptService));
		CertUtils.initSyncState(bean);
		if (isAdd) save(bean);
		else updateById(bean);
		for (CertUtils.CertSubTableEnum em : CertUtils.CertSubTableEnum.byAbbrArray(StringUtils.trimToEmpty(certType.getZszb()).split("[,]+"))) {
			List<CertSubTable> list = pageEntity.getSubMap().get(em.getAbbr());
			if (CollectionUtils.isEmpty(list)) continue;
			int sort = 0;
			String sortColumn = oConvertUtils.camelName(em.getSortColumn());
			for (CertSubTable targetItem : list) {
				sort++;
				if (StringUtils.isBlank(targetItem.getString("id")))
					targetItem.put("id", UUIDGenerator.generate());
				if (StringUtils.isNotBlank(sortColumn)) targetItem.put(sortColumn, sort);
				targetItem.put("xzspid", bean.getId());
				targetItem.put("zsid", bean.getZsid());
			}
			if (!isAdd) subTableService.removeByXzspId(em, bean.getZt(), bean.getId());
			subTableService.saveBatch(em, list, bean.getZt());
		}
		return "补录成功";
	}

	@Transactional
	public String zhuXiao(CertInfoPage pageEntity) {
		CertInfo bean = getById(pageEntity.getId());
		if (null == bean) return "原证书不存在";
		if ("50".equals(bean.getYxzt())) return "原证书已经注销";
		LoginUser user = WebUtils.getLoginUser();
		update(new LambdaUpdateWrapper<CertInfo>()
			.set(CertInfo::getYxzt, "50")
			.set(CertInfo::getUpdateTime, new Date())
			.eq(CertInfo::getId, bean.getId()));
		CertInfoOperationRecord record = new CertInfoOperationRecord();
		record.setId(UUIDGenerator.generate());
		record.setZsid(bean.getZsid());
		record.setCzryid(user.getId());
		record.setCzrxm(user.getRealname());
		record.setCzsj(new Date());
		record.setOperateNo("0");
		record.setYwlx("注销");
		record.setBgyy(pageEntity.getWhyy());
		record.setGzstutas("0");
		record.setStutas("20");
		record.setBglx("4");
		record.setWhr(pageEntity.getWhr());
		record.setFj(pageEntity.getFj());
		record.setBgcs((operationRecordService.countBgjlByZsid(bean.getZsid()) + 1) + "");
		operationRecordService.save(record);
		return "注销成功";
	}

	@Transactional
	public String innerBatchGz(List<?> certList, String type, String signatureName, String keySn, HttpServletRequest request) throws Exception {
		if (CollectionUtils.isEmpty(certList)) return "无法获取证书信息.";
		String filepath = uploadPath + "/";
		boolean toSeal = null == type, fromWgz = certList.get(0) instanceof ZsYwxxb;
		ResultBean stampInfo, stampInfoKey = null;
		Map<String, ResultBean> stampCache = new HashMap<>();
		Map<String, CertType> certTypeCache = new HashMap<>();
		List<CertInfo> certInfoList = new ArrayList<>();
		Map<String, List<CertInfoOperationRecord>> operationRecordListMap = new HashMap<>();
		List<Attachinfo> attachInfoList = new ArrayList<>();
		for (Object itemObj : certList) {
			CertInfo newCert;
			if (fromWgz) {
				BeanUtils.copyProperties(itemObj, newCert = new CertInfo());
			} else {
				newCert = (CertInfo) itemObj;
			}
			//初始化签章信息
			if (StringUtils.isNotBlank(keySn)) {
				if (null == stampInfoKey) stampInfoKey = zsYwxxbService.getSealcodeByKeySn(StringUtils.left(keySn, 16));
				stampInfo = stampInfoKey;
				if (stampInfo == null) return "未找到当前ukey所对应的章，无法盖章，请联系管理员";
			} else {
				stampInfo = stampCache.get(newCert.getFzjg());
				if (null == stampInfo) {
					stampInfo = zsYwxxbService.getRealcodeByName(newCert.getFzjg());
					if (null != stampInfo) stampCache.put(newCert.getFzjg(), stampInfo);
				}
				if (stampInfo == null) stampInfo = new ResultBean("", "");
			}
			//初始化证书类型
			if (!certTypeCache.containsKey(newCert.getCerttypeid()))
				certTypeCache.put(newCert.getCerttypeid(), certTypeService.getById(newCert.getCerttypeid()));
			CertType certType = certTypeCache.get(newCert.getCerttypeid());
			if (null == certType) return "证书类型不存在";
			//初始化子表
			ZsDto zsDto = new ZsDto();
			BeanUtils.copyProperties(newCert, zsDto);
			if (StringUtils.isBlank(zsDto.getCp())) zsDto.setCp(zsDto.getChanping());
			if (StringUtils.isBlank(zsDto.getGg())) zsDto.setGg(zsDto.getGuige());
			if (null == zsDto.getZslx()) zsDto.setZslx(NumberUtils.toInt(certType.getZslx()));
			zsDto.setQrcode(YwUtil.generateQRCodeImageOfd(YwUtil.getQrCodeValue(zsDto.getZsid(), serverUrl), 200, 200));
			CertUtils.initSubTable(zsDto, newCert.getZsid(), newCert.getId(), newCert.getZt(), certType);
			//初始化证书元
			List<CertMetadata> certMetadata = getCertMetadata(newCert.getCerttypeid(), null);
			if (CollectionUtils.isEmpty(certMetadata)) return "未配置证书元数据，无法生成证照";
			newCert.setBbid(certMetadata.get(0).getCertmetadataversionId());
			//初始化模板
			List<CertMode> certModes = certModeService.listByCertTypeId(newCert.getCerttypeid());
			String relativePath = certType.getCerttype() + "/" + DateFormatUtils.format(new Date(), "yyyy/M");
			File targetPath = new File(uploadPath, relativePath);
			if ((!targetPath.exists() || !targetPath.isDirectory()) && !targetPath.mkdirs())
				return "目录[" + targetPath.getCanonicalPath() + "]创建失败";
			List<CertInfoOperationRecord> operationRecordList = new ArrayList<>();
			String orgFj = zsDto.getFj();
			List<String> fjNameList = new ArrayList<>();
			for (String item : StringUtils.trimToEmpty(orgFj).split("[,]+")) {
				if (StringUtils.isBlank(item)) continue;
				fjNameList.add(StringUtils.trimToEmpty(FilenameUtils.getBaseName(item)).replaceAll("_\\d+$", ""));
			}
			zsDto.setFj(StringUtils.join(fjNameList, ","));
			for (CertMode certMode : certModes) {
				File tplFile = null;
				Map<String, Object> objMap = new HashMap<>();
				objMap.put("tplFile", tplFile);
				// 处理特殊证照
				String errMsg = dealSpecialCert(certType.getZslx(), certMode, zsDto, objMap);
				if (StringUtils.isNotBlank(errMsg)) {
					return errMsg;
				}
				tplFile = (File) objMap.get("tplFile");
				if (!tplFile.exists() || !tplFile.isFile())
					return certMode.getTemplateName() + "模板文件[" + certMode.getFile() + "]不存在";
				String error = createCert(newCert, zsDto, orgFj, certType, certMode, certMetadata, toSeal ? stampInfo : null,
					tplFile, targetPath, relativePath, operationRecordList, attachInfoList);
				if (StringUtils.isNotBlank(error)) return error;
			}
			newCert.setZt("4");
			newCert.setGztime(new Date());
			newCert.setLocalZszb(certType.getZszb());
			CertUtils.initSyncState(newCert);
			certInfoList.add(newCert);
			operationRecordListMap.put(newCert.getId(), operationRecordList);
		}
		List<String> zsIdList = certInfoList.stream().map(CertInfo::getZsid).collect(Collectors.toList()),
			certIdList = certInfoList.stream().map(CertInfo::getId).collect(Collectors.toList());
		//将相同zsid的附件全部置为无效
		attachInfoService.update(new LambdaUpdateWrapper<Attachinfo>().in(Attachinfo::getZsid, certIdList).eq(Attachinfo::getStatus, "1").set(Attachinfo::getStatus, "0"));
		if (toSeal) {
			//将主表相同zsid的记录作废掉，后期可以将其移到历史表中
			if (fromWgz)
				certInfoService.update(new LambdaUpdateWrapper<CertInfo>().in(CertInfo::getZsid, zsIdList).set(CertInfo::getYxzt, "99"));
			List<String> existsIds = certInfoService.findExistsIds(certIdList);
			List<CertInfoOperationRecord> operationRecordList = new ArrayList<>();
			List<CertInfo> insertCert = new ArrayList<>(), updateCert = new ArrayList<>();
			for (CertInfo item : certInfoList) {
				operationRecordList.addAll(operationRecordListMap.get(item.getId()));
				boolean exists = existsIds.contains(item.getId());
				String orgId = item.getId();
				//当待盖章表的id在已盖章表存在且有未盖章变更时，执行修改id的操作
				if (fromWgz && 0 < operationRecordListMap.get(item.getId()).size() && exists) {
					item.setId(UUIDGenerator.generate());
					exists = false;
					for (Attachinfo attach : attachInfoList) {
						if (StringUtils.equalsIgnoreCase(attach.getZsid(), orgId))
							attach.setZsid(item.getId());
					}
				}
				if (exists) certInfoService.updateById(item);
				else certInfoService.save(item);
				/* 子表覆盖到正式子表中 */
				if (fromWgz) {
					for (CertUtils.CertSubTableEnum em : CertUtils.CertSubTableEnum.byAbbrArray(StringUtils.trimToEmpty(item.getLocalZszb()).split("[,]+"))) {
						subTableService.copyToGz(em, new QueryWrapper<CertSubTable>().eq("XZSPID", orgId), item.getId());
					}
				}
				ywSjXybService.saveXyb(null, item);
			}
			//更新操作记录表为已盖章状态
			if (CollectionUtils.isNotEmpty(operationRecordList))
				operationRecordService.update(new LambdaUpdateWrapper<CertInfoOperationRecord>()
					.in(CertInfoOperationRecord::getId, operationRecordList.stream().map(CertInfoOperationRecord::getId).collect(Collectors.toList()))
					.and(q -> q.eq(CertInfoOperationRecord::getGzstutas, "0").or().isNull(CertInfoOperationRecord::getGzstutas))
					.set(CertInfoOperationRecord::getGzstutas, "1")
					.set(CertInfoOperationRecord::getGztime, new Date()));
			//删除待盖章数据
			if (fromWgz) {
				zsYwxxbService.remove(new LambdaQueryWrapper<ZsYwxxb>()
					.in(ZsYwxxb::getId, certList.stream().map(t -> ((ZsYwxxb) t).getId()).collect(Collectors.toList())));
			}
			//throw new RuntimeException("盖章测试");
		}
		//附件记录保存
		if (CollectionUtils.isNotEmpty(attachInfoList)) attachInfoService.saveBatch(attachInfoList);
		return toSeal ? "盖章成功" : "生成证照成功";
	}

	/**
	 * 处理特殊证照
	 * @param zslx
	 * @param certMode
	 * @param zsDto
	 * @param objMap
	 * @return
	 */
	public String dealSpecialCert(String zslx, CertMode certMode, ZsDto zsDto, Map<String, Object> objMap) {
		if ("84".equals(zslx)) {// 药品GMP符合性检查结果通知书
			String[] strs = certMode.getFile().split("[,]+");
			for (String item : strs) {
				if (StringUtils.isNotBlank(zsDto.getYlzd3()) && StringUtils.contains(item, "有受托")
						|| StringUtils.isBlank(zsDto.getYlzd3()) && !StringUtils.contains(item, "有受托")) {
					objMap.put("tplFile", new File(uploadPath, item));
					break;
				}
			}
			if (null == objMap.get("tplFile")) return "无法获取正确的模板文件";
		} else if ("73".equals(zslx)) {// 医疗器械出口销售证明
			String[] strs = certMode.getFile().split("[,]+");
			for (String item : strs) {
				List<CertSubTable> certSubTables = zsDto.getSubMap().get(CertUtils.CertSubTableEnum.QXCK_XSZM.getAbbr());
				if ((CollectionUtils.isNotEmpty(certSubTables) && StringUtils.contains(item, "有子表"))
						|| (CollectionUtils.isEmpty(certSubTables) && !StringUtils.contains(item, "有子表"))) {
					objMap.put("tplFile", new File(uploadPath, item));
					break;
				}
			}
			if (null == objMap.get("tplFile")) return "无法获取正确的模板文件";
		} else {
			objMap.put("tplFile", new File(uploadPath, certMode.getFile().split("[,]+")[0]));
		}
		return "";
	}

	public String createCert(CertInfo newCert, ZsDto zsDto, String orgFj, CertType certType, CertMode certMode, List<CertMetadata> certMetadata,
							 ResultBean stampInfo, File tplFile, File targetPath, String relativePath,
							 List<CertInfoOperationRecord> operationRecordList, List<Attachinfo> attachInfoList) throws Exception {
		String path = targetPath.getAbsolutePath() + "/", suffix, ext = "ofd";
		if ("1".equals(certMode.getTemplateType())) suffix = "zb";
		else if ("2".equals(certMode.getTemplateType())) suffix = "fb";
		else if ("3".equals(certMode.getTemplateType())) suffix = "fy";
		else if ("4".equals(certMode.getTemplateType())) suffix = "bgjl";
		else if ("5".equals(certMode.getTemplateType())) {
			suffix = "fj";
			ext = "pdf";
		} else return "未知模板类型";
		boolean isElqx = "3".equals(certType.getZslx()) || "26".equals(certType.getZslx()),
			isCreatePdf = "84".equals(certType.getZslx()) && StringUtils.equalsAny(certMode.getTemplateType(), "1");
		String timeStr = DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"),
			filename = newCert.getId() + "_" + suffix,
			wgzFile = newCert.getId() + "_" + timeStr + "_" + suffix + "_wgz." + ext,
			wgzPdfFile = newCert.getId() + "_" + timeStr + "_" + suffix + "_wgz.pdf",
			ygzFile = newCert.getId() + "_" + timeStr + "_" + suffix + "." + ext,
			ygzPdfFile = newCert.getId() + "_" + timeStr + "_" + suffix + ".pdf";
		int pageSize = 0, total = 0, maxPage = 0;
		//变更页
		if ("4".equals(certMode.getTemplateType())) {
			//换发不生成变更记录，当证书主表换发后产生变更时其zszt不应是2换发
			if ("2".equals(newCert.getZszt())) return null;
			List<CertInfoOperationRecord> recordList = operationRecordService.listBgjlByZsid(newCert.getZsid(), true),
				tmpRecordList = new ArrayList<>();
			if (CollectionUtils.isEmpty(recordList)) return null;
			for (CertInfoOperationRecord item : recordList) {
				if (!"1".equals(item.getGzstutas())) operationRecordList.add(item);
				if (StringUtils.equalsAnyIgnoreCase(item.getBglx(), "2", "3")) tmpRecordList.add(item);
			}
			recordList = tmpRecordList;
			//排版类型 1左三右三 2左四右四 3单页 4左二右二
			if ("1".equals(certMode.getPblx())) pageSize = 6;
			else if ("2".equals(certMode.getPblx())) pageSize = 8;
			else if ("4".equals(certMode.getPblx())) pageSize = 4;
			else pageSize = 1;
			//获取最近一次换证的索引
			int start = -1;
			for (int idx = 0; idx < recordList.size(); idx++) {
				if ("2".equals(recordList.get(idx).getBglx())) start = idx;
			}
			//获取最近一次换证后的变更记录
			if (0 <= start) recordList = recordList.subList(start + 1, recordList.size());
			if (CollectionUtils.isEmpty(recordList)) return null;
			List<CertInfoOperationDetail> detailList = new ArrayList<>();
			if (isElqx) {
				recordList.sort((a1, a2) -> {
					Date d1 = a1.getCzsj(), d2 = a2.getCzsj();
					if (null == d1) return -1;
					if (null == d2) return 1;
					if (d1.before(d2)) return 1;
					if (d1.after(d2)) return -1;
					return 0;
				});
				QueryWrapper<CertInfoOperationDetail> query = new QueryWrapper<>();
				query.in("ZSCZJL", recordList.stream().map(CertInfoOperationRecord::getId).collect(Collectors.toList()));
				query.orderByAsc("ZSCZJL,CZSJ,TO_NUMBER(BGCS)");
				detailList = operationDetailService.list(query);
			}
			total = recordList.size();
			maxPage = (int) Math.ceil(total * 1.0 / pageSize);
			String filenameTpl = suffix + "_%s.odf";
			File tmpPath = new File(path, zsDto.getId());
			try {
				if (!tmpPath.exists() && !tmpPath.mkdirs()) return "临时目录[" + tmpPath.getCanonicalPath() + "]创建失败";
				certMetadata = new ArrayList<>();
				List<Map<String, Object>> modifyInfoList = new ArrayList<>();
				for (int idx = 0; idx < total; idx++) {
					CertInfoOperationRecord item = recordList.get(idx);
					String content = StringUtils.join(item.getBgnr(), item.getBgyy(), "；");
					//二类器械注册证和二类器械体外诊断试剂，变更页特殊处理
					if ("3".equals(certType.getZslx()) || "26".equals(certType.getZslx())) {
						Map<String, Object> map = new HashMap<>();
						map.put("modifyinfo", item.getBgnr());
						map.put("modifytime", item.getCzsj());
						StringBuilder bz = new StringBuilder();
						if (StringUtils.isNotBlank(item.getBgyy())) bz.append(item.getBgyy());
						else {
							for (CertInfoOperationDetail detail : detailList) {
								if (!StringUtils.equalsIgnoreCase(detail.getZsczjl(), item.getId()) || StringUtils.isBlank(detail.getBz()))
									continue;
								bz.append(0 < bz.length() ? "；" : "").append(detail.getBz());
							}
						}
						map.put("bz", bz.toString());
						modifyInfoList.add(map);
					} else {
						BeanUtils.setProperty(zsDto, "modifyinfo" + (idx + 1), content);
						BeanUtils.setProperty(zsDto, "modifytime" + (idx + 1), item.getCzsj());
						certMetadata.add(CertMetadata.byYssx("modifyinfo" + (idx + 1)));
						certMetadata.add(CertMetadata.byYssx("modifytime" + (idx + 1)));
					}
				}
				zsDto.setModifyinfoList(modifyInfoList);
				createCert(zsDto, certMode, certMetadata, tplFile, path + wgzFile, pageSize);
			} finally {
				FileUtils.deleteQuietly(tmpPath);
			}
		} else if ("5".equals(certMode.getTemplateType())) {//附件
			if (StringUtils.isBlank(orgFj)) return null;
			int idx = 1;
			for (String item : StringUtils.trimToEmpty(orgFj).split("[,]+")) {
				File file = new File(uploadPath, item);
				if (!file.exists() && !file.isFile()) return "附件[ " + item + " ]不存在";
				String target = newCert.getId() + "_" + timeStr + "_" + suffix + "_" + StringUtils.right("000" + idx, 3)
					+ (null == stampInfo ? "_wgz" : "") + ".pdf",
					relativeFile = relativePath + "/" + target;
				String error = OfdUtil.toPdf(file.getAbsolutePath(), path + target, certMode
					, "1".equals(certMode.getIsSeal()) ? stampInfo : null, false);
				if ("useSourceFile".equals(error)) {
					relativeFile = item;
				} else if (StringUtils.isNotBlank(error)) return error;
				addAttachInfo(attachInfoList, filename + "_" + StringUtils.right("000" + idx, 3) + "_wgz.ofd"
					, certMode.getTemplateName() + idx, relativeFile, zsDto.getId(), null != stampInfo);
				idx++;
			}
			return null;
		} else {
			createCert(zsDto, certMode, certMetadata, tplFile, path + wgzFile, pageSize);
		}
		if (!new File(path, wgzFile).exists()) return certMode.getTemplateName() + "模板未盖章文件生成失败";
		if (isCreatePdf) OfdUtil.ofd2Pfd(path + wgzFile, false);
		if ("1".equals(certMode.getIsmergeFile())) {
			if (StringUtils.isNotBlank(orgFj)) {
				String error = OfdUtil.makeAttach(path + wgzFile, path + ygzFile, orgFj, uploadPath, certMode,
					"1".equals(certMode.getIsSeal()) ? stampInfo : null);
				if (StringUtils.isNotBlank(error)) return certMode.getTemplateName() + "模板的合并附件失败：" + error;
				Files.move(Paths.get(path + ygzFile), Paths.get(path + wgzFile), StandardCopyOption.REPLACE_EXISTING);
			}
		}
		addAttachInfo(attachInfoList, filename + "_wgz.ofd", certMode.getTemplateName(), relativePath + "/" + wgzFile, zsDto.getId(), false);
		if (null != stampInfo) {
			if ("4".equals(certMode.getTemplateType())) {
				String tmpFile = filename + "_tmp.ofd";
				try {
					StringBuilder sb = new StringBuilder();
					for (int idx = 1; idx < maxPage; idx++) sb.append(1 < idx ? "," : "").append(idx);
					String pages = sb.toString();
					for (int idx = 0; idx < pageSize; idx++) {
						String x, y, last = 0 == total % pageSize || idx < total % pageSize ? (StringUtils.isNotBlank(pages) ? "," : "") + maxPage : "";
						if (2 > pageSize || pageSize / 2 > idx) {
							x = BeanUtils.getPropertyStr(certMode, "postleftX" + (idx + 1));
							y = BeanUtils.getPropertyStr(certMode, "postLeft" + (idx + 1));
						} else {
							x = BeanUtils.getPropertyStr(certMode, "postrightX" + (idx + 1 - pageSize / 2));
							y = BeanUtils.getPropertyStr(certMode, "postRight" + (idx + 1 - pageSize / 2));
						}
						JSONObject json = SignatureUtil.createSignInfo(x, y, null, null, null, pages + last, stampInfo.getSealCode(), stampInfo.getSealName());
						log.debug("multi sign ===> {}", json.toJSONString());
						String source = path + (1 > idx ? wgzFile : tmpFile),
							target = path + (2 > pageSize || 0 < idx || 2 > total ? ygzFile : tmpFile);
						SignatureUtil.addSignOfd(source, target, json);
						if ((idx + 1) < pageSize && (1 < maxPage || idx + 1 < total))
							Files.move(Paths.get(target), Paths.get(path + tmpFile), StandardCopyOption.REPLACE_EXISTING);
						else break;
					}
				} finally {
					FileUtils.deleteQuietly(new File(path, tmpFile));
				}
			} else if ("1".equals(certMode.getPostmethod())) {
				SignatureUtil.addSignOfd(path + wgzFile, path + ygzFile, certMode.getPostleftX1(),
					certMode.getPostLeft1(), null, null, null, "0", stampInfo.getSealCode(), stampInfo.getSealName());
				if (isCreatePdf)
					SignatureUtil.addSignOfd(path + wgzPdfFile, path + ygzPdfFile, certMode.getPostleftX1(),
						certMode.getPostLeft1(), null, null, null, "0", stampInfo.getSealCode(), stampInfo.getSealName());
			} else {
				SignatureUtil.addSignOfd(path + wgzFile, path + ygzFile, certMode.getPostleftX1(),
					certMode.getPostLeft1(), null, null, certMode.getWbpost(), "0", stampInfo.getSealCode(), stampInfo.getSealName());
				if (isCreatePdf)
					SignatureUtil.addSignPDF(path + wgzPdfFile, path + ygzPdfFile, certMode.getPostleftX1(),
						certMode.getPostLeft1(), null, null, certMode.getWbpost(), "0", stampInfo.getSealCode(), stampInfo.getSealName());
			}
			// 医疗器械出口销售证明，有子表也需要盖章
			if ("1".equals(certMode.getTemplateType()) && "73".equals(certType.getZslx())
					&& CollectionUtils.isNotEmpty(zsDto.getSubMap().get(CertUtils.CertSubTableEnum.QXCK_XSZM.getAbbr()))) {
				int pageCount = 100;
				try {
					OFDReader reader = new OFDReader(path + ygzFile);
					pageCount = reader.getNumberOfPages();
					System.out.println("OFD文件页数: " + pageCount);
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				SignatureUtil.addSignOfd(path + ygzFile, path + ygzFile, certMode.getPostleftX1(),
						certMode.getPostLeft1(), null, null, null, "2-"+pageCount, stampInfo.getSealCode(), stampInfo.getSealName());
				if (isCreatePdf)
					SignatureUtil.addSignOfd(path + ygzFile, path + ygzPdfFile, certMode.getPostleftX1(),
							certMode.getPostLeft1(), null, null, null, "2-"+pageCount, stampInfo.getSealCode(), stampInfo.getSealName());
			}
			if (!new File(path, ygzFile).exists()) return certMode.getTemplateName() + "模板盖章文件生成失败";
			addAttachInfo(attachInfoList, filename + ".ofd", certMode.getTemplateName(), relativePath + "/" + ygzFile, zsDto.getId(), true);
		}
		return null;
	}

	public String createCert(ZsDto zsDto, CertMode certMode, List<CertMetadata> certMetadata, File tplFile, String target, int pageSize) {
		//word模板
		if ("3".equals(certMode.getModeformat())) {
			if (StringUtils.equalsAnyIgnoreCase(certMode.getTemplateType(), "1", "2")) {
				new XmlUtil().getWordToOfdByJH(tplFile.getAbsolutePath(), target, zsDto, certMetadata);
			} else {
				XmlUtil.getWordByWord(tplFile.getAbsolutePath(), target, zsDto, zsDto.getQymc());
			}
		} else {
			String xml = XmlUtil.createCardprintXMLForOFD(zsDto, certMetadata, pageSize);
			if (StringUtils.isNotBlank(zsDto.getBgnr())) {
				OfdUtil.template2Ofd(xml, tplFile.getAbsolutePath(), target);
			} else {
				OfdUtil.generaterMorePage(xml, tplFile.getAbsolutePath(), target);
			}
		}
		return null;
	}

	public void addAttachInfo(List<Attachinfo> attachInfoList, String filename, String type, String fileUrl, String zsid, boolean isSeal) {
		LoginUser user = WebUtils.getLoginUser();
		Attachinfo attachinfo = new Attachinfo();
		attachinfo.setId(UUIDGenerator.generate());
		attachinfo.setCreateBy(user.getUsername());
		attachinfo.setCreateTime(new Date());
		attachinfo.setType(type);
		attachinfo.setModeUrl(fileUrl);
		attachinfo.setStatus("1");
		attachinfo.setUserId(user.getId());
		attachinfo.setUserName(user.getRealname());
		attachinfo.setFileName(filename);
		attachinfo.setZsid(zsid);
		attachinfo.setIsgz(isSeal ? "1" : "0");
		attachInfoList.add(attachinfo);
	}

	public List<CertMetadata> getCertMetadata(String cardTypeId, String versionId) {
		if (StringUtils.isBlank(versionId)) {
			LambdaQueryWrapper<CertMetadataVersion> query = new LambdaQueryWrapper<>();
			query.eq(CertMetadataVersion::getCertTypeId, cardTypeId);
			query.eq(CertMetadataVersion::getStatus, "0");
			List<CertMetadataVersion> list = certMetadataVersionService.list(query);
			if (CollectionUtils.isNotEmpty(list)) versionId = list.get(0).getId();
		}
		LambdaQueryWrapper<CertMetadata> query = new LambdaQueryWrapper<>();
		query.eq(CertMetadata::getCertmetadataversionId, versionId);
		query.eq(CertMetadata::getZt, 0);
		//query.eq(CertMetadata::getSfsc, 0);
		query.orderByAsc(CertMetadata::getPx);
		return certMetadataService.list(query);
	}

	@Autowired
	public CertHandleServiceImpl(CertHandleMapper certHandleMapper, ICertTypeService certTypeService, ICertModeService certModeService,
								 ICertMetadataVersionService certMetadataVersionService, ICertMetadataService certMetadataService,
								 IZsYwxxbService zsYwxxbService, ICertInfoService certInfoService,
								 ICertInfoOperationRecordService operationRecordService, ICertInfoOperationDetailService operationDetailService,
								 IAttachinfoService attachInfoService, ICertSubTableService subTableService,
								 ITYwSjXybService ywSjXybService, ISDeptService deptService) {
		this.certHandleMapper = certHandleMapper;
		this.subTableService = subTableService;
		this.certTypeService = certTypeService;
		this.certModeService = certModeService;
		this.certMetadataVersionService = certMetadataVersionService;
		this.certMetadataService = certMetadataService;
		this.zsYwxxbService = zsYwxxbService;
		this.certInfoService = certInfoService;
		this.operationRecordService = operationRecordService;
		this.operationDetailService = operationDetailService;
		this.attachInfoService = attachInfoService;
		this.ywSjXybService = ywSjXybService;
		this.deptService = deptService;
	}

	protected CertHandleMapper certHandleMapper;
	protected ICertSubTableService subTableService;
	protected ICertTypeService certTypeService;
	protected ICertModeService certModeService;
	protected ICertMetadataVersionService certMetadataVersionService;
	protected ICertMetadataService certMetadataService;
	protected IZsYwxxbService zsYwxxbService;
	protected ICertInfoService certInfoService;
	protected ICertInfoOperationRecordService operationRecordService;
	protected ICertInfoOperationDetailService operationDetailService;
	protected IAttachinfoService attachInfoService;
	protected ITYwSjXybService ywSjXybService;
	protected ISDeptService deptService;

	@Value(value = "${jeecg.path.upload}")
	private String uploadPath;

	@Value("${qrcode.serverUrl}")
	private String serverUrl;

}
