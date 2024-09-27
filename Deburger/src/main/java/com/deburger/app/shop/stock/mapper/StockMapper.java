package com.deburger.app.shop.stock.mapper;

import java.util.List;
import java.util.Map;

import com.deburger.app.shop.shoporder.service.ShopOrderVO;
import com.deburger.app.shop.stock.service.StockVO;

public interface StockMapper {


	
	// 전체 조회
	public List<StockVO> selectStock(StockVO stockVO);

	// 장바구니 업데이트
	public int insertCart(StockVO stockVO);

	// 상세 조회
	public List<StockVO> selectStockinfo(StockVO stockVO);

	// 재고 조정
	public int updqtestoreStock(StockVO stockVO);

	// 가맹점 재료 소비
	public int insertstoreProductSale(StockVO stockVO);

	// 가맹점 store_in 테이블
	public int updqtestoreIn(StockVO stockVO);

	// 분류
	public List<StockVO> stockClassification();

	// 조건 조회
	public List<StockVO> classificationList(StockVO stockVO);

	// Material 총 갯수
	public int shopcountMaterial();
	
	// 상세조회 총 갯수
	public int shopinfo(StockVO stockVO);
	
	//장바구니 중복확인
	public int countCart(StockVO stockVO);
}
