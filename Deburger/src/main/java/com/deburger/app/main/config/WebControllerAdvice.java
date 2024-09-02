package com.deburger.app.main.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class WebControllerAdvice {

	// contextPath
	@ModelAttribute("contextPath")
	public String contextPath(final HttpServletRequest request) {
		return request.getContextPath();
	}
}
