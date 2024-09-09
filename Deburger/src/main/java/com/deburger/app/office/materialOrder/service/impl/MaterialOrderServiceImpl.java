package com.deburger.app.office.materialOrder.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.office.materialOrder.mapper.MaterialOrderMapper;
import com.deburger.app.office.materialOrder.service.MaterialOrderService;
import com.deburger.app.office.materialOrder.service.MaterialOrderVO;

@Service
public class MaterialOrderServiceImpl implements MaterialOrderService {
	
	private MaterialOrderMapper materialOrderMapper;
	
	//물류창고 발주 -> 발주상세
	@Override
	@Transactional
	public int supplyOrder(MaterialOrderVO materialOrderVO) {
		materialOrderMapper.insertLogisticOrder(materialOrderVO);
		return materialOrderMapper.insertLogisticOrderDetail(materialOrderVO);
	}

}

/*

// 물류 창고 폐기 처리
	@Override
	@Transactional
	public int disposeItem(ContainerVO containerVO) {
		containerMapper.containerInupdate(containerVO);
		return containerMapper.containerOutInsert(containerVO);
	}
*/
