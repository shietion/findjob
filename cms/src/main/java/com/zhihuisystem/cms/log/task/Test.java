package com.zhihuisystem.cms.log.task;

import com.zhihuisystem.cms.core.queue.QueueManager;
import com.zhihuisystem.cms.log.model.SystemLog;

public class Test {

	public static void main(String[] args) {
		SystemLog log = new SystemLog() ;
		SysLogTask st = new SysLogTask() ;
		st.setLog(log);
		QueueManager.add(st);
	}
}
