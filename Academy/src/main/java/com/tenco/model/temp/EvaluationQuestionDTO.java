package com.tenco.model.temp;

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

public class EvaluationQuestionDTO {

		private int id;
		private String question1;
		private String question2;
		private String question3;
		private String question4;
		private String question5;
		private String question6;
		private String question7;
		private String question8;
		private String question9;
		private String question10;
		private String sugContent;
		

}
