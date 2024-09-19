package com.deburger.app.shop.stock.service;

import java.util.List;
import java.util.Map;

public interface StockService {


	// 재고 전체 조회
	public List<StockVO> selectStock(StockVO stockVO);

	// 장바구니 저장
	public int insertCart(StockVO stockVO);

	// 재고 상세 전체 조회
	public List<StockVO> selectStockinfo(StockVO stockVO);

	// 재고 조정
	public int updqtestoreStock(StockVO stockVO);

	// 분류
	public List<StockVO> stockClassification();

	// 조건 조회
	public List<StockVO> classificationList(StockVO stockVO);
	
	// Material 총 갯수
	public int shopcountMaterial();
	
	// 상세조회 총 갯수
	public int shopinfo(StockVO stockVO);
}
