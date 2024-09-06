package com.deburger.app.office.logistic.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.deburger.app.office.logistic.service.LogisticService;
import com.deburger.app.office.logistic.service.LogisticVO;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LogisticController {
		
	
		private LogisticService logisticService;
		
		@Autowired
		public LogisticController(LogisticService logisticService) {
				this.logisticService = logisticService;
		}
		
		//창고 전체조회
		@GetMapping("logisticList")
		public String logisticList(Model model) {
				List<LogisticVO> list = logisticService.logisticList();
				model.addAttribute("logistics", list);
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
		
		//물품 단건조회
		@GetMapping("stockInfoAjax")
		@ResponseBody
		public List<LogisticVO> getMaterialInfoAjax(LogisticVO logisticVO) {
			List<LogisticVO> infoVO = logisticService.logisticMaterialInfo(logisticVO);
			return infoVO;
		}
		
		
}
