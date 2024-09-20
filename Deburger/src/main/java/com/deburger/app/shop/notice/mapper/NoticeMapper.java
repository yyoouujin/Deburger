package com.deburger.app.shop.notice.mapper;

import java.util.List;

import com.deburger.app.shop.notice.service.NoticeVO;

public interface NoticeMapper {
	
	//전체조회(전체)
	public List<NoticeVO> noticeListShop(NoticeVO noticeVO);
	
	//카운트
	public int countNotice(NoticeVO noticeVO);
	
	//전체조회(업데이트, 서비스, 이벤트, 작업, 공고)
	public List<NoticeVO> noticeListShopE(NoticeVO noticeVO);
	
	//상세조회
	public NoticeVO noticeListInfoShop(NoticeVO noticeVO);
	
	//등록하기
	public int noticeInsertOffice (NoticeVO noticeVO);
	
	//수정하기
	public int noticeCorrectOffice(NoticeVO noticeVO);
	
	//삭제하기
	public int noticeDeleteOffice (String noticeNumber);
	
	//전체조회(메인페이지)
	public List<NoticeVO> noticeListShopList();
	
}
