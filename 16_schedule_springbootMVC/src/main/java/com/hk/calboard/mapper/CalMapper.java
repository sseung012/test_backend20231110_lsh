package com.hk.calboard.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hk.calboard.dtos.CalDto;

@Mapper
public interface CalMapper {

	//일정추가
	public int insertCalBoard(CalDto dto);
	//일정목록
	public List<CalDto> calBoardList(String id,String yyyyMMdd);
	//일정상세조회
	public CalDto calBoardDetail(int seq);
	//일정수정하기
	public boolean calBoardUpdate(CalDto dto);
	//일정삭제하기
	public boolean calMuldel(Map<String, String[]>map);
	//한달의 일정보여주기
	public List<CalDto> calViewList(String id, String yyyyMM);
	//일일의 일정개수 보여주기
	public int calBoardCount(String id, String yyyyMMdd);
}


















