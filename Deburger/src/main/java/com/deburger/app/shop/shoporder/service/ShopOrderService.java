package com.deburger.app.shop.shoporder.service;

import java.util.List;

public interface ShopOrderService {

	//전체 조회
	public List<ShopOrderVO> selectShopOrder();
	
	//발주 신청
	public int insertShopOrder(ShopOrderVO shopOrderVO);
		
}
