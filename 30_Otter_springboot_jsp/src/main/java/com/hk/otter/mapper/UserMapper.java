package com.hk.otter.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hk.otter.dtos.UserDto;


@Mapper
public interface UserMapper {
	
	//회원가입
	public int addUser(UserDto dto);
	//로그인
	public UserDto loginUser(UserDto dto);
	//아이디중복체크
	public String idChk(String id);
	//나의 정보 조회
	public UserDto UserInfo(String id);
	//회원목록조회
	public List<UserDto> getUserList();

}