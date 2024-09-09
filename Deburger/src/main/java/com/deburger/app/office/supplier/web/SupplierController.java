package com.deburger.app.office.supplier.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.deburger.app.office.supplier.service.SupplierService;
import com.deburger.app.office.supplier.service.SupplierVO;

import groovy.util.logging.Slf4j;

@Slf4j
@Controller
public class SupplierController {
	
		private SupplierService supplierService;
		
		@Autowired
		public SupplierController(SupplierService supplierService) {
			this.supplierService = supplierService;
		}
		
		// application.properties 에서 불러와 필드에 담음
		@Value("${file.upload.path}")
		private String uploadPath;
		
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
		@GetMapping("supplierInfo")
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
		public String supplierInsertProcess(SupplierVO supplierVO, MultipartFile contractPdfFile) {
				
				String fileName = contractPdfFile.getOriginalFilename();
				System.out.println("fileName : " + fileName);
				
				//날짜 폴더 생성
				String folderPath = makeFolder();
				//UUID 고유값을 보장함
				String uuid = UUID.randomUUID().toString();
				//저장할 파일 이름 중간에 "_"를 이용하여 구분
				String uploadFileName = folderPath + File.separator + uuid + "_" + fileName;
				
				String saveName = uploadPath + File.separator + uploadFileName;
				
				Path savePath = Paths.get(saveName);
				//Paths.get()메서드는 특정 경로의 파일 정보를 가져옵니다 (경로 정의하기)
				
				try {
					contractPdfFile.transferTo(savePath);
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				supplierVO.setContractPdf(setImagePath(uploadFileName));
				
				
				//반환되는 값이 공급업체 아이디의 SUP0000001 중 0000001만 반환된다
				int cid = supplierService.insertSupplier(supplierVO);
				String strcid = String.format("%07d", cid);
				return "redirect:supplierInfo?clientId=SUP" + strcid;
				//return "office/supplier/supplierList";
		}

		
		private String makeFolder() {
				String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
				// LocalDate를 문자열로 포멧
				String folderPath = str.replace("/", File.separator);
				File uploadPathFoler = new File(uploadPath, folderPath);
				// File newFile= new File(dir,"파일명");
				if (uploadPathFoler.exists() == false) {
					uploadPathFoler.mkdirs();
					// 만약 uploadPathFolder가 존재하지않는다면 makeDirectory하라는 의미입니다.
					// mkdir(): 디렉토리에 상위 디렉토리가 존재하지 않을경우에는 생성이 불가능한 함수
					// mkdirs(): 디렉토리의 상위 디렉토리가 존재하지 않을 경우에는 상위 디렉토리까지 모두 생성하는 함수
				}
				return folderPath;
		}
		
		private String setImagePath(String uploadFileName) {
				return uploadFileName.replace(File.separator, "/");
		}

		//수정페이지
		@GetMapping("supplierUpdate")
		public String supplierUpdateForm(SupplierVO supplierVO, Model model) {
				SupplierVO findVO = supplierService.supplierInfo(supplierVO);
				model.addAttribute("supplier", findVO);
				return "office/supplier/supplierUpdate";
		}
		
		//수정처리
		@PostMapping("supplierUpdate")
		public String supplierUpdateProcess(SupplierVO supplierVO) {
				supplierService.updateSupplier(supplierVO);
				return "redirect:supplierList";
		}
		
		
		//삭제
		@GetMapping("supplierDelete")
		public String supplierDelete(String clientId) {
				supplierService.deleteSupplier(clientId);
				return "redirect:supplierList";
		}
		
	
}
