package com.deburger.app.shop.StoreMatCon.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class StoreMatConVO {

	//재료 테이블
	private String materialName;
	private String materialItem;
	private String materialClassification;
	private String materialNumber;
	
	//재료 소비 테이블
	private String storeNumber;
	private int amountcon;
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date productDate;
	private String operation;
	private String dt;
}
