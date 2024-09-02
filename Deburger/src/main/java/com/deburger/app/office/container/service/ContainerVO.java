package com.deburger.app.office.container.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ContainerVO {

	public String lot;
	public String detailsOrderNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date inDay;
	public int inCount;
	public String inspectionOperation;
	public Date expirationLimit;
	public Date consumptionLimit;
	public String disposalOperation;
	public int outCount;
	public Date manufactureDay;
	public String personId;

	public String number;
	public String item;
	public String name;
	public String count;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date limit;

}
