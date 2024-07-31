package com.tenco.model.subject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SubjectDTO {
	private int id;
	private String name;
	private String roomId;
	private String departmentName;
	private String majorType;
	private int year;
	private int semester;
	private int grades;
}
