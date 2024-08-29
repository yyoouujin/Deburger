package com.deburger.app.office.product.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.deburger.app.office.product.mapper.ProductMapper;
import com.deburger.app.office.product.service.ProductService;
import com.deburger.app.office.product.service.ProductVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
	
	public ProductMapper productMapper;
	
	@Override
	public List<ProductVO> serviceAllList() {
		return productMapper.selectAllList();
	}

	
}
