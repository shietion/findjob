package com.jqd.cms.system.service;

import java.util.List;

import com.jqd.cms.base.BaseService;
import com.jqd.cms.system.model.SysMenu;

/**
 * SysMenuService接口
 * 
 * @author by dujianqiao on 2017/7/31.
 * @version 1.1 <b>DATE:</b> 2017/7/31.
 */
public interface SysMenuService extends BaseService<SysMenu> {

	/**
	 * 通过父节点ID 检索菜单信息
	 * 
	 * @param parentId
	 */
	List<SysMenu> selectByParentKey(Long parentId);

	/**
	 * 通过菜单ID 删除菜单信息
	 * 
	 * @param sId
	 * @return
	 */
	int deleteByPrimaryKey(Long sId);

	/**
	 * 新增菜单信息
	 * 
	 * @param record
	 * @return
	 */
	int insertSelective(SysMenu record);

	/**
	 * 通过菜单ID 检索菜单信息
	 * 
	 * @param sId
	 * @return
	 */
	SysMenu selectByPrimaryKey(Long sId);

	/**
	 * 修改菜单信息
	 * 
	 * @param record
	 * @return
	 */
	int updateByPrimaryKeySelective(SysMenu record);

}