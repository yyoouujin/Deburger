package com.deburger.app.main.store.service.impl;

import org.springframework.stereotype.Service;

import com.deburger.app.main.store.mapper.StoreMapper;
import com.deburger.app.main.store.service.StoreService;
import com.deburger.app.main.store.service.StoreVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StoreServiceImpl implements StoreService{
	
	private StoreMapper storeMapper;

	@Override
	public int insertStore(StoreVO storeVO) {
		// TODO Auto-generated method stub
		return storeMapper.insertStore(storeVO);
	}

}
