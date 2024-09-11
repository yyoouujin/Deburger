package com.deburger.app.main.login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.deburger.app.main.login.mapper.UserMapper;
import com.deburger.app.main.login.service.LoginUserVO;
import com.deburger.app.main.login.service.UserVO;


@Service
public class CustomerUserDetailsService implements UserDetailsService{
	private UserMapper usermapper;
	
	@Autowired
	CustomerUserDetailsService(UserMapper usermapper){
		this.usermapper = usermapper;
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// Mapper를 활용해서 DB에 접근
		UserVO userVO = usermapper.selectUserInfo(username);
		
		if(userVO == null) {
			throw new UsernameNotFoundException(username);
		}
		return new LoginUserVO(userVO);
	}

}
