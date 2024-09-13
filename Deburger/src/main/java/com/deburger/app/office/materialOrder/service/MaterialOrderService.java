package com.deburger.app.office.materialOrder.service;

import java.util.List;

import com.deburger.app.office.logistic.service.LogisticVO;
import com.deburger.app.office.supplier.service.SupplierVO;

public interface MaterialOrderService {
	
	//물류창고 발주 -> 발주상세
	public int supplyOrder(MaterialOrderVO materialOrderVO);
		
	
	// 업체조회
	public List<SupplierVO> selectSupplierList();
	// 물류창고 조회
	public List<LogisticVO> selectLogisticsList();
	// 업체별 제료 목록
	public List<MaterialOrderVO> selectSupplierListOptions(MaterialOrderVO meteMaterialOrderVO);
}


/*
	// 물류 창고 폐기 처리
	public int disposeItem(ContainerVO containerVO);
	 * 
*/
