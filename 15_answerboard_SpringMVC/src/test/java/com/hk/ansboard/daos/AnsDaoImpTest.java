package com.hk.ansboard.daos;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
//import static org.junit.Assert.*;
//import org.apache.ibatis.session.SqlSession;
//import org.springframework.test.context.jdbc.Sql;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.hk.ansboard.dtos.AnsDto;

import lombok.val;

//@RunWith:spring에서 junit을 사용하기 위한 설정
//ContextConfiguration:spring bean설정 파일의 위치를 지정
//@WebAppConfiguration:MVC 및 웹 환경에 사용되는 bean들을 자동으로 등록 생성해줌
//bean은 객체를 말함
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
@WebAppConfiguration
public class AnsDaoImpTest {

	@Autowired
	@Qualifier(value = "sqlSessionTemplate")
	public SqlSessionTemplate sqlSession;
	
	public String namespace="com.hk.ansboard.";
	
	@Before
	public void beforeMethod() {
		System.out.println("before실행");
	}
	
	//timeout=ms, expected=Exception
	@Test
	public void getAllListTest() {
		Map<String, String>map=new HashMap<>();
		map.put("pnum", "1");
		List<AnsDto> list=sqlSession.selectList(namespace+"getAllList",map);
		System.out.println("글 목록 개수 : "+list.size());
		assertEquals(10, list.size());
//		fail("Not yet implemented");
	}
	
	@After
	public void afterMethod() {
		System.out.println("after실행");
	}
	
	
	
	

}

















