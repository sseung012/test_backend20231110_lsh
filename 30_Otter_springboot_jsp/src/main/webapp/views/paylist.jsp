<%@page import="com.hk.otter.dtos.OrderDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
request.setCharacterEncoding("utf-8");
%>
<%
response.setContentType("text/html; charset=UTF-8");
%>
<%@ page import="com.hk.otter.dtos.ProductDto" %>
<%@ page import="com.hk.otter.dtos.UserDto" %>
<%@ page import="com.hk.otter.dtos.OrderDto" %>
<%@ page import="org.springframework.web.bind.annotation.RequestParam" %>
<%@ page import="org.springframework.web.bind.annotation.ModelAttribute" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<%
	List<OrderDto> list=(List<OrderDto>)request.getAttribute("list");
%>
<%
	UserDto ldto = (UserDto)request.getSession().getAttribute("ldto");
	ProductDto dto = (ProductDto)request.getSession().getAttribute("dto");
// 	OrderDto odto = (OrderDto)request.getSession().getAttribute("odto");
%>

<title>Otter</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!--         Bootstrap icons -->
<!--         <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" /> -->
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />

</head>

<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
   <div class="container px-4 px-lg-5">
       <a class="navbar-brand" href="/">Otter</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
               <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
<!--                    <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Home</a></li> -->
<!--                     <li class="nav-item"><a class="nav-link" href="#!">About</a></li> -->
                    <li class="nav-item dropdown">
                       <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Category</a>
                           <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
	                            <li><a class="dropdown-item" href="/product/category">전체</a></li>
	                            <li><hr class="dropdown-divider" /></li>
	                            <li><a class="dropdown-item" href="/product/category?cate_seq=1">홈/리빙</a></li>
	                            <li><a class="dropdown-item" href="/product/category?cate_seq=2">패션/잡화</a></li>
	                            <li><a class="dropdown-item" href="/product/category?cate_seq=3">뷰티</a></li>
	                            <li><a class="dropdown-item" href="/product/category?cate_seq=4">푸드</a></li>
	                            <li><a class="dropdown-item" href="/product/category?cate_seq=5">출판</a></li>
	                            <li><a class="dropdown-item" href="/product/category?cate_seq=6">반려동물</a></li>
	                            <li><a class="dropdown-item" href="/product/category?cate_seq=7">기타</a></li>
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
			                <a class="btn btn-outline-darkk" type="submit" href="/product/myProject">
			                    <i class="bi-cart-fill me-1"></i>
			                    나의정보
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
      <div class="container myy-51">
         <div class="roww justify-content-center">
            <div class="coll-lg-6">
            	<div class="contents">
			        <h1>참여한 펀딩</h1>
			        <br />
			        <div id="paylist">
			            <table class="table2" style="width:1200px;">
			                <tr>
			                    <th>제목</th>
			                    <th>선택한 리워드</th>
			                    <th>총 개수</th>
			                    <th>총 결제금액</th>
			                    <th>주문날짜</th>
			                </tr>
								<%
							    if (list == null || list.isEmpty()) { 
							%>
							    <tr>
							        <td colspan="8">-- 참여한 펀딩이 없습니다. --</td>
							    </tr>
							<%
							    } else {
							        for (OrderDto odto : list) {
							%>
							            <tr>
							                <td>
							                    <a href='/banking/orderDetail/<%= odto.getSeq() %>'>  
							                        <span><%= odto.getTitle() %></span>
							                    </a>
							                </td>
							                <td><%= odto.getSelect_reward() %></td>
							                <td><%= odto.getSelect_amount() %></td>
							                <td><%= odto.getTotal_price() %>원</td> 
							                <td><%= odto.getOrder_date() %></td>
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
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="resources/js/scripts.js"></script>
</body>
</html>