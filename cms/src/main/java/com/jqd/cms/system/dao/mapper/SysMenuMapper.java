package com.jqd.cms.system.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.jqd.cms.system.model.SysMenu;

@Repository
public interface SysMenuMapper {

	/**
	 * 通过父节点ID 检索菜单信息
	 * @param parentId
	 */
	List<SysMenu> selectByParentKey(Long parentId) ;

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