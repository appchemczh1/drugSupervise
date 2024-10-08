package org.jeecg.modules.demo.dzzz.dataDeal;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.common.util.CollectionUtils;
import org.jeecg.modules.demo.dzzz.attachinfo.entity.Attachinfo;
import org.jeecg.modules.demo.dzzz.certinfo.entity.CertInfo;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.certtype.entity.CertType;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Api(tags="提供给外部的接口")
@RestController
@RequestMapping("/outerJk")
@Slf4j
public class OuterDataDealController {
    @Autowired
    private ICertTypeService certTypeService;
    @Autowired
    private ICertInfoService certInfoService;

    // 数科阅读器URL
    @Value("${shuke.ydqUrl}")
    private String ydqUrl;
    // 证照URL
    @Value("${shuke.certUrl}")
    private String certUrl;

    @ApiOperation(value="行政审批-预览证照", notes="行政审批-预览证照")
    @GetMapping(value = "/getAttachByParams")
    public Result<String> getAttachByParams(HttpServletRequest request, HttpServletResponse response,
                                            @RequestParam String xzspid, @RequestParam String zsid) throws IOException {
        LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CertInfo :: getId, xzspid);
        queryWrapper.eq(CertInfo :: getZsid, zsid);
        queryWrapper.eq(CertInfo :: getYxzt, YwConstant.ZSZT_YX);
        CertInfo certInfo = certInfoService.getOne(queryWrapper);
        if (certInfo == null) {
            return Result.error("未查询到证书信息，请联系管理员");
        }
        Attachinfo attachinfo = certInfoService.getAttachByParamsForSp(certInfo.getId());
        if (attachinfo == null) {
            return Result.error("未找到对应的证照，请联系管理员");
        }
        String openCertUrl = ydqUrl + "?file=" + certUrl + attachinfo.getModeUrl();
        response.sendRedirect(openCertUrl);
        return Result.OK("调用成功");
    }

    @ApiOperation(value="行政审批-获取证照列表", notes="行政审批-获取证照列表")
    @GetMapping(value = "/getAttachListByParams")
    public Result<List<Attachinfo>> getAttachListByParams(@RequestParam String zslx, @RequestParam String zsbh) {
        // 查询证书类型ID
        LambdaQueryWrapper<CertType> certTypeQuery = new LambdaQueryWrapper();
        certTypeQuery.eq(CertType::getZslx, zslx);
        certTypeQuery.eq(CertType::getStatus, YwConstant.CERT_TYPE_STATUS_FB);
        List<CertType> certTypeList = certTypeService.list(certTypeQuery);
        if (CollectionUtils.isEmpty(certTypeList)) {
            return Result.error("未找到该证书类型，请联系管理员");
        }
        LambdaQueryWrapper<CertInfo> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CertInfo :: getCerttypeid, certTypeList.get(0).getId());
        queryWrapper.eq(CertInfo :: getZsbh, zsbh);
        queryWrapper.ne(CertInfo :: getYxzt, YwConstant.ZSZT_ZF);
        CertInfo certInfo = certInfoService.getOne(queryWrapper);
        if (certInfo == null) {
            return Result.error("未查询到证书信息，请联系管理员");
        }

        List<Attachinfo> attachList = certInfoService.getAttachListByParamsForSp(certInfo.getId());
        if (CollectionUtils.isEmpty(attachList)) {
            return Result.error("该证照未生成证照，请联系管理员");
        }
        for (Attachinfo attachinfo : attachList) {
            attachinfo.setModeUrl(certUrl + attachinfo.getModeUrl());
        }
        return Result.OK("调用成功", attachList);
    }

}
