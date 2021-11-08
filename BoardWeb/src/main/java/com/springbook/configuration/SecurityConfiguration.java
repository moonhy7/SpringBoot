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
		//authoizeRequests() : ����� ������ ���� ����
		//antMathers() : ��Ī�Ǵ� url���Ͽ� ���� ���� ����
		//permitAll() : ��� ����� ���� ���
		//hasRole() : Ư�������� ����ڸ� ���� ���
		//authenticated() : ������ ����ڿ��Ը� ���� ���
		security.authorizeRequests().antMatchers("/").permitAll()
									.antMatchers("/member/**").authenticated()
									.antMatchers("/manager/**").hasRole("MANAGER")
									.antMatchers("admin/**").hasAnyRole("ADMIN");
		
		//ũ�ν� ������ ����Ʈ ���� ��û�� ���� ����
		//��Ȱ��ȭ�ؼ� ��𼭵� ���� �����ϵ��� ����
		security.csrf().disable();
		
		//�α��� ó��
		security.formLogin().loginPage("/login.do").defaultSuccessUrl("/loginSuccess.do", true);
		//�α׾ƿ� ó��
		security.logout().invalidateHttpSession(true).logoutSuccessUrl("/login.do");
		
		security.userDetailsService(userDetailsServiceImpl);
	}
	
	@Autowired
	public void authenticate(AuthenticationManagerBuilder auth) throws Exception {
		
	}
	
	//��ȣȭó�� �� ��ü ���
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
