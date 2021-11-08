package com.springbook.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.springbook.impl.UserDetailsServiceImpl;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@Override
	protected void configure(HttpSecurity security) throws Exception {
		//authoizeRequests() : 사용자 인증과 권한 설정
		//antMathers() : 매칭되는 url패턴에 대한 접근 설정
		//permitAll() : 모든 사용자 접근 허용
		//hasRole() : 특정권한의 사용자만 접근 허용
		//authenticated() : 인증된 사용자에게만 접근 허용
		security.authorizeRequests().antMatchers("/").permitAll()
									.antMatchers("/member/**").authenticated()
									.antMatchers("/manager/**").hasRole("MANAGER")
									.antMatchers("admin/**").hasAnyRole("ADMIN");
		
		//크로스 도메인 사이트 위조 요청에 대한 설정
		//비활성화해서 어디서든 접근 가능하도록 설정
		security.csrf().disable();
		
		//로그인 처리
		security.formLogin().loginPage("/login.do").defaultSuccessUrl("/loginSuccess.do", true);
		//로그아웃 처리
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login.do");
		
		security.userDetailsService(userDetailsServiceImpl);
	}
	
	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	
	//암호화처리 빈 객체 등록
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
