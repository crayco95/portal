package com.portal.dao;


import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.portal.model.Role;


@Mapper
public interface RoleMapper {
	
	public List<Role> getRoleByUserid(int userid);
	public void getRoleByUseridDB(HashMap<Object, Object> parametrosINOUT);
	
	
}
