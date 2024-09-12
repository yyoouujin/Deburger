package com.deburger.app.shop.qna.mapper;

import java.util.List;
import java.util.Map;

import com.deburger.app.shop.qna.service.QnaVO;

public interface QnaMapper {

	// QnA목록
	// 전체조회(본사)-완
	public List<QnaVO> qnaListOffice();

	// 전체조회(본사 카운트)-완
	public int qnaListOfficeConut(QnaVO qnaVO);

	// 전체조회( 전체 조회에서 상태 변경(본사, 가맹점 공통))
	public int statusUpdate(QnaVO qnaVO);
	
	//전체조회(가맹점) -완
	public List<QnaVO> qnaListShop(String storeNumber);
	  
	//전체조회(가맹점 카운트) -완 
	public int qnaListShopConut(QnaVO qnaVO);
	  
	  
	//QnA등록
	  
	//가맹점에서 글 등록
	public int qnaShopInsert(QnaVO qnaVO);
	  
	//QnA상세 조회(가맹점) 
	public QnaVO qnaListInfoShop(QnaVO qnaVO);
	
	//QnA상세 조회(가맹점 댓글 조회)
	public QnaVO qnaListInfoShopComment(QnaVO qnaVO);
	  
	//가맹점 QnA수정 
	public int qnaShopUpdate(QnaVO qnaVO);
	  
	//가맹점 QnA삭제 
	public int qnaShopDelete(int qnaVO);
	  
	//QnA상세 조회(본사) 
	public QnaVO qnaListInfoOffice(QnaVO qnaVO);
	  
	//QnA 댓글 등록(본사) 
	public int qnaCommentInsert(QnaVO qnaVO);
	  
	//QnA 댓글 조회(본사)
	public int qnaCommertSelect(QnaVO qnaVO);
	  
	 



}
