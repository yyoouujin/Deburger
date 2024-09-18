package com.deburger.app.office.product.mapper;

import java.util.List;

import com.deburger.app.office.product.service.ProductVO;

public interface ProductMapper {

	// 전체 조회
	public List<ProductVO> selectAllList(ProductVO productVO);

	// 단건 조회
	public List<ProductVO> selectProductInfo(ProductVO productVO);

	// 등록
	public int insertProductInfo(ProductVO productVO);

	// 수정
	public int updateProductInfo(ProductVO productVO);

	// 삭제
	public int deleteProductInfo(String productNumber);
}
