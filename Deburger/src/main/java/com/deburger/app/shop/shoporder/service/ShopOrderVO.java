package com.deburger.app.shop.shoporder.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ShopOrderVO {
	
	//장바구니
	private String storeNumber;
	private int count;
	private String materialNumber;
	
	//재료
	private String materialName;
	private String unit;
	private int saleUnitprice;
	private String materialItem;
	private String materialClassification;
	
	//발주
	private String orderNumber; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDay;
	private String autoOrderOperation; 
	private String note;
	private String personID;
	private String cancelOperation;
	private String orderName;
	private int allprice;
	private String oderApp;
	
	//상세 발주
	private String orderDetailsNumber;
	private String detailsNumber;
	
	//담당자 id
	private String email;
	private String phone;
	
	//store_stock
	private int stockCount;
	private int safetyStock;
	
	List<ShopOrderDetailsVO> detList;
	List<ShopOrderCartVO> cartList;
	
}
