package com.deburger.app.shop.storein.mapper;

import java.util.List;

import com.deburger.app.shop.storein.service.ListVO;
import com.deburger.app.shop.storein.service.StoreInVO;

public interface StoreInMapper {

	//입고 승인 전체 조회
	public List<StoreInVO> StoreInList(StoreInVO storeInVO);
	
	//입고 재고 상세 조회
	public List<StoreInVO> StoreIninfoList(StoreInVO storeInVO);
	
	//입고 저장
	public int insertStoreInList(StoreInVO storeInVO);
	
	//재고 저장
	public int storeStock(StoreInVO storeInVO);
	
	// store in 
	public int shopincoun(StoreInVO storeInVO);
	
	//입고 전체 조회
	public List<StoreInVO> stockInList(StoreInVO storeInVO);
	
	//입고 검색
	public List<StoreInVO> stockfound(StoreInVO storeInVO);
	
	// 페이징
	public int stockInListCon(StoreInVO storeInVO);
	
	//입고 상세 조회
	public List<StoreInVO> stockInListInfo(StoreInVO storeInVO);
	

	
	
}
