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
	
	
	//
	private int nowPage; 
	private int startPage; 
	private int endPage; 
	private int total; 
	private int cntPerPage; 
	private int lastPage;
	private int start; 
	private int end;
	private int cntPage = 5;
	
    private int rn; // 쿼리에서 ROWNUM으로 반환되는 값

    public NoticeVO() {
	}
	public NoticeVO(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}
	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double)total / (double)cntPerPage));
	}
	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int)Math.ceil((double)nowPage / (double)cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}
		if(getEndPage() % getCntPage() != 0) {
			setStartPage((getEndPage()/getCntPage())*getCntPage() + 1);
		}
		if (getStartPage() < 1) {
			setStartPage(1);
		}
	}
	// DB 쿼리에서 사용할 start, end값 계산
	public void calcStartEnd(int nowPage, int cntPerPage) {
		setEnd(nowPage * cntPerPage);
		setStart(getEnd() - cntPerPage + 1);
	}
	
    //검색
	private String keyword;

}
