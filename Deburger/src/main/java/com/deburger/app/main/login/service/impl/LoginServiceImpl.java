package com.deburger.app.main.login.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.main.login.mapper.UserMapper;
import com.deburger.app.main.login.service.LoginService;
import com.deburger.app.main.login.service.PersonVO;
import com.deburger.app.main.login.service.UserVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {
	
	private UserMapper userMapper;
		
	// 사용자 조회
	@Override
	public UserVO selectUserInfo(String id) {
		return userMapper.selectUserInfo(id);
	}

	// 사용자 등록
	@Override
	public int insertUserInfo(UserVO userVO) {
		return userMapper.insertUserInfo(userVO);
	}
	
	//  담당자 등록
	@Override
	@Transactional
	public int insertPersonInfo(PersonVO personVO,UserVO userVO) {
		userMapper.insertUserInfo(userVO);
		return userMapper.insertPersonInfo(personVO);
	}

}
