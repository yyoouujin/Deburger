package com.deburger.app.shop.qna.mapper;

import java.util.List;

import com.deburger.app.shop.qna.service.QnaVO;

public interface QnaMapper {

	//전체조회(본사)
	public List<QnaVO> qnaListOffice();
	
	
	//전체조회(전체 조회에서 상태 update)
	public int qnaListWriterUpdate(QnaVO qnaVO);
	
	
	//전체조회(가맹점)
	public List<QnaVO> qnaListShop();
	
	
}
