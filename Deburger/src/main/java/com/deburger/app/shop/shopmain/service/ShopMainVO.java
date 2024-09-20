package com.deburger.app.shop.shopmain.service;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ShopMainVO {
	
	private int mainMaterial;
	private int subMaterial;
	
	private int limitMaterial;
	private int limitsubMaterial;
	
	private int oneMaterial;
	private int twoMaterial;
	
	private String storeNumber;
	private String dt;
	private int profits;
	
	private String productDate;
	private int count;
	
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date orderDay;
	private String materialName;
	private int remainStockCount;
	
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date expirationLimit;
	
	private String orderDetailsNumber;
	private String materialNumber;

    private String title;
	@DateTimeFormat(pattern = "yy-MM-dd")
	private Date writerDate;
    private int datem;


    
}
