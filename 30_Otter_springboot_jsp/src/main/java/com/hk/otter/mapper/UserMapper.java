package com.hk.otter.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.hk.otter.dtos.UserDto;

@Mapper
public interface UserMapper {
	
	public int addUser(UserDto dto);
	public UserDto loginUser(UserDto dto);
	public String idChk(String id);

}