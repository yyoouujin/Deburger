package com.deburger.app.office.container.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ContainerVO {


	public Date consumptionLimit;
	public String disposalOperation;

	public Date manufactureDay;

	// 물류 재고 리스트
	public String logisticsId;
	public String logisticsName;
	public String personId;
	public String stockNumber;
	public String stockCount;
	public String logisticsSafetyStock;
	public String inspectionOperation;
	public String materialClassification;
	public String orderCondition;
	public String inOperation;

	public String materialNumber;
	public String materialItem;
	public String materialName;
	public int count;
	public int inCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date expirationLimit;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date limit;

	// 물류 재고 상세
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date inDay;
	
	// 물류 입고 조회
	public String detailsOrderNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public String orderDay;
	public String clientId;
	public String clientName;
	
	// 물류 창고 폐기 처리
	public String logisticsOutNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date outDate;
	public String inspection;
	public int outCount;
	public String note;
	public String outOperation;
	public String lot;
	
	
}
