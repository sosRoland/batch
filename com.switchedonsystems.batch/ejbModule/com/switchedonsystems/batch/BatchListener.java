/**
 * 
 */
package com.switchedonsystems.batch;

import javax.batch.api.listener.AbstractJobListener;
import javax.batch.runtime.context.JobContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author roland
 *
 */

@Named
public class BatchListener extends AbstractJobListener {

	/***********************************************
	 * System Resources
	 */

	@Inject
    private JobContext jobContext; 

		
	/**
	 * 
	 */
	public BatchListener() {
	}

	/* (non-Javadoc)
	 * @see javax.batch.api.listener.AbstractJobListener#afterJob()
	 */
	@Override
	public void afterJob() throws Exception {
		System.out.println("BatchListiner::afterJob Execution of " + jobContext.getExecutionId() + " done");
	}
}
