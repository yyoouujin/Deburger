package com.deburger.app.office.material.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
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

	// 재료 전체 페이지
	@GetMapping("materials")
	public String materialList(Model model) {
		List<MaterialVO> list = materialService.serviceAllList();
		model.addAttribute("materials", list);

		return "office/material/materials";
	}

	// 재료 상세 페이지
	@GetMapping("materialInfo")
	public String materialInfo(MaterialVO materialVO, Model model) {
		List<MaterialVO> list = materialService.materialInfo(materialVO);
		model.addAttribute("material", list);
		return "office/material/materialInfo";
	}

	// properties 처리 방식
	@Value("${file.upload.path}")
	private String uploadPath;

	// 파일 찾기
	@GetMapping("formUpload")
	public void formUploadPage() {
	}

	// 파일 업로드 형식
	@PostMapping("uploadForm")
	public String formUploadFile(@RequestPart MultipartFile[] files) { // MultipartFile[] input 에서 multiple 으로 처리 하면 배열로
																		// 넘어 오기에 배열 처리를 해줘야 된다
																		// client 가 보낸 data 처리
																		// multipartResolver 라은 Bean 이 있어야 한다
		log.info(uploadPath);
		for (MultipartFile file : files) {
			log.info(file.getContentType()); // 타입
			log.info(file.getOriginalFilename()); // 이름
			log.info(String.valueOf(file.getSize())); // 사이즈

			String fileName = file.getOriginalFilename();
			String saveName = uploadPath + File.separator + fileName; // 경로 작성

			log.debug("saveName :" + saveName);

			Path savePath = Paths.get(saveName); // Path 경로 처리

			try {
				file.transferTo(savePath); // 지정한 경로 이동 시키는 역할
			} catch (IOException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return "redirect:formUpload";
	}

}
