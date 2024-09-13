package com.deburger.app.shop.productSale.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class StoreSaleVO {	
	
	
	private String productNumber;
	private String productName;
	private int saleUnitprice;
	private String image;
	private String recipePdf;
	private int price;
	private String category;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date registrationDay;
	private String kind;
	private String note;
	
	
	private int count;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date productDate;
	private int seq;
	private String storeNumber;
	
	private int profits;
	private int spending;
	
}
