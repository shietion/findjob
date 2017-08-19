package com.jqd.cms.systemservice.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jqd.cms.base.BaseServiceImpl;
import com.jqd.cms.system.dao.mapper.SysUserMapper;
import com.jqd.cms.system.model.SysUser;
import com.jqd.cms.system.service.SysUserService;

/**
* SysUserService接口实现
* @author by dujianqiao on 2017/7/29.
* @version 1.1
* <b>DATE:</b> 2017/7/29.
*/
@Service
@Transactional
public class SysUserServiceImpl extends BaseServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    public static Logger logger = LoggerFactory.getLogger(SysUserServiceImpl.class);

    @Autowired
    SysUserMapper sysUserMapper;

	@Override
	public SysUser login(SysUser user) {
		return sysUserMapper.login(user) ;
	}
    
}