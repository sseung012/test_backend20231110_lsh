package com.hk.calboard.service;

import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import com.hk.calboard.command.InsertCalCommand;
import com.hk.calboard.command.UpdateCalCommand;
import com.hk.calboard.dtos.CalDto;

public interface ICalService {

	//캘린더 생성
	public Map<String, Integer> makeCalendar(HttpServletRequest request);
	//일정추가
	public boolean insertCalBoard(InsertCalCommand insertCalCommand)throws Exception;
	//일정목록
	public List<CalDto> calBoardList(String id,String yyyyMMdd);
	//일정상세조회
	public CalDto calBoardDetail(int seq);
	//일정수정하기
	public boolean calBoardUpdate(UpdateCalCommand updateCalCommand);
	//일정삭제하기
	public boolean calMuldel(Map<String, String[]>map);
	//한달의 일정보여주기
	public List<CalDto> calViewList(String id, String yyyyMM);
	//일일의 일정개수 보여주기
	public int calBoardCount(String id, String yyyyMMdd);
}
