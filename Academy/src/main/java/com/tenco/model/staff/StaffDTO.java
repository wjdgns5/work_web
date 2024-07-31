package com.tenco.model.staff;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class StaffDTO {

	private int id;
	private String name;
	private String birthDate;
	private String gender;
	private String address;
	private String tel;
	private String email;
	private Timestamp hireDate;
	
}
