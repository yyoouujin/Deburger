package com.deburger.app.shop.shopmain.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.shop.shopmain.mapper.ShopMainMapper;
import com.deburger.app.shop.shopmain.service.ShopMainService;
import com.deburger.app.shop.shopmain.service.ShopMainVO;
import com.deburger.app.shop.stock.service.StockVO;

@Service
public class ShopMainServiceImpl implements ShopMainService {

	private ShopMainMapper shopMainMapper;
	
	@Autowired
	ShopMainServiceImpl(ShopMainMapper shopMainMapper){
		this.shopMainMapper = shopMainMapper;
	}
		
	
	//메인페이지 숫자 카운트
	@Override
	public List<ShopMainVO> listCount1() {
		// TODO Auto-generated method stub
		
		String mcode = SecurityUtil.memberCode();
		ShopMainVO shopMainVO = new ShopMainVO();
		shopMainVO.setStoreNumber(mcode);

		
		return shopMainMapper.listCount1(shopMainVO);
	}
	
	@Override
	public List<ShopMainVO> listCount2() {
		// TODO Auto-generated method stub
		
		String mcode = SecurityUtil.memberCode();
		ShopMainVO shopMainVO = new ShopMainVO();
		shopMainVO.setStoreNumber(mcode);

		
		return shopMainMapper.listCount2(shopMainVO);
	}
	
	@Override
	public List<ShopMainVO> listCount3() {
		// TODO Auto-generated method stub
		
		String mcode = SecurityUtil.memberCode();
		ShopMainVO shopMainVO = new ShopMainVO();
		shopMainVO.setStoreNumber(mcode);

		
		return shopMainMapper.listCount3(shopMainVO);
	}
		
	
	//매출액 그래프
	@Override
	public List<ShopMainVO> shopSellG(ShopMainVO shopMainVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		shopMainVO.setStoreNumber(mcode);
		return shopMainMapper.shopSellG(shopMainVO);
	}
	
	//매출 제품
	@Override
	public List<ShopMainVO> shopOrderG(ShopMainVO shopMainVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		shopMainVO.setStoreNumber(mcode);
		
		return shopMainMapper.shopOrderG(shopMainVO);
	}
	
	// 유통임박 재고 리스트
	@Override
	public List<ShopMainVO> limitList( ) {
		// TODO Auto-generated method stub
		
		ShopMainVO shopMainVO = new ShopMainVO();
		
		String mcode = SecurityUtil.memberCode();
		shopMainVO.setStoreNumber(mcode);
		return shopMainMapper.limitList(shopMainVO);
	}
	
	// 공지사항 최근 1개
	@Override
	public List<ShopMainVO> noticeList() {
		// TODO Auto-generated method stub
		return shopMainMapper.noticeList();
	}
}
