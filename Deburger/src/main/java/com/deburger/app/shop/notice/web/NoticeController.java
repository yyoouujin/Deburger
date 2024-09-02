package com.deburger.app.shop.notice.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    public String noticeListShopUpdate(Model model) {
    	List<NoticeVO> list = noticeService.noticeListShopUpdate();
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(서비스 )
    @GetMapping("noticeListShopService")
    public String noticeListShopService(Model model) {
    	List<NoticeVO> list = noticeService.noticeListShopService();
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(이벤트 )
    @GetMapping("noticeListShopEvent")
    public String noticeListShopEvent(Model model) {
    	List<NoticeVO> list = noticeService.noticeListShopEvent();
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(작업 )
    @GetMapping("noticeListShopWork")
    public String noticeListShopWork(Model model) {
    	List<NoticeVO> list = noticeService.noticeListShopWork();
    	model.addAttribute("notices", list);
    	
    	return "shop/noticeListShop";
    }
    
    //전체조회(공고 )
    @GetMapping("noticeListShopAnnouncement")
    public String noticeListShopAnnouncement(Model model) {
    	List<NoticeVO> list = noticeService.noticeListShopAnnouncement();
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
}
