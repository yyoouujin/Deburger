package com.deburger.app.office.logistic.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.deburger.app.office.logistic.service.Criteria;
import com.deburger.app.office.logistic.service.LogisticService;
import com.deburger.app.office.logistic.service.LogisticVO;
import com.deburger.app.office.logistic.service.PageDTO;

import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LogisticController {
		
	
		private LogisticService logisticService;
		
		@Autowired
		public LogisticController(LogisticService logisticService) {
				this.logisticService = logisticService;
		}
		
		/*
		//창고 전체조회
		@GetMapping("logisticList")
		public String logisticList(Model model) {
				List<LogisticVO> list = logisticService.logisticList();
				model.addAttribute("logistics", list);
				return "office/logistic/logisticList";
		}
		*/
		
		
		//창고 전체조회(페이징)
		@GetMapping("logisticList")
		public String logisticList(Criteria criteria, Model model) {
				List<LogisticVO> list = logisticService.logistiList(criteria);
				
				model.addAttribute("logistics", list);
				
				model.addAttribute("pageMaker", new PageDTO(logisticService.getTotal(), 5, criteria));
				
				return "office/logistic/logisticList";
		}
		
		//창고 단건조회
		@GetMapping("logisticInfo")
		public String logisticInfo(LogisticVO logisticVO, Model model) {
				List<LogisticVO> list = logisticService.logisticInfo(logisticVO);
				//LogisticVO findVO = logisticService.logisticInfo(logisticVO);
				model.addAttribute("logistic", list);
				model.addAttribute("localDateTime", LocalDateTime.now());
				return "office/logistic/logisticInfo";
		}
		

		//창고 내 물품 단건조회
		@GetMapping("stockInfoAjax")
		@ResponseBody
		public List<LogisticVO> getMaterialInfoAjax(LogisticVO logisticVO) {
			List<LogisticVO> infoVO = logisticService.logisticMaterialInfo(logisticVO);
			return infoVO;
		}
		
		//창고 등록 페이지
		@GetMapping("logisticInsert")
		public String logisticInsertForm() {
			return "office/logistic/logisticInsert";
		}
		
		//창고 등록 페이지 담당자 아이디 선택
		@GetMapping("selectDBGidAjax")
		@ResponseBody
		public List<LogisticVO> getLogisticPersonIdAjax(LogisticVO logisticVO) {
			List<LogisticVO> infoVO = logisticService.logisticPersonInfo(logisticVO);
			return infoVO;
		}
		
		//창고 등록처리
		@PostMapping("logisticInsert")
		public String logisticInsertProcess(LogisticVO logisticVO) {
			int lid = logisticService.insertLogistic(logisticVO);
			String strlid = String.format("%07d", lid);
			return "redirect:logisticInfo?logisticsId=CTN" + strlid;
			//return "office/logistic/logisticList";
		}
		
		//창고 수정페이지
		@GetMapping("logisticUpdate")
		public String logisticUpdateForm(LogisticVO logisticVO, Model model) {
			LogisticVO findVO = logisticService.logisticDetailInfo(logisticVO);
			model.addAttribute("logistic", findVO);
			int lid = logisticService.updateLogistic(logisticVO);
			String strlid = String.format("%07d", lid);
			return "redirect:logisticInfo?logisticsId=CTN" + strlid;
		}
		
		//창고 수정처리
		@PostMapping("logisticInfo")
		public String logisticUpdateProcess(LogisticVO logisticVO) {
			int lid = logisticService.updateLogistic(logisticVO);
			String strlid = String.format("%07d", lid);
			return "redirect:logisticInfo?logisticsId=CTN" + strlid;
			//return "office/logistic/logisticList";
		}
		
		

		
}
