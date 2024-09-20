package com.deburger.app.office.materialOrder.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.office.logistic.service.LogisticVO;
import com.deburger.app.office.materialOrder.mapper.MaterialOrderMapper;
import com.deburger.app.office.materialOrder.service.MaterialOrderListVO;
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

	@Override
	public List<MaterialOrderVO> selectSupplierListOptions(MaterialOrderVO meteMaterialOrderVO) {
		// TODO Auto-generated method stub
		return materialOrderMapper.selectSupplierListOptions(meteMaterialOrderVO);
	}

	//물류창고 발주 , 상세 발주
	@Override
	@Transactional
	public int insertLogisticOrder(MaterialOrderListVO materialOrderListVO) {
		int cnt=0;
		String mcode = SecurityUtil.memberCode();
		//발주 등록
		materialOrderMapper.insertLogisticOrder(materialOrderListVO.getMaterialOrder());	
		
		// 상세발주 등록
		for(MaterialOrderVO materialOrderVO : materialOrderListVO.getMaterialOrderList()) {
			materialOrderVO.setOrderNumber(materialOrderListVO.getMaterialOrder().getOrderNumber());
			materialOrderVO.setPersonId(mcode);
			materialOrderMapper.insertLogisticOrderDetail(materialOrderVO );
			cnt++;
		}
		return cnt;
	}

	@Override
	public List<MaterialOrderVO> selectMaterialOrder() {
		// TODO Auto-generated method stub
		return materialOrderMapper.selectMaterialOrder();
	}

	@Override
	public List<MaterialOrderVO> selectMaterialOrderInfo(MaterialOrderVO meteMaterialOrderVO) {
		// TODO Auto-generated method stub
		return materialOrderMapper.selectMaterialOrderInfo(meteMaterialOrderVO);
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
