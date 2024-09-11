package com.deburger.app.shop.productSale.mapper;

import java.util.List;

import com.deburger.app.shop.productSale.service.StoreSaleVO;

public interface StoreSaleMapper {	
	public List<StoreSaleVO> selectStoreSaleList();
	public int insertStoreSaleList(StoreSaleVO saleVO);
}
