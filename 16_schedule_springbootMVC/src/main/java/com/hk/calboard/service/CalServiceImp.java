package com.hk.calboard.service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hk.calboard.command.InsertCalCommand;
import com.hk.calboard.command.UpdateCalCommand;
import com.hk.calboard.dtos.CalDto;
import com.hk.calboard.mapper.CalMapper;
import com.hk.calboard.utils.Util;

//import jakarta.security.auth.message.callback.PrivateKeyCallback.Request;

@Service
public class CalServiceImp implements ICalService{

	//Validated 유효값처리 라이브러리 사용
	//	- command 클래스를 생성하여 유효값 확인
	//	  화면-->command-->컨트롤러/서비스-->command값을 Dto에 담아서 이동--> mapper
	//	  command에 저장된 값을 확인하여 오류가 있으면 화면으로 보내고 오류가 없으면 서비스로 보냄
	@Autowired
	private CalMapper calMapper;
	
	public Map<String, Integer>makeCalendar(HttpServletRequest request){
		Map<String, Integer>map =new HashMap<String, Integer>();
		
		//달력의 날짜를 바꾸기 위해 전달된 year와 month 파라미터를 받는 코드
		String paramYear=request.getParameter("year");
		String paramMonth=request.getParameter("month");
		
		Calendar cal=Calendar.getInstance();	//추상 클래스, static메서드 (new생성 못함)
		//요청된 날짜로 저장 or 기본 오늘 날짜로 저장할지
		int year=paramYear==null? cal.get(Calendar.YEAR):Integer.parseInt(paramYear);
		//calendar 객체에서 month는 0~11월임(1~12월)
		int month=paramYear==null? cal.get(Calendar.MONTH)+1:Integer.parseInt(paramMonth);
		
		if(month>12) {
			month=1;
			year++;
		}
		if(month<1) {
			month=12;
			year--;
		}
		//1.매달 1일에 대한 요일 구하기
		cal.set(year, month-1,1);	//원하는 날짜로 셋팅
		int dayOfWeek=cal.get(Calendar.DAY_OF_WEEK);	//1~7중에 반환(1:일요일~7:토요일)
		
		//2.매달 말일에 대한 요일 구하기
		int lastDay=cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		map.put("year",year);
		map.put("month",month);
		map.put("dayOfWeek",dayOfWeek);
		map.put("lastDay",lastDay);
		
		return map;
	}
	
	@Override
	public boolean insertCalBoard(InsertCalCommand insertCalCommand) throws Exception {
	// command --> dto로 값을 이동
	//DB에서는 mdate 컬럼, command에서는 year, month..:12자리로 변환작업
		String mdate=insertCalCommand.getYear()
		           +Util.isTwo(insertCalCommand.getMonth()+"")
				   +Util.isTwo(insertCalCommand.getDate()+"")
				   +Util.isTwo(insertCalCommand.getHour()+"")
				   +Util.isTwo(insertCalCommand.getMin()+"");
					// 202311151335 12자리
					//202311181110  11자리...

	      //command --> dto 값 복사
	      CalDto dto=new CalDto();
	      dto.setId(insertCalCommand.getId());
	      dto.setTitle(insertCalCommand.getTitle());
	      dto.setContent(insertCalCommand.getContent());
	      dto.setMdate(mdate);
	     
	      int count=calMapper.insertCalBoard(dto);
	      
	      if(count>0){
	          throw new Exception("트랜잭션 실행됨");
	      }
	      return count>0?true:false;
	   }

	@Override
	public List<CalDto> calBoardList(String id, String yyyyMMdd) {
		
		return calMapper.calBoardList(id, yyyyMMdd);
	}

	@Override
	public CalDto calBoardDetail(int seq) {
		return calMapper.calBoardDetail(seq);
	}

	@Override
	public boolean calBoardUpdate(UpdateCalCommand updateCalCommand) {
		//command(y,M,d)값을 dto로 옮겨야함
		String mdate=updateCalCommand.getYear()
		           +Util.isTwo(updateCalCommand.getMonth()+"")
				   +Util.isTwo(updateCalCommand.getDate()+"")
				   +Util.isTwo(updateCalCommand.getHour()+"")
				   +Util.isTwo(updateCalCommand.getMin()+"");	//12자리
		
		//dto<--command
		CalDto dto=new CalDto();
		dto.setSeq(updateCalCommand.getSeq());
		dto.setTitle(updateCalCommand.getTitle());
		dto.setContent(updateCalCommand.getContent());
		dto.setMdate(mdate);
		
		return calMapper.calBoardUpdate(dto);
	}

	@Override
	public boolean calMuldel(Map<String, String[]> map) {
		calMapper.calMuldel(map);
		
		return false;
	}

	@Override
	public List<CalDto> calViewList(String id, String yyyyMM) {
		
		return calMapper.calViewList(id, yyyyMM);
	}

	@Override
	public int calBoardCount(String id, String yyyyMMdd) {
		
		return calMapper.calBoardCount(id, yyyyMMdd);
	}

}














