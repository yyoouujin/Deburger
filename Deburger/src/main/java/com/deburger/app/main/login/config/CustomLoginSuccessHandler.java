package com.deburger.app.main.login.config;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import groovy.util.logging.Log4j;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Log4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		String con = request.getContextPath() ;
		List<String> roleNames = new ArrayList<String>();
		
		authentication.getAuthorities().forEach(autgority ->{
			roleNames.add(autgority.getAuthority());
		});
		System.out.println(roleNames);
		
		if(roleNames.contains("ROLE_4")) {
			response.sendRedirect(con+"/shop");
			return;
		}
		
		if(roleNames.contains("ROLE_3")) {
			response.sendRedirect(con+"/");
			return;
		}
		
		if(roleNames.contains("ROLE_2")) {
			response.sendRedirect(con+"/");
			return;
		}
		
		if(roleNames.contains("ROLE_1")) {
			response.sendRedirect(con+"/");
			return;
		}
		response.sendRedirect(con+"/");
	}
}
