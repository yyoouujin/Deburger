package com.deburger.app.office.delivery.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.office.delivery.mapper.DeliveryMapper;
import com.deburger.app.office.delivery.service.DeliveryService;
import com.deburger.app.office.delivery.service.DeliveryVO;
import com.deburger.app.office.logistic.service.Criteria;

@Service
public class DeliveryServiceImpl implements DeliveryService {
	
	private DeliveryMapper deliveryMapper;
	
	@Autowired
	public DeliveryServiceImpl(DeliveryMapper deliveryMapper) {
		this.deliveryMapper = deliveryMapper;
	}
	
	
	@Override
	public List<DeliveryVO> deliveryList(Criteria criteria) {
		return deliveryMapper.selectDeliveryAll(criteria);
	}
	
	@Override
	public int getTotal() {
		return deliveryMapper.getTotal();
	}
	
	@Override
	public List<DeliveryVO> deliveryInfo(DeliveryVO deliveryVO) {
		return deliveryMapper.selectDeliveryInfo(deliveryVO);
	}
	
	@Override
	public int logisticAllStock(DeliveryVO deliveryVO) {
		Integer result = deliveryMapper.selectLogisticStock(deliveryVO);
		return result;
	}
	
	@Override
	public int orderAllStock(DeliveryVO deliveryVO) {
		return deliveryMapper.selectOrderStock(deliveryVO);
	}

	
	@Override
	public List<DeliveryVO> logisticsStockInfo(DeliveryVO deliveryVO) {
		return deliveryMapper.selectLogistics(deliveryVO);
	}
	
	@Override
	public Map<String, Object> updateOderapp(DeliveryVO deliveryVO) {
		
		Map<String, Object> map = new HashMap<>();
		
		boolean isSuccessed = false;
		int result = deliveryMapper.updateOderapp(deliveryVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", deliveryVO);
		
		return map;
		
	}
	
	
	@Override
	public Map<String, Object> updateCancelOperation(DeliveryVO deliveryVO) {
		
		Map<String, Object> map = new HashMap<>();
		
		boolean isSuccessed = false;
		int result = deliveryMapper.updateCancelOperation(deliveryVO);
		
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", deliveryVO);
		
		return map;
		
		
	}
	

}
