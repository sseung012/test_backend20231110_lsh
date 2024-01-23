package com.hk.hello;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//servlet객체: 클라이언트와 통신을 하기 위한 객체
//servlet객체를 만들기 위해서 HttpServlet클래스를 상속받아야함
public class HelloServletOld extends HttpServlet{
	@Override
	public void init() throws ServletException {
		System.out.println("init():servlet객체가 생성되면 최초 한번 실행되는 메서드");
	}
	
	//Servletconfig객체는 init()메서드의 파라미터로 얻어올 수 있음
	@Override
	public void init(ServletConfig config) throws ServletException {
		//config객체를 통해 서블릿에 저장된 값 가져오기
		String name=config.getInitParameter("name");
		System.out.println("config를 통해 값 가져오기:"+name);
		
		//servletcontext객체는 servletconfig객체로부터 얻어올 수 있음
		ServletContext application=config.getServletContext();
		application.setAttribute("id","id");
		String id=(String)application.getAttribute("id");
		
		//web.xml에 정의된 값 가져오기
		String driver=application.getInitParameter("driver");
		System.out.println("application을 통해 값 가져오기:"+driver);
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get방식 요청");
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
		
		//파라미터 받기:jsp와 완전동일
		String param=request.getParameter("param");
		//session객체 구하기
		HttpSession session=request.getSession();
//		UserDto ldto=(UserDto)session.getAttribute("ldto");
		
		//java의 결과 html에 출력하기
		PrintWriter out=response.getWriter();
		out.print("<h1>서블릿 응답</h1>");
		out.print("<h2>서블릿 3대 개념 알아보기</h2>");
		out.print("<h3><a href='index.jsp'>index</a></h3>");
		
		//서블릿에서 바로 다른 페이지 응답
		//response.sendRedirect("test.jsp");
		//forward방식
//		request.getRequestDispatcher("test.jsp").forward(request, response);
		test(request);	//다른객체에서 요청정보처리하려면 request객체를 전달해야 함
	}
	
	public void test(HttpServletRequest request) {
		//자체적으로 request 객체 생성할 수 없음(interface)
//		HttpServletRequest request=new HttpServletRequest();
		request.getSession();	//session 객체 생성
	}
	
	
	
	@Override
	public void destroy() {
		System.out.println("destroy(): 더 이상 요청이 없으면 서블릿 소멸");
		
	}
}






