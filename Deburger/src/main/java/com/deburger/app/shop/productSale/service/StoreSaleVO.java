package com.deburger.app.shop.productSale.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class StoreSaleVO {	
	
	
	public String productNumber;
	public String productName;
	public int saleUnitprice;
	public String image;
	public String recipePdf;
	public int price;
	public String category;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date registrationDay;
	public String kind;
	public String note;
	
	
	public int count;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date productDate;
	public int seq;
	public String storeNumber;
}
