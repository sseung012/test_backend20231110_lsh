<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.hk.otter.dtos.UserDto" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Otter</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="resources/assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
<script type="text/javascript">

	// 클라이언트에서 전달받은 플래그 확인
	var loginResult = "<%= request.getAttribute("loginResult") %>";
	
	// 페이지 로드 시 실행
	window.onload = function() {
	    // checkLoginResult 함수 호출
	    checkLoginResult();
	};
	
	// 로그인 결과에 따라 알림창 띄우기
	function checkLoginResult() {
	    if (loginResult === "실패") {
	        alert("아이디 또는 비밀번호가 올바르지 않습니다.");
	    }
	}


</script>

</head>
<body class="join">
    <!-- Navigation-->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container px-4 px-lg-5">
            <a class="navbar-brand" href="/">Otter</a>
        </div>
    </nav>

    <section class="pyy-5">
        <div class="container myy-5">
            <div class="roww justify-content-center">
                <div class="coll-lg-6">
                    <form action="/user/login" method="post">
                        <table class="table">
                            <tr>
                                <th>아이디</th>
                                <td><input type="text" name="id" class="form-control"/></td>
                            </tr>
                            <tr>
                                <th>비밀번호</th>
                                <td><input type="password" name="userpassword" class="form-control"/></td>
                            </tr>
                            <tr>   
                                <td colspan="2">       
                                    <div style="display: flex;">
                                        <button type="submit" class="form-control">Login</button> &nbsp;&nbsp;&nbsp;    
                                        <a class="btn form-control" href="/user/join" style="border: 1px solid #ccc;">SignUp</a>
                                    
                                    </div> 
                                    
                                </td>
                            </tr>                                
                        </table>
                    </form>
                </div>
            </div>
        </div>
    </section>
    <!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="resources/js/scripts.js"></script>
</body>
</html>