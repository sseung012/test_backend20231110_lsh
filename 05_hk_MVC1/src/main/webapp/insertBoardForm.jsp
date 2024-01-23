<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8");%>
<%@include file="header_board.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>새 글 작성하기</title>
</head>
<body>
<h1 class="first">새 글 작성하기</h1>
<form action="hkController.jsp" method="post">
<input type="hidden" name="command" value="insertBoard">
<table border="1" class="insertboard">
	<tr>
		<th>작성자(ID)</th>
		<td><input type="text" name="id" value=<%=ldto.getId()%> readonly="readonly"/></td>
	</tr>
	<tr>
		<th>글제목</th>
		<td><input type="text" name="title" required="required"/></td>
	</tr>
	<tr>
		<th>글내용</th>
		<td><textarea rows="10" cols="110" name="content" required="required"/></textarea></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="등록"/>
						<input type="button" value="글 목록"
							   onclick="location.href='hkController.jsp?command=boardList'"/></td>
	</tr>
</form>
</table>
<%@include file="footer.jsp" %>
</body>
</html>