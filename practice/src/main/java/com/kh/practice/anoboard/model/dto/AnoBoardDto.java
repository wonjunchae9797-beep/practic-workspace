package com.kh.practice.anoboard.model.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AnoBoardDto {
	
	private Long boardNo;
	@NotBlank
	@Size(min=2, max=20)
	private String userName;
	@NotBlank
	@Size(min=4)
	private String userPwd;
	@NotBlank
	private String title;
	@NotBlank
	private String content;
	private String fileUrl;
	private Integer viewCount;
	private LocalDateTime createDate;
	private LocalDateTime modifyDate;
	private String status;
	
}
