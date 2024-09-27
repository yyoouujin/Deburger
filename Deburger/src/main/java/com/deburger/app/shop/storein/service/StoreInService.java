package com.deburger.app.shop.storein.service;

import java.util.List;

public interface StoreInService {
	
	//입고 승인 전체 조회
	public List<StoreInVO> StoreInList(StoreInVO storeInVO);
	
	//입고 재고 상세 조회
	public List<StoreInVO> StoreIninfoList(StoreInVO storeInVO);

	//입고 저장
	public int insertStoreInList(ListVO listVO);
	
	// store in 
	public int shopincoun();
	
	//입고 전체 조회
	public List<StoreInVO> stockInList(StoreInVO storeInVO);
	
	//입고 검색
	public List<StoreInVO> stockfound(StoreInVO storeInVO);
	
	// 페이징
	public int stockInListCon();
	
	//입고 상세 조회
	public List<StoreInVO> stockInListInfo(StoreInVO storeInVO);

	
}
