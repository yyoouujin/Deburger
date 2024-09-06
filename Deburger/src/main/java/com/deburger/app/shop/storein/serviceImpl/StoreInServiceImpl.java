package com.deburger.app.shop.storein.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.shop.storein.mapper.StoreInMapper;
import com.deburger.app.shop.storein.service.StoreInService;
import com.deburger.app.shop.storein.service.StoreInVO;

@Service
public class StoreInServiceImpl implements StoreInService {

	private StoreInMapper storeInMapper;
	
	@Autowired
	StoreInServiceImpl(StoreInMapper storeInMapper){
		this.storeInMapper = storeInMapper;
	}
	
	//입고 승인 전체 조회
	@Override
	public List<StoreInVO> StoreInList() {
		// TODO Auto-generated method stub
		return storeInMapper.StoreInList();
	}
	
	//입고 재고 상세 조회
	@Override
	public List<StoreInVO> StoreIninfoList(StoreInVO storeInVO) {
		// TODO Auto-generated method stub
		return storeInMapper.StoreIninfoList(storeInVO);
	}
	
	//입고 저장
	@Override
	public int insertStoreInList(StoreInVO storeInVO) {
		// TODO Auto-generated method stub
		storeInMapper.insertStoreInList(storeInVO);
		
		return 1;
	}
	
}
