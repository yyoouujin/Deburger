package com.deburger.app.shop.shoporder.mapper;

import java.util.List;

import com.deburger.app.shop.shoporder.service.ShopOrderVO;

public interface ShopOrderMapper {
		
		//전체 조회
		public List<ShopOrderVO> selectShopOrder();

}
