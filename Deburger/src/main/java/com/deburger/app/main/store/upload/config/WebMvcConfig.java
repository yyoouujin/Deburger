package com.deburger.app.main.store.upload.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer{
	
	@Value("${file.upload.url}")
	private String uploadPath;
	
	

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**") // URL static 폴더안에있는 이름과 달라야함
		.addResourceLocations("file:///" + uploadPath, "");
	}
	

}