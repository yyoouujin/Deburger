package com.deburger.app.shop.qna.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	//QnA 전체 조회(전체 조회에서 상태 update)
	@PostMapping("qnaListWriterUpdate")
	@ResponseBody
    public Map<String, Object> statusUpdate(@RequestBody QnaVO qnaVO) {
		System.out.println(qnaVO);
    	return qnaService.statusUpdate(qnaVO);
    }
	
	//전체조회(가맹점)
	@GetMapping("qnaListShop")
	public String qnaList(Model model,QnaVO vo) {
		// 접수현황
		Map<String, Object> count = qnaService.qnaListShopConut(vo);
		model.addAttribute("counts", count);
		
		//접수리스트
		List<QnaVO> list = qnaService.qnaListShop();
		model.addAttribute("qnas",list);
		
		return "shop/qnaListShop";
	}
	
	//글 등록(가맹점)
	@GetMapping("qnaShopInsert")
	public String qnaShopInsert() {
		return "shop/qnaShopInsert";
	}
	
	//글 등록(가맹점)
    @PostMapping("qnaShopInsert")
    public String qnaShopInsert(QnaVO qnaVO) {
    	qnaService.qnaShopInsert(qnaVO);
    	
    	return "redirect:qnaListShop";
    }
    
    //상세 조회(가맹점)
    @GetMapping("qnaListInfoShop")
    public String qnaListInfoShop(QnaVO qnaVO, Model model) {
    	Map<String, Object> Info = qnaService.qnaListInfoShop(qnaVO);
    	model.addAttribute("qna", Info);
    	
    	return "shop/qnaListInfoShop";
    }
    
    //가맹점 QnA수정  
    @GetMapping("qnaShopUpdate")
    public String qnaShopUpdate(QnaVO qnaVO, Model model) {
    	Map<String, Object> qnasVO = qnaService.qnaListInfoShop(qnaVO);
    	model.addAttribute("qna",qnasVO);
    	return "shop/qnaShopUpdate";
    }    
    
    //가맹점 QnA수정 
    @PostMapping("qnaShopUpdate")
    @ResponseBody
    public Map<String, Object> qnaShopUpdate(@RequestBody QnaVO qnaVO) {
    	return qnaService.qnaShopUpdate(qnaVO);
    }
        
    //가맹점 QnA삭제
    @GetMapping("qnaShopDelete")
    public String qnaShopDelete(int qnaNumber) {
    	qnaService.qnaShopDelete(qnaNumber);
    	return "redirect:qnaListShop";
    }
    
    //QnA상세 조회,댓글조회(본사) 
    @GetMapping("qnaListInfoOffice")
    public String qnaListInfoOffice(QnaVO qnaVO, Model model) {
    	Map<String, Object> Info = qnaService.qnaListInfoOffice(qnaVO);
    	model.addAttribute("qna", Info);
    	return "office/qna/qnaListInfoOffice";
    }
    
    //QnA 답글 등록(본사)
	@GetMapping("qnaCommentInsert")
	public String qnaCommentInsert() {
		return "office/qna/qnaCommentInsert";
	}
	
	//QnA 답글 등록(본사)
    @PostMapping("qnaCommentInsert")
    @ResponseBody
    public String qnaCommentInsert(@RequestBody QnaVO qnaVO) {
    	
    	System.err.println(qnaVO);
    	qnaService.qnaCommentInsert(qnaVO);
    	
    	return null;
    }
    
    //QnA 답글 수정(본사)
    @GetMapping("qnaCommentUpdate")
    public String qnaCommentUpdate(QnaVO qnaVO, Model model) {
    	Map<String, Object> qnasVO = qnaService.qnaCommentUpdate(qnaVO);
    	model.addAttribute("qna",qnasVO);
    	return "office/qna/qnaCommentUpdate";
    }    
    
  //QnA 답글 수정(본사)
    @PostMapping("qnaCommentUpdate")
    @ResponseBody
    public Map<String, Object> qnaCommentUpdate(@RequestBody QnaVO qnaVO) {
    	return qnaService.qnaCommentUpdate(qnaVO);
    }
    
    
}
    
    
