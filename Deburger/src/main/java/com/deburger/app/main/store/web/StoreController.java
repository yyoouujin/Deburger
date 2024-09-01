package com.deburger.app.main.store.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.deburger.app.main.store.service.StoreService;
import com.deburger.app.main.store.service.StoreVO;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
public class StoreController {
	
	private StoreService storeService;
	
	// 가맹점 등록
	@GetMapping("insertStore")
	public String officeMain() {
		return "main/store/insertStore";
	}
	
	// 가맹점 등록 post
	@PostMapping("insertStore")
	public String postMethodName( StoreVO storeVO) {
		//TODO: process POST request	
		storeService.insertStore(storeVO);
		return  "main/store/insertStore";
	}
	
	// 가맹점 목록
		@GetMapping("officeListStore")
		public String listStore() {
			return "main/store/officeListStore";
		}
		
	// 가맹점 현황
		@GetMapping("StoreStatistics")
		public String StoreStatistics() {
			return "main/store/StoreStatistics";
		}		

}
