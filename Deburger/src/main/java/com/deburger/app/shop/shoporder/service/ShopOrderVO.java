package com.deburger.app.shop.shoporder.service;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ShopOrderVO {
	//조건조회
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date startDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date endDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date today;
	
	private String ssemail;
	private int ssph;
	
	private String storeName;
	
	//장바구니
	private String storeNumber;
	private int count;
	private String materialNumber;
	
	//재료
	private String materialName;
	private String unit;
	private int saleUnitprice;
	private String materialItem;
	private String materialClassification;
	
	//발주
	private String orderNumber; 
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date orderDay;
	private String autoOrderOperation; 
	private String note;
	private String personID;
	private String cancelOperation;
	private String orderName;
	private int allprice;
	private String oderApp;
	private String  logisticsId;
	
	//상세 발주
	private String orderDetailsNumber;
	private String detailsNumber;
	
	//담당자 id
	private String email;
	private String phone;
	private String name;
	
	//store_stock
	private int stockCount;
	private int safetyStock;
	
	List<ShopOrderDetailsVO> detList;
	List<ShopOrderCartVO> cartList;
	
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
	
    public ShopOrderVO() {
	}
	public ShopOrderVO(int total, int nowPage, int cntPerPage) {
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
