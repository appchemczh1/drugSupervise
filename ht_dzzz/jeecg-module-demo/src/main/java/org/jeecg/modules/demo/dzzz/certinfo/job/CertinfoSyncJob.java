package org.jeecg.modules.demo.dzzz.certinfo.job;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertinfoJobService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Description: 同步定时任务测试
 * <p>
 * 此处的同步是指 当定时任务的执行时间大于任务的时间间隔时
 * 会等待第一个任务执行完成才会走第二个任务
 * @author: taoyan
 * @date: 2020年06月19日
 */
//@PersistJobDataAfterExecution
//@DisallowConcurrentExecution

//public class CertinfoSyncJob implements Job {

@Slf4j
@Component
public class CertinfoSyncJob {
    @Autowired
    private ICertinfoJobService certinfoJobService;
    private String parameter;

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    //    @Override
//    @Scheduled(fixedDelay = 3000)
    @Scheduled(cron="0/5 * *  * * ? ")
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(" --- 同步任务调度开始 --- ");
//        certinfoJobService.xzspToZsxt(this.parameter);

    }


}
