package com.tenco.model.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@Getter
@Builder
@ToString

public class UserDTO {
	//tb_user
	private int id;
	private int permissionLevel;
	//student staff professor 공통
	private String name;
	private String birth;
	private String gender;//남자,여자
	private String address;
	private String phoneNum;
	private String email;
	//only student
	private int deptId;
	private int grade;
	private int semester;
	
}
