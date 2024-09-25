package com.deburger.app.office.material.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.deburger.app.office.material.service.MaterialService;
import com.deburger.app.office.material.service.MaterialVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class MaterialController {

	public MaterialService materialService;

	@Autowired
	MaterialController(MaterialService materialService) {
		this.materialService = materialService;
	}

	// application.properties 에서 불러와 필드에 담음
	@Value("${file.upload.path}")
	private String uploadPath;

	// 파일 찾기
	@GetMapping("formUpload")
	public void formUploadPage() {
	}

	private String setImagePath(String uploadFileName) {
		return uploadFileName.replace(File.separator, "/");
	}

	// 재료 전체 페이지
	@GetMapping("materials")
	public String materialList(MaterialVO materialVO, Model model,
			@RequestParam(value = "nowPage", required = false) String nowPage,
			@RequestParam(value = "cntPerPage", required = false) String cntPerPage) {
		int total = materialService.countMaterialService();
		if (nowPage == null && cntPerPage == null) {
			nowPage = "1";
			cntPerPage = "10";
		} else if (nowPage == null) {
			nowPage = "1";
		} else if (cntPerPage == null) {
			cntPerPage = "10";
		}
		materialVO = new MaterialVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		System.err.println(materialVO);
		model.addAttribute("paging", materialVO);
		model.addAttribute("viewAll", materialService.serviceAllList(materialVO));
		return "office/material/materials";
	}

	// 재료 상세 페이지
	@GetMapping("materialInfo")
	public String materialInfo(MaterialVO materialVO, Model model) {
		List<MaterialVO> list = materialService.materialInfo(materialVO);
		model.addAttribute("material", list);
		return "office/material/materialInfo";
	}

	// insert 보여주기
	@GetMapping("materialInsert")
	public String materialInsert(MaterialVO materialVO) {
		return "office/material/materialInsert";
	}

	// insert 처리
	@PostMapping("materialInserts")
	public String materialInsertProcess(MaterialVO materialVO, @RequestParam MultipartFile materialImage) {

		String fileName = materialImage.getOriginalFilename();
		System.out.println("fileName : " + fileName);

		// 날짜 폴더 생성
		String folderPath = makeFolder();
		// UUID 고유값을 보장함
		String uuid = UUID.randomUUID().toString();
		// 저장할 파일 이름 중간에 "_"를 이용하여 구분

		String uploadFileName = folderPath + File.separator + uuid + "_" + fileName;

		String saveName = uploadPath + File.separator + uploadFileName;

		Path savePath = Paths.get(saveName);
		// Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
		System.out.println("path : " + saveName);
		try {
			materialImage.transferTo(savePath);
			// uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
		} catch (IOException e) {
			e.printStackTrace();
		}

		materialVO.setImage(setImagePath(uploadFileName));
		materialService.insertMaterialService(materialVO);
		return "office/material/materialInsert";
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

}
