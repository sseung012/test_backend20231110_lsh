<%@include file="header.jsp" %>
<%@page import="com.hk.user.dtos.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	//나의 정보
	UserDto dto=(UserDto)request.getAttribute("dto");
%>
<script type="text/javascript">
	function delUser(id) {
		location.href="userController.jsp?command=delUser&id="+id;
	}
</script>
<body>
<div id="container">
	<div class="main">
		<div class="lead">
			<span><%=ldto.getId()%>[<%=ldto.getRole()%>]님이 로그인 하였습니다.</span>
			<span><a href="userController.jsp?command=myinfo&id=<%=ldto.getId()%>">나의정보</a></span>
			<span><a href="userController.jsp?command=logout">로그아웃</a></span>
		</div>
		<div class="contents">
			<h1>사용자 페이지</h1>
			<h2>나의 정보</h2>
			<div id="myinfo">
				<form action="userController.jsp" method="post">
					<input type="hidden" name="command" value="updateUser"/>
					<input type="hidden" name="id" value="<%=ldto.getId()%>"/>
					<table class=table>
						<tr>
							<th>ID</th>
							<td><%=dto.getId()%></td>
						</tr>
						<tr>
							<th>이름</th>
							<td><%=dto.getName()%></td>
						</tr>
						<tr>
							<th>등급</th>
							<td><%=dto.getRole()%></td>
						</tr>
						<tr>
							<th>주소</th>
							<td>
							<input type="text" name="address" value="<%=dto.getAddress()%>"/>
							</td>
						</tr>
						<tr>
							<th>Email</th>
							<td>
							<input type="text" name="email" value="<%=dto.getEmail()%>"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
							<button type="submit">수정</button>
							<button type="button" onclick="delUser('<%=ldto.getId()%>')">탈퇴</button>
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
	</div>
</div>

<%@include file="footer.jsp" %>

</body>
</html>