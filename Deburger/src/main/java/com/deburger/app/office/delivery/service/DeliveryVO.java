package com.deburger.app.office.delivery.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class DeliveryVO {
	
	//가맹점 테이블
	private String storeNumber;
	private String shopkeeper;
	private String phone;
	private String email;
	private String storeName;
	private String logisticsId;
	
	
	//가맹점 발주 테이블
	private String orderNumber;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date orderDay;
	private String autoOrderOperation;
	private String note;
	private String personId;
	private String cancelOperation;
	private String orderName;
	private String allprice;
	private String oderApp;
	
	//가맹점 발주 디테일 테이블
	private int count;
	private String materialNumber;
	private String orderDetailsNumber;
	
	//재료 테이블
	private String materialName;
	private String unit;
	
	//물류창고 테이블
	private String logisticsName;
	private int stockCount;
	private String basicsAddress;
	
	//물류창고의 전체재고 (주문번호별)
	private int allStockLogistic;
	//전체 발주수량 (주문번호별)
	private int allStockOrder;
	
	
	private int logisticAllStock;
	private int orderAllStock;
	
	

}
