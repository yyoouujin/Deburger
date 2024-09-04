package com.deburger.app.shop.shoporder.service;

import lombok.Data;

@Data
public class ShopOrderCartVO {
	
	//장바구니
	private int cartNumber;
	private String storeNumber;
	private int count;
	private String materialNumber;
}
