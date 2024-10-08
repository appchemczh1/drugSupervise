package org.jeecg.modules.sso;

import lombok.extern.slf4j.Slf4j;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.PersistJobDataAfterExecution;

/**
 * <p>Created by Raofeicheng on 2023/4/17.</p>
 * @author Raofeicheng
 * @version 1.0
 */
@PersistJobDataAfterExecution
@DisallowConcurrentExecution
@Slf4j
public class SsoSyncJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		SsoUtils.syncAll();
	}

}
