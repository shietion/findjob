package com.jqd.cms.system.dao.mapper;

import org.springframework.stereotype.Repository;
import com.jqd.cms.system.model.SysUser;

@Repository
public interface SysUserMapper {
	
    int deleteByPrimaryKey(Long sid);

    int insertSelective(SysUser record);

    SysUser selectByPrimaryKey(Long sid);

    int updateByPrimaryKeySelective(SysUser record);

	SysUser login(SysUser user);
}