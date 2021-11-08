package com.springbook.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springbook.mapper.UserMapper;
import com.springbook.vo.MemberVO;
import com.springbook.vo.SecurityUser;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO member = userMapper.findById(username);
		
		if(member == null) {
			throw new UsernameNotFoundException(username + " 사용자 없음");
		} else {
			return new SecurityUser(member);
		}
	}
}
