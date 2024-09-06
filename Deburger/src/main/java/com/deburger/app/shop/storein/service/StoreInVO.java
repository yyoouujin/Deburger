package com.deburger.app.shop.storein.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class StoreInVO {

	//발주
	private String orderNumber; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDay;
	private String orderName;
	private String oderApp;
	
	//상세 발주
	private String orderDetailsNumber;
	private String detailsNumber;
	private int count;
	private String storeNumber;
	private String materialNumber;
	private String materialName;
	
	//입고 
	private int inNumber;
	private String disposalOperation;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date consumptionLimit;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationLimit;
	private String inImage;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date manufactureDay;
	private int remainStockCount;
	private String note;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date inDay;
	private String inOperation;
	
	//물류창고
	private String lot;
	
	//
	private MultipartFile contractImageFile;

}
