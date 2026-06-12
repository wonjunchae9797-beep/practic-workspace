package com.kh.practice.user.model.vo;

import java.sql.Date;

import lombok.Builder;
import lombok.Value;
@Value
@Builder
public class User {
	
	private String userId;
	private String userPwd;
	private String userName;
	private Date enrollDate;
	private Date modifyDate;
	private String role;
	private String status;
	
	

}
