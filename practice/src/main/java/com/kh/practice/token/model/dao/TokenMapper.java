package com.kh.practice.token.model.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.kh.practice.token.model.vo.RefreshToken;

@Mapper
public interface TokenMapper {

	
	@Insert("INSERT INTO PRAC_TOKEN VALUES(#{memberId}, #{token}, #{expiration})")
	void saveToken(RefreshToken token);
	
	@Delete("DELETE FROM PRAC_TOKEN WHERE MEMBER_ID = #{memberId}")
	void deleteToken(String memberId);
	
	@Select("SELECT MEMBER_ID, TOKEN, EXPIRATION FROM PRAC_TOKEN WHERE TOKEN = #{token}")
	RefreshToken findByToken(String token);

}
