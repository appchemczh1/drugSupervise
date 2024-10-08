package org.jeecg.modules.demo.dzzz.certinfo.job;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.util.DateUtils;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationDetailService;
import org.jeecg.modules.demo.dzzz.certInfoOperation.service.ICertInfoOperationRecordService;
import org.jeecg.modules.demo.dzzz.certinfo.entity.*;
import org.jeecg.modules.demo.dzzz.certinfo.mapper.CertInfoMapper;
import org.jeecg.modules.demo.dzzz.certinfo.service.*;
import org.jeecg.modules.demo.dzzz.certmatadataversion.service.ICertMetadataVersionService;
import org.jeecg.modules.demo.dzzz.certtype.service.ICertTypeService;
import org.jeecg.modules.demo.dzzz.czmx.service.ITYwZsCzjlmxLsNService;
import org.jeecg.modules.demo.dzzz.dept.service.ISDeptService;
import org.jeecg.modules.demo.dzzz.lszb.service.*;
import org.jeecg.modules.demo.dzzz.wgz.service.IZsYwxxbService;
import org.jeecg.modules.demo.spxt.service.*;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description: 同步定时任务测试
 *
 * 此处的同步是指 当定时任务的执行时间大于任务的时间间隔时
 * 会等待第一个任务执行完成才会走第二个任务
 *
 *
 * @author: taoyan
 * @date: 2020年06月19日
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Slf4j
@Service
public class CertinfoCountJob  implements Job {
    @Autowired
    ITYwZsLsNService itYwZsLsNService;
    @Autowired
    ITYwZsCzjlLsNService itYwZsCzjlLsNService;
    @Autowired
    ITJcZsCkomylyZbLsService itJcZsCkomylyZbLsService;
    @Autowired
    ITJcZsMzyphjsypddscpjZbLsService itJcZsMzyphjsypddscpjZbLsService;
    @Autowired
    ITJcZsYlqxcpckxszmZbLsService itJcZsYlqxcpckxszmZbLsService;
    @Autowired
    ITJcZsYlqxlcsybaZbLsService itJcZsYlqxlcsybaZbLsService;
    @Autowired
    ITJcZsYlqxscbaZbLsService itJcZsYlqxscbaZbLsService;
    @Autowired
    ITJcZsYlqxwtscbaZbLsService itJcZsYlqxwtscbaZbLsService;
    @Autowired
    ITJcZsYpckxszmZbLsService itJcZsYpckxszmZbLsService;
    @Autowired
    ITJcZsYpckzxzZbLsService itJcZsYpckzxzZbLsService;
    @Autowired
    ITJcZsYpscxkGmpLsService itJcZsYpscxkGmpLsService;
    @Autowired
    ITJcZsYpscxkStLsService itJcZsYpscxkStLsService;
    @Autowired
    ITJcZsYpscxkWtLsService itJcZsYpscxkWtLsService;
    @Autowired
    ITJcZsYpscxkZcLsService itJcZsYpscxkZcLsService;
    @Autowired
    ICertTypeService iCertTypeService;
    @Autowired
    ICertMetadataVersionService iCertMetadataVersionService;

    @Autowired
    ICertInfoOperationRecordService iCertInfoOperationRecordService;
    @Autowired
    ICertInfoOperationDetailService iCertInfoOperationDetailService;
    @Autowired
    ICertchildCkomylyService iCertchildCkomylyService;
    @Autowired
    ICertchildMzyphjsypddscService iCertchildMzyphjsypddscService;
    @Autowired
    ICertchildYlqxcpckxsService iCertchildYlqxcpckxsService;
    @Autowired
    ICertchildYlqxscbaZbService iCertchildYlqxscbaZbService;
    @Autowired
    ICertchildYpckxkzService iCertchildYpckxkzService;
    @Autowired
    ICertchildYlqxwtbaZbService iCertchildYlqxwtbaZbService;
    @Autowired
    ICertchildYpckxszmService iCertchildYpckxszmService;
    @Autowired
    ICertchildYpscGmpService iCertchildYpscGmpService;
    @Autowired
    ICertchildYpscStService iCertchildYpscStService;
    @Autowired
    ICertchildYpscWtService iCertchildYpscWtService;
    @Autowired
    ICertchildYpscZcService iCertchildYpscZcService;
    @Autowired
    ICertchirdYlqxlcsybaService iCertchirdYlqxlcsybaService;
    @Autowired
    IZsYwxxbService iZsYwxxbService;
    @Autowired
    ICertInfoService  iCertInfoService;
    @Autowired
    CertInfoMapper certInfoMapper;

    @Autowired
    ICertchildCkomylyHService iCertchildCkomylyHService;
    @Autowired
    ICertchildMzyphjsypddscHService iCertchildMzyphjsypddscHService;
    @Autowired
    ICertchildYlqxcpckxsHService iCertchildYlqxcpckxsHService;
    @Autowired
    ICertchildYlqxscbaZbHService iCertchildYlqxscbaZbHService;
    @Autowired
    ICertchildYpckxkzHService iCertchildYpckxkzHService;
    @Autowired
    ICertchildYlqxwtbaZbHService iCertchildYlqxwtbaZbHService;
    @Autowired
    ICertchildYpckxszmHService iCertchildYpckxszmHService;
    @Autowired
    ICertchildYpscGmpHService iCertchildYpscGmpHService;
    @Autowired
    ICertchildYpscStHService iCertchildYpscStHService;
    @Autowired
    ICertchildYpscWtHService iCertchildYpscWtHService;
    @Autowired
    ICertchildYpscZcHService iCertchildYpscZcHService;
    @Autowired
    ICertchirdYlqxlcsybaHService iCertchirdYlqxlcsybaHService;
    @Autowired
    ISDeptService isDeptService;
    @Autowired
    ITYwZsCzjlmxLsNService itYwZsCzjlmxLsNService;

     //中午 12点半 以及 凌晨1点半点开始跑
    //cron ="0 30 12,1 * * ?"
    //@Scheduled(cron  ="0 30 12,1 * * ?")
    public void countqg() throws JobExecutionException {
        log.info(" --- 同步计算类任务调度开始 --- ");
        try {
            //此处模拟任务执行时间 5秒  任务表达式配置为每秒执行一次：0/1 * * * * ? *
            //计算二类证换发的有效期
            LambdaQueryWrapper<CertInfo> lq=new LambdaQueryWrapper<>();
            lq.eq(CertInfo::getZt,"4");
            //(二类医疗器械注册证，体外试剂)
            lq.in(CertInfo::getZslx,"3","26");
            List<CertInfo> list = iCertInfoService.list(lq);
            for (CertInfo certinfo : list) {
                Date now=new Date();
                if(certinfo.getYxqz()!=null) {
                    Date yxqz =DateUtils.parseDate( certinfo.getYxqz(),"yyyy-MM-dd");
                    if (now.compareTo(yxqz) > 1) {
                        certinfo.setIsgq("1");
                        certinfo.setYxzt("60");
                        iCertInfoService.updateById(certinfo);
                    }
                    else {
                        certinfo.setIsgq("0");
                        certinfo.setYxzt("10");
                        iCertInfoService.updateById(certinfo);
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //测试发现 每5秒执行一次
        log.info(" --- 计算类任务执行完毕，时间："+DateUtils.now()+"---");
    }


    // 处理过期证照
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        iCertInfoService.dealCertExpire();
    }

}
