package com.hk.trip.utils;

import org.springframework.stereotype.Component;

//action Tag : <useBean /> --> DTO객체를 구현하는 태그 
@Component
public class Util {

	private String arrowNbsp;//공백과화살표를 출력할 문자열

	//set메서드에서 depth값을 받아서 공백과 화살표 만들어주기
	public String setArrowNbsp(String depth) {
		String nbsp="";
		int depthInt=Integer.parseInt(depth);
		for (int i = 0; i < depthInt; i++) {
			nbsp+="&nbsp;&nbsp;&nbsp;&nbsp;";
		}
		//           답글인 조건: depth>0
		return nbsp+(depthInt>0?"🌷":"");
		//            "&nbsp;&nbsp;&nbsp;&nbsp;->"
		
	}
	
	public String getArrowNbsp() {
		return arrowNbsp;
	}

	
	
	
}