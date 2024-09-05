package com.deburger.app.office.container.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.office.container.service.ContainerService;
import com.deburger.app.office.container.service.ContainerVO;

@Controller
public class ContainerController {

	public ContainerService containerService;
	private List<ContainerVO> testList;
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

	// 상세 조회
	@GetMapping("containerInfo")
	public String containerInfo(ContainerVO containerVO, Model model) {
		List<ContainerVO> list = containerService.containerInfo(containerVO);
		model.addAttribute("container", list);
		return "office/container/containerInfo";
	}

	// 등록
	// @GetMapping("containerInsert")
	public String containerInsertForm() {
		return "office/container/containerInsert";
	}

	// 수정

	// ----------------------------
	// 물류 창고 입고 조회
	@GetMapping("containerIn")
	public String containerInList(Model model) {
		List<ContainerVO> list = containerService.containerAllInList();
		model.addAttribute("containersIn", list);
		return "office/container/containersIn";
	}

	// 물류 창고 입고 상세 조회
	@PostMapping("containerInsert")
	@ResponseBody
	public List<ContainerVO> selectcontainerInInfo(@RequestBody List<ContainerVO> list) {
		System.out.println("aaaa");
		testList = containerService.containerInInfo(list);
		return testList;
	}
	@GetMapping("containerInsert")
	public String insertPage(Model model) {
		System.out.println("tttt");
		System.out.println(testList.toString());
		model.addAttribute("list", testList);
		return "office/container/containerInsert";
	}

	// 폐기 조회
	@GetMapping("containerDelete")
	public String containerDelete(ContainerVO containerVO, Model model) {
		List<ContainerVO> list = containerService.containerDtInfo(containerVO);
		model.addAttribute("container", list);
		return "office/container/containerdelete";
	}

	// 폐기 처리
	@PostMapping("containerIn")
	public String disposeController(ContainerVO containerVO, Model model) {
		containerService.disposeItem(containerVO);
		return "redirect:container";
	}
}
