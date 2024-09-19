package com.deburger.app.shop.StoreMatCon.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.shop.StoreMatCon.service.StoreMatConService;
import com.deburger.app.shop.StoreMatCon.service.StoreMatConVO;
import com.deburger.app.shop.StoreProSale.service.StoreProSaleVO;

@Controller
public class StoreMatConController {

	private StoreMatConService storeMatConService;
	
	@Autowired
	StoreMatConController(StoreMatConService storeMatConService){
		this.storeMatConService = storeMatConService;
	}
	
	@GetMapping("StoreMaterialConList")
	public String StoreMaterialConList(Model model) {
		
		List<StoreMatConVO> list = storeMatConService.StoreMaterialList();
		List<StoreMatConVO> list2 = storeMatConService.stockClassificationMa();
		
		
		model.addAttribute("StoreMaterialConList",list);
		model.addAttribute("stockC", list2);
		
		return "shop/Material";
	}
	
	@GetMapping("StoreMaterialoneList")
	public String StoreMaterialoneList(StoreMatConVO storeMatConVO,Model model) {
		
		List<StoreMatConVO> list = storeMatConService.StoreMaterialoneList(storeMatConVO);
		
		model.addAttribute("StoreMaterialoneList", list);
		
		return"shop/MaterialGraph";
	}
	
	@PostMapping("classificationListMa")
	@ResponseBody
	public List<StoreMatConVO> classificationListpro(@RequestBody StoreMatConVO storeMatConVO,Model model) {		
		List<StoreMatConVO> list = storeMatConService.classificationListMa(storeMatConVO);
	return list;
	}
}
