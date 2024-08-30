package com.deburger.app.office.yujin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.deburger.app.office.supplier.mapper.SupplierMapper;
import com.deburger.app.office.supplier.service.SupplierVO;

@SpringBootTest
public class DeburgerApplicationTestYujin {
		
		//공급업체 매퍼
		@Autowired
		SupplierMapper supplierMapper;
		
		//공급업체 전체조회
		//@Test
		void supplierList() {
				List<SupplierVO> list = supplierMapper.selectSupplierAll();
				assertTrue(!list.isEmpty());
				System.err.println(list);
		}
		
		//공급업체 단건조회
		//@Test
		void supplierInfo() {
				SupplierVO supplierVO = new SupplierVO();
				supplierVO.setClientId("SUP0000021");
				
				SupplierVO findVO = supplierMapper.selectSupplierInfo(supplierVO);
				assertEquals("퍼스트한돈 주식회사", findVO.getClientName());
				System.out.println("업체명 : " + findVO.getClientName());
		}
		
		//공급업체 등록
		//@Test
		void supplierInsert() {
				
				SupplierVO supplierVO = new SupplierVO();
				supplierVO.setBusinessnum("560-81-02630");
				supplierVO.setClientName("빵명장(주)");
				supplierVO.setRepresentativeName("이세군");
				supplierVO.setPostal(14261);
				supplierVO.setAddress("경기도 광명시 밤일로 38");
				supplierVO.setAddresssec("1층,3층(하안동)");
				
				int result = supplierMapper.insertSupplierInfo(supplierVO);
				System.out.println(supplierVO.getClientId());
				
				assertEquals(1, result);
				
		}
		
		//공급업체 수정
		//@Test
		void supplierUpdate() {
				
				SupplierVO supplierVO = new SupplierVO();
				supplierVO.setClientId("SUP0000022");
				
				SupplierVO findVO = supplierMapper.selectSupplierInfo(supplierVO);
				System.err.println(findVO);
				
				findVO.setClientName("(주)빵명장");
				
				int result = supplierMapper.updateSupplierInfo(findVO);
				
				assertEquals(1, result);
			
		}
		
		//공급업체 삭제
		//@Test
		void supplierDelete() {
				int result = supplierMapper.deleteSupplierInfo("SUP0000022");
				assertEquals(1, result);
		}
		
		
		
		

}
