package com.kh.practice.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kh.practice.api.model.vo.ApiResponse;
import com.kh.practice.user.model.dto.UserDto;
import com.kh.practice.user.model.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService userService;
	@PostMapping
	public ResponseEntity<ApiResponse<Void>> save(@RequestBody @Valid UserDto user){
		
		
		
		userService.save(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.created("회원가입 성공!", null));
	}
	

}
