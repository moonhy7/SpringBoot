package com.springbook.vo;

import lombok.Data;

@Data
public class MemberVO {
	private String id;
	private String password;
	private String name;
	private String role;
	private String enalbed;
}
