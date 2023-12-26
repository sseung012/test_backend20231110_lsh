<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.hk.otter.dtos.UserDto" %>
<!DOCTYPE html>
<html>
<head>
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

<%
 	List<UserDto> list=(List<UserDto>)request.getAttribute("list");
%>

</head>

<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
   <div class="container px-4 px-lg-5">
       <a class="navbar-brand" href="/">Otter</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
               <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                   <li class="nav-item"><a class="nav-link active" aria-current="page"></a></li>
                    <li class="nav-item"><a class="nav-link"></a></li>
                    <li class="nav-item dropdown">
                       <ul class="dropdown-menu" aria-labelledby="navbarDropdown"></ul>
	               </li>
	            </ul>
            	<form class="dd-flex">
					&nbsp;
					<a class="btn btn-outline-darkk" type="submit" href="/user/manage" >
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
      <div class="container myyy-5">
         <div class="rowww justify-content-center">
            <div class="coll-lg-6">
            	<div class="contents">
			        <h1>전체회원목록</h1>
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