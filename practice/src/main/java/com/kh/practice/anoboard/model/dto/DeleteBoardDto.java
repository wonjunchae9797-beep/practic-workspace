package com.kh.practice.anoboard.model.dto;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class DeleteBoardDto {

	private Long boardNo;
	private String userPwd;
	
}
