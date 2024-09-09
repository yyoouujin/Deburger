package com.deburger.app.shop.qna.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.shop.qna.service.QnaService;
import com.deburger.app.shop.qna.service.QnaVO;





@Controller
public class QnaController {

	private QnaService qnaService;
	
	@Autowired
	public QnaController (QnaService qnaService) {
		this.qnaService = qnaService;
	}
	
	//QnA 전체조회(본사)
	@GetMapping("qnaListOffice")
	public String qnaListOffice(Model model,QnaVO vo) {
		// 접수현황
		Map<String, Object> count = qnaService.qnaListOfficeConut(vo);
		model.addAttribute("counts", count);
		
		//접수리스트
		List<QnaVO> list = qnaService.qnaListOffice();
		model.addAttribute("qnas",list);
		
		return "office/qna/qnaListOffice";
	}
	
/*	//QnA 전체조회(본사 카운트:접수)
	@GetMapping("qnaListOffice")
	public String qnaListOfficeConut(Model model,QnaVO qnaVO) {
	
		qnaVO.setWriter("접수");
		int list = qnaService.qnaListOfficeConut(qnaVO);
		model.addAttribute("qnas",list);
		
		return "office/qna/qnaListOffice";
	}
	
	//QnA 전체조회(본사 카운트:처리중)
	@GetMapping("qnaListOffice")
	public String qnaListOfficeConutProcess(Model model,QnaVO qnaVO) {
		qnaVO.setWriter("처리중");
		int list = qnaService.qnaListOfficeConut(qnaVO);
		model.addAttribute("qnas",list);
		
		return "office/qna/qnaListOffice";
	}
	
	//QnA 전체조회(본사 카운트:완료)
	@GetMapping("qnaListOffice")
	public String qnaListOfficeConutComplete(Model model,QnaVO qnaVO) {
		qnaVO.setWriter("완료");
		int list = qnaService.qnaListOfficeConut(qnaVO);
		model.addAttribute("qnas",list);
		
		return "office/qna/qnaListOffice";
	}
	*/
	//QnA 전체 조회 상태 update)
	@PostMapping("qnaListWriterUpdate")
	@ResponseBody
    public Map<String, Object> qnaListWriterUpdate(@RequestBody QnaVO qnaVO) {
    	return qnaService.qnaListWriterUpdate(qnaVO);
    }
	
	//QnA 전체조회(지수)
	@GetMapping("qnaListShop")
	public String qnaList() {
		return "shop/qnaListShop";
	}
	
	//QnA 상세조회(지수)
	@GetMapping("qnaListInfoShop")
	public String qnaListInfo() {
		return "shop/qnaListInfoShop";
	}	
	
	//QnA작성(지수)
	@GetMapping("qnaInsertShop")
	public String qnaInsert() {
		return "shop/qnaInsertShop";
	}
	
	//QnA수정(지수)
	@GetMapping("qnaCorrectShop")
	public String qnaCorrect() {
		return "shop/qnaCorrectShop";
	}	
}