package com.deburger.app.main.login.mapper;

import com.deburger.app.main.login.service.UserVO;

public interface UserMapper {
	
	// 사용자 조회
	public UserVO selectUserInfo(String id);
	
	// 사용자 등록
	public int insertUserInfo(UserVO userVO);
}
