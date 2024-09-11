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
    public String noticeListOffice(Model model) {
    	List<NoticeVO> list = noticeService.noticeListShop();
    	model.addAttribute("notices", list);
    	
    	return "office/notice/noticeListOffice";
    }
        
    //전체조회(본점-업데이트)
    @GetMapping("noticeListOfficeUpdate")
    public String noticeListOfficeUpdate(Model model,NoticeVO noticeVO) {
    	noticeVO.setDivision("업데이트");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "office/notice/noticeListOffice";
    }    
    
    //전체조회(본점-서비스)
    @GetMapping("noticeListOfficeService")
    public String noticeListOfficeService(Model model,NoticeVO noticeVO) {
    	noticeVO.setDivision("서비스");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "office/notice/noticeListOffice";
    }    
    
    //전체조회(본점-이벤트 )
    @GetMapping("noticeListOfficeEvent")
    public String noticeListOfficeEvent(Model model,NoticeVO noticeVO) {
    	noticeVO.setDivision("이벤트");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "office/notice/noticeListOffice";
    }
    
    //전체조회(본점-작업 )
    @GetMapping("noticeListOfficeWork")
    public String noticeListOfficeWork(Model model,NoticeVO noticeVO) {
       	noticeVO.setDivision("작업");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "office/notice/noticeListOffice";
    }
    
    //전체조회(본점-공고 )
    @GetMapping("noticeListOfficeAnnouncement")
    public String noticeListOfficeAnnouncement(Model model,NoticeVO noticeVO) {
       	noticeVO.setDivision("공고");   	
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
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
    public String noticeListShop(Model model) {
    	List<NoticeVO> list = noticeService.noticeListShop();
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    
    //전체조회(가맹점-업데이트 )
    @GetMapping("noticeListShopUpdate")
    public String noticeListShopUpdate(Model model,NoticeVO noticeVO) {
    	noticeVO.setDivision("업데이트");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(가맹점-서비스 )
    @GetMapping("noticeListShopService")
    public String noticeListShopService(Model model,NoticeVO noticeVO) {
    	noticeVO.setDivision("서비스");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(가맹점-이벤트 )
    @GetMapping("noticeListShopEvent")
    public String noticeListShopEvent(Model model,NoticeVO noticeVO) {
    	noticeVO.setDivision("이벤트");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(가맹점-작업 )
    @GetMapping("noticeListShopWork")
    public String noticeListShopWork(Model model,NoticeVO noticeVO) {
       	noticeVO.setDivision("작업");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(가맹점-공고 )
    @GetMapping("noticeListShopAnnouncement")
    public String noticeListShopAnnouncement(Model model,NoticeVO noticeVO) {
       	noticeVO.setDivision("공고");   	
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
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
    	return "shop/noticeInsertOffice";
    }
   
    //등록(본점)
    @PostMapping("noticeInsertOffice")
    public String noticeInsertOffice(NoticeVO noticeVO) {
    	noticeService.noticeInsertOffice(noticeVO);
    	
    	return "redirect:noticeListShop";
    }
    //수정(본점)
    @GetMapping("noticeCorrectOffice")
    public String noticeCorrectOffice(NoticeVO noticeVO, Model model) {
    	NoticeVO noticesVO = noticeService.noticeListInfoShop(noticeVO);
    	model.addAttribute("notice",noticesVO);
    	return "shop/noticeCorrectOffice";
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
    	return "redirect:noticeListShop";
    }
    
}
