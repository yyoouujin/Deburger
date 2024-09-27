package com.deburger.app.shop.shoporder.service;

import java.util.List;
import java.util.Map;

public interface ShopOrderService {
	


	//장바구니 전체 조회
	public List<ShopOrderVO> selectShopOrder();
	
	//발주 신청
	public int insertShopOrder(ShopOrderVO shopOrderVO);
	
	//발주 전체 조회
	public List<ShopOrderVO> ShopOrderList(ShopOrderVO shopOrderVO);
	

	

	//발주 취소 업데이트
	public int updateOrderCancel(ShopOrderVO shopOrderVO);
	
	//발주 상세 조회
	public List<ShopOrderVO> orderInfo(ShopOrderVO shopOrderVO);
	
	// Material 총 갯수
	public int OrdercountMaterial();
	
	//자동발주 상세조회
	public List<ShopOrderVO> autoOrderInfo(ShopOrderVO shopOrderVO);
	
	//자동발주 취소
	public int deleteAuto(String orderDetailsNumber);
	
	// autoMaterial 총 갯수
	public int AutoOrdercountMaterial();
	
	//조건 조회
	public List<ShopOrderVO> selectdate(ShopOrderVO shopOrderVO);

	//장바구니 삭제
	public int delMater(List<ShopOrderVO> shopOrderVO);	
	
}
