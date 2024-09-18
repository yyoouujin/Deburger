package com.deburger.app.shop.shopmain.mapper;

import java.util.List;

import com.deburger.app.shop.shopmain.service.ShopMainVO;

public interface ShopMainMapper {

	//조회
	public List<ShopMainVO> listCount(ShopMainVO shopMainVO);
	
	//판매 그래프
	public List<ShopMainVO> shopSellG(ShopMainVO shopMainVO);
	
	//판매 건수 그래프
	public List<ShopMainVO> shopOrderG(ShopMainVO shopMainVO);
	
	//유통기한 초과
	public List<ShopMainVO> limitList(ShopMainVO shopMainVO);
}
