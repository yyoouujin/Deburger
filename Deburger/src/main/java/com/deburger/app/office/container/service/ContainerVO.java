package com.deburger.app.office.container.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ContainerVO {

	public String detailsOrderNumber;

	public String inspectionOperation;;
	public Date consumptionLimit;
	public String disposalOperation;

	public Date manufactureDay;
	public String personId;

	// 물류 재고 리스트
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

	// 물류 창고 폐기 처리
	public String logisticsOutNumber;
	public String logisticsId;
	public String inspection;
	public int outCount;
	public String note;
	public String outOperation;
	public String lot;
}
