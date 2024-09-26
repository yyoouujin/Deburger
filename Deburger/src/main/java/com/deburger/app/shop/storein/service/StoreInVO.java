package com.deburger.app.shop.storein.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class StoreInVO {
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;

	//발주
	private String orderNumber; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDay;
	private String orderName;
	private String oderApp;
	
	//상세 발주
	private String orderDetailsNumber;
	private String detailsNumber;
	private int count;
	private String storeNumber;
	private String materialNumber;
	private String materialName;
	
	//입고 
	private int inNumber;
	private String disposalOperation;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date consumptionLimit;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date expirationLimit;
	private String inImage;
	@DateTimeFormat(pattern = "yyyy/MM/dd")
	private Date manufactureDay;
	private int remainStockCount;
	private String note;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date inDay;
	private String inOperation;
	
	//물류창고
	private String lot;
	
	//
	private MultipartFile contractImageFile;
	
	//재고저장
	private String stockNumber;
	private int stockCount;
	private int safetyStock;
	
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
	
    public StoreInVO() {
	}
	public StoreInVO(int total, int nowPage, int cntPerPage) {
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
}
