package com.deburger.app.shop.notice.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class NoticeVO {
	private String noticeNumber; //순번
	private String division;     //구분
	@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date writerDate;     //작성일자
	private String writer;       //작성자
	private String 	content;     //내용
	private String title;        //제목
}
