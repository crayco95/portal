package com.portal.persistence;

import org.springframework.beans.factory.annotation.Autowired;

import com.portal.dao.UserMapper;

public class UserServiceDb {
	@Autowired
	private UserMapper userMapper;

}
