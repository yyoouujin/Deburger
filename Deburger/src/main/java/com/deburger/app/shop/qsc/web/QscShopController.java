package com.deburger.app.shop.qsc.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.shop.qsc.service.QscListVO;
import com.deburger.app.shop.qsc.service.QscResultVO;
import com.deburger.app.shop.qsc.service.QscService;
import com.deburger.app.shop.qsc.service.QscVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class QscShopController {
	
	private QscService qscService;
	

	// 가맹점
	//QSC전체조회(희창)
	@GetMapping("qscListShop")
	public String qsclist(Model model) {
		String storeNo = "FRC0000001";
		QscResultVO qscResultVO = new QscResultVO();
		qscResultVO.setStoreNumber(storeNo);
		
		List<QscResultVO> list =  qscService.selectQscListShop(qscResultVO);
		model.addAttribute("QscList", list);
		return "shop/qscListShop";
	}
	
	//QSC상세조회(희창)
	@GetMapping("qscListInfoShop")
	public String qscListInfo(Model model) {
		List<QscVO> list =  qscService.selectQscListRecent();
		for(QscVO qscVO : list) {
			qscVO.setScore(1);			
		}
		model.addAttribute("QscList", list);
		return "shop/qscListInfoShop";
	}
	
	//QSC 작성(희창)
	@PostMapping("qscListInfoShop")
	@ResponseBody
	public String qscListInfoInsert(@RequestBody QscListVO qscListVO) {
		qscService.insertQscDetails(qscListVO.getQscDataList(), qscListVO.getScores());		
		return "qscListShop";
	}
	
	
	
	// 본점
	//QSC항목 작성(희창)
	@GetMapping("qscInsertOffice")
	public String qscInsertOffice(Model model) {
		List<QscVO> list =  qscService.selectQscListRecent();
		model.addAttribute("QscList", list);
		return "office/qscInsertOffice";
	}
	// QSC항목 작성 입력(희창)
	@PostMapping("qscInsertOffice")
	@ResponseBody
	public int qscInsertOfficePost(@RequestBody List<QscVO>  qscVO) {
		int cnt = 0;
		int version = qscService.cntQscListRecent();
		for(QscVO qscs : qscVO) {
			qscs.setVersionInformation( Integer.toString(version));
			qscService.insertQscListRecent(qscs);
			cnt++;
		}
		return cnt;
	}
	
	
	
	//QSC결과 전체 조회(희창)
	@GetMapping("qscListOffice")
	public String qscListOffice(Model model) {
		String storeNo = "FRC0000001";
		QscResultVO qscResultVO = new QscResultVO();
		qscResultVO.setStoreNumber(storeNo);
		
		List<QscResultVO> list =  qscService.selectQscListShop(qscResultVO);
		model.addAttribute("QscList", list);
		return "office/qscListOffice";
	}	
	
	//QSC결과 상세 조회(희창)
	@GetMapping("qscListInfoDetail")
	public String qscListInfoDetail(QscResultVO qscResultVO, Model model) {
		List<QscResultVO> list =  qscService.selectQscInfoDetail(qscResultVO);
		model.addAttribute("QscList", list);
		model.addAttribute("qscDates", list.get(0));
		return "shop/qscListInfoDetail";
	}
	
	
	
}
