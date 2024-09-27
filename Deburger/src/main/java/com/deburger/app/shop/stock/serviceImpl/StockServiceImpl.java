package com.deburger.app.shop.stock.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.office.logistic.mapper.LogisticMapper;
import com.deburger.app.shop.stock.mapper.StockMapper;
import com.deburger.app.shop.stock.service.StockService;
import com.deburger.app.shop.stock.service.StockVO;

@Service
public class StockServiceImpl implements StockService {

	private StockMapper stockMapper;

	@Autowired
	StockServiceImpl(StockMapper stockMapper) {
		this.stockMapper = stockMapper;
	}

	@Override
	public int shopcountMaterial() {
		// TODO Auto-generated method stub
		return stockMapper.shopcountMaterial();
	}

	// 전체 조회
	@Override
	public List<StockVO> selectStock(StockVO stockVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		stockVO.setStoreNumber(mcode);
		return stockMapper.selectStock(stockVO);
	}

	// 장바구니 저장
	@Override
	public int insertCart(StockVO stockVO) {
		// TODO Auto-generated method stub

		String mcode = SecurityUtil.memberCode();
		stockVO.setStoreNumber(mcode);
		int result = 0;
		if(stockMapper.countCart(stockVO) == 0) {
			result = stockMapper.insertCart(stockVO);
		}
		

		return result == 1 ? 1 : -1;
	}

	// 상세조회
	@Override
	public List<StockVO> selectStockinfo(StockVO stockVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		stockVO.setStoreNumber(mcode);
		return stockMapper.selectStockinfo(stockVO);
	}

	@Override
	@Transactional
	public int updqtestoreStock(StockVO stockVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		stockVO.setStoreNumber(mcode);

		stockMapper.updqtestoreIn(stockVO);
		stockMapper.updqtestoreStock(stockVO);
		stockMapper.insertstoreProductSale(stockVO);
		return 1;
	}

	@Override
	public List<StockVO> stockClassification() {
		// TODO Auto-generated method stub
		return stockMapper.stockClassification();
	}

	@Override
	public List<StockVO> classificationList(StockVO stockVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		stockVO.setStoreNumber(mcode);
		return stockMapper.classificationList(stockVO);
	}
	
	@Override
	public int shopinfo(StockVO stockVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		stockVO.setStoreNumber(mcode);
		return stockMapper.shopinfo(stockVO);
	}
}
