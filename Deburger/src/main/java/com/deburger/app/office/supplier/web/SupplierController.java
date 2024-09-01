package com.deburger.app.office.supplier.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.office.supplier.service.SupplierService;
import com.deburger.app.office.supplier.service.SupplierVO;

@Controller
public class SupplierController {
		
		private SupplierService supplierService;
		
		@Autowired
		public SupplierController(SupplierService supplierService) {
				this.supplierService = supplierService;
		}
		
		//전체조회 : URI - office/supplierList
		//				RETURN - 	office/supplier.html
		@GetMapping("supplierList")
		public String supplierList(Model model) {
				List<SupplierVO> list = supplierService.supplierList();
				model.addAttribute("suppliers", list);
				return "office/supplier/supplierList";
		}
		
		
		//단건조회 : URI - office/supplierInfo/PARAMETER(SupplierVO)
		//				RETURN - office/supplierInfo.html
		@GetMapping("office/supplierInfo")
		public String supplierInfo(SupplierVO supplierVO, Model model) {
				SupplierVO findVO = supplierService.supplierInfo(supplierVO);
				model.addAttribute("supplier", findVO);
				return "office/supplier/supplierInfo";
		}
		
		
		//등록페이지
		@GetMapping("supplierInsert")
		public String supplierInsertForm() {
				return "office/supplier/supplierInsert";
		}
		
		//등록저리 
		@PostMapping("supplierInsert")
		public String supplierInsertProcess(SupplierVO supplierVO) {
				
				//반환되는 값이 공급업체 아이디의 SUP0000001 중 0000001만 반환된다
				int cid = supplierService.insertSupplier(supplierVO);
				return "redirect:supplierInfo?clientId=SUP" + cid;
			
		}
		
		
		//수정페이지
		@GetMapping("office/supplierUpdate")
		public String supplierUpdateForm(SupplierVO supplierVO, Model model) {
				SupplierVO findVO = supplierService.supplierInfo(supplierVO);
				model.addAttribute("supplier", findVO);
				return "office/supplier/supplierUpdate";
		}
		
		//수정처리
		@PostMapping("office/supplierUpdate")
		@ResponseBody
		public Map<String, Object> supplierUpdateProcess(@RequestBody SupplierVO supplierVO) {
				return supplierService.updateSupplier(supplierVO);
		}
		
		
		//삭제
		@GetMapping("office/supplierDelete")
		public String supplierDelete(String clientId) {
				supplierService.deleteSupplier(clientId);
				return "redirect:office/supplierList";
		}
		
	
}
