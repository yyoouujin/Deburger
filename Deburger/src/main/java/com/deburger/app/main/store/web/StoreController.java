package com.deburger.app.main.store.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

import javax.print.attribute.Size2DSyntax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.main.login.service.UserVO;
import com.deburger.app.main.store.service.StoreSalesVO;
import com.deburger.app.main.store.service.StoreService;
import com.deburger.app.main.store.service.StoreVO;
import com.deburger.app.office.container.service.ContainerService;
import com.deburger.app.office.container.service.ContainerVO;
import com.deburger.app.office.logistic.service.LogisticService;
import com.deburger.app.office.logistic.service.LogisticVO;
import com.deburger.app.shop.notice.service.NoticeService;
import com.deburger.app.shop.notice.service.NoticeVO;
import com.deburger.app.shop.productSale.service.StoreSaleVO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class StoreController {

	private StoreService storeService;
	private NoticeService noticeService;
	private ContainerService containerService;
	private LogisticService logisticService;
	

	@Autowired
	public StoreController(StoreService storeService, NoticeService noticeService, ContainerService containerService, LogisticService logisticService) {
		this.storeService = storeService;
		this.noticeService = noticeService;
		this.containerService = containerService;
		this.logisticService = logisticService;
	}

	// application.properties 에서 불러와 필드에 담음
	@Value("${file.upload.path}")
	private String uploadPath;

	// 가맹점 등록
	@GetMapping("insertStore")
	public String officeMain(Model model) {
		StoreVO storeVO = storeService.selectStoreNumber();
		model.addAttribute("storeNumber", storeVO);
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
		userVO.setPassword(storeVO.getPhone());
		userVO.setAuthority("4");
		userVO.setPasswordChangeOpertation("N");
		
		storeService.insertStore(storeVO, userVO);

		return "redirect:officeListStore";
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
	public String listStore(Model model) {
		List<StoreVO> list = storeService.selectStoreList();		
		model.addAttribute("StoreList", list);
		return "main/store/officeListStore";
	}
	
	// 가맹점 상제 정보
	@GetMapping("officeStoreInfo")
	public String officeStoreInfo(String storeNumber) {
		return "main/store/officeStoreInfo";
	}
	
	// 가맹점 현황
	@GetMapping("storeStatistics")
	public String StoreStatistics(Model model) {
		
		String mcode = SecurityUtil.memberCode();
		ContainerVO cvo = new ContainerVO();
		cvo.setPersonId(mcode);
		
		List<NoticeVO> list = noticeService.noticeListShopList();
		List<StoreSalesVO>  StoreSales = storeService.selectStoreSalesMonth();
		List<StoreSalesVO>  StoreProduct = storeService.selectStoreProductMonth();
		List<StoreSalesVO>  StoreOrder = storeService.selectStoreOrderMonth();
		List<ContainerVO> In = containerService.countInsertList(cvo);
		int countIn = In.size();
		List<ContainerVO> out = containerService.containerOutAllList(cvo);
		int countOut = out.size();
		LogisticVO lvo = new LogisticVO();
		lvo.setPersonId(mcode);
		
		StoreVO svo = storeService.selectLogisticsId(mcode);
		lvo.setLogisticsId(svo.getLogisticsId());
		
		List<LogisticVO> order = logisticService.selectRequireStock(lvo);
		int countorder = order.size();
		
    	model.addAttribute("notices", list);
    	//월별 가맹점 매출
    	model.addAttribute("StoreSales", StoreSales);
    	//전체메뉴 월별 판매량
    	model.addAttribute("StoreProduct", StoreProduct);
    	//월별 발주 원가
    	model.addAttribute("StoreOrder", StoreOrder);
    	//입고대기 건수
    	model.addAttribute("countIn", countIn);
    	//출고대기 건수
    	model.addAttribute("countOut", countOut);
    	//발주대기 건수
    	model.addAttribute("countOrder", countorder);
    	//발주대기 건수
    	model.addAttribute("logisticsId", svo.getLogisticsId());
    	
		return "main/store/storeStatistics";
	}
	

}
