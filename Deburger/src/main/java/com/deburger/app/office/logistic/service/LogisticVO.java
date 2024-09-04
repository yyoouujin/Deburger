package com.deburger.app.office.logistic.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class LogisticVO {
		
		//물류창고 테이블
		private String logisticsId;
		private String logisticsName;
		private int postal;
		private String basicsAddress;
		private String detailsAddress;
		private String note;
		
		private String address = basicsAddress + detailsAddress + note;
		
		private String phone;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date permissionDay;
		private String personId;
		
		//재료 테이블
		private String materialNumber;
		private String materialName;
		private String unit;
		private String materialItem;
		private String materialClassification;				//제빵류
		private int logisticsSafetyStock;
		
		
		//물류창고 재고 테이블
		private String stockNumber;
		private int stockCount;						//
		private int allStock;							//물류창고 총 재고
		private int requireStock;					//필요재고
		//private String logisticsId;
		//private String materialNumber;
		
		//물류창고 입고 테이블
		private Date expirationLimit;			//유통기한
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date inDay;								//입고날짜
		private int inCount;							//입고수량
		

}
