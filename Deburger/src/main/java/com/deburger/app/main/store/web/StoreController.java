package com.deburger.app.main.store.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.deburger.app.main.login.service.LoginService;
import com.deburger.app.main.login.service.UserVO;
import com.deburger.app.main.store.service.StoreService;
import com.deburger.app.main.store.service.StoreVO;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StoreController {

	private StoreService storeService;
	

	@Autowired
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}

	// application.properties 에서 불러와 필드에 담음
	@Value("${file.upload.path}")
	private String uploadPath;

	// 가맹점 등록
	@GetMapping("insertStore")
	public String officeMain() {
		return "main/store/insertStore";
	}

	@GetMapping("upload")
	public void uploadPage() {
	}

	// 가맹점 등록 post
	@PostMapping("insertStore")
	public String postMethodName(StoreVO storeVO, MultipartFile contractImageFile,
			MultipartFile businessLicenseImageFile) {

		String fileName = contractImageFile.getOriginalFilename();
//        String fileName = originalName.substring(originalName.lastIndexOf("//")+1);

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
			contractImageFile.transferTo(savePath);
			// uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
		} catch (IOException e) {
			e.printStackTrace();
		}
		// DB에 해당 경로 저장
		// 1) 사용자가 업로드할 때 사용한 파일명
		// 2) 실제 서버에 업로드할 때 사용한 경로
		storeVO.setContractImage(setImagePath(uploadFileName));

		
		String fileName2 = businessLicenseImageFile.getOriginalFilename();
//      String fileName = originalName.substring(originalName.lastIndexOf("//")+1);

		System.out.println("fileName : " + fileName2);

		// 날짜 폴더 생성
		String folderPath2 = makeFolder();
		// UUID 고유값을 보장함
		String uuid2 = UUID.randomUUID().toString();
		// 저장할 파일 이름 중간에 "_"를 이용하여 구분

		String uploadFileName2 = folderPath2 + File.separator + uuid2 + "_" + fileName2;

		String saveName2 = uploadPath + File.separator + uploadFileName2;

		Path savePath2 = Paths.get(saveName2);
		// Paths.get() 메서드는 특정 경로의 파일 정보를 가져옵니다.(경로 정의하기)
		System.out.println("path : " + saveName2);
		try {
			businessLicenseImageFile.transferTo(savePath2);
			// uploadFile에 파일을 업로드 하는 메서드 transferTo(file)
		} catch (IOException e) {
			e.printStackTrace();
		}
		// DB에 해당 경로 저장
		// 1) 사용자가 업로드할 때 사용한 파일명
		// 2) 실제 서버에 업로드할 때 사용한 경로
		storeVO.setBusinessLicenseImage(setImagePath(uploadFileName2));
		
		UserVO userVO = new UserVO();
		userVO.setId("frc" + storeVO.getBusinessRegistrationNumber());
		userVO.setPassword(storeVO.getPhone());
		userVO.setAuthority("4");
		userVO.setPasswordChangeOpertation("N");

		storeService.insertStore(storeVO, userVO);

		return "main/store/insertStore";
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

	// 가맹점 목록
	@GetMapping("officeListStore")
	public String listStore() {
		return "main/store/officeListStore";
	}

	// 가맹점 현황
	@GetMapping("StoreStatistics")
	public String StoreStatistics() {
		return "main/store/StoreStatistics";
	}

}
