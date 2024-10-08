package org.jeecg.modules.demo.dzzz.dataExchange.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class WhsjJob {

    private static final Logger logger = LoggerFactory.getLogger(WhsjJob.class);


    public void cleanOrder() {
        System.out.println("======开始====");
        logger.debug("处理--------------开始");
        logger.debug("处理--------------结束");
        System.out.println("======结束====");
    }

}
