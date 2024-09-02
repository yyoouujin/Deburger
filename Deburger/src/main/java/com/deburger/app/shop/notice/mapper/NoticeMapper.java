package com.deburger.app.shop.notice.mapper;

import java.util.List;

import com.deburger.app.shop.notice.service.NoticeVO;

public interface NoticeMapper {
	
	//전체조회(전체)
	public List<NoticeVO> noticeListShop();
	
	//전체조회(업데이트)
	public List<NoticeVO> noticeListShopUpdate();
	
	//전체조회(서비스)
	public List<NoticeVO> noticeListShopService();
	
	//전체조회(이벤트)
	public List<NoticeVO> noticeListShopEvent();
		
	//전체조회(작업)
	public List<NoticeVO> noticeListShopWork();
	
	//전체조회(공고)
	public List<NoticeVO> noticeListShopAnnouncement();
	
	
	//상세조회
	public NoticeVO noticeListInfoShop(NoticeVO noticeVO);
	
	//등록하기
	public int noticeInsertOffice (NoticeVO noticeVO);
	
	//수정하기
	public int noticeCorrectOffice(NoticeVO noticeVO);
	
	//삭제하기
	public int noticeDeleteOffice (int noticeVO);
}
