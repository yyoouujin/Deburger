package com.deburger.app.main.store.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.main.login.service.LoginService;
import com.deburger.app.main.login.service.UserVO;
import com.deburger.app.main.store.mapper.StoreMapper;
import com.deburger.app.main.store.service.StoreService;
import com.deburger.app.main.store.service.StoreVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService{
	
	private StoreMapper storeMapper;
	private LoginService loginService;

	@Override
	@Transactional
	public int insertStore(StoreVO storeVO, UserVO userVO) {
		// TODO Auto-generated method stub		
		loginService.insertUserInfo(userVO);
		return storeMapper.insertStore(storeVO);
	}

}
