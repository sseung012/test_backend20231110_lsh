package com.hk.trip.service;

import java.io.IOException;
//import java.util.HashMap;
//import java.util.Iterator;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartRequest;

import com.hk.trip.command.InsertBoardCommand;
import com.hk.trip.command.ReplyBoardCommand;
import com.hk.trip.command.UpdateBoardCommand;
import com.hk.trip.dtos.BoardDto;
import com.hk.trip.mapper.BoardMapper;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	
	//글목록 조회
	public List<BoardDto> getAllList(){
		return boardMapper.getAllList();
	}
	
//	//페이지수 구하기
//	public int getPCount() {
//		return boardMapper.getPCount();
//	}

	//글 추가, 파일업로드및 파일정보 추가
	@Transactional
	public void insertBoard(InsertBoardCommand insertBoardCommand
			              , MultipartRequest multipartRequest
			              , HttpServletRequest request) 
			              throws IllegalStateException, IOException {
		//command:UI -> dto:DB 데이터 옮겨담기
		BoardDto boardDto=new BoardDto();
		boardDto.setId(insertBoardCommand.getId());
		boardDto.setTitle(insertBoardCommand.getTitle());
		boardDto.setContent(insertBoardCommand.getContent());
		
		//새글을 추가할때 파라미터로 전달된 boardDto객체에 자동으로,
		//증가된 board_seq값이 저장
		boardMapper.insertBoard(boardDto);//새글 추가
//		System.out.println("파일첨부여부:"
//		+multipartRequest.getFiles("filename").get(0).isEmpty());
//		//첨부된 파일들이 있는 경우
//		if(!multipartRequest.getFiles("filename").get(0).isEmpty()) {
//			//파일 저장경로 설정: 절대경로, 상대경로
//			String filepath=request.getSession().getServletContext()
//					       .getRealPath("upload");
//			System.out.println("파일저장경로:"+filepath);
//			//파일업로드 작업은 FileService쪽에서 업로드하고 업로드된 파일정보 반환
//			List<FileBoardDto>uploadFileList
//			      =fileService.uploadFiles(filepath, multipartRequest);
//			//파일정보를 DB에 추가
//			//글추가할때 board_seq 증가된 값---> file정보를 추가할때 사용
//			//Testboard: board_seq PK       board_seq FK
//			for (FileBoardDto fDto : uploadFileList) {
//				fileMapper.insertFileBoard(
//				 new FileBoardDto(0, boardDto.getBoard_seq(),//증가된 board_seq값을 넣는다 
//						             fDto.getOrigin_filename(),
//						 			 fDto.getStored_filename())
//				                          );
//			}
//		}
		
	}   
	//상세내용조회
	public BoardDto getBoard(int board_seq) {
		return boardMapper.getBoard(board_seq);
	}
	
	//수정하기
	public boolean updateBoard(UpdateBoardCommand updateBoardCommand) {
		//command:UI ---> DTO:DB 
		BoardDto dto=new BoardDto();
		dto.setBoard_seq(updateBoardCommand.getBoard_seq());
		dto.setTitle(updateBoardCommand.getTitle());
		dto.setContent(updateBoardCommand.getContent());
		return boardMapper.updateBoard(dto);
	}
	

	//글 상세보기 들어가서 글 삭제
	public boolean mulDel(String[] seqs) {
		return boardMapper.mulDel(seqs);
	}
	
	//답글
	@Transactional
	public boolean replyBoard(ReplyBoardCommand replyBoardCommand
            , HttpServletRequest request) {
		int count=0;
		BoardDto boardDto=new BoardDto();
		boardDto.setId(replyBoardCommand.getId());
		boardDto.setTitle(replyBoardCommand.getTitle());
		boardDto.setContent(replyBoardCommand.getContent());
		boardDto.setBoard_seq(replyBoardCommand.getBoard_seq()); 
		
		boardMapper.replyUpdate(boardDto);
		boardMapper.replyInsert(boardDto);//새글 추가
		
		return count>0?true:false;
	}

	//조회수
	public boolean readCount(int board_seq) {
		int count=0;
		boardMapper.readCount(board_seq);
		
		return count>0?true:false;
	}
	
	
}





