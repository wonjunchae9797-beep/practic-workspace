package com.kh.practice.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.kh.practice.api.model.vo.ApiResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	
	@ExceptionHandler(DuplicatedIdException.class)
	public ResponseEntity<ApiResponse<Void>> handlerDuplicateId(DuplicatedIdException e){
		return ResponseEntity.badRequest().body(ApiResponse.badRequest(e.getMessage(), null));
		
	}
	@ExceptionHandler(InvalidParameterException.class)
	public ResponseEntity<ApiResponse<Void>> handlerInvalidParameter(InvalidParameterException e){
		return ResponseEntity.badRequest().body(ApiResponse.badRequest(e.getMessage(), null));
	}
	@ExceptionHandler(CustomAuthenticationException.class)
	public ResponseEntity<ApiResponse<Void>> handlerCustomAuthentication(CustomAuthenticationException e){
		return ResponseEntity.badRequest().body(ApiResponse.badRequest(e.getMessage(), null));
	}

}
