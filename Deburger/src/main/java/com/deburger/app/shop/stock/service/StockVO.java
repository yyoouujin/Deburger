package com.deburger.app.shop.stock.service;

import lombok.Data;

@Data
public class StockVO {

	
	//재고 테이블
	private Integer stockNumber;
	private Integer stockCount;
	private String storeNumber;
	private Integer safetyStock;
	private String autoApplicationOperation;
	private String materialNumber;
	
	//재료 테이블
	private String materialName;
	private String materialClassification;
	private String unit;
	private Integer saleUnitprice;
	
	//장바구니 테이블
	private Integer cartNumber;
	private Integer count;
}
