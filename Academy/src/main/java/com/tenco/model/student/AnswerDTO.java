package com.tenco.model.student;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Data 
public class AnswerDTO {
	
	private int stuId;
	private int subId;
	private int[] answer;
	private String content;
	private double avg;
	
}


