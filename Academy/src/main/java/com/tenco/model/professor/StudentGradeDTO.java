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
public class StudentGradeDTO {
	private int studentId;
	private String studentName;
	private int subjectId;
	private String subjectName;
	private int midExam;
	private int finalExam;
	private float convertedMark; 
}
