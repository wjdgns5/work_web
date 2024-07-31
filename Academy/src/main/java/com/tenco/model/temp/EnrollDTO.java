package com.tenco.model.temp;

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
public class EnrollDTO {

	private int studentId;
	private int subjectId;
	private String subjectName;
	private String professorName;
	private int deptId;
	private int day;
	private int period;
	private String roomId;
}
