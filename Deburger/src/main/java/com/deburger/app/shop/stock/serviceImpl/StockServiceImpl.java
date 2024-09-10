package com.deburger.app.shop.stock.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	// 전체 조회
	@Override
	public List<StockVO> selectStock() {
		// TODO Auto-generated method stub
		return stockMapper.selectStock();
	}

	// 장바구니 저장
	@Override
	public int insertCart(StockVO stockVO) {
		// TODO Auto-generated method stub

		int result = stockMapper.insertCart(stockVO);

		return result == 1 ? 1 : -1;
	}

	// 상세조회
	@Override
	public List<StockVO> selectStockinfo(StockVO stockVO) {
		// TODO Auto-generated method stub
		return stockMapper.selectStockinfo(stockVO);
	}

	@Override
	@Transactional
	public int updqtestoreStock(StockVO stockVO) {
		// TODO Auto-generated method stub
		
		stockMapper.updqtestoreIn(stockVO);
		stockMapper.updqtestoreStock(stockVO);
		stockMapper.insertstoreProductSale(stockVO);
		return 1;
	}

}
