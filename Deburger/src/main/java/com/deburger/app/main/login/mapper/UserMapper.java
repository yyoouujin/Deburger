package com.deburger.app.main.login.mapper;

import com.deburger.app.main.login.service.PersonVO;
import com.deburger.app.main.login.service.UserVO;

public interface UserMapper {
	
	// 사용자 조회
	public UserVO selectUserInfo(String username);
	
	// 사용자 등록
	public int insertUserInfo(UserVO userVO);
	
	// 담당자 등록
	public int insertPersonInfo(PersonVO personVO);
}
