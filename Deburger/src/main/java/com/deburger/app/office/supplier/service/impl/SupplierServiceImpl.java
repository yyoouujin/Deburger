package com.deburger.app.office.supplier.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.deburger.app.office.supplier.mapper.SupplierMapper;
import com.deburger.app.office.supplier.service.SupplierService;
import com.deburger.app.office.supplier.service.SupplierVO;

@Service
public class SupplierServiceImpl implements SupplierService {

		private SupplierMapper supplierMapper;
		
		
		@Autowired
		public SupplierServiceImpl(SupplierMapper supplierMapper) {
				this.supplierMapper = supplierMapper;
		}
		
		
		@Override
		public List<SupplierVO> supplierList() {
				return supplierMapper.selectSupplierAll();
		}
	
		@Override
		public SupplierVO supplierInfo(SupplierVO supplierVO) {
				return supplierMapper.selectSupplierInfo(supplierVO);
		}
	
		@Override
		public int insertSupplier(SupplierVO supplierVO) {
				int result = supplierMapper.insertSupplierInfo(supplierVO);
				return result == 1 ? Integer.parseInt(supplierVO.getClientId().substring(3)) : -1;
				//거래처 아이디 SUP0000001 중 0000001 만 반환
				//return result;
		}
	
		@Override
		public Map<String, Object> updateSupplier(SupplierVO supplierVO) {
				Map<String, Object> map = new HashMap<>();
				
				boolean isSuccessed = false;
				int result = supplierMapper.updateSupplierInfo(supplierVO);
				
				
				if (result == 1) {
						isSuccessed = true;
				}
				
				map.put("result", isSuccessed);
				map.put("target", supplierVO);
				
				return map;
				
		}
	
		
		@Override
		public int deleteSupplier(String clientId) {
				return supplierMapper.deleteSupplierInfo(clientId);
		}
		
}
