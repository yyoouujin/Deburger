package com.deburger.app.main.store.service.impl;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.main.login.service.LoginService;
import com.deburger.app.main.login.service.UserVO;
import com.deburger.app.main.store.mapper.StoreMapper;
import com.deburger.app.main.store.service.StoreService;
import com.deburger.app.main.store.service.StoreVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoreServiceImpl implements StoreService{
	private final BCryptPasswordEncoder passwordEncoder;
	private final StoreMapper storeMapper;
	private final LoginService loginService;

	@Override
	@Transactional
	public int insertStore(StoreVO storeVO, UserVO userVO) {
		String password = passwordEncoder.encode(userVO.getPassword());
		userVO.setPassword(password);
		loginService.insertUserInfo(userVO);		
		return storeMapper.insertStore(storeVO);
	}

	@Override
	public List<StoreVO> selectStoreList() {
		return storeMapper.selectStoreList();
	}

	@Override
	public String selectStoreInfoNumber(String id) {
		// TODO Auto-generated method stub
		return storeMapper.selectStoreInfoNumber(id);
	}

}
