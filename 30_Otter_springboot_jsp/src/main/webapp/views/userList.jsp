<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
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
<%
 	List<UserDto> list=(List<UserDto>)request.getAttribute("list");
%>
<meta charset="UTF-8">
<title>Insert title here</title>

<style type="text/css">
h2{
	margin-top: 20px;
}

</style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
   <div class="container px-4 px-lg-5">
       <a class="navbar-brand" href="#!">Otter</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
               <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                   <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
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
	            <form class="d-flex">
				                &nbsp;
				                <a class="btn btn-outline-darkk" type="submit" href="/user/manage">
				                    <i class="bi-cart-fill me-1"></i>
				                    회원관리
				                </a>  
				                &nbsp;
				                <a class="btn btn-outline-darkk" type="submit" href="/project/manage">
				                    <i class="bi-cart-fill me-1"></i>
				                    프로젝트 관리
				                </a>
				                &nbsp;
				                <a class="btn btn-outline-darkk" type="submit" href="/user/logout">
				                    <i class="bi-cart-fill me-1"></i>
				                    로그아웃
				                </a> 
				            </form>
		</div>
   </div>
</nav>

<section class="pyyy-5">
      <div class="container myy-5">
         <div class="roww justify-content-center">
            <div class="coll-lg-6">
			    <div class="contents">
			        <h2>전체회원목록</h2>
			        <br />
			        <div id="getUserList">
			            <table class="table2">
			                <tr>
			                    <th>회원번호</th>
			                    <th>아이디</th>
			                    <th>이름</th>
			                    <th>연락처</th>
			                    <th>이메일</th>
			                    <th>회원등급</th>
			                    <th>탈퇴여부</th>
			                </tr>
							<%
							    if (list == null || list.isEmpty()) {
							%>
							    <tr>
							        <td colspan="8">-- 가입된 회원이 없습니다. --</td>
							    </tr>
							<%
							    } else {
							        for (UserDto dto : list) {
							%>
							            <tr>
							                <td><%= dto.getSeq() %></td>
							                <td>
							                    <a href='/user/userRoleForm?id=<%= dto.getId() %>'>
							                        <span><%= dto.getId() %></span>
							                    </a>
							                </td>
							                <td><%= dto.getUsername() %></td>
							                <td><%= dto.getPhone() %></td>
							                <td><%= dto.getUseremail() %></td>
							                <td><%= dto.getRole() %></td>
							                <td><%= (dto.getDelflag().equals("Y") ? "탈퇴" : "유저") %></td>
							            </tr>
							<%
							        }
							    }
							%>
			            </table>
			        </div>
			    </div>
			</div>
		</div>
	</div>
</section>
</body>
</html>