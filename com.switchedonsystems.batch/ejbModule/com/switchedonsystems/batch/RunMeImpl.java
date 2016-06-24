/**
 * 
 */
package com.switchedonsystems.batch;

import javax.annotation.PostConstruct;
import javax.batch.operations.JobOperator;
import javax.batch.runtime.BatchRuntime;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 * @author roland
 *
 */

@Startup
@Singleton
public class RunMeImpl {

	private int runMeCount=0;
	
	/**
	 * 
	 */
	public RunMeImpl() {
	}

	
	@PostConstruct
	public void init () {
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		long executionId = jobOperator.start("MyBatch", null);
		
		System.out.println("RunMeImpl::init " + executionId);
	}
	
	@Schedule(dayOfWeek="*", hour="*", minute="*", second="*/10", persistent=false)
	public void run () {
		runMeCount++;
		
		if (runMeCount >= 20)
			return;
		
		JobOperator jobOperator = BatchRuntime.getJobOperator();
		long executionId = jobOperator.start("MyBatch", null);
		
		System.out.println("RunMeImpl::run " + executionId + " in loop " + runMeCount);
		
	}
	
}
