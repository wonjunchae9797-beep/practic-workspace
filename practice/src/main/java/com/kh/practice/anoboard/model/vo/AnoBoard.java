package com.kh.practice.anoboard.model.vo;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AnoBoard {

	private Long boardNo;
	private String userName;
	private String userPwd;
	private String title;
	private String content;
	private String fileUrl;
	private Integer viewCount;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	private String status;
	
}
