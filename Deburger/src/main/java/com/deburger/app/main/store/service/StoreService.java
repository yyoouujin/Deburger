package com.deburger.app.main.store.service;

import java.util.List;

import com.deburger.app.main.login.service.UserVO;

public interface StoreService {
	public int insertStore(StoreVO storeVO, UserVO userVO);
	public List<StoreVO> selectStoreList();
}
