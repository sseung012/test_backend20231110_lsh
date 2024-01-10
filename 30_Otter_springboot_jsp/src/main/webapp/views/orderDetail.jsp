<%@page import="com.hk.otter.dtos.OrderDto"%>
<%@ page import="com.hk.otter.dtos.RewardDto"%>
<%@page import="com.hk.otter.dtos.ProductDto"%>
<%@page import="com.hk.otter.dtos.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html> 
<head>
<%
   UserDto ldto = (UserDto)request.getSession().getAttribute("ldto");
   ProductDto dto = (ProductDto)request.getSession().getAttribute("dto");
   OrderDto odto = (OrderDto)request.getSession().getAttribute("odto");
%>
<meta charset="utf-8" />
 <script src="https://js.tosspayments.com/v1/payment-widget"></script>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Otter</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />
<style>
   th {
   		font-size:18px;
   }
</style>
<script type="text/javascript">

</script>
<!-- 주소록 API를 사용하기 위해 join.jsp에 외부 스크립트 파일을 연결하는 코드 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


</head>
<body >
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
   <div class="container px-4 px-lg-5">
       <a class="navbar-brand" href="/">Otter</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
               <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                   <li class="nav-item"><a class="nav-link active" aria-current="page" href="/">Home</a></li>
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
			                    내 프로젝트
			                </a> 
			                &nbsp;
			                <a class="btn btn-outline-darkk" type="submit" href="/banking/paylist">
			                    <i class="bi-cart-fill me-1"></i>
			                    결제내역
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
      <div class="container mmmy-5" style="width:800px; height:700px;">
         <div class="roww justify-content-center">
            <div class="coll-lg-6">
            	<div class="contents">
					<h1>결제 내역</h1><br/>
					<div id="orderDetail">
						<form>
							<input type="hidden" name="id" value="${odto.seq}"/>
							<table class="table1">
								<tr>
									<th>아이디</th>
									<td>
										<input type="text" name="id" value="${odto.user_id}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
								    <th>이름</th>
								    <td>
								    	<input type="text" name="user_name" value="${odto.user_name}" readonly="readonly" class="form-control1"/>
								    </td>
								</tr>
								<tr>
								    <th>제목</th>
								    <td>
								        <input type="text" name="phone" value="${odto.title}" class="form-control1"/>
								    </td>
								</tr>
								<tr>
								    <th>선택한 리워드</th>
								    <td>
								        <input type="email" name="useremail" value="${odto.select_reward}" class="form-control1"/>
								    </td>
								</tr>
								<tr>
									<th>총 개수</th>
									<td>
										<input type="text" name="role" value="${odto.select_amount}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
									<th>총 금액</th>
									<td>
										<input type="text" name="delflag" value="${odto.total_price}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
									<th>주문 날짜</th>
									<td>
										<input type="text" name="delflag" value="${odto.order_date}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
									<th>주소</th>
									<td>
										<input type="text" name="delflag" value="${odto.address}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
									<th>전화번호</th>
									<td>
										<input type="text" name="delflag" value="${odto.phone}" readonly="readonly" class="form-control1"/>
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
<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="resources/js/scripts.js"></script>
</body>
</html>