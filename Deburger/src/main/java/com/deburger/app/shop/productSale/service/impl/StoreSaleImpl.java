package com.deburger.app.shop.productSale.service.impl;


import java.util.List;

import org.springframework.stereotype.Service;

import com.deburger.app.shop.productSale.mapper.StoreSaleMapper;
import com.deburger.app.shop.productSale.service.StoreSaleService;
import com.deburger.app.shop.productSale.service.StoreSaleVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StoreSaleImpl implements StoreSaleService{
	
	private StoreSaleMapper storeSaleMapper;

	@Override
	public List<StoreSaleVO> selectStoreSaleList() {
		// TODO Auto-generated method stub
		return storeSaleMapper.selectStoreSaleList();
	}

	@Override
	public int insertStoreSaleList(StoreSaleVO saleVO) {
		// TODO Auto-generated method stub
		return storeSaleMapper.insertStoreSaleList(saleVO);
	}

	@Override
	public void insertStoreSaleProcedure(StoreSaleVO saleVO) {
		storeSaleMapper.insertStoreSaleProcedure(saleVO);
		
	}

	@Override
	public StoreSaleVO selectStoreSaleDate() {
		// TODO Auto-generated method stub
		return storeSaleMapper.selectStoreSaleDate();
	}

	@Override
	public int insertStoreSaleStatistics(StoreSaleVO saleVO) {
		// TODO Auto-generated method stub
		return storeSaleMapper.insertStoreSaleStatistics(saleVO);
	}

	@Override
	public int countStoreSale(StoreSaleVO saleVO) {
		// TODO Auto-generated method stub
		return storeSaleMapper.countStoreSale(saleVO);
	}
	
	
		
	

	

}
