package com.deburger.app.main.store.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class StoreSalesVO {
	private int sumCnt;
	private String dateList;
}
