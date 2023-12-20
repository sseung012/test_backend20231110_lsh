<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
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

        	
<script type="text/javascript">
	
</script>
</head>
<body class="addProductForm">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
    	<a class="navbar-brand" href="#!">Otter</a>
    </div>
</nav>

<section class="pyy-5">
        <div class="container myy-5">
            <div class="roww justify-content-center">
                <div class="coll-lg-6">
                    <form action="/user/adduser" method="post" >
                        
                        <div class="addProduct">
                            <label for="userpassword" class="form-label">대표 이미지</label>
                            <input type="password" name="userpassword" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="userpassword2" class="form-label">회사명</label>
                            <input type="password" name="userpassword2" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="username" class="form-label">목표 금액</label>
                            <input type="text" name="username" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="phone" class="form-label">제목</label>
                            <input type="text" name="phone" class="form-control" onblur="validatePhoneNumber()" />
                        </div>
                        <div class="signup">
                            <label for="useremail" class="form-label">신청 날짜</label>
                            <input type="email" name="useremail" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="useraccesstoken" class="form-label">마감일</label>
                            <input type="text" name="useraccesstoken" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="userrefreshtoken" class="form-label">상세내용</label>
                            <input type="text" name="userrefreshtoken" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="userseqno" class="form-label">카테고리 선택</label>
                            <input type="text" name="userseqno" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="userseqno" class="form-label">리워드</label>
                            <input type="text" name="userseqno" class="form-control" />
                            <input type="text" name="userseqno" class="form-control" />
                            <input type="text" name="userseqno" class="form-control" />
                            <input type="text" name="userseqno" class="form-control" />
                            <input type="submit" value="추가" class="btn" />
                        </div>
                        <input type="submit" value="등록" class="btn" />
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>