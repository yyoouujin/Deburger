package com.deburger.app.shop.shoporder.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.deburger.app.shop.shoporder.mapper.ShopOrderMapper;
import com.deburger.app.shop.shoporder.service.ShopOrderCartVO;
import com.deburger.app.shop.shoporder.service.ShopOrderDetailsVO;
import com.deburger.app.shop.shoporder.service.ShopOrderService;
import com.deburger.app.shop.shoporder.service.ShopOrderVO;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

	private ShopOrderMapper shopOrderMapper;

	@Autowired
	ShopOrderServiceImpl(ShopOrderMapper shopOrderMapper) {
		this.shopOrderMapper = shopOrderMapper;
	}

	// 전체조회
	@Override
	public List<ShopOrderVO> selectShopOrder() {
		// TODO Auto-generated method stub
		return shopOrderMapper.selectShopOrder();
	}

@Override
@Transactional
	public int insertShopOrder (ShopOrderVO shopOrderVO) {
	    
	
	   shopOrderMapper.insertShopOrder(shopOrderVO);
	   
	   for(ShopOrderDetailsVO devo : shopOrderVO.getDetList()) {
		   shopOrderMapper.dinsertShopOrder(devo);
	   }
	   for(ShopOrderCartVO shvo : shopOrderVO.getCartList()) {
		   shopOrderMapper.deleteOrderCart(shvo);
	   }
	   return 1;
		
	}

}
