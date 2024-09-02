package com.deburger.app.office.logistic.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class LogisticVO {
	
		private String logisticsId;
		private String logisticsName;
		private int postal;
		private String basicsAddress;
		private String detailsAddress;
		private String note;
		private String phone;
		@DateTimeFormat(pattern="yyyy-MM-dd")
		private Date permissionDay;
		private String personId;

}
