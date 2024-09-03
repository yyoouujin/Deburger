package com.deburger.app.shop.notice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.deburger.app.shop.notice.service.NoticeService;
import com.deburger.app.shop.notice.service.NoticeVO;

@Controller
public class NoticeController {

    private NoticeService noticeService;
    
    @Autowired
    NoticeController(NoticeService noticeService){
    	this.noticeService = noticeService;
    }
    //전체조회(전체)
    @GetMapping("noticeListShop")
    public String noticeListShop(Model model) {
    	List<NoticeVO> list = noticeService.noticeListShop();
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    
    //전체조회(업데이트 )
    @GetMapping("noticeListShopUpdate")
    public String noticeListShopUpdate(Model model,NoticeVO noticeVO) {
    	noticeVO.setDivision("업데이트");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(서비스 )
    @GetMapping("noticeListShopService")
    public String noticeListShopService(Model model,NoticeVO noticeVO) {
    	noticeVO.setDivision("서비스");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(이벤트 )
    @GetMapping("noticeListShopEvent")
    public String noticeListShopEvent(Model model,NoticeVO noticeVO) {
    	noticeVO.setDivision("이벤트");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(작업 )
    @GetMapping("noticeListShopWork")
    public String noticeListShopWork(Model model,NoticeVO noticeVO) {
       	noticeVO.setDivision("작업");
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(공고 )
    @GetMapping("noticeListShopAnnouncement")
    public String noticeListShopAnnouncement(Model model,NoticeVO noticeVO) {
       	noticeVO.setDivision("공고");   	
    	List<NoticeVO> list = noticeService.noticeListShopE(noticeVO);
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }

    
    //단건조회
    @GetMapping("noticeListInfoShop")
    public String noticeListInfoShop(NoticeVO noticeVO, Model model) {
    	NoticeVO list = noticeService.noticeListInfoShop(noticeVO);
    	model.addAttribute("notice", list);
    	
    	return "shop/noticeListInfoShop";
    }
    
    //등록
    @GetMapping("noticeInsertOffice")
    public String noticeInsertOffice() {
    	return "shop/noticeInsertOffice";
    }
   
    //등록
    @PostMapping("noticeInsertOffice")
    public String noticeInsertOffice(NoticeVO noticeVO) {
    	noticeService.noticeInsertOffice(noticeVO);
    	
    	return "redirect:noticeListShop";
    }
    //수정
    
    
}
