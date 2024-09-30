package com.deburger.app.main.store.service;

import java.util.List;

import com.deburger.app.main.login.service.UserVO;
import com.deburger.app.shop.productSale.service.StoreSaleVO;

public interface StoreService {
	public int insertStore(StoreVO storeVO, UserVO userVO);
	public List<StoreVO> selectStoreList();
	public String selectStoreInfoNumber(String id);
	
	public List<StoreSalesVO> selectStoreSalesMonth();
	
	public List<StoreSalesVO> selectStoreProductMonth();
	
	public List<StoreSalesVO> selectStoreOrderMonth();
	
	public StoreVO selectLogisticsId(String personId);
	
	public StoreVO selectStoreNumber();
}
