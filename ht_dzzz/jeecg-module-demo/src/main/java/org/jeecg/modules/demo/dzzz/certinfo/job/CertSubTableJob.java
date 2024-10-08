package org.jeecg.modules.demo.dzzz.certinfo.job;

import lombok.extern.slf4j.Slf4j;

import org.jeecg.modules.demo.dzzz.util.CertUtils;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

/**
 * <p>Created by Raofeicheng on 2024/9/13.</p>
 * @author Raofeicheng
 * @version 1.0
 */
@Slf4j
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
public class CertSubTableJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			CertUtils.CertSubTableEnum.initMetadata();
		} catch (Throwable e) {
			log.error(e.getMessage(), e);
		}
	}

}
