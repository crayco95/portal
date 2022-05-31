package com.portal.dao;

import org.apache.ibatis.annotations.Mapper;

import com.portal.model.User;

@Mapper
public interface UserMapper {
	
	public User findByUserid(int id);
	public User findByUsername(String username); 

}
