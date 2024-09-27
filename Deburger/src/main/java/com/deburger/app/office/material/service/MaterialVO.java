package com.deburger.app.office.material.service;

import lombok.Data;

@Data
public class MaterialVO {

	public String materialNumber;
	public String materialName;
	public String unit;
	public int saleUnitprice;
	public String materialItem;
	public int buyUnitprice;
	public String image;
	public String materialClassification;
	public int logisticsSafetyStock;
	public int cost;
	public String clientName;

	// 현재페이지, 시작페이지, 끝페이지, 게시글 총 갯수, 페이지당 글 갯수, 마지막페이지, SQL쿼리에 쓸 start, end
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

	public MaterialVO() {
	}

	public MaterialVO(int total, int nowPage, int cntPerPage) {
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
		if (getLastPage() < 1) {
			setEndPage(1);
		}

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
