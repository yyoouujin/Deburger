package com.deburger.app.office.product.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.deburger.app.office.product.mapper.ProductMapper;
import com.deburger.app.office.product.service.ProductService;
import com.deburger.app.office.product.service.ProductVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	public ProductMapper productMapper;

	@Override
	public List<ProductVO> serviceAllList(ProductVO productVO) {

		List<ProductVO> list =productMapper.selectAllList(productVO);
		System.out.println(list);
		return list;
		
	}

	@Override
	public List<ProductVO> productInfo(ProductVO productVO) {
		// TODO Auto-generated method stub
		return productMapper.selectProductInfo(productVO);
	}

	@Override
	public int productInsert(ProductVO productVO) {
		// TODO Auto-generated method stub
		int result = productMapper.insertProductInfo(productVO);
		return result == 1 ? Integer.parseInt(productVO.getProductNumber()) : -1;
	}

	@Override
	public Map<String, Object> productUpdate(ProductVO productVO) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;

		int result = productMapper.updateProductInfo(productVO);

		if (result == 1) {
			isSuccessed = true;
		}

		map.put("result", isSuccessed);
		map.put("target", productVO);

		return map;
	}

	@Override
	public int productDelete(String productNumber) {
		// TODO Auto-generated method stub
		return productMapper.deleteProductInfo(productNumber);
	}

}
