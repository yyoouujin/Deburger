package com.deburger.app.shop.StoreProSale.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class StoreProSaleVO {
	
	//판매량
	private int SEQ;
	private int count;
	private String storeNumber;
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date productDate;
	private String productNumber;
	
	//메뉴
	private String category;
	private String kind;
	private String productName;
	
	private String dt;
	
	
}
