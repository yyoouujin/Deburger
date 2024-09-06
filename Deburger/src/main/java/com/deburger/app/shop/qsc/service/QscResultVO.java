package com.deburger.app.shop.qsc.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class QscResultVO {
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date qscDate;	
	public String processCondition;
	public String category;
	public String list;
	public String content;
	public String storeNumber;
	public String checklistNumber;
	public int qualityScore;
	public int cleanlScore;
	public int serviceScore;
	public String qscResultDetailsNumber;
	public String qscNumber;
	public String storeName;
	public int score;
	public int qscTotal;
}
