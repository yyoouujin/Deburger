package com.deburger.app.main.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class SpringSecurityConfig {

	@Bean // 비밀번호 암호화
	BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	CustomLoginSuccessHandler loginSuccessHandler() {
		return new CustomLoginSuccessHandler();
	}

	// 인증 및 인가
	@Bean  
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http  // Security가 적용될 URI
		.authorizeHttpRequests((authorize) -> authorize
				.dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
				.requestMatchers("/login","/assets/**").permitAll()
				.requestMatchers("/**").hasAnyRole("4","3","2","1")
				.anyRequest().authenticated())
		.formLogin(formlogin -> formlogin
				.loginPage("/login")
				//.loginProcessingUrl("/loginProc")
				.successHandler(loginSuccessHandler()))
		.logout(logout -> logout
				.logoutSuccessUrl("/login")
				.invalidateHttpSession(true));
		
//		http.csrf(csrf -> csrf.disable());
		return http.build();
	}
	
}
