package org.jeecg.modules.demo.dzzz.dataExchange.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.StringUtils;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertHandleService;
import org.jeecg.modules.demo.dzzz.certmatadataversion.entity.CertMetadata;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.dataExchange.util.YwUtil;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;
import org.jeecg.modules.demo.dzzz.enums.YwlxEnum;
import org.jeecg.modules.demo.dzzz.information.entity.Information;
import org.jeecg.modules.demo.dzzz.information.service.IInformationService;
import org.jeecg.modules.demo.dzzz.util.CertUtils;
import org.jeecg.modules.demo.dzzz.util.DateUtils;
import org.jeecg.modules.demo.dzzz.wgz.entity.ZsYwxxb;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * <p>Created by Raofeicheng on 2024/8/31.</p>
 * @author Raofeicheng
 * @version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/inf/cert")
public class InfController {

	@PostMapping(value = "/add")
	public Result<?> add(@RequestBody String report, HttpServletRequest req) {
		if (StringUtils.isBlank(report)) return Result.error("请求报文为空");
		JSONObject json;
		ZsYwxxb bean;
		try {
			json = JSON.parseObject(report);
			bean = JSON.parseObject(report, ZsYwxxb.class);
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
			return Result.error("JSON解析失败");
		}
		if (StringUtils.isBlank(bean.getId())) return Result.error("业务id不能为空");
		bean.setZsid(StringUtils.defaultIfBlank(bean.getZsid(), json.getString(json.containsKey("licenseId") ? "licenseId" : "licenseid")));
		if (StringUtils.isBlank(bean.getZsid())) return Result.error("证书id不能为空");
		if (StringUtils.isBlank(bean.getZslx())) return Result.error("证书类型不能为空");
		if (!StringUtils.equalsAny(bean.getZslx(), "84")) return Result.error("暂不支持证书类型[ " + bean.getZslx() + " ]");
		if (StringUtils.isBlank(bean.getZsbh())) return Result.error("证书编号不能为空");
		if (StringUtils.isBlank(bean.getQymc())) return Result.error("企业名称不能为空");
		if (StringUtils.isBlank(bean.getShxydm())) return Result.error("社会信用代码不能为空");
		if (StringUtils.isBlank(bean.getFzjg())) return Result.error("发证机关不能为空");
		if (StringUtils.isBlank(bean.getFzrq())) return Result.error("发证日期不能为空");
		YwlxEnum ywlx = YwlxEnum.byCode(StringUtils.defaultIfBlank(bean.getZszt(), json.getString("ywlx")));
		if (null == ywlx) return Result.error("业务类型不存在");
		Date fzrq = DateUtils.parseDate(bean.getFzrq());
		if (null == fzrq) return Result.error("发证日期格式无法识别");
		bean.setFzrq(DateFormatUtils.format(fzrq, "yyyy-MM-dd"));
		bean.setYwlb(ywlx.getCode());
		bean.setZszt(ywlx.getCode());
		CertType certType = certTypeService.getByZslx(bean.getZslx(), true);
		if (null == certType) return Result.error("证书类型不存在");
		bean.setCerttypeid(certType.getId());
		bean.setZsdl(certType.getCerttypeClassification());
		Information qyxx = informationService.getByShxydm(bean.getShxydm());
		if (null == qyxx) return Result.error("社会信用代码不存在");
		bean.setQyid(qyxx.getId());
		if (null != zsYwxxbService.getById(bean.getId()))
			return Result.error("请不要重复推送");
		if (null != zsYwxxbService.getLastRecordByZsid(bean.getZsid()))
			return Result.error("该证书存在未盖章记录，请将其盖章后再推送新的操作");
		if (ywlx == YwlxEnum.HEFA) {
			if (null != certHandleService.getByZsid(bean.getZsid(), true))
				return Result.error("该证书已存在，不能再次核发");
		} else {
			return Result.error("暂不支持 " + ywlx.getName() + " 操作");
		}
		bean.setFzjgid(YwUtil.fzjgValid(bean.getFzjg(), deptService));
		List<CertMetadata> certMetadata = certHandleService.getCertMetadata(bean.getCerttypeid(), null);
		if (CollectionUtils.isEmpty(certMetadata)) Result.error("未配置证书元数据，无法生成证照");
		bean.setBbid(certMetadata.get(0).getCertmetadataversionId());
		CertUtils.setDataByMetadata(json, bean, certMetadata, "id", "qyid", "zslx", "fzjg", "fzrq", "jsly", "zt",
			"ywlb", "bbid", "mbid", "fzjgid", "sjtbGspt", "sjtbDa", "sjtbXzsp", "sjtbGj", "sjtbCwxx", "sjtbGjsj", "sync", "glzdb",
			"certtypeid", "zszt", "yxzt", "synctime", "zsdl", "oldId", "isxt", "zsid", "whid", "czzt", "iswh", "gztime");
		if (StringUtils.isBlank(bean.getQfr())) return Result.error("签发人不能为空");
		bean.setZt("3");
		bean.setYxzt("10");
		bean.setSjtbGj("0");
		String error = certHandleService.saveZsYwxxb(certType, bean);
		return Result.OK("");
	}

	@Autowired
	public InfController(ICertTypeService certTypeService, IInformationService informationService, IZsYwxxbService zsYwxxbService,
						 ICertHandleService certHandleService, ISDeptService deptService) {
		this.certTypeService = certTypeService;
		this.informationService = informationService;
		this.zsYwxxbService = zsYwxxbService;
		this.certHandleService = certHandleService;
		this.deptService = deptService;
	}

	protected ICertTypeService certTypeService;
	protected IInformationService informationService;
	protected IZsYwxxbService zsYwxxbService;
	protected ICertHandleService certHandleService;
	protected ISDeptService deptService;

}
