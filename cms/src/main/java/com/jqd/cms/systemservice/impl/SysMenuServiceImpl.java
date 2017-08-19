package com.jqd.cms.systemservice.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.jqd.cms.base.BaseServiceImpl;
import com.jqd.cms.system.dao.mapper.SysMenuMapper;
import com.jqd.cms.system.model.SysMenu;
import com.jqd.cms.system.service.SysMenuService;

/**
 * SysMenuService接口实现
 * 
 * @author by dujianqiao on 2017/7/31.
 * @version 1.1 <b>DATE:</b> 2017/7/31.
 */
@Service
@Transactional
public class SysMenuServiceImpl extends BaseServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

	public static Logger logger = LoggerFactory.getLogger(SysMenuServiceImpl.class);

	@Autowired
	SysMenuMapper sysMenuMapper;

	/**
	 * 通过父节点ID 检索菜单信息
	 * 
	 * @param parentId
	 */
	public List<SysMenu> selectByParentKey(Long parentId) {
		return sysMenuMapper.selectByParentKey(parentId) ;
	}

	/**
	 * 通过菜单ID 删除菜单信息
	 * 
	 * @param sId
	 * @return
	 */
	public int deleteByPrimaryKey(Long sId) {
		return sysMenuMapper.deleteByPrimaryKey(sId) ;
	}

	/**
	 * 新增菜单信息
	 * 
	 * @param record
	 * @return
	 */
	public int insertSelective(SysMenu record) {
		return sysMenuMapper.insertSelective(record) ;
	} 

	/**
	 * 通过菜单ID 检索菜单信息
	 * 
	 * @param sId
	 * @return
	 */
	public SysMenu selectByPrimaryKey(Long sId){
		return sysMenuMapper.selectByPrimaryKey(sId) ;
	} 

	/**
	 * 修改菜单信息
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(SysMenu record) {
		return sysMenuMapper.updateByPrimaryKeySelective(record) ;
	} 

}