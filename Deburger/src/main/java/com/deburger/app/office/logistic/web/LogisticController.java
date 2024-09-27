package com.deburger.app.office.logistic.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.deburger.app.office.logistic.service.Criteria;
import com.deburger.app.office.logistic.service.LogisticService;
import com.deburger.app.office.logistic.service.LogisticVO;
import com.deburger.app.office.logistic.service.PageDTO;

import org.springframework.web.bind.annotation.ResponseBody;

/*
작성자 : 채유진
작성일자 : 2024-09-
기능 : 물류창고 관리
*/
@Controller
public class LogisticController {
		
		private LogisticService logisticService;
		
		@Autowired
		public LogisticController(LogisticService logisticService) {
				this.logisticService = logisticService;
		}
		
		//창고 전체조회(페이징)
		@GetMapping("logisticList")
		public String logisticList(Criteria criteria, Model model) {
				List<LogisticVO> list = logisticService.logistiList(criteria);
				model.addAttribute("logistics", list);
				model.addAttribute("pageMaker", new PageDTO(logisticService.getTotal(), 5, criteria));
				return "office/logistic/logisticList";
		}
		
		
		//창고 단건조회(페이징)
		@GetMapping("logisticInfo")
		public String logisticInfo(LogisticVO logisticVO, Model model,
									@RequestParam(value = "nowPage", required=false) String nowPage,
									@RequestParam(value = "cntPerPage", required=false) String cntPerPage) {
				
				int total = logisticService.getMatTotal();
				if(nowPage == null && cntPerPage == null) {
					nowPage = "1";
					cntPerPage = "10";
				} else if (nowPage == null) {
					nowPage = "1";
				} else if (cntPerPage == null) {
					cntPerPage = "10";
				}
				
				model.addAttribute("logi", logisticVO);
				String logiId = logisticVO.getLogisticsId();
				
				logisticVO = new LogisticVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
				System.err.println(logisticVO);
				
				logisticVO.setLogisticsId(logiId);
				
				List<LogisticVO> list = logisticService.logisticInfo(logisticVO);
				model.addAttribute("logistic", list);
				model.addAttribute("paging", logisticVO);
				model.addAttribute("viewAll", logisticService.logisticInfo(logisticVO));
				model.addAttribute("localDateTime", LocalDateTime.now());
				return "office/logistic/logisticInfo";
		}
		
		
		//창고 필요재고
		@GetMapping("requireStock")
		@ResponseBody
		public List<LogisticVO> getRequireStock(LogisticVO logisticVO) {
			List<LogisticVO> requireVO = logisticService.selectRequireStock(logisticVO);
			return requireVO;
		}
		
		
		//창고 충분재고
		@GetMapping("enoughStock")
		@ResponseBody
		public List<LogisticVO> getEnoughStock(LogisticVO logisticVO) {
			List<LogisticVO> enoughVO = logisticService.selectEnoughStock(logisticVO);
			return enoughVO;
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
		
		//창고 정보 조회(아작스)
		@GetMapping("logisticDetailInfoAjax")
		@ResponseBody
		public List<LogisticVO> logisticDetailInfoAjax(LogisticVO logisticVO, Model model) {
			List<LogisticVO> infoVO = logisticService.logisticDetailInfo(logisticVO);
			return infoVO;
		}
		
		//창고 수정처리
		@PostMapping("logisticUpdate")
		public String logisticUpdateProcess(LogisticVO logisticVO) {
			logisticService.updateLogisticInfo(logisticVO);
			return "redirect:logisticList";
		}
		
		//창고 삭제
		@GetMapping("logisticDelete")
		public String logisticDelete(String logisticsId) {
			logisticService.deleteLogistic(logisticsId);
			return "redirect:logisticList";
		}
		

}
