package com.deburger.app.shop.notice.service;

import java.util.List;

public interface NoticeService {
    
	//공지사항 전체 조회(전체)
	public List<NoticeVO> noticeListShop();
	
	//공지사항 전체 조회(업데이트)
	public List<NoticeVO> noticeListShopUpdate();
	
	//공지사항 전체 조회(서비스)
	public List<NoticeVO> noticeListShopService();
	
	//공지사항 전체 조회(이벤트)
	public List<NoticeVO> noticeListShopEvent();

	//공지사항 전체 조회(작업)
	public List<NoticeVO> noticeListShopWork();

	//공지사항 전체 조회(공고)
	public List<NoticeVO> noticeListShopAnnouncement();
	
	//
	//공지사항 단건 조회
	public NoticeVO noticeListInfoShop(NoticeVO noticeVO);
	
	
}
