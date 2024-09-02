package com.deburger.app.office.material.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.deburger.app.office.material.service.MaterialService;
import com.deburger.app.office.material.service.MaterialVO;

@Controller
public class MaterialController {

	public MaterialService materialService;

	@Autowired
	MaterialController(MaterialService materialService) {
		this.materialService = materialService;
	}

	@GetMapping("materials")
	public String materialList(Model model) {
		List<MaterialVO> list = materialService.serviceAllList();
		model.addAttribute("materials", list);

		return "office/material/materials";
	}

	@GetMapping("materialInfo")
	public String materialInfo(MaterialVO materialVO, Model model) {
		MaterialVO mvo = materialService.materialInfo(materialVO);
		model.addAttribute("material", mvo);
		return "office/material/materialInfo";
	}

}
