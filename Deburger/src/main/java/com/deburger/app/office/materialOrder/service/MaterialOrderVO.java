package com.deburger.app.office.materialOrder.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class MaterialOrderVO {
	
	//물류창고 발주
	private String orderNumber;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date orderDay;
	private String logisticsId; //물류창고
	private String note;
	private String clientId;
	
	//물류창고 발주 상세
	private String detailsOrderNumber;
	private int count;  // 수량
	private String unit;  //규격
	private String materialNumber;
	private String personId;
	private int orderCost;
	private String orderCondition; 	
	private String inOperation;
	
	
	//재료
	
	private String materialName; // 품명
	private int saleUnitprice;    //판매원가(본점이 가맹점에게 판매할떄 금액)
	private String materialItem;
	private int buyUnitprice;    //구매원가(본점이 공급처에게 살 때 금액)
	private String image;
	private String materialClassification;
	private int logisticsSafetyStock;
	private int cost;             //재료원가(공급처의 재료 원가) 단가
						
	private String clientName;		
	
}
