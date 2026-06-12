package com.kh.practice.api.model.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApiResponse<T> {
	private int code;
	private String message;
	private  T data;

	public static <T> ApiResponse<T> success(T data){
		return new ApiResponse<>(200, "요청에 성공했습니다.", data);
	}
	public static <T> ApiResponse<T> success(String message, T data){
		return new ApiResponse<>(200, message, data);
	}

	public static <T> ApiResponse<T> created(T data){
		return new ApiResponse<>(201, "요청에 성공했습니다", data);
	}
	public static <T> ApiResponse<T> created(String message, T data){
		return new ApiResponse<>(201, message, data);
	}
	
	public static <T> ApiResponse<T> noContent(T data){
		return new ApiResponse<>(204, "요청에 성공했습니다.", data);
	}
	
	public static <T> ApiResponse<T> noContent(String message, T data){
		return new ApiResponse<>(204, message, data);
	}
	
	public static <T> ApiResponse<T> badRequest(String message, T data){
		return new ApiResponse<>(400, message, data);
	}
	
	

	
	
	

	
}
