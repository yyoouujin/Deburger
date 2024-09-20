package com.deburger.app.shop.notice.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.shop.notice.mapper.NoticeMapper;
import com.deburger.app.shop.notice.service.NoticeService;
import com.deburger.app.shop.notice.service.NoticeVO;

@Service
public class NoticeServiceImpl implements NoticeService {

	private NoticeMapper mapper;
	
	@Autowired
	NoticeServiceImpl(NoticeMapper mapper){
		this.mapper = mapper;
	}
	
	//공지사항 전체 조회(전체)
	@Override
	public List<NoticeVO> noticeListShop(NoticeVO noticeVO) {
		return mapper.noticeListShop(noticeVO);
	}

	//전체조회(업데이트, 서비스, 이벤트, 작업, 공고)
	@Override
	public List<NoticeVO> noticeListShopE(NoticeVO noticeVO) {
		return mapper.noticeListShopE(noticeVO);
	}
	
	//공지사항 단건 조회
	@Override
	public NoticeVO noticeListInfoShop(NoticeVO noticeVO) {
		return mapper.noticeListInfoShop(noticeVO);
	}

	//공지사항 등록
	@Override
	public int noticeInsertOffice(NoticeVO noticeVO) {
		int result = mapper.noticeInsertOffice(noticeVO);
		return result;
	}

	//공지사항 수정
	@Override
	public Map<String, Object> noticeCorrectOffice(NoticeVO noticeVO) {
        Map<String, Object> map = new HashMap<>();
        boolean isSuccessed = false;
        
        int result = mapper.noticeCorrectOffice(noticeVO);
        
        if(result == 1) {
        	isSuccessed = true;
        }
        
        map.put("result", isSuccessed);
        map.put("target", noticeVO);
        
		return map;
	}

	//공지사항 삭제
	@Override
	public int noticeDeleteOffice(String noticeNumber) {
		return mapper.noticeDeleteOffice(noticeNumber);
	}

	//카운트
	@Override
	public int countNoticeService(NoticeVO noticeVO) {
		return mapper.countNotice(noticeVO);
	}
    
	//전체조회(메인페이지)
	@Override
	public List<NoticeVO> noticeListShopList() {
		return mapper.noticeListShopList();
	}





	

}
