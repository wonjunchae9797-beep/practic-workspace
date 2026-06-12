package com.kh.practice.user.model.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.kh.practice.exception.DuplicatedIdException;
import com.kh.practice.user.model.dao.UserMapper;
import com.kh.practice.user.model.dto.UserDto;
import com.kh.practice.user.model.vo.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

	private final UserMapper userMapper;
	private final PasswordEncoder passwordEncoder;
	
	public void save(UserDto user) {
		
		checkId(user.getUserId());
		
		User userEntity = User.builder().userId(user.getUserId())
										.userPwd(encodePassword(user.getUserPwd()))
										.userName(user.getUserName())
										.build();
		
		userMapper.save(userEntity);
	}
	
	private void checkId(String userId) {
		if(userMapper.checkId(userId) > 0) {
			throw new DuplicatedIdException("중복된 아이디입니다.");
		}
	}
	
	private String encodePassword(String userPwd) {
		return passwordEncoder.encode(userPwd);
	}
	

}
