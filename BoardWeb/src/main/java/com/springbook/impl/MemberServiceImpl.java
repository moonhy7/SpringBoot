package com.springbook.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.mapper.UserMapper;
import com.springbook.service.MemberService;
import com.springbook.vo.MemberVO;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void join(MemberVO vo) {
		userMapper.join(vo);
	}
}
