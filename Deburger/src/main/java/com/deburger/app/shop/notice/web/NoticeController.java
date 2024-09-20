package com.deburger.app.shop.notice.web;

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

import com.deburger.app.shop.notice.service.NoticeService;
import com.deburger.app.shop.notice.service.NoticeVO;

@Controller
public class NoticeController {

    private NoticeService noticeService;
    
    @Autowired
    NoticeController(NoticeService noticeService){
    	this.noticeService = noticeService;
    }
    
    //전체조회(본점)
    @GetMapping("noticeListOffice")
    public String noticeListOffice(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
    	int total = noticeService.countNoticeService(null);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", noticeVO);
		model.addAttribute("viewAll", noticeService.noticeListShop(noticeVO));
    	
    	return "office/notice/noticeListOffice";
    }
        
    //전체조회(본점-업데이트)
    @GetMapping("noticeListOfficeUpdate")
    public String noticeListOfficeUpdate(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
    	
    	noticeVO.setDivision("업데이트");
    	int total = noticeService.countNoticeService(noticeVO);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		noticeVO.setDivision("업데이트");
		model.addAttribute("paging", noticeVO);		
    	model.addAttribute("viewAll", noticeService.noticeListShopE(noticeVO));
    	
    	return "office/notice/noticeListOffice";
    }    
    
    //전체조회(본점-서비스)
    @GetMapping("noticeListOfficeService")
    public String noticeListOfficeService(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
    	
    	noticeVO.setDivision("서비스");
    	int total = noticeService.countNoticeService(noticeVO);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		noticeVO.setDivision("서비스");
		model.addAttribute("paging", noticeVO);		
    	model.addAttribute("viewAll", noticeService.noticeListShopE(noticeVO));
    	
    	return "office/notice/noticeListOffice";
    }    
    
    //전체조회(본점-이벤트 )
    @GetMapping("noticeListOfficeEvent")
    public String noticeListOfficeEvent(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {

    	noticeVO.setDivision("이벤트");
    	int total = noticeService.countNoticeService(noticeVO);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		noticeVO.setDivision("이벤트");
		model.addAttribute("paging", noticeVO);		
    	model.addAttribute("viewAll", noticeService.noticeListShopE(noticeVO));
    	
    	return "office/notice/noticeListOffice";
    }
    
    //전체조회(본점-작업 )
    @GetMapping("noticeListOfficeWork")
    public String noticeListOfficeWork(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
    	
    	noticeVO.setDivision("작업");
    	int total = noticeService.countNoticeService(noticeVO);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		noticeVO.setDivision("작업");
		model.addAttribute("paging", noticeVO);		
    	model.addAttribute("viewAll", noticeService.noticeListShopE(noticeVO));
    	
    	return "office/notice/noticeListOffice";
    }
    
    //전체조회(본점-공고 )
    @GetMapping("noticeListOfficeAnnouncement")
    public String noticeListOfficeAnnouncement(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
    	
    	noticeVO.setDivision("공고");
    	int total = noticeService.countNoticeService(noticeVO);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		noticeVO.setDivision("공고");
		model.addAttribute("paging", noticeVO);		
    	model.addAttribute("viewAll", noticeService.noticeListShopE(noticeVO));
    	
    	
    	return "office/notice/noticeListOffice";
    }
 
    //단건조회(본점)
    @GetMapping("noticeListInfoOffice")
    public String noticeListInfoOffice(NoticeVO noticeVO, Model model) {
    	NoticeVO list = noticeService.noticeListInfoShop(noticeVO);
    	model.addAttribute("notice", list);
    	
    	return "office/notice/noticeListInfoOffice";
    }
    
    
    //전체조회(가맹점-전체)
    @GetMapping("noticeListShop")
    public String noticeListShop(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {
		int total = noticeService.countNoticeService(null);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		model.addAttribute("paging", noticeVO);
		model.addAttribute("viewAll", noticeService.noticeListShop(noticeVO));
    	
    	return "shop/noticeListShop";
    }
    
    
    //전체조회(가맹점-업데이트 )
    @GetMapping("noticeListShopUpdate")
    public String noticeListShopUpdate(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {

    	noticeVO.setDivision("업데이트");
    	int total = noticeService.countNoticeService(noticeVO);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		noticeVO.setDivision("업데이트");
		model.addAttribute("paging", noticeVO);		
    	model.addAttribute("viewAll", noticeService.noticeListShopE(noticeVO));
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(가맹점-서비스 )
    @GetMapping("noticeListShopService")
    public String noticeListShopService(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {

    	noticeVO.setDivision("서비스");
    	int total = noticeService.countNoticeService(noticeVO);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		noticeVO.setDivision("서비스");
		model.addAttribute("paging", noticeVO);		
    	model.addAttribute("viewAll", noticeService.noticeListShopE(noticeVO));
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(가맹점-이벤트 )
    @GetMapping("noticeListShopEvent")
    public String noticeListShopEvent(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {

    	noticeVO.setDivision("이벤트");
    	int total = noticeService.countNoticeService(noticeVO);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		noticeVO.setDivision("이벤트");
		model.addAttribute("paging", noticeVO);		
    	model.addAttribute("viewAll", noticeService.noticeListShopE(noticeVO));
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(가맹점-작업 )
    @GetMapping("noticeListShopWork")
    public String noticeListShopWork(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {

    	noticeVO.setDivision("작업");
    	int total = noticeService.countNoticeService(noticeVO);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		noticeVO.setDivision("작업");
		model.addAttribute("paging", noticeVO);		
    	model.addAttribute("viewAll", noticeService.noticeListShopE(noticeVO));
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(가맹점-공고 )
    @GetMapping("noticeListShopAnnouncement")
    public String noticeListShopAnnouncement(NoticeVO noticeVO, Model model
			, @RequestParam(value="nowPage", required=false)String nowPage
			, @RequestParam(value="cntPerPage", required=false)String cntPerPage) {

    	noticeVO.setDivision("공고");
    	int total = noticeService.countNoticeService(noticeVO);
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) { 
			cntPerPage = "10";
		}
		noticeVO = new NoticeVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		noticeVO.setDivision("공고");
		model.addAttribute("paging", noticeVO);		
    	model.addAttribute("viewAll", noticeService.noticeListShopE(noticeVO));
    	
    	return "shop/noticeListShop";
    }

    
    //단건조회(가맹점)
    @GetMapping("noticeListInfoShop")
    public String noticeListInfoShop(NoticeVO noticeVO, Model model) {
    	NoticeVO list = noticeService.noticeListInfoShop(noticeVO);
    	model.addAttribute("notice", list);
    	
    	return "shop/noticeListInfoShop";
    }
    
    //등록(본점)
    @GetMapping("noticeInsertOffice")
    public String noticeInsertOffice() {
    	return "office/notice/noticeInsertOffice";
    }
   
    //등록(본점)
    @PostMapping("noticeInsertOffice")
    public String noticeInsertOffice(NoticeVO noticeVO) {
    	noticeService.noticeInsertOffice(noticeVO);
    	
    	return "redirect:noticeListOffice";
    }
    //수정(본점)
    @GetMapping("noticeCorrectOffice")
    public String noticeCorrectOffice(NoticeVO noticeVO, Model model) {
    	NoticeVO noticesVO = noticeService.noticeListInfoShop(noticeVO);
    	model.addAttribute("notice",noticesVO);
    	return "office/notice/noticeCorrectOffice";
    }
    //수정(본점)
    @PostMapping("noticeCorrectOffice")
    @ResponseBody
    public Map<String, Object> noticeCorrectProcess(@RequestBody NoticeVO noticeVO) {
    	return noticeService.noticeCorrectOffice(noticeVO);
    }
    
    //삭제(본점)
    @GetMapping("noticeDeleteOffice")
    public String noticeDeleteOffice(String noticeNumber) {
    	noticeService.noticeDeleteOffice(noticeNumber);
    	return "redirect:noticeListOffice";
    }
    

    
    
}
