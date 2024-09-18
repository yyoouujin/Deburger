package com.deburger.app.shop.StoreMatCon.service;

import java.util.List;

public interface StoreMatConService {

	//목록표시
	public List<StoreMatConVO> StoreMaterialList();
	
	//제품 그래프 조회
	public List<StoreMatConVO> StoreMaterialoneList(StoreMatConVO storeMatConVO);
}
