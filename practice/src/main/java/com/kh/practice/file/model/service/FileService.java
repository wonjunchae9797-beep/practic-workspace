package com.kh.practice.file.model.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {

	String store(MultipartFile file);
	
}
