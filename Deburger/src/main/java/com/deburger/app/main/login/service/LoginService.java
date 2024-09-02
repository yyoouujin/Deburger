package com.deburger.app.main.login.service;

public interface LoginService {
	
	// 사용자 조회
	public UserVO selectUserInfo(String id);
	
	// 사용자 등록
	public int insertUserInfo(UserVO userVO);

}
