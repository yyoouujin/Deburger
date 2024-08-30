package com.deburger.app.main.login.mapper;

import com.deburger.app.main.login.service.UserVO;

public interface UserMapper {
	public UserVO selectUserInfo(String id);
}
