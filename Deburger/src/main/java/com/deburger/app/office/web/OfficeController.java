package com.deburger.app.office.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OfficeController {
	
	@GetMapping("office")
	public String officeMain() {
		return "office/main";
	}			
	
	//공지사항 전체 조회(지수)
	@GetMapping("noticeListOffice")
	public String noticeListOffice() {
		return "office/noticeListOffice";
	}			
	
	//공지사항 상세 조회(지수)
	@GetMapping("noticeListInfoOffice")
	public String noticeListInfoOffice() {
		return "office/noticeListInfoOffice";
	}	
	
	//공지사항 수정(지수)
	@GetMapping("noticeCorrectOffice")
	public String noticeCorrectOffice() {
		return "office/noticeCorrectOffice";
	}
	
	//공지사항 작성(지수)
	@GetMapping("noticeInsertOffice")
	public String noticeInsertOffice() {
		return "office/noticeInsertOffice";
	}	
	
	//QnA전체조회(지수)
	@GetMapping("qnaListOffice")
	public String qnaListOffice() {
		return "office/qnaListOffice";
	}	
	
	//QnA상세 조회 및 답변
	@GetMapping("qnaListInfoOffice")
	public String qnaListInfoOffice() {
		return "office/qnaListInfoOffice";
	}	
		
	
}
