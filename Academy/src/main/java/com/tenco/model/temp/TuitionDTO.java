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
public class TuitionDTO {

	private int id;
	private String studentName;
	private int tuiYear;
	private int semester;
	private int tuiId;
	private int schType;
	private String collName;
	private int amount;
	private String schName;
	private int schMount;
	private int status;
}
