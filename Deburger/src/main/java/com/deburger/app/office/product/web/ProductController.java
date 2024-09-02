package com.deburger.app.office.product.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	public String productList(Model model) {
		List<ProductVO> list = productService.serviceAllList();
		model.addAttribute("products", list);

		return "office/product/products";
	}

	@GetMapping("productInfo")
	public String productInfo(ProductVO productVO, Model model) {
		ProductVO pvo = productService.productInfo(productVO);
		model.addAttribute("product", pvo);
		return "office/product/productInfo";
	}
}
