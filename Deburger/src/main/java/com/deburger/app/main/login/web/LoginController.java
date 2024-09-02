package com.deburger.app.main.login.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.deburger.app.main.login.mapper.UserMapper;
import com.deburger.app.main.login.service.LoginService;
import com.deburger.app.main.login.service.PersonVO;
import com.deburger.app.main.login.service.UserVO;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class LoginController {
	
	private LoginService loginService;
	
	//로그인
	@GetMapping("login")
	public String officeMain() {
		return "main/login/loginForm";
	}
	
	// 담당자 등록
	@GetMapping("insertPerson")
	public String insertPerson() {
		return "main/login/insertPerson";
	}
	
	// 담당자 등록
	@PostMapping("insertPerson")
	public String insertPersonInfo(PersonVO personVO) {
		
		UserVO userVO = new UserVO();
		userVO.setId("DBG"+ personVO.getPersonId());
		userVO.setPassword(personVO.getPhone());
		userVO.setAuthority("4");
		userVO.setPasswordChangeOpertation("N");
		
		loginService.insertPersonInfo(personVO, userVO);
		
		return "main/login/insertPerson";
	}

}
