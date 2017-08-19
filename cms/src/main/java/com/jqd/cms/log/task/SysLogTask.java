package com.jqd.cms.log.task;

import com.jqd.cms.core.queue.QueueTask;
import com.jqd.cms.log.model.SystemLog;

public class SysLogTask extends QueueTask {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7715372371433855486L;
	
	private SystemLog log ;

	@Override
	public String getName() {
		return "SystemLogTask";
	}

	@Override
	public String getDesc() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	public SystemLog getLog() {
		return log;
	}

	public void setLog(SystemLog log) {
		this.log = log;
	}

	@Override
	public void exec() {
		//saveLog(log);
		
	}

}
