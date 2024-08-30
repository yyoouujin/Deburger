package com.deburger.app.office.supplier.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

public interface SupplierService {
		
		//공급업체 전체조회
		public List<SupplierVO> supplierList();
		//공급업체 단건조회
		public SupplierVO supplierInfo(SupplierVO supplierVO);
		//공급업체 등록
		public int insertSupplier(SupplierVO supplierVO);
		//공급업체 수정
		public Map<String, Object> updateSupplier(SupplierVO supplierVO);
		//공급업체 삭제
		public int deleteSupplier(String clientId);

}
