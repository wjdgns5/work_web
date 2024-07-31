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
public class NoticeDTO {

	private int id;
	private String category;
	private String title;
	private String content;
	private Timestamp createdTime;
	private int views;
	
}
