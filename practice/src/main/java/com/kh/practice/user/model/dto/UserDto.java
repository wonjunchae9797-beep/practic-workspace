package com.kh.practice.user.model.dto;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {
	
	@NotBlank
	@Size(min = 4, max=20)
	@Pattern(regexp="[A-Za-z0-9]*$")
	private String userId;
	@NotBlank
	@Size(min = 4, max=20)
	@Pattern(regexp="[A-Za-z0-9]*$")
	private String userPwd;
	@NotBlank
	@Size(min = 2, max=20)
	private String userNickname;
	private Date enrollDate;
	private Date modifyDate;
	private String role;
	private String status;
	
	
	
}
