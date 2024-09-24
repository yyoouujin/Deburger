package com.deburger.app.office.delivery.service;

import java.util.List;
import java.util.Map;

import com.deburger.app.office.logistic.service.Criteria;

public interface DeliveryService {
	
	//가맹점 발주 전체조회
	//public List<DeliveryVO> deliveryList(DeliveryVO deliveryVO);
	
	//가맹점 발주 전체조회(페이징)
	public List<DeliveryVO> deliveryList(Criteria criteria);
	//발주건 총 갯수(페이징)
	public int getTotal();
	
	//가맹점 발주 상세조회
	public List<DeliveryVO> deliveryInfo(DeliveryVO deliveryVO);
	
	//주문번호의 담당 물류창고 전체재고
	public int logisticAllStock(DeliveryVO deliveryVO);
	
	//발주 전체수량
	public int orderAllStock(DeliveryVO deliveryVO);
	
	//창고선택
	public List<DeliveryVO> logisticsStockInfo(DeliveryVO deliveryVO);
	
	//발주상태 수정
	public Map<String, Object> updateOderapp(DeliveryVO deliveryVO);
	
	//취소상태 수정
	public Map<String, Object> updateCancelOperation(DeliveryVO deliveryVO);
	
}
