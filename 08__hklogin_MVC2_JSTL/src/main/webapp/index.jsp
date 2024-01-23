<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/loginpage.css" />
<script type="text/javascript" src="js/cookieFunc.js"></script>
<script type="text/javascript">
	//회원가입폼 이동
	function registForm(){
		location.href="registForm.user";
	}
	
	// 아이디를 쿠키에 저장
	function userIdCookie() {
		//chkID는 아이디 저장 체크박스 객체
		var chkID=document.querySelectorAll("input[type=checkbox]")[0];
		var id=document.forms[0].id.value;	//forms 속성 이용
//		var id=document.getElementsByName("id")[0].value;	//dom탐색 메서드 이용
		if(chkID.checked){	//체크여부 확인하여 쿠키에 id저장하기
			setCookie("rememberid",id,100);
		}
		return true;
	}
	onload=function(){
		 var cookieID=getCookie("rememberid");
		 if(cookieID!=null){
			 //id 입력 박스에 cookie에서 가져온 값을 넣어줌
			 document.getElementsByName("id")[0].value=cookieID;
		 }
	}
</script>
</head>
<%-- <% String msg=request.getParameter("msg"); %> --%>
<body>
<form action="login.user" method="post" onsubmit="return userIdCookie()">
<!--    <input type="hidden" name="command" value="login" /> -->
   <h1>Login in</h1>
   <input class="loginVal" type="text" name="id" placeholder="ID" required="required" />
   <input class="loginVal" type="password" name="password" placeholder="PASSWORD" required="required" />
   <input type="checkbox" value="remember-me" /><label>아이디 저장</label>
   <br/>
   <label style="color:gray;"><small>${msg==null?"":msg}</small></label>
   <button type="submit">Sign in</button>
   <button type="button" onclick="registForm()">Sign up</button>
</form>
</body>
</html>