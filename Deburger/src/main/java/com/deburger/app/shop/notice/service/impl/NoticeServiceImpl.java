package com.deburger.app.shop.notice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.shop.notice.mapper.NoticeMapper;
import com.deburger.app.shop.notice.service.NoticeService;
import com.deburger.app.shop.notice.service.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	NoticeMapper mapper;
	
	//공지사항 전체 조회(전체)
	@Override
	public List<NoticeVO> noticeListShop() {
		return mapper.noticeListShop();
	}

	//공지사항 전체 조회(업데이트)
	@Override
	public List<NoticeVO> noticeListShopUpdate() {
		return mapper.noticeListShopUpdate();
	}

	//공지사항 전체 조회(서비스)
	@Override
	public List<NoticeVO> noticeListShopService() {
		return mapper.noticeListShopService();
	}

	//공지사항 전체 조회(이벤트)
	@Override
	public List<NoticeVO> noticeListShopEvent() {
        return mapper.noticeListShopEvent();
	}

	//공지사항 전체 조회(작업)
	@Override
	public List<NoticeVO> noticeListShopWork() {
		return mapper.noticeListShopWork();
	}

	//공지사항 전체 조회(공고)
	@Override
	public List<NoticeVO> noticeListShopAnnouncement() {
		return mapper.noticeListShopAnnouncement();
	}

	
	//공지사항 단건 조회
	@Override
	public NoticeVO noticeListInfoShop(NoticeVO noticeVO) {
		return mapper.noticeListInfoShop(noticeVO);
	}
	
	//공지사항 등록
	
	//공지사항 수정
	
	//공지사항 삭제
}
