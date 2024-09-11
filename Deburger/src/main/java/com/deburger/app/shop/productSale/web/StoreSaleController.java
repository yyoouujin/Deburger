package com.deburger.app.shop.productSale.web;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.main.store.service.StoreService;
import com.deburger.app.shop.productSale.service.StoreSaleService;
import com.deburger.app.shop.productSale.service.StoreSaleVO;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;




@Controller
@AllArgsConstructor
public class StoreSaleController {
	
	private StoreSaleService storeSaleService;
	private StoreService storeService;
	
	// 가맹점 판매 정산 
	@GetMapping("StoreSale")
	public String getStoreSale(Model model) {
		
		List<StoreSaleVO> list = storeSaleService.selectStoreSaleList();
		String mcode = SecurityUtil.memberCode();
		String id = storeService.selectStoreInfoNumber(mcode);
		
		for(StoreSaleVO storeSaleVO : list) {
			storeSaleVO.setStoreNumber(mcode);
		}
		
		model.addAttribute("storeNumber", id);
		model.addAttribute("List", list);
		return "shop/StoreSale";
	}
	
	@PostMapping("StoreSale")
	@ResponseBody
	public String postStoreSale(@RequestBody List<StoreSaleVO> listStoreSaleVO){
		
		for(StoreSaleVO storeSaleVO : listStoreSaleVO) {
			if(storeSaleVO.getCount() != 0) {
				storeSaleService.insertStoreSaleList(storeSaleVO);				
			}
		}
		
		return "";
	}
	
	

	
	
}
