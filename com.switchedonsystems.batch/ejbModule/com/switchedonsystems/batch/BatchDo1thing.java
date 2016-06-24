/**
 * 
 */
package com.switchedonsystems.batch;

import javax.batch.api.AbstractBatchlet;
import javax.batch.runtime.BatchStatus;
import javax.inject.Named;

/**
 * @author roland
 *
 */

@Named
public class BatchDo1thing extends AbstractBatchlet {

	/**
	 * 
	 */
	public BatchDo1thing() {
	}

	/* (non-Javadoc)
	 * @see javax.batch.api.AbstractBatchlet#process()
	 */
	@Override
	public String process() throws Exception {
		System.out.println("BatchDo1thing::process Do Job");
		
		System.out.println("BatchDo1thing::process Done");
		
		//return BatchStatus.COMPLETED.name();
		return "DONE";
	}

}
