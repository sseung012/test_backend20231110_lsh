<%@page import="com.hk.board.dtos.HkDto"%>
<%@page import="com.hk.board.daos.HkDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글수정하기</title>
</head>
<body>
<%
	//detailBoard.jsp에서 전달된 파라미터 받기 : seq=글번호
	String seq=request.getParameter("seq");
	int sseq=Integer.parseInt(seq);	//형변환
	HkDao dao=new HkDao();
	HkDto dto=dao.getBoard(sseq);
%>
</body>
<h1>글수정하기</h1>
<form action="updateBoard.jsp" method="post">
	<input type="hidden" name="seq" value="<%=dto.getSeq()%>"/>
	<table border="1">
		<tr>
			<th>작성자</th>
			<td><%=dto.getId()%></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input type="text" name="title" value="<%=dto.getTitle()%>"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea rows="10" cols="60" name="content"><%=dto.getContent()%></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<button type="submit">수정완료</button>
				<button type="button" onclick="location.href='boardList.jsp'">글 목록</button>
			</td>
		</tr>
	</table>
</form>
</body>
</html>