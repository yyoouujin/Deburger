package com.deburger.app.shop.shoporder.mapper;

import java.util.List;

import com.deburger.app.shop.shoporder.service.ShopOrderVO;

public interface ShopOrderMapper {
		
		//전체 조회
		public List<ShopOrderVO> selectShopOrder();
		
		//발주 신청
		public int insertShopOrder(ShopOrderVO shopOrderVO);
		
		//발주 상세
		public int dinsertShopOrder(ShopOrderVO shopOrderVO);

		//장바구니 삭제
		public int deleteOrderCart(ShopOrderVO shopOrderVO);
}
