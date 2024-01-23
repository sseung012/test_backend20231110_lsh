package com.hk.board.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.hk.board.dtos.HkDto;
import com.hk.datasource.DataBase;

public class HkDao extends DataBase{
   
   
   public HkDao() { //생략가능
      super(); //생략가능 --> 부모의 생성자 호출 --> 객체 생성
      
   }
   
   //글목록 조회 기능 : 반환값 List<HkDto> --> 여러개의 행일 경우
   public List<HkDto> getAllList(){
      List<HkDto> list = new ArrayList<>();
      Connection conn=null; //DB연결된 객체
      PreparedStatement psmt=null; // 쿼리준비를 위한 객체 ?파라미터를 제공함
      ResultSet rs = null; //쿼리 실행결과를 받아줄 객체
      
      
      String sql="SELECT seq, id, title, content, regdate "
            + " FROM hkboard ORDER BY regdate DESC";
      
      
      try {
         conn=getConnection(); //2단계 : DB연결하기
         psmt = conn.prepareStatement(sql); //3단계 : 쿼리 준비하기
         rs = psmt.executeQuery(); //4단계 : 쿼리실행하기
         //5단계 : 쿼리 결과 받기 -> 자바에서 사용할 수 있게 처리
         while(rs.next()) { //rs객체안에 데이터가 있는지 여부를 확인
            HkDto dto=new HkDto(); //행단위로 저장
            dto.setSeq(rs.getInt(1)); //DB인덱스체계는 1부터 시작
            dto.setId(rs.getString(2));
            dto.setTitle(rs.getString(3));
            dto.setContent(rs.getString(4));
            dto.setRegDate(rs.getDate(5));
            list.add(dto);
            System.out.println(dto);
         }
      } catch (SQLException e) {
         System.out.println("JDBC실패: " + getClass()+":"+"getAllList()");
         e.printStackTrace();
      }finally {
         close(rs, psmt, conn); //6단계 : 쿼리결과닫기
      }
      
      
      return list;
   }
   // 글추가: insert문 실행, 파라미터(id, title, content), seq, regdate ->쿼리에서 추가
   // 테이블 수정 --> 결과값이 없음
   public boolean insertBoard(HkDto dto) {
	   int count=0;
	   Connection conn=null;
	   PreparedStatement psmt=null;
	   
	   String sql=" INSERT INTO hkboard "+" VALUES(NULL,?,?,?,SYSDATE()) ";
	   
	   try {
		conn=getConnection();	//2단계: DB연결
		psmt=conn.prepareStatement(sql);	//3단계: 쿼리준비
		psmt.setString(1, dto.getId());		//Dto에서 가져오는 값의 타입이 String
		psmt.setString(2, dto.getTitle());
		psmt.setString(3, dto.getContent());	//3단계 쿼리준비 완료
		
		//4단계: 쿼리 실행
		count=psmt.executeUpdate();	//테이블을 수정하기 때문에 executeUpdate()를 사용
		
	   } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	   }finally {
		   close(null,psmt,conn);
	   }
	   return count>0? true:false;
   }
   // 글 상세조회: select문, 파라미터(pk: seq)
   // 조회 기능이니까 결과가 있음 -> ResultSet필요
   // 반환타입: 
   public HkDto getBoard(int seq) {
	   HkDto dto=new HkDto();
	   Connection conn= null;
	   PreparedStatement psmt=null;
	   ResultSet rs=null;
	   String sql="SELECT seq, id, title, content, regdate "
	   				+ " FROM hkboard "
	   				+ " WHERE seq = ? ";
	   
	   try {
		conn=getConnection();
		psmt=conn.prepareStatement(sql);
		psmt.setInt(1, seq);
		rs=psmt.executeQuery();	//조회-->executeQuery()를 사용
		while(rs.next()) {
			dto.setSeq(rs.getInt(1));	//setSeq:int타입
			dto.setId(rs.getString(2));	//setId:String타입
			dto.setTitle(rs.getString(3));
			dto.setContent(rs.getString(4));
			dto.setRegDate(rs.getDate(5));
			System.out.println(dto);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close(rs,psmt,conn);
	}
	   return dto;
	}
   
   
   // 글 수정하기: Update문 실행, 파라미터(seq, title, content), regdate는 쿼리에서 수정
   // 테이블 수정이기 때문에 결과 X resultset객체 X
   public boolean updateBoard(HkDto dto) {
	   int count=0;
	   Connection conn=null;
	   PreparedStatement psmt=null;
	   
	   String sql="UPDATE hkboard"
	   		+ " SET title= ?, content= ?, regdate=SYSDATE() "
	   		+ " WHERE seq= ? ";
	   try {
		conn=getConnection();	//2
		psmt=conn.prepareStatement(sql);
		psmt.setString(1, dto.getTitle());
		psmt.setString(2, dto.getContent());
		psmt.setInt(3, dto.getSeq());	//3
		
		count=psmt.executeUpdate();	//4-> 수정된 행의 개수를 반환
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		close(null, psmt, conn);
	}
	   return count>0? true:false;
   }
   
   // 글 삭제: delete문 실행, 파라미터(seq)
   // 테이블 수정: resultset X, 결과값이 없음
   public boolean deleteBoard(int seq) {
	   int count=0;
	   Connection conn=null;
	   PreparedStatement psmt=null;
	   String sql="DELETE FROM hkboard WHERE seq= ? ";
	   try {
		conn=getConnection();
		psmt=conn.prepareStatement(sql);
		psmt.setInt(1, seq);
		
		count=psmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		close(null,psmt,conn);
	}
	   return count>0? true:false;
   }
}












