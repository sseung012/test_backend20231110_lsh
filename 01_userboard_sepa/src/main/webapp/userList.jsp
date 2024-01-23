<%@page import="com.hk.board.dtos.UserDto"%>
<%@page import="java.util.List"%>
<%@page import="com.hk.board.daos.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userList.jsp</title>
<script type="text/javascript">
// javascript code 작성 영역
	//자바스크립트에서 삭제 여부를 확인하고 삭제 진행
	function deleteUser(userId){
	if(confirm("정말 삭제하시겠습니까")){
		location.href="userDelete.jsp?userId="+userId;
	}
}
</script>
</head>
<% // java코드 실행부
	UserDao dao=new UserDao();
	List<UserDto> list=dao.getAllUser();
%>
<body>
<h1>회원조회 결과</h1>
<table border="1">
<!-- 출력할 영역 -->
	<tr>
		<th>아이디</th>
		<th>이름</th>
		<th>가입일</th>
		<th>수정</th>
		<th>삭제</th>
	</tr>
	<%
		for(int i=0; i<list.size();i++){
		UserDto dto= list.get(i);	
	%>
	<tr>
		<td><%=dto.getUserID()%></td>
		<td><%=dto.getName()%></td>
		<td><%=dto.getmDate()%></td>
		<td><a href="userUpdateForm.jsp?userId=<%=dto.getUserID()%>">수정</a></td>
<%-- 		<td><a href="userDelete.jsp?userId=<%=dto.getUserID()%>">삭제</a></td> --%>
		<td><a href="#" onclick="deleteUser('<%=dto.getUserID()%>')">삭제</a></td>
	</tr>
	<%
	}
	%>
	<tr>
		<td colspan="5">
		<a href="index.jsp">초기화면</a>
		</td>
	</tr>
</table>
</body>
</html>