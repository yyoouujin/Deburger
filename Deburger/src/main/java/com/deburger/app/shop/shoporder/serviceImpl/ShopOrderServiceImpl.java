package com.deburger.app.shop.shoporder.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.deburger.app.main.login.config.SecurityUtil;
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
		String mcode = SecurityUtil.memberCode();
		ShopOrderVO shopOrderVO = new ShopOrderVO();
		shopOrderVO.setStoreNumber(mcode);

		return shopOrderMapper.selectShopOrder(shopOrderVO);
	}

	// 발주
	@Override
	@Transactional
	public int insertShopOrder(ShopOrderVO shopOrderVO) {
		
		String mcode = SecurityUtil.memberCode();
		shopOrderVO.setStoreNumber(mcode);
		

			String imlog = shopOrderMapper.storelog(shopOrderVO);
			shopOrderVO.setLogisticsId(imlog);
			
			shopOrderMapper.insertShopOrder(shopOrderVO);

			for (ShopOrderDetailsVO devo : shopOrderVO.getDetList()) {
				devo.setOrderNumber(shopOrderVO.getOrderNumber());
				shopOrderMapper.dinsertShopOrder(devo);
			}
			
			
			for (ShopOrderCartVO shvo : shopOrderVO.getCartList()) {
				shvo.setStoreNumber(mcode);
				shopOrderMapper.deleteOrderCart(shvo);
			}
		
		
		return 1;

	}

	// 발주 리스트
	@Override
	public List<ShopOrderVO> ShopOrderList(ShopOrderVO shopOrderVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		shopOrderVO.setStoreNumber(mcode);
		return shopOrderMapper.ShopOrderList(shopOrderVO);
	}
	
	@Override
	public int OrdercountMaterial() {
		// TODO Auto-generated method stub
		return shopOrderMapper.OrdercountMaterial();
	}

	// 발주 취소 설정
	@Override
	public int updateOrderCancel(ShopOrderVO shopOrderVO) {
		// TODO Auto-generated method stub

		shopOrderMapper.updateOrderCancel(shopOrderVO);
		return 1;
	}

	// 발주 상세 조회
	@Override
	public List<ShopOrderVO> orderInfo(ShopOrderVO shopOrderVO) {
		// TODO Auto-generated method stub
		return shopOrderMapper.orderInfo(shopOrderVO);
	}

	// 자동 발주 조회
	@Override
	public List<ShopOrderVO> autoOrderInfo(ShopOrderVO shopOrderVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		shopOrderVO.setStoreNumber(mcode);
		return shopOrderMapper.autoOrderInfo(shopOrderVO);
	}
	
	//삭제
	@Override
	public int deleteAuto(String orderDetailsNumber) {
		// TODO Auto-generated method stub
		return shopOrderMapper.deleteAuto(orderDetailsNumber);
	}
	
	@Override
	public int AutoOrdercountMaterial() {
		// TODO Auto-generated method stub
		shopOrderMapper.Alldel();
		return shopOrderMapper.AutoOrdercountMaterial();
	}
	
	@Override
	public List<ShopOrderVO> selectdate(ShopOrderVO shopOrderVO) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		shopOrderVO.setStoreNumber(mcode);
		
		return shopOrderMapper.selectdate(shopOrderVO);

	}
	
	@Override
	public int delMater(List<ShopOrderVO> list) {
		// TODO Auto-generated method stub
		String mcode = SecurityUtil.memberCode();
		
		for(ShopOrderVO soVO : list) {			
			soVO.setStoreNumber(mcode);
			shopOrderMapper.delMater(soVO);
		}		
		
		return 1;
	}
}
