package com.deburger.app.shop.StoreProSale.mapper;

import java.util.List;

import com.deburger.app.shop.StoreProSale.service.StoreProSaleVO;

public interface StoreProSaleMapper {

	// 목록 표시
	public List<StoreProSaleVO> StoreProSaleList(StoreProSaleVO storeProSaleVO);

	// 제품 그래프 조회
	public List<StoreProSaleVO> StoreProSaleoneList(StoreProSaleVO storeProSaleVO);

	// 분류
	public List<StoreProSaleVO> stockClassification();

	// 조건 조회
	public List<StoreProSaleVO> classificationListpro(StoreProSaleVO storeProSaleVO);
}
