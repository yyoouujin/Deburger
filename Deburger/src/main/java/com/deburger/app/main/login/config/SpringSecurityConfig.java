package com.deburger.app.main.login.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
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
	
	// 메모리상 인증정보 등록 => 테스트 전용 방식
//	@Bean
//	InMemoryUserDetailsManager inMemoryUserDetailsService() {
//		
//		UserDetails user = User.builder()
//				.username("user1")
//				.password(passwordEncoder().encode("1234"))
//				.roles("USER") // ROLE_USER
////				.authorities("ROLE_USER")   // 사용하는 메서드에 따라 다르게 사용해야함 (같은의미에서 사용)
//				.build();
//		
//		UserDetails admin = User.builder()
//				.username("admin1")
//				.password(passwordEncoder().encode("1234"))
////				.roles("ADMIN") // ROLE_ADMIN
//				.authorities("ROLE_ADMIN","ROLE_USER")
//				.build();
//		
//		
//		
//		return new InMemoryUserDetailsManager(user,admin);
//	}
}
