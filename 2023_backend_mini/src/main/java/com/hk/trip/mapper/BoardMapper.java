package com.hk.trip.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.hk.trip.dtos.BoardDto;

@Mapper
public interface BoardMapper {

	//글목록
	public List<BoardDto> getAllList();
	//페이지수 구하기
//	public int getPCount();
	//글상세조회
	public BoardDto getBoard(int board_seq);
	//글추가
	public boolean insertBoard(BoardDto dto);
	//글 수정
	public boolean updateBoard(BoardDto dto);
	//글 삭제
	public boolean mulDel(String[] seqs);
	//조회수
	public boolean readCount(int board_seq);
	
	//답글달기
	public boolean replyUpdate(BoardDto dto);
	public int replyInsert(BoardDto dto);
}
