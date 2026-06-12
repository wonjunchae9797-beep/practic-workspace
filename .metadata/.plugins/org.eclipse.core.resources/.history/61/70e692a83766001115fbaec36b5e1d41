package com.kh.practice.user.model.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.practice.user.model.vo.User;

@Mapper
public interface UserMapper {
	@Insert("INSERT INTO PRAC_USER(USER_ID, USER_PWD, USER_NICKNAME) VALUES (#{userId}, #{userPwd}, #{userNickname})")
	int save(User userEntity);
	
	@Select("SELECT COUNT(*) FROM PRAC_USER WHERE USER_ID = #{userId}")
	int checkId(String userId);

}
