package com.deburger.app.shop.storein.service;

import java.util.List;

public interface StoreInService {
	
	//입고 승인 전체 조회
	public List<StoreInVO> StoreInList();
	
	//입고 재고 상세 조회
	public List<StoreInVO> StoreIninfoList(StoreInVO storeInVO);

	//입고 저장
	public int insertStoreInList(ListVO listVO);
}
