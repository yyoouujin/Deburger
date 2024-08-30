package com.deburger.app.main.store.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class StoreVO {
	private String storeNumber;
	private String shopkeeper;
	private String businessRegistrationNumber;
	private String phone;
	private String email;
	private String storeName;
	private String address;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date contractStartDay;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date contractFinDay;
	private String contractImage;
	private String businessLicenseImage;
	private Integer postal;
	private String addressses;
	private String note;
	private String logisticsId;	
}
