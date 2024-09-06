package com.deburger.app.shop.qsc.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class QscVO {	
	public String qscNumber;
	public String category;
	public String content;
	public int score;
	public String versionInformation;
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date finalChangeDay;
	public String list;		
}
