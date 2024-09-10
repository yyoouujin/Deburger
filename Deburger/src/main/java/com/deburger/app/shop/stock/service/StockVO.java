package com.deburger.app.shop.stock.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

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
	private String disposalOperation;
	private Integer amountcon;
	
	//재료 테이블
	private String materialName;
	private String materialClassification;
	private String unit;
	private Integer saleUnitprice;
	
	//장바구니 테이블
	private Integer cartNumber;
	private Integer count;
	
	//입고테이블	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDay;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationLimit;
	private Integer remainStockCount;
	private String disposalOperatioin;
	
	//상세테이블
	private String orderDetailsNumber;

}
