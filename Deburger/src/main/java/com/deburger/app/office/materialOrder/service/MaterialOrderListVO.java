package com.deburger.app.office.materialOrder.service;


import java.util.List;

import lombok.Data;

@Data
public class MaterialOrderListVO {
	
	private MaterialOrderVO materialOrder;
	private List<MaterialOrderVO> materialOrderList; 
		
	
}
