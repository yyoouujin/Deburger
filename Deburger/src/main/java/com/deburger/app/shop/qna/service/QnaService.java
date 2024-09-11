package com.deburger.app.shop.qna.service;

import java.util.List;
import java.util.Map;

import com.deburger.app.shop.notice.service.NoticeVO;

public interface QnaService {

	//전체조회(본점)
	public List<QnaVO> qnaListOffice();
	
	//전체조회(본점 카운트)
	public  Map<String, Object> qnaListOfficeConut(QnaVO qnaVO); 
	
	//전체조회(전체 조회에서 상태 update)
	public Map<String, Object> qnaListWriterUpdate(QnaVO qnaVO);
	
	//전체조회(가맹점)
	public List<QnaVO> qnaListShop();
	
	//전체조회(가맹점 카운트)
	public Map<String, Object> qnaListShopConut(QnaVO qnaVO);
	
	//글 등록(가맹점)
	public int qnaShopInsert(QnaVO qnaVO);
	
	//QnA상세 조회(가맹점) 
	public Map<String, Object> qnaListInfoShop(QnaVO qnaVO);

	
	
}
