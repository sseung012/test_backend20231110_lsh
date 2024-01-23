<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInsertForm.jsp</title>
</head>
<body>
<h1>신규회원입력</h1>
<form action="userInsert.jsp" method="get">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" name="userId"/></td>
		</tr>
		<tr>
			<td>이름</td>
			<td><input type="text" name="name"/></td>
		</tr>
		<tr>
			<td>출생년도</td>
			<td><input type="text" name="birthYear"/></td>
		</tr>
		<tr>
			<td>지역</td>
			<td><input type="text" name="addr"/></td>
		</tr>
		<tr>
			<td>휴대폰 국번</td>
			<td><input type="text" name="mobile1"/></td>
		</tr>
		<tr>
			<td>휴대폰 전화번호</td>
			<td><input type="text" name="mobile2"/></td>
		</tr>
		<tr>
			<td>신장</td>
			<td><input type="text" name="height"/></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="회원입력"/></td>
		</tr>
	</table>
</form>
</body>
</html>