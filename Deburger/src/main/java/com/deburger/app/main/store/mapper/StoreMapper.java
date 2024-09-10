package com.deburger.app.main.store.mapper;

import java.util.List;

import com.deburger.app.main.store.service.StoreVO;

public interface StoreMapper {
	public List<StoreVO> selectStoreList();
	
	public int insertStore(StoreVO storeVO);
	
	public String selectStoreInfoNumber(String id);
	
}
