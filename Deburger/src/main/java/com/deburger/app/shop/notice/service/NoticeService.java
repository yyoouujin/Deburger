package com.deburger.app.shop.notice.service;

import java.util.List;
import java.util.Map;

public interface NoticeService {
    
	//공지사항 전체 조회(전체)
	public List<NoticeVO> noticeListShop(NoticeVO noticeVO);
	
	//카운트
	public int countNoticeService(NoticeVO noticeVO);
	
	//전체조회(업데이트, 서비스, 이벤트, 작업, 공고)
	public List<NoticeVO> noticeListShopE(NoticeVO noticeVO);
	
	//공지사항 단건 조회
	public NoticeVO noticeListInfoShop(NoticeVO noticeVO);
	
	//공지사항 등록
	public int noticeInsertOffice(NoticeVO noticeVO);
	
	//공지사항 수정
	public Map<String, Object> noticeCorrectOffice(NoticeVO noticeVO);
	
	//공지사항 삭제
	public int noticeDeleteOffice(String noticeNumber);
	
	//전체조회(메인페이지)
	public List<NoticeVO> noticeListShopList();
	

	
}
