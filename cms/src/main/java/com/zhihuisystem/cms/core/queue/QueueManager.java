package com.zhihuisystem.cms.core.queue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * 
 * @author dujianqiao
 *         <p>
 * 		desc 统一处理线程池，加入相应的任务
 *         </p>
 * @version 1.1
 * @date 2017年7月20日 下午9:39:05
 */
public class QueueManager {
	private static Logger logger = LoggerFactory.getLogger(QueueManager.class);

	private static ThreadPoolTaskExecutor poolTaskExecutor;

	private QueueManager() {
	}

	private static void init() {
		poolTaskExecutor = new ThreadPoolTaskExecutor();
		// 线程池所使用的缓冲队列
		poolTaskExecutor.setQueueCapacity(200);
		// 线程池维护线程的最少数量(核心线程数)
		poolTaskExecutor.setCorePoolSize(5);
		// 线程池维护线程的最大数量
		poolTaskExecutor.setMaxPoolSize(100);
		// 线程池维护线程所允许的空闲时间
		poolTaskExecutor.setKeepAliveSeconds(30000);
		poolTaskExecutor.initialize();
	}

	/**
	 * 添加任务
	 * 
	 * @param qt
	 */
	public static void add(QueueTask qt) {
		if (poolTaskExecutor == null) {
			init();
		}
		logger.debug("add task:" + qt.getName());
		TaskThread tt = new TaskThread(qt);
		poolTaskExecutor.execute(tt);

	}

}

class TaskThread extends Thread {
	private static Logger logger = LoggerFactory.getLogger(TaskThread.class);

	private QueueTask m_qt;

	public TaskThread(QueueTask qt) {
		m_qt = qt;
	}

	@Override
	public void run() {
		logger.debug("start exec:" + m_qt.getName());
		m_qt.exec();
		logger.debug("end exec:" + m_qt.getName());
	}

}
