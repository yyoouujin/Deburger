package com.deburger.app.shop.productSale.web;


import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.main.store.service.StoreService;
import com.deburger.app.shop.productSale.service.StoreSaleListVO;
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
	
	// 가맹점 판매 정산 페이지
	@GetMapping("StoreSale")
	public String getStoreSale(Model model) {
		
		List<StoreSaleVO> list = storeSaleService.selectStoreSaleList();
		String mcode = SecurityUtil.memberCode();
		
		String id = storeService.selectStoreInfoNumber(mcode);
		
		StoreSaleVO svo = new StoreSaleVO();
		svo.setStoreNumber(mcode);
		int countSale = storeSaleService.countStoreSale(svo);
		
				
		for(StoreSaleVO storeSaleVO : list) {
			storeSaleVO.setStoreNumber(mcode);
		}
		
		if(countSale > 0) {
			model.addAttribute("count", false);
		}else {
			model.addAttribute("count", true);
		}		
		
		model.addAttribute("storeNumber", id);
		model.addAttribute("List", list);
		return "shop/StoreSale";
	}
	
	// 가맹점 판매 정산 처리
	@PostMapping("StoreSale")
	@ResponseBody
	@Transactional	
	public int postStoreSale(@RequestBody StoreSaleListVO storeSaleListVO){
		
		String mcode = SecurityUtil.memberCode();
		StoreSaleVO today = storeSaleService.selectStoreSaleDate();
		
		//가맹점 판매 통계 정보 담기
		StoreSaleVO storeSale = new StoreSaleVO();
		storeSale.setProductDate(today.getProductDate());
		storeSale.setStoreNumber(mcode);
		storeSale.setProfits(storeSaleListVO.getStoreSale().getProfits());
		
		// 가맹점 재품판매 저장
		for(StoreSaleVO storeSaleVO : storeSaleListVO.getStoreSaleList()) {
			if(storeSaleVO.getCount() != 0) {
				storeSaleVO.setProductDate(today.getProductDate());
				storeSaleService.insertStoreSaleList(storeSaleVO);				
			}
		}
		// 프로시저 호출
		for(StoreSaleVO storeSaleVO : storeSaleListVO.getStoreSaleList()) {
			if(storeSaleVO.getCount() != 0) {			
				storeSaleService.insertStoreSaleProcedure(storeSaleVO);				
				break;
			}
		}
		//가맹점 판매 통계 저장		
		return storeSaleService.insertStoreSaleStatistics(storeSale);		
	}		
}
