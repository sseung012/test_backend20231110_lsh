<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.hk.otter.dtos.ProductDto" %>
<%@ page import="com.hk.otter.dtos.UserDto" %>
<%@ page import="org.springframework.web.bind.annotation.RequestParam" %>
<%@ page import="org.springframework.web.bind.annotation.ModelAttribute" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
 	List<ProductDto> list=(List<ProductDto>)request.getAttribute("list");
%>
<%
	UserDto ldto = (UserDto)request.getSession().getAttribute("ldto");
	ProductDto dto = (ProductDto)request.getSession().getAttribute("dto");
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
        



<section class="pyyy-5">
      <div class="container myyy-5">
         <div class="rowww justify-content-center">
            <div class="coll-lg-6">
            	<div class="contents">
			        <h1>프로젝트 목록</h1>
			        <br />
			        <div id="getProductList">
			            <table class="table2">
						    <tr>
						        <th>글번호</th>
						        <th>카테고리</th>
						        <th>제목</th>
						        <th>회사명</th>
						        <th>승인요청일</th>
						        <th>승인일</th>
						        <th>마감일</th>
						        <th>승인상태</th>
						        <th>남은날짜</th>
						    </tr>
	
						    <c:choose>
							    <c:when test="${ldto != null && !empty list}">
							        <c:forEach var="pdto" items="${list}">
							            <c:if test="${pdto.user_seq eq ldto.seq}">
							                <tr>
							                    <td>${pdto.seq}</td>
							                    <td>
							                        <c:set var="categoryName">
							                            <c:choose>
							                                <c:when test="${pdto.cate_seq eq 1}">홈/리빙</c:when>
							                                <c:when test="${pdto.cate_seq eq 2}">패션/잡화</c:when>
							                                <c:when test="${pdto.cate_seq eq 3}">뷰티</c:when>
							                                <c:when test="${pdto.cate_seq eq 4}">푸드</c:when>
							                                <c:when test="${pdto.cate_seq eq 5}">출판</c:when>
							                                <c:when test="${pdto.cate_seq eq 6}">반려동물</c:when>
							                                <c:otherwise>알 수 없음</c:otherwise>
							                            </c:choose>
							                        </c:set>
							                        ${categoryName}
							                    </td>
							                    <td>
							                        <a href='/product/productDetail/${pdto.seq}'>
							                            <span>${pdto.title}</span>
							                        </a>
							                    </td>
							                    <td>${pdto.maker}</td>
							                    <td>
													${pdto.created_date}
							                    </td>
							                    <td>
							                    	${pdto.open_date}
							                    </td>
							                    <td>${pdto.close_date}</td>
							                    <td style="<c:if test='${pdto.product_check eq "N"}'>color: red;</c:if>">
							                        ${pdto.product_check eq "Y" ? "승인완료" : "승인대기"}
							                    </td>
							                    <c:choose>
													<c:when test="${pdto.remainingDays lt 0}">
												        <td>마감</td>
												    </c:when>
												    <c:otherwise>
												        <td>${pdto.remainingDays}</td>
												    </c:otherwise>
						                        </c:choose> 
							                </tr>
							            </c:if>
							        </c:forEach>
							    </c:when>
							    <c:otherwise>
							        <tr>
							            <td colspan="8">-- 로그인 오류 또는 프로젝트 없음 --</td>
							        </tr>
							    </c:otherwise>
							</c:choose>
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