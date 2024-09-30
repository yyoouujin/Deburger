package com.deburger.app.shop.shopmain.mapper;

import java.util.List;

import com.deburger.app.shop.shopmain.service.ShopMainVO;
import com.deburger.app.shop.stock.service.StockVO;

public interface ShopMainMapper {

	//조회1
	public List<ShopMainVO> listCount1(ShopMainVO shopMainVO);
	
	//조회2
	public List<ShopMainVO> listCount2(ShopMainVO shopMainVO);
	
	//조회3
	public List<ShopMainVO> listCount3(ShopMainVO shopMainVO);
	
	//판매 그래프
	public List<ShopMainVO> shopSellG(ShopMainVO shopMainVO);
	
	//판매 건수 그래프
	public List<ShopMainVO> shopOrderG(ShopMainVO shopMainVO);
	
	//유통기한 초과
	public List<ShopMainVO> limitList(ShopMainVO shopMainVO);
	
	// 공지사항 단건조회
	public List<ShopMainVO> noticeList();
}
