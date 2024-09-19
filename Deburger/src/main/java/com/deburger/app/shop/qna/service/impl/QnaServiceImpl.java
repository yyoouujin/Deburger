package com.deburger.app.shop.qna.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.main.login.config.SecurityUtil;
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
	
	//전체조회(본점 카운트)
	@Override
	public Map<String, Object> qnaListOfficeConut(QnaVO vo) {
		Map<String, Object> map = new HashMap<>();
		
		vo.setWriter("접수");
		map.put("count1", mapper.qnaListOfficeConut(vo));
		vo.setWriter("처리중");
		map.put("count2", mapper.qnaListOfficeConut(vo));
		vo.setWriter("완료");
		map.put("count3", mapper.qnaListOfficeConut(vo));
		return map;
	}

	//QnA 전체 조회(전체 조회에서 상태 update)
	@Override
	public Map<String, Object> statusUpdate(QnaVO qnaVO) {
		 Map<String, Object> map = new HashMap<>();
	        boolean isSuccessed = false;
	        
	        int result = mapper.statusUpdate(qnaVO);
	        
	        if(result == 1) {
	        	isSuccessed = true;
	        }
	        
	        map.put("result", isSuccessed);
	        map.put("target", qnaVO);
	        
			return map;
		}
	
	//전체조회(가맹점)
	@Override
	public List<QnaVO> qnaListShop() {
		String mcode = SecurityUtil.memberCode();//id
		return mapper.qnaListShop(mcode);
	}

	//전체조회(가맹점 카운트)
	@Override
	public Map<String, Object> qnaListShopConut(QnaVO vo) {
		String mcode = SecurityUtil.memberCode();//storeNumber
		
		Map<String, Object> map = new HashMap<>();
		vo.setStoreNumber(mcode);
		vo.setWriter("접수");
		map.put("count1", mapper.qnaListShopConut(vo));
		vo.setWriter("처리중");
		map.put("count2", mapper.qnaListShopConut(vo));
		vo.setWriter("완료");
		map.put("count3", mapper.qnaListShopConut(vo));
		return map;
	}

	//글 등록(가맹점)
	@Override
	public int qnaShopInsert(QnaVO qnaVO) {
		String mcode = SecurityUtil.memberCode();//storeNumber
		qnaVO.setStoreNumber(mcode);
		int result = mapper.qnaShopInsert(qnaVO);
		return result;
	}

	//QnA상세 조회(가맹점) 
	@Override
	public Map<String, Object> qnaListInfoShop(QnaVO qnaVO) {
	    // QnA 상세 정보 조회
	    QnaVO qnaDetail = mapper.qnaListInfoShop(qnaVO);
	    
	    // QnA 댓글 조회
	    QnaVO comments = mapper.qnaListInfoShopComment(qnaVO);
	
	    Map<String, Object> resultMap = new HashMap<>();
	    resultMap.put("qnaDetail", qnaDetail);
	    resultMap.put("comments", comments);
	    
	    return resultMap;
	}
    
	//가맹점 QnA수정 
	@Override
	public Map<String, Object> qnaShopUpdate(QnaVO qnaVO) {
        Map<String, Object> map = new HashMap<>();
        boolean isSuccessed = false;
        
        int result = mapper.qnaShopUpdate(qnaVO);

        if(result == 1) {
        	isSuccessed = true;
        }
        
        map.put("result", isSuccessed);
        map.put("target", qnaVO);
        
		return map;
	}

	//가맹점 QnA삭제 
	@Override
	public int qnaShopDelete(int qnaNumber) {
		return mapper.qnaShopDelete(qnaNumber);
	}

	//QnA상세조회,댓글조회(본사) 
	@Override
	@Transactional
	public Map<String, Object> qnaListInfoOffice(QnaVO qnaVO) {
	    // QnA 상세 정보 조회
	    QnaVO qnaDetail = mapper.qnaCommentOffice(qnaVO);
	    // QnA 댓글 조회
	    String comselect = mapper.qnaCommertSelect(qnaVO);
	
	    Map<String, Object> resultMap = new HashMap<>();
	    resultMap.put("qnaDetail", qnaDetail);
	    resultMap.put("comselect", comselect);
	    
	    return resultMap;
	}

	//QnA 답글 수정(본사)
	@Override
	public Map<String, Object> qnaCommentUpdate(QnaVO qnaVO) {
        Map<String, Object> map = new HashMap<>();
        boolean isSuccessed = false;
        System.out.println(qnaVO);  
        int result = mapper.qnaCommentUpdate(qnaVO);

        if(result == 1) {
        	isSuccessed = true;
        }
              
        map.put("result", isSuccessed);
        map.put("target", qnaVO);
        
		return map;
	}

	//답글 작성
	@Override
	public int qnaCommentInsert(QnaVO qnaVO) {
		System.err.println(qnaVO);
		int result = mapper.qnaCommentInsert(qnaVO);
		return result;
	}

	}

	

	
