package com.jqd.cms.log.task;

import com.jqd.cms.core.queue.QueueManager;
import com.jqd.cms.log.model.SystemLog;

public class Test {

	public static void main(String[] args) {
		SystemLog log = new SystemLog() ;
		SysLogTask st = new SysLogTask() ;
		st.setLog(log);
		QueueManager.add(st);
	}
}
