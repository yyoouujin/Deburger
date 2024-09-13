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
	public Map<String, Object> statusUpdate(QnaVO qnaVO);
	
	//전체조회(가맹점)
	public List<QnaVO> qnaListShop();
	
	//전체조회(가맹점 카운트)
	public Map<String, Object> qnaListShopConut(QnaVO qnaVO);
	
	//글 등록(가맹점)
	public int qnaShopInsert(QnaVO qnaVO);
	
	//QnA상세 조회(가맹점) 
	public Map<String, Object> qnaListInfoShop(QnaVO qnaVO);
	
	//가맹점 QnA수정 
	public Map<String, Object> qnaShopUpdate(QnaVO qnaVO);
	  
	//가맹점 QnA삭제 
	public int qnaShopDelete(int qnaNumber);

	//QnA상세 조회,댓글조회(본사) 
	public Map<String, Object> qnaListInfoOffice(QnaVO qnaVO);
	
	//QnA 문의 답글 수정(본사)
	public Map<String, Object> qnaCommentUpdate(QnaVO qnaVO);
	
	//QnA 문의 답글 작성(본사)
	public int qnaCommentInsert(QnaVO qnaVO);
		
	
}
