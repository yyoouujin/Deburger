package com.deburger.app.shop.shoporder.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.shop.shoporder.mapper.ShopOrderMapper;
import com.deburger.app.shop.shoporder.service.ShopOrderService;
import com.deburger.app.shop.shoporder.service.ShopOrderVO;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {
	
	private ShopOrderMapper shopOrderMapper; 
	
	@Autowired
	ShopOrderServiceImpl(ShopOrderMapper shopOrderMapper){
		this.shopOrderMapper = shopOrderMapper;
	}
	
	//전체조회
	@Override
	public List<ShopOrderVO> selectShopOrder() {
		// TODO Auto-generated method stub
		return shopOrderMapper.selectShopOrder();
	}

}
