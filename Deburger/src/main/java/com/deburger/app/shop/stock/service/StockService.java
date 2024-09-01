package com.deburger.app.shop.stock.service;

import java.util.List;

public interface StockService {
	
	//재고 전체 조회
	public List<StockVO> selectStock();
	
	//장바구니 저장
	public int insertCart(StockVO stockVO);
	
	//재고 상세 조회
	public StockVO selectStockinfo(StockVO stockVO);
}
