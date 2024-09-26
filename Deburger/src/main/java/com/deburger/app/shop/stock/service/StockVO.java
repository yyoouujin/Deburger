package com.deburger.app.shop.stock.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class StockVO {

	
	//재고 테이블
	private String stockNumber;
	private Integer stockCount;
	private String storeNumber;
	private Integer safetyStock;
	private String autoApplicationOperation;
	private String materialNumber;
	private String disposalOperation;
	private Integer amountcon;
	
	//재료 테이블
	private String materialName;
	private String materialClassification;
	private String unit;
	private Integer saleUnitprice;
	
	//장바구니 테이블
	private Integer cartNumber;
	private Integer count;
	
	//입고테이블	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDay;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date expirationLimit;
	private Integer remainStockCount;
	private String disposalOperatioin;
	private String note;
	
	//상세테이블
	private String orderDetailsNumber;

	
	private int nowPage =1; 
	private int startPage; 
	private int endPage; 
	private int total; 
	private int cntPerPage = 10; 
	private int lastPage;
	private int start; 
	private int end;
	private int cntPage = 5;
	
    private int rn; // 쿼리에서 ROWNUM으로 반환되는 값
	
    public StockVO() {
	}

    public void setTotal(int total) {
    	this.total=total;
		calcLastPage(getTotal(), getCntPerPage());
		calcStartEndPage(getNowPage(), cntPage);
		calcStartEnd(getNowPage(), getCntPerPage());
    }
    
	public StockVO(int total, int nowPage, int cntPerPage) {
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
