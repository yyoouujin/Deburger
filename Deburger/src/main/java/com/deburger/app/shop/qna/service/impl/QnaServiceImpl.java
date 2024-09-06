package com.deburger.app.shop.qna.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.shop.qna.mapper.QnaMapper;
import com.deburger.app.shop.qna.service.QnaService;
import com.deburger.app.shop.qna.service.QnaVO;

@Service
public class QnaServiceImpl implements QnaService {

	private QnaMapper mapper;
	
	@Autowired
	QnaServiceImpl(QnaMapper mapper){
		this.mapper = mapper;
	}
	
	//QnA 전체 조회(본사)
	@Override
	public List<QnaVO> qnaListOffice() {
		return mapper.qnaListOffice();
	}

	//QnA 전체 조회(전체 조회에서 상태 update)
	@Override
	public Map<String, Object> qnaListWriterUpdate(QnaVO qnaVO) {
		 Map<String, Object> map = new HashMap<>();
	        boolean isSuccessed = false;
	        
	        int result = mapper.qnaListWriterUpdate(qnaVO);
	        
	        if(result == 1) {
	        	isSuccessed = true;
	        }
	        
	        map.put("result", isSuccessed);
	        map.put("target", qnaVO);
	        
			return map;
		}

	@Override
	public List<QnaVO> qnaListShop() {
		return mapper.qnaListShop();
	}
}
	
