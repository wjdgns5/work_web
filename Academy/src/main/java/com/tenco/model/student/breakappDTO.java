package com.tenco.model.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class breakappDTO {
	// 학생 휴학 신청 
	int student_id; // 학생 아이디
	int student_grade; // 학생 학년
	int from_year;
	int from_semester;
	int to_year;
	int to_semester;
	String type;
	String app_date;
	String status;
}
