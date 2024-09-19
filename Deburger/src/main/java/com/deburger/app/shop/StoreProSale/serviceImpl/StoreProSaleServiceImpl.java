package com.deburger.app.shop.StoreProSale.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.shop.StoreProSale.mapper.StoreProSaleMapper;
import com.deburger.app.shop.StoreProSale.service.StoreProSaleService;
import com.deburger.app.shop.StoreProSale.service.StoreProSaleVO;

@Service
public class StoreProSaleServiceImpl implements StoreProSaleService {

	private StoreProSaleMapper storeProSaleMapper;

	@Autowired
	StoreProSaleServiceImpl(StoreProSaleMapper storeProSaleMapper) {
		this.storeProSaleMapper = storeProSaleMapper;
	}

	@Override
	public List<StoreProSaleVO> StoreProSaleList() {
		// TODO Auto-generated method stub

		String mcode = SecurityUtil.memberCode();
		StoreProSaleVO storeProSaleVO = new StoreProSaleVO();
		storeProSaleVO.setStoreNumber(mcode);

		return storeProSaleMapper.StoreProSaleList(storeProSaleVO);
	}

	@Override
	public List<StoreProSaleVO> StoreProSaleoneList(StoreProSaleVO storeProSaleVO) {
		// TODO Auto-generated method stub

		String mcode = SecurityUtil.memberCode();
		storeProSaleVO.setStoreNumber(mcode);
		
		return storeProSaleMapper.StoreProSaleoneList(storeProSaleVO);
	}
	
	@Override
	public List<StoreProSaleVO> stockClassification() {
		// TODO Auto-generated method stub
		return storeProSaleMapper.stockClassification();
	}
	
	@Override
	public List<StoreProSaleVO> classificationListpro(StoreProSaleVO storeProSaleVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		storeProSaleVO.setStoreNumber(mcode);
		
		return storeProSaleMapper.classificationListpro(storeProSaleVO);
	}
}
