package com.deburger.app.shop.qna.mapper;

import java.util.List;
import java.util.Map;

import com.deburger.app.shop.qna.service.QnaVO;

public interface QnaMapper {

	// QnA 본사 
	// 문의 조회
	public List<QnaVO> qnaListOffice();

	// 문의 상태 카운팅
	public int qnaListOfficeConut(QnaVO qnaVO);

	// 문의 상태 변경
	public int statusUpdate(QnaVO qnaVO);

	// 문의 상세 조회 
	public QnaVO qnaCommentOffice(QnaVO qnaVO);
	  
	// 문의 답글 등록 
	public int qnaCommentInsert(QnaVO qnaVO);
	
	// 문의 답글 수정
	public int qnaCommentUpdate(QnaVO qnaVO);
	
	// 문의 답글 조회
	public String qnaCommertSelect(QnaVO qnaVO);
	  
	//QnA 가맹점
	//문의 조회
	public List<QnaVO> qnaListShop(String storeNumber);
	  
	// 문의 상태 카운팅 
	public int qnaListShopConut(QnaVO qnaVO);

	// 문의 등록
	public int qnaShopInsert(QnaVO qnaVO);
	
	// 문의 수정 
	public int qnaShopUpdate(QnaVO qnaVO);
	  
	// 문의 삭제 
	public int qnaShopDelete(int qnaVO);
	
	// 문의 상세 조회 
	public QnaVO qnaListInfoShop(QnaVO qnaVO);
	
	// 문의 답글 조회
	public QnaVO qnaListInfoShopComment(QnaVO qnaVO);
	  

	  

	  
	 



}
