package com.deburger.app.office.product.web;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.deburger.app.office.product.service.ProductService;
import com.deburger.app.office.product.service.ProductVO;

@Controller
public class ProductController {

	public ProductService productService;

	@Autowired
	ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("products")
	public String productList(ProductVO productVO ,Model model, @RequestParam(value="category", required=false) String category) {
		if(category == null) {
			category = "버거";
		}
		productVO.setCategory(category);
		
		List<ProductVO> list = productService.serviceAllList(productVO);
		model.addAttribute("products", list);
		model.addAttribute("selcate", category);
		return "office/product/products";
	}
	
	@PostMapping("products")
	@ResponseBody
	public Map<String, Object> productList(@RequestBody ProductVO productVO) {
	    Map<String, Object> map = new HashMap<>();
	     productVO.getCategory();
	   
	    List<ProductVO> list = productService.serviceAllList(productVO);
	    
	    map.put("products", list);
	    return map; 
	}

	@GetMapping("productInfo")
	public String productInfo(ProductVO productVO, Model model) {
		List<ProductVO> list = productService.productInfo(productVO);
		model.addAttribute("product", list);
		return "office/product/productInfo";
	}
}
