package com.springbook.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.springbook.vo.MemberVO;

@Mapper
public interface UserMapper {
	MemberVO findById(String username);
	
	void join(MemberVO vo);
}
