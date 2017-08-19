package com.jqd.cms.core.queue;

import java.io.Serializable;

/**
 * 
 * @author Administrator
 * <p>desc 任务的初始类</p>
 * @version 1.1
 * @date 2017年7月20日 下午9:41:23
 */
public abstract class QueueTask implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5760986201011140363L;
	
	
	private int level=TaskLevelHelper.TASK_LEVEL_LOWEST;//优先成都
	//对任务描述
	public abstract String getName();
	//对数据的描述
	public abstract String getDesc();
	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	/**
	 * 执行
	 */
	public abstract void exec();
}
