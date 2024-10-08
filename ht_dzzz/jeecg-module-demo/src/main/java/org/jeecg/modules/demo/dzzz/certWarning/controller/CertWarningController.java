package org.jeecg.modules.demo.dzzz.certWarning.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.api.vo.Result;
import org.jeecg.config.JeecgBaseConfig;
import org.jeecg.modules.demo.dzzz.certWarning.dto.YxqWarnReqDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.YxqWarnResDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.WgzWarnReqDto;
import org.jeecg.modules.demo.dzzz.certWarning.dto.WgzWarnResDto;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertInfoService;
import org.jeecg.modules.demo.dzzz.constant.YwConstant;
import org.jeecgframework.poi.excel.def.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.view.JeecgEntityExcelView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;


/**
 * 证书预警
 */
@Api(tags="证书预警")
@RestController
@RequestMapping("/certWarning")
@Slf4j
public class CertWarningController {

    @Autowired
    private ICertInfoService certInfoService;
    @Resource
    private JeecgBaseConfig jeecgBaseConfig;

    /**
     * 有效期预警-分页列表查询
     * @param dto
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value="证书-有效期预警-分页列表查询", notes="证书-有效期预警-分页列表查询")
    @GetMapping(value = "/queryYxqPageList")
    public Result<IPage<YxqWarnResDto>> queryYxqPageList(YxqWarnReqDto dto,
                                                         @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                         @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<YxqWarnReqDto> page = new Page<>(pageNo, pageSize);
        IPage<YxqWarnResDto> pageList = certInfoService.selectYxqWarningPageList(dto, page);
        List<YxqWarnResDto> recordList = pageList.getRecords();
        recordList.forEach(bean -> {
            // 当时时间 + 1个月
            LocalDate dqrqAddOneMonth = LocalDate.parse(bean.getOneMonth());
            // 有效期止
            LocalDate yxqz = LocalDate.parse(bean.getYxqz());
            if(dqrqAddOneMonth.compareTo(yxqz) > 0) {
                bean.setYjbs("红牌");
                bean.setYjIcon("/@/assets/images/yj_red.png");
            } else {
                // 当时时间 + 3个月
                LocalDate dqrqAddThreeMonth = LocalDate.parse(bean.getThreeMonth());
                if(dqrqAddThreeMonth.compareTo(yxqz) > 0) {
                    bean.setYjbs("黄牌");
                    bean.setYjIcon("/@/assets/images/yj_yellow.png");
                }
            }
            if (null == bean.getYjclzt()) {
                bean.setYjclzt(YwConstant.YJCLZT_WCL);
            } else if (YwConstant.CONFIRM == Integer.parseInt(bean.getYjclzt())) {
                bean.setYjclzt(YwConstant.YJCLZT_YCL);
            }
        });
        return Result.OK(pageList);
    }

    /**
     * 未盖章预警-分页列表查询
     * @param dto
     * @param pageNo
     * @param pageSize
     * @return
     */
    @ApiOperation(value="证书-未盖章预警-分页列表查询", notes="证书-未盖章预警-分页列表查询")
    @GetMapping(value = "/queryWgzPageList")
    public Result<IPage<WgzWarnResDto>> queryWgzPageList(WgzWarnReqDto dto,
                                                         @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
                                                         @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize) {
        Page<WgzWarnReqDto> page = new Page<>(pageNo, pageSize);
        IPage<WgzWarnResDto> pageList = certInfoService.selectWgzWarningPageList(dto, page);
        return Result.OK(pageList);
    }

    /**
     * 证书-有效期预警-导出excel
     * @param dto
     * @return
     */
    @ApiOperation(value = "证书-有效期预警-导出excel", notes = "证书-有效期预警-导出excel")
    @RequestMapping(value = "/exportYxqXls")
    public ModelAndView exportYxqXls(YxqWarnReqDto dto) {
        List<YxqWarnResDto> exportList = certInfoService.selectYxqWarningList(dto);
        exportList.forEach(bean -> {
            // 当时时间 + 1个月
            LocalDate dqrqAddOneMonth = LocalDate.parse(bean.getOneMonth());
            // 有效期止
            LocalDate yxqz = LocalDate.parse(bean.getYxqz());
            if(dqrqAddOneMonth.compareTo(yxqz) > 0) {
                bean.setYjbs("红牌");
            } else {
                // 当时时间 + 3个月
                LocalDate dqrqAddThreeMonth = LocalDate.parse(bean.getThreeMonth());
                if(dqrqAddThreeMonth.compareTo(yxqz) > 0) {
                    bean.setYjbs("黄牌");
                }
            }
            if (null == bean.getYjclzt()) {
                bean.setYjclzt(YwConstant.YJCLZT_WCL);
            } else if (YwConstant.CONFIRM == Integer.parseInt(bean.getYjclzt())) {
                bean.setYjclzt(YwConstant.YJCLZT_YCL);
            }
        });

        String title = "证书有效期预警列表";
        ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
        mv.addObject(NormalExcelConstants.FILE_NAME, title);
        mv.addObject(NormalExcelConstants.CLASS, YxqWarnResDto.class);
        ExportParams exportParams = new ExportParams(title + "导出", null, title);
        exportParams.setImageBasePath(jeecgBaseConfig.getPath().getUpload());
        mv.addObject(NormalExcelConstants.PARAMS, exportParams);
        mv.addObject(NormalExcelConstants.DATA_LIST, exportList);
        return mv;
    }

    /**
     * 证书-未盖章预警-导出excel
     * @param dto
     * @return
     */
    @ApiOperation(value = "证书-未盖章预警-导出excel", notes = "证书-未盖章预警-导出excel")
    @RequestMapping(value = "/exportWgzXls")
    public ModelAndView exportWgzXls(WgzWarnReqDto dto) {
        List<WgzWarnResDto> exportList = certInfoService.selectWgzWarningList(dto);

        String title = "证书未盖章预警列表";
        ModelAndView mv = new ModelAndView(new JeecgEntityExcelView());
        mv.addObject(NormalExcelConstants.FILE_NAME, title);
        mv.addObject(NormalExcelConstants.CLASS, WgzWarnResDto.class);
        ExportParams exportParams = new ExportParams(title + "导出", null, title);
        exportParams.setImageBasePath(jeecgBaseConfig.getPath().getUpload());
        mv.addObject(NormalExcelConstants.PARAMS, exportParams);
        mv.addObject(NormalExcelConstants.DATA_LIST, exportList);
        return mv;
    }

}
