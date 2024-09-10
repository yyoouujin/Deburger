package com.deburger.app.main.login.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import com.deburger.app.main.login.service.LoginUserVO;

public class SecurityUtil {
	public static String memberCode(){
	       Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	       LoginUserVO loginUserVO = (LoginUserVO)authentication.getPrincipal();
	       String mcode = loginUserVO.getUserVO().getId();
	       return mcode;
	   }
}
