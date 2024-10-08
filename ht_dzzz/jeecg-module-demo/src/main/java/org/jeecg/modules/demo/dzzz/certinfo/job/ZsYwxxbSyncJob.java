package org.jeecg.modules.demo.dzzz.certinfo.job;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.modules.demo.dzzz.certinfo.service.ICertinfoJobService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author huke
 * @date 2024年08月27日 18:56
 */
@Slf4j
@Component
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class ZsYwxxbSyncJob implements Job {
    @Autowired
    private ICertinfoJobService certinfoJobService;
    private String parameter;

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println(" --- 1111111同步任务调度开始 --- ");
        certinfoJobService.xzspToZsxt(this.parameter);
    }

}
