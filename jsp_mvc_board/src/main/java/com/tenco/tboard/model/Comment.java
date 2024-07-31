package com.tenco.tboard.model;

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
public class Comment {
	
	private int id; 
	private int boardId; 
	private int userId; 
	private String content; 
	private Timestamp createdAt;
	private String username;
}
