package com.deburger.app.shop.productSale.mapper;

import java.util.List;

import com.deburger.app.shop.productSale.service.StoreSaleVO;

public interface StoreSaleMapper {	
	
	// 가맹점에서 판매하는 재품 리스트
	public List<StoreSaleVO> selectStoreSaleList();
	// 가맹점의 판매등록
	public int insertStoreSaleList(StoreSaleVO saleVO);
	// 가맹점 판매등록에따른 제고 변경 시퀀스
	public void insertStoreSaleProcedure(StoreSaleVO saleVO);
	// 가맹점 판매등록시 일시통일
	public StoreSaleVO selectStoreSaleDate();
	// 가맹점 등록시 매출통계 등록
	public int insertStoreSaleStatistics(StoreSaleVO saleVO);
	// 가맹점 등록시 매출통계 등록
	public int countStoreSale(StoreSaleVO saleVO);
	
}
