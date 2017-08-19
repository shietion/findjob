package com.jqd.cms.core.queue;

/**
 * 
 * @author dujianqiao
 * <p>desc</p>
 * @version 1.1
 * @date 2017年7月20日 下午9:42:23
 */
public interface TaskLevelHelper {
	/**
	 * 任务优先度高
	 */
	public int TASK_LEVEL_HIGHEST  = Integer.MIN_VALUE;
	/**
	 * 任务优先度低
	 */
	public int TASK_LEVEL_LOWEST = Integer.MAX_VALUE;
}
