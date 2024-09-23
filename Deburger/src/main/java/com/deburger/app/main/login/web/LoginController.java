package com.deburger.app.main.login.web;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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
		return "main/login/loginForm2";
	}
	
	// 담당자 등록
	@GetMapping("insertPerson")
	@PreAuthorize("hasAnyRole('4','3','2','1')")
	public String insertPerson() {
		return "main/login/insertPerson";
	}
	
	// 담당자 등록
	@PostMapping("insertPerson")
	public String insertPersonInfo(PersonVO personVO) {
		
		UserVO userVO = new UserVO();
		userVO.setId("DBG"+ personVO.getPersonId());
		personVO.setPersonId(userVO.getId());
		userVO.setPassword(personVO.getPhone());
		if(personVO.getDepartment().equals("물류담당자")) {
			userVO.setAuthority("3");			
		}else {
			userVO.setAuthority("2");
		}
		userVO.setPasswordChangeOpertation("N");
		
		loginService.insertPersonInfo(personVO, userVO);
		
		return "main/login/insertPerson";
	}

}
