package com.deburger.app.office.container.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.office.container.service.ContainerService;
import com.deburger.app.office.container.service.ContainerVO;

@Controller
public class ContainerController {

	public ContainerService containerService;

	@Autowired
	ContainerController(ContainerService containerService) {
		this.containerService = containerService;
	}

	// 전체 조회
	@GetMapping("container")
	public String containerList(Model model) {
		List<ContainerVO> list = containerService.containerAllList();
		model.addAttribute("containers", list);

		return "office/container/containers";
	}

	// 단건 조회
	@GetMapping("containerInfo")
	public String containerInfo(ContainerVO containerVO, Model model) {
		ContainerVO findeVO = containerService.containerInfo(containerVO);
		model.addAttribute("container", findeVO);
		return "office/container/containerInfo";
	}
	
	// 등록
	@GetMapping("containerInsert")
	public String containerInsertForm() {
		return "office/container/containerInsert";
	}
	
	// 수정
	
	// 삭제(폐기 처리)
	
}
