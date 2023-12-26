package com.hk.otter.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.otter.dtos.ProductDto;
import com.hk.otter.dtos.RewardDto;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class FileService {
	
	@Autowired
	private ProductDto productMapper;
	
	// 파일업로드하기
	public List<ProductDto> uploadFiles(String uploadPath,
							MultipartRequest multipartRequest) throws IllegalStateException, IOException {
		
		// 여러 개의 파일들을 List에 담는 코드
		List<MultipartFile> multipartFiles
					= multipartRequest.getFiles("img");
		
		// 업로드된 파일들의 정보(원본명, 저장명)를 담아줄 list 선언
		List<ProductDto> uploadFileList = new ArrayList<>();
		
		for(MultipartFile multipartFile : multipartFiles) {
			
			// 원본파일명
			String img = multipartFile.getOriginalFilename();		
						
			// 파일저장 경로 구하기
			String fileuploadUrl = uploadPath + "/" + img;
			multipartFile.transferTo(new File(fileuploadUrl)); // upload 실행
						
		}
		return uploadFileList;
		
	}
	
	
	

}










