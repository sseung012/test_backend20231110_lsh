package com.hk.otter.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.hk.otter.dtos.UserDto;
import com.hk.otter.mapper.UserMapper;


@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public boolean addUser(UserDto dto) {
		int count=userMapper.addUser(dto);
		return count>0?true:false;
	}
	
	public UserDto loginUser(UserDto dto) {
		return userMapper.loginUser(dto);
	}
	
	
	//아이디중복체크
	public String idChk(String id) {
		return userMapper.idChk(id);
	}
	
	//마이페이지
	public UserDto UserInfo(String id) {
		return userMapper.UserInfo(id);
	}
	
	//나의 정보 수정
	public boolean updateUser(UserDto dto){
		UserDto mdto=new UserDto();
		mdto.setId(dto.getId());
		mdto.setPhone(dto.getPhone());
		mdto.setUseremail(dto.getUsername());
		
		
		return userMapper.updateUser(mdto);
	}
	
	
	
}












