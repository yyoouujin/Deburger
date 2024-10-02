package com.deburger.app.office.logistic.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Component
@Data
public class LogisticVO {

	// 물류창고 테이블
	private String logisticsId;
	private String logisticsName;
	private int postal;
	private String basicsAddress;
	private String detailsAddress;
	private String note;

	private String phone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date permissionDay;
	private String personId;
	private String name;

	// 재료 테이블
	private String materialNumber;
	private String materialName;
	private String unit;
	private String materialItem;
	private String materialClassification; // 제빵류
	private int logisticsSafetyStock; // 안전재고

	// 물류창고 재고 테이블
	private String stockNumber;
	private int stockCount; //
	private int allStock; // 물류창고 총 재고
	private int requireStock; // 필요재고
	// private String logisticsId;
	// private String materialNumber;

	// 물류창고 입고 테이블
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date expirationLimit; // 유통기한

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date minExpirationLimit; // 가장 빠른 유통기한

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	private Date inDay; // 입고날짜

	private int inCount; // 입고수량
	private int outCount; // 출고수량

	private String clientId;
	private String aggclientId;
	private String clientName;
	private String aggclientName;

	// 페이징
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

	public LogisticVO() {

	}

	public LogisticVO(int total, int nowPage, int cntPerPage) {
		setNowPage(nowPage);
		setCntPerPage(cntPerPage);
		setTotal(total);
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
	}

	// 제일 마지막 페이지 계산
	public void calcLastPage(int total, int cntPerPage) {
		setLastPage((int) Math.ceil((double) total / (double) cntPerPage));
	}

	// 시작, 끝 페이지 계산
	public void calcStartEndPage(int nowPage, int cntPage) {
		setEndPage(((int) Math.ceil((double) nowPage / (double) cntPage)) * cntPage);
		if (getLastPage() < getEndPage()) {
			setEndPage(getLastPage());
		}

		if (getEndPage() % getCntPage() != 0) {
			setStartPage((getEndPage() / getCntPage()) * getCntPage() + 1);
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

}
