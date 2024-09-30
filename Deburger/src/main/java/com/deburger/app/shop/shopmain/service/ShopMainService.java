package com.deburger.app.shop.shopmain.service;

import java.util.List;

import com.deburger.app.shop.stock.service.StockVO;

public interface ShopMainService {

	//조회
	public List<ShopMainVO> listCount1();
	
	//조회
	public List<ShopMainVO> listCount2();
	
	//조회
	public List<ShopMainVO> listCount3();
	
	
	//판매 그래프
	public List<ShopMainVO> shopSellG(ShopMainVO shopMainVO);
	
	//판매 건수 그래프
	public List<ShopMainVO> shopOrderG(ShopMainVO shopMainVO);
	
	//유통기한 초과
	public List<ShopMainVO> limitList();
	
	// 공지사항 단건조회
	public List<ShopMainVO> noticeList();
}
