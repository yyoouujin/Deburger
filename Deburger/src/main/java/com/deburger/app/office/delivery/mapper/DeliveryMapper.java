package com.deburger.app.office.delivery.mapper;

import java.util.List;

import com.deburger.app.office.delivery.service.DeliveryVO;

public interface DeliveryMapper {
	
	//가맹점 발주 전체조회
	public List<DeliveryVO> selectDeliveryAll();
	
	//가맹점 발주 상세 조회
	public List<DeliveryVO> selectDeliveryInfo(DeliveryVO deliveryVO);
	
	//창고 재고 전체조회
	public int selectLogisticStock(DeliveryVO deliveryVO);
	
	//발주 전체수량
	public int selectOrderStock(DeliveryVO deliveryVO);
	
	//창고선택
	public List<DeliveryVO> selectLogistics(DeliveryVO deliveryVO);
	
	//발주승인(oderapp : 'L1' -> 'L2')
	public int updateOderapp(DeliveryVO deliveryVO);
	
	//취소승인(cancel_operation : 'J2' -> 'J3'(취소승인) 또는 'J1'(취소거부 = 진행)
	public int updateCancelOperation(DeliveryVO deliveryVO);
	
}
