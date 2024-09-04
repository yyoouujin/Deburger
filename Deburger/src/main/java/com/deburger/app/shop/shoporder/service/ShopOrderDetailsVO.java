package com.deburger.app.shop.shoporder.service;

import lombok.Data;

@Data
public class ShopOrderDetailsVO {

	//상세 발주
		private String orderDetailsNumber;
		private String detailsNumber;
		private int count;
		private String orderNumber;
		private String materialNumber;
}
