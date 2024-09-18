package com.deburger.app.office.product.service;

import java.util.List;
import java.util.Map;

public interface ProductService {

	public List<ProductVO> serviceAllList(ProductVO productVO);

	public List<ProductVO> productInfo(ProductVO productVO);

	public int productInsert(ProductVO productVO);

	public Map<String, Object> productUpdate(ProductVO productVO);

	public int productDelete(String productNumber);
}
