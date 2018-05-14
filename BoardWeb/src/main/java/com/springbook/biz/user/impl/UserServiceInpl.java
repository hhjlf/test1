package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserService;
import com.springbook.biz.user.UserVo;

@Service
public class UserServiceInpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	
	@Override
	public UserVo getUser(UserVo vo) {
		 
		return userDAO.getUser(vo);
	}

}
