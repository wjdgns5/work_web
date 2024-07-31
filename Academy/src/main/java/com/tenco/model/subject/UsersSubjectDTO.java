package com.tenco.model.subject;

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

public class UsersSubjectDTO {
	
	private int subjectId;
	private String subjectName;
	private String professorName;
	private String roomId;
	private String departmentName;
	private String majorType;
	private String year;
	private String semester; 
	private String grades;
	
}
