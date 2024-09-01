package com.deburger.app.shop.shoporder.service;

import lombok.Data;

@Data
public class ShopOrderVO {
	
	private String storeNumber;
	private int count;
	private String materialNumber;
	
	private String materialName;
	private String unit;
	private int saleUnitprice;
	
	
}
