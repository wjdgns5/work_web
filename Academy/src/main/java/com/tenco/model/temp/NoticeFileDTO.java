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
public class NoticeFileDTO {

	private int noticeId;
	private String originFilename;
	private String uuidFilename;
	
	
	
}
