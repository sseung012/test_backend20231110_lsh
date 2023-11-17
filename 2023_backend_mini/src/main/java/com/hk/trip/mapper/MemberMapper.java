package com.hk.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hk.trip.dtos.MemberDto;

@Mapper
public interface MemberMapper {
	
	//회원가입
	public boolean insertUser(MemberDto dto);
	
	//아이디 중복체크
	public String idChk(String id);
	
	//로그인
	public MemberDto getLogin(String id);
	
	//나의 정보 조회
	public MemberDto getUserinfo(String id);
	
	//나의 정보 수정
	public boolean updateUser(MemberDto dto);
	
	//회원 탈퇴
	public boolean delUser(String id);
	
	//회원목록 전체조회
	public List<MemberDto> getAllUserList();
	
	//회원목록 조회(사용중인 회원)
	public List<MemberDto> getUserList();
}






