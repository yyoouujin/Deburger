package com.deburger.app.office.supplier.mapper;

import java.util.List;

import com.deburger.app.office.supplier.service.SupplierVO;

public interface SupplierMapper {
	
	//공급업체 전체조회
	public List<SupplierVO> selectSupplierAll();
	//공급업체 단건조회
	public SupplierVO selectSupplierInfo(SupplierVO supplierVO);
	//공급업체 등록
	public int insertSupplierInfo(SupplierVO supplierVO);
	//공급업체 수정
	public int updateSupplierInfo(SupplierVO supplierVO);
	//공급업체 삭제
	public int deleteSupplierInfo(String clientId);
	
	
}
