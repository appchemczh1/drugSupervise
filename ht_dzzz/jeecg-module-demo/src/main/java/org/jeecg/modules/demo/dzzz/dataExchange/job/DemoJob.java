package org.jeecg.modules.demo.dzzz.dataExchange.job;

import lombok.extern.slf4j.Slf4j;
import org.jeecg.common.util.DateUtils;
import org.quartz.*;

@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Slf4j
public class DemoJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("00000000000000000000000");
        log.info(" --- 同步任务调度开始 --- ");
        log.info(" --- 执行完毕，时间："+ DateUtils.now()+"---");
    }
}
