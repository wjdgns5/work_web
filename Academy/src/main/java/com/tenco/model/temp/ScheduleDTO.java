package com.tenco.model.temp;

import java.sql.Timestamp;

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
public class ScheduleDTO {
	private int id;
	private int staffId;
	private Timestamp startDay;
	private Timestamp endDay;
	private String information;
	
}
