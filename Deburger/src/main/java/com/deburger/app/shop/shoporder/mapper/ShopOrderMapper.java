package com.deburger.app.shop.shoporder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.deburger.app.shop.shoporder.service.ShopOrderCartVO;
import com.deburger.app.shop.shoporder.service.ShopOrderDetailsVO;
import com.deburger.app.shop.shoporder.service.ShopOrderVO;

public interface ShopOrderMapper {

	// 조회
	public String storelog(ShopOrderVO shopOrderVO);

	// 장바구니 전체 조회
	public List<ShopOrderVO> selectShopOrder(ShopOrderVO shopOrderVO);

	// 발주 신청
	public int insertShopOrder(ShopOrderVO shopOrderVO);

	// 발주 상세
	public int dinsertShopOrder(ShopOrderDetailsVO ShopOrderDetailsVO);

	// 장바구니 삭제
	public int deleteOrderCart(ShopOrderCartVO ShopOrderCartVO);

	// 발주 전체 조회
	public List<ShopOrderVO> ShopOrderList(ShopOrderVO shopOrderVO);

	// Material 총 갯수
	public int OrdercountMaterial();

	// 발주 취소 저장
	public int updateOrderCancel(ShopOrderVO shopOrderVO);

	// 발주 상세 조회
	public List<ShopOrderVO> orderInfo(ShopOrderVO shopOrderVO);

	// 자동발주 상세조회
	public List<ShopOrderVO> autoOrderInfo(ShopOrderVO shopOrderVO);

	// 자동발주 취소
	public int deleteAuto(String orderDetailsNumber);

	// autoMaterial 총 갯수
	public int AutoOrdercountMaterial();
	
	// 자동 발주시 details 모든 내용 삭제시 store_order 삭제
	public int Alldel();
	
	//조건 조회
	public List<ShopOrderVO> selectdate(ShopOrderVO shopOrderVO);
	
	//장바구니 삭제
	public int delMater(ShopOrderVO shopOrderVO);	
	

	
}
