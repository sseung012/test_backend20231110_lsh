<%@page import="com.hk.otter.dtos.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Base64"%>
<%@ page import="java.util.Base64.Encoder"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.net.URL" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.Reader" %>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <%
	UserDto ldto = (UserDto)request.getSession().getAttribute("ldto");
	%>
    <meta charset="utf-8" />
    <!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="/resources/css/styles.css" rel="stylesheet" />
	<style>
		.complete {
  		text-align : center;
  		padding : 100px 0; 		
  		}	
	</style>
  </head>
  <body>
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
	<br/>
	<form action="/confirm" method="post">
	<input type="hidden" name="orderId" value="${ORDER_ID}"/>
	<input type="hidden" name="paymentKey" value="${PAYMENT_KEY}"/>
		<div class='complete'>
	    <h2>펀딩이 완료되었습니다. 감사합니다 :)</h2>
	    <br/>
	    <p style="font-weight:bold;" id="orderId"></p>
	    <br/>
	    <p>해당 펀딩 상품의 주문, 배송정보는 이메일과</p>
	    <p>카카오톡 또는 SMS로 안내 드리겠습니다.</p>
	<!--     <p id="paymentKey"></p> -->
		<br/>
		<p style="font-weight:bold;">총 결제금액</p>
	    <p style="font-weight:bold;" id="amount"></p>
<!--     		<button type="button" id="confirm" class="btn btn-primary">결제완료</button> -->
    	</div>
    </form>

    <script>
      // 쿼리 파라미터 값이 결제 요청할 때 보낸 데이터와 동일한지 반드시 확인하세요.
      // 클라이언트에서 결제 금액을 조작하는 행위를 방지할 수 있습니다.
      const urlParams = new URLSearchParams(window.location.search);
      const orderId = urlParams.get("orderId");
      const paymentKey = urlParams.get("paymentKey");
      const amount = urlParams.get("amount");

      async function confirm() {
        const requestData = {
          orderId: orderId,
          paymentKey: paymentKey,
          amount: amount,
        };

        const response = await fetch("/confirm", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(requestData),
        });

        const json = await response.json();

        if (!response.ok) {
          // 결제 실패 비즈니스 로직을 구현하세요.
          console.log(json);
          window.location.href = `/fail?message=${json.message}&code=${json.code}`;
        }

        // 결제 성공 비즈니스 로직을 구현하세요.
        console.log(json);
      }
      confirm();

		
	  
      const orderIdElement = document.getElementById("orderId");
      const paymentKeyElement = document.getElementById("paymentKey");
      const amountElement = document.getElementById("amount");
      
      orderIdElement.textContent = "주문번호: " + orderId;
      amountElement.textContent = amount + "원";
      paymentKeyElement.textContent = "paymentKey: " + paymentKey;
      
    </script>

  </body>
</html>



