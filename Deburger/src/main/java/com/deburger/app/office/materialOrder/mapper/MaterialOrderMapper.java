package com.deburger.app.office.materialOrder.mapper;

import com.deburger.app.office.materialOrder.service.MaterialOrderVO;

public interface MaterialOrderMapper {
	
	/*
	// 물류 창고 폐기 처리
	public int containerOutInsert(ContainerVO containerVO);

	public int containerInupdate(ContainerVO containerVO);
	*/
	
	
	//물류창고 재료 발주
	public int insertLogisticOrder(MaterialOrderVO materialOrderVO);
	
	//물류창고 재료 발주 상세
	public int insertLogisticOrderDetail(MaterialOrderVO materialOrderVO);
	
	

}
