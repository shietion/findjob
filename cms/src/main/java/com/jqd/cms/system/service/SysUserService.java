package com.jqd.cms.system.service;

import com.jqd.cms.base.BaseService;
import com.jqd.cms.system.model.SysUser;

/**
* SysUserService接口
* @author by dujianqiao on 2017/7/29.
* @version 1.1
* <b>DATE:</b> 2017/7/29.
*/
public interface SysUserService extends BaseService<SysUser> {

	SysUser login(SysUser user);
}