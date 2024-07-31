package com.tenco.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class UserDTO {
	
	/*
	 *  데이터 변환, 담는 개념, 메서드 사용할 수 있다.
	 */
	
	private int id;
	private String username;
	private String password;
	private String email;
	private String createdAt;

}
