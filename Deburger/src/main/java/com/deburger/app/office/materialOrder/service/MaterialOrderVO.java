package com.deburger.app.office.materialOrder.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class MaterialOrderVO {
	
	//물류창고 발주
	private String orderNumber; // 발주번호
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date orderDay; // 발주 일자
	private String logisticsId; //물류창고
	private String logisticsName; // 물류창고 이름
	private String note;
	private String clientId;
	
	//물류창고 발주 상세
	private String detailsOrderNumber;
	private int count;  // 수량
	private int tax;  // 세금
	private String unit;  //규격
	private String materialNumber;
	private String personId; //담당자 id
	private String email; //담당자 id
	private String name; // 담당자 이름
	private String phone; // 업체 번호
	private String phoneLog; // 물류창고 번호	
	private int orderCost;
	private String orderCondition; 	
	private String inOperation; // 입고여부
	
	
	//재료
	
	private String materialName; // 품명
	private int saleUnitprice;    //판매원가(본점이 가맹점에게 판매할떄 금액)
	private String materialItem;
	private int buyUnitprice;    //구매원가(본점이 공급처에게 살 때 금액)
	private String image;
	private String materialClassification;
	private int logisticsSafetyStock;
	private int cost;             //재료원가(공급처의 재료 원가) 단가
						
	private String clientName; // 거래처 이름		
	
}
