package com.deburger.app.office.materialOrder.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.office.logistic.service.LogisticVO;
import com.deburger.app.office.materialOrder.mapper.MaterialOrderMapper;
import com.deburger.app.office.materialOrder.service.MaterialOrderService;
import com.deburger.app.office.materialOrder.service.MaterialOrderVO;
import com.deburger.app.office.supplier.service.SupplierVO;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MaterialOrderServiceImpl implements MaterialOrderService {
	
	private MaterialOrderMapper materialOrderMapper;
	
	//물류창고 발주 -> 발주상세
	@Override
	@Transactional
	public int supplyOrder(MaterialOrderVO materialOrderVO) {
		materialOrderMapper.insertLogisticOrder(materialOrderVO);
		return materialOrderMapper.insertLogisticOrderDetail(materialOrderVO);
	}

	@Override
	public List<SupplierVO> selectSupplierList() {
		// TODO Auto-generated method stub
		return materialOrderMapper.selectSupplierList();
	}

	@Override
	public List<LogisticVO> selectLogisticsList() {
		// TODO Auto-generated method stub
		return materialOrderMapper.selectLogisticsList();
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
