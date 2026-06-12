package com.kh.practice.auth.model.service;

import java.util.Map;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.kh.practice.auth.model.dto.LoginRequestDto;
import com.kh.practice.auth.model.dto.LoginResponseDto;
import com.kh.practice.auth.model.vo.CustomUserDetails;
import com.kh.practice.exception.InvalidParameterException;
import com.kh.practice.token.model.service.TokenService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthService {

	private final TokenService tokenService;
	private final AuthenticationManager authenticationManager;
	
	public LoginResponseDto login(LoginRequestDto lrd) {
		
		Authentication auth = null;
		try {
			auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(lrd.getUserId(), lrd.getUserPwd()));
		} catch(AuthenticationException e){
			throw new InvalidParameterException("로그인중 문제발생");
		}
		
		CustomUserDetails user = (CustomUserDetails)auth.getPrincipal();
		
		Map<String, String> tokens = tokenService.getTokens(user);
		
		return LoginResponseDto.builder()
							   .memberId(user.getUsername())
							   .userName(user.getUserName())
							   .role(user.getAuthorities().toString())
							   .accessToken(tokens.get("accessToken"))
							   .refreshToken(tokens.get("refreshToken"))
							   .build();
	}
}
