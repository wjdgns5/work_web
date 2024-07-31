package com.tenco.model.professor;

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

public class RestClassDTO {
	private int id;
	private int subjectId;
	private String subjectName;
	private int professorId;
	private String restDay;
	private String roomId;
	private int year;
	private int semester;
	private String supplement;
}
