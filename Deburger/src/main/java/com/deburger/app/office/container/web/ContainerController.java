package com.deburger.app.office.container.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.deburger.app.main.login.config.SecurityUtil;
import com.deburger.app.office.container.service.ContainerService;
import com.deburger.app.office.container.service.ContainerVO;
import com.deburger.app.office.logistic.service.Criteria;
import com.deburger.app.office.logistic.service.PageDTO;

@Controller
public class ContainerController {

	public ContainerService containerService;

	@Autowired
	ContainerController(ContainerService containerService) {
		this.containerService = containerService;
	}

	// 전체 조회
	@GetMapping("container")
	public String containerList(Criteria criteria, Model model) {
		// 담당 물류 창고 이름
		ContainerVO mid = new ContainerVO();
		String mcode = SecurityUtil.memberCode(); // id
		mid.setPersonId(mcode);
		mid.setPageNum(criteria.getPageNum());
		mid.setAmount(criteria.getAmount());

		// 해당 물
		List<ContainerVO> list = containerService.containerAllList(mid);
		// list;
		ContainerVO pid = containerService.loginService(mid);

		model.addAttribute("containers", list);
		model.addAttribute("persons", pid);
		model.addAttribute("pageMaker", new PageDTO(containerService.containerAllCount(mid), 5, criteria));
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

	// 물류 창고 입고 조회
	@GetMapping("containerIn")
	public String containerInList(Model model) {
		// 세션 처리 해보기
		ContainerVO mid = new ContainerVO();
		String mcode = SecurityUtil.memberCode(); // id
		mid.setPersonId(mcode);
		ContainerVO pid = containerService.loginService(mid);
		List<ContainerVO> list = containerService.containerAllInList(pid);
		
		int lcnt = list.size();
		if (lcnt > 0) {
			model.addAttribute("lcnts", true);
		} else {
			model.addAttribute("lcnts", false);
		}


		model.addAttribute("containersIn", list);
		model.addAttribute("persons", pid);
		return "office/container/containersIn";
	}

	// 물류 창고 입고 상세 조회
	@GetMapping("containerInsert")
	public String selectcontainerInInfo(ContainerVO containerVO, Model model) {
		List<ContainerVO> lists = containerService.containerInInfo(containerVO);
		model.addAttribute("list", lists);
		return "office/container/containerInsert";
	}

	// ---------------------------------------
	// 물류 창고 입고 처리
	@PostMapping("containerInsert")
	@ResponseBody
	public String containerInInsert(@RequestBody List<ContainerVO> list) {
		containerService.containerInTreatment(list);
		return "redirect:containerInsert";
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
	public String disposeController(ContainerVO containerVO) {
		containerService.disposeItem(containerVO);
		return "redirect:container";
	}

	// -------------------------------
	// 출고 리스트
	@GetMapping("containerOuts")
	public String containerOutAll(Criteria criteria, Model model) {
		ContainerVO mid = new ContainerVO();
		String mcode = SecurityUtil.memberCode(); // id
		mid.setPersonId(mcode);
		mid.setPageNum(criteria.getPageNum());
		mid.setAmount(criteria.getAmount());
		List<ContainerVO> list = containerService.containerOutAll(mid);
		ContainerVO pid = containerService.loginService(mid);
		model.addAttribute("outs", list);
		model.addAttribute("persons", pid);
		model.addAttribute("pageMaker", new PageDTO(containerService.containerOutAllCount(mid), 5, criteria));
		return "office/container/containerOutList";

	}

	// 출고 상세 리스트
	@GetMapping("containerOutInfos")
	public String containerOutInfoLists(ContainerVO containerVO, Model model) {
		List<ContainerVO> list = containerService.containerOutInfo(containerVO);
		model.addAttribute("outList", list);
		return "office/container/containerOutInfos";
	}

	// 출고 처리 리스트
	@GetMapping("containerOut")
	public String containerOutListAll(ContainerVO containerVO, Model model) {
		ContainerVO mid = new ContainerVO();
		String mcode = SecurityUtil.memberCode(); // id
		mid.setPersonId(mcode);
		ContainerVO pid = containerService.loginService(mid);
		List<ContainerVO> list = containerService.containerOutAllList(pid);

		int lcnt = list.size();
		if (lcnt > 0) {
			model.addAttribute("lcnts", true);
		} else {
			model.addAttribute("lcnts", false);
		}
		model.addAttribute("out", list);
		model.addAttribute("persons", pid);
		System.err.println(lcnt);
		return "office/container/containerOut";
	}

	// 출고 처리 상세 리스트
	@GetMapping("containerOutInfo")
	public String containerOutInfoList(ContainerVO containerVO, Model model) {
		List<ContainerVO> list = containerService.containerOutInfo(containerVO);
		model.addAttribute("outList", list);
		return "office/container/containerOutInfo";
	}

	// 모달창 input 자재별 유효 재고 lot 리스트
	@PostMapping("containerModal")
	@ResponseBody
	public List<ContainerVO> containerModalInfo(@RequestBody ContainerVO containerVO) {
		return containerService.containerOutModalInfo(containerVO);
	}

	// 출고 처리
	@PostMapping("containerOutPd")
	@ResponseBody
	public String containerOutPds(@RequestBody List<ContainerVO> list) {
		containerService.containerOutpD(list);
		return "office/container/containerOutInfo";
	}

}
