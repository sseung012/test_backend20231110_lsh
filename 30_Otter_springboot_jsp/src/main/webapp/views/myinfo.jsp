<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.hk.otter.dtos.UserDto" %>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>
<head>
<%
	UserDto ldto = (UserDto)request.getSession().getAttribute("ldto");
%>
<meta charset="UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Otter</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!--         Bootstrap icons -->
<!--         <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" /> -->
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />
</head>
<script type="text/javascript">
    function delUser() {
        var isConfirmed = confirm("회원 탈퇴하시겠습니까?");

        if (isConfirmed) {
            $.ajax({
                url: "/user/delUser",
                method: "GET",
                data: {},
                dataType: "json",
                success: function(data) {
                    if (data.delUser) {
                        alert("회원 탈퇴가 성공적으로 이루어졌습니다.");
                        window.location.href = "/"; // 메인 페이지로 리다이렉트
                    } else {
                        alert("회원 탈퇴에 실패했습니다. 다시 시도해주세요.");
                    }
                },
                error: function() {
                    alert("서버와의 통신 중 오류가 발생했습니다.");
                }
            });
        }
    }
</script>

<body >
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
   <div class="container px-4 px-lg-5">
       <a class="navbar-brand" href="/">Otter</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
               <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                   <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                    <li class="nav-item dropdown">
                       <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Shop</a>
                           <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                               <li><a class="dropdown-item" href="#!">전체</a></li>
                                <li><hr class="dropdown-divider" /></li>
                                <li><a class="dropdown-item" href="#!">홈/리빙</a></li>
                                <li><a class="dropdown-item" href="#!">패션/잡화</a></li>
                                <li><a class="dropdown-item" href="#!">뷰티</a></li>
                                <li><a class="dropdown-item" href="#!">푸드</a></li>
                                <li><a class="dropdown-item" href="#!">출판</a></li>
                                <li><a class="dropdown-item" href="#!">반려동물</a></li>
                            </ul>
	               </li>
	            </ul>
            
			
				<%
				    if ("USER".equals(ldto.getRole())) {
				%>
					<!-- ADMIN이 아닌 경우의 버튼들 -->
			            <form class="d-flex">
			                &nbsp;
			                <a class="btn btn-outline-darkk" type="submit" href="/product/insertProductForm">
			                    <i class="bi-cart-fill me-1"></i>
			                    프로젝트 만들기
			                </a> 
			                &nbsp;
			                <a class="btn btn-outline-darkk" type="submit" href="/user/logout">
			                    <i class="bi-cart-fill me-1"></i>
			                    로그아웃
			                </a> 
			            </form>
				<%
				        }
				%>

 
         </div>
   </div>
</nav>
       
<section class="pyy-5">
      <div class="container myy-5">
         <div class="roww justify-content-center">
            <div class="coll-lg-6">
            	<div class="contents">
					<h1>나의 정보</h1>
					<div id="myinfo">
						<form action="/user/updateUser" method="post">
							<input type="hidden" name="id" value="${ldto.id}"/>
							<table class="table1">
								<tr>
									<th>아이디</th>
									<td>
										<input type="text" name="id" value="${dto.id}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
								    <th>이름</th>
								    <td>
								    	<input type="text" name="username" value="${dto.username}" readonly="readonly" class="form-control1"/>
								    </td>
								</tr>
								<tr>
								    <th>연락처</th>
								    <td>
								        <input type="text" name="phone" value="${dto.phone}" class="form-control"/>
								    </td>
								</tr>
								<tr>
								    <th>이메일</th>
								    <td>
								        <input type="email" name="useremail" value="${dto.useremail}" class="form-control"/>
								    </td>
								</tr>
								<tr>
									<th>등급</th>
									<td>
										<input type="text" name="role" value="${dto.role}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
									<th>탈퇴여부</th>
									<td>
										<input type="text" name="delflag" value="${dto.delflag}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="button" value="탈퇴" onclick="delUser('${ldto.id}')" class="btn btn-outline-darkk" style="float:right; margin-left:5px;" />
										<input type="submit" value="수정" class="btn btn-outline-darkk" style="float:right;"/>
									</td>
								</tr> 
							</table>
						</form>
					</div>
				</div>
            </div>
         </div>
      </div>
   </section>
</body>
</html>