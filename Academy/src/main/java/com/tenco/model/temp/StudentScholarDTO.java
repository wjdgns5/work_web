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
public class StudentScholarDTO {
	private int studentId;
	private int schYear;
	private int semester;
	private int schType;
	private String studentName;
	private int amount;
	private String schTypeName;
}
