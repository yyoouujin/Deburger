package com.deburger.app.office.container.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class ContainerVO {

	public Date consumptionLimit;
	public String disposalOperation;

	public Date manufactureDay;

	// 물류 재고 리스트
	public String logisticsId;
	public String logisticsName;
	public String personId;
	public String stockNumber;
	public int stockCount;
	public String logisticsSafetyStock;
	public String inspectionOperation;
	public String materialClassification;
	public String orderCondition;
	public String inOperation;

	public String materialNumber;
	public String materialItem;
	public String materialName;
	public int count;
	public int inCount;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date expirationLimit;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date limit;

	// 물류 재고 상세
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date inDay;

	// 물류 입고 조회
	public String detailsOrderNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public String orderDay;
	public String clientId;
	public String clientName;
	public int sum;

	// 물류 입고 상세
	public int orderCost;
	public String orderNumber;
	public String logisticsPhone;
	public String unit;

	// 물류 창고 폐기 처리
	public String logisticsOutNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	public Date outDate;
	public String inspection;
	public int outCount;
	public String note;
	public String outOperation;
	public String lot;

	// 물류 창고 출고 조회
	public String storeName;
	public String orderDetailsNumber;

	// 프로시저
	public String pNumber;
	public String pOutOperation;
	public String pInspection;
	public String pOrderDetailsNumber;
	public int result;

	// 로그인
	public String name;
	public String email;
	public String phone;
	public String area;
	public String department;
	public String position;

	public String oderApp;
	
	
	// 페이지 처리
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

    public ContainerVO() {
	}
	public ContainerVO(int total, int nowPage, int cntPerPage) {
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
		setStartPage(getEndPage() - cntPage + 1);
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
