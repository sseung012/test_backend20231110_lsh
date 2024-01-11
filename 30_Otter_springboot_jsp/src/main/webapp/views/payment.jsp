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
   RewardDto rdto = (RewardDto)request.getSession().getAttribute("rdto");
   boolean isAdmin = ldto != null && "ADMIN".equals(ldto.getRole());
//    boolean isProductNotApproved = dto != null && "N".equals(dto.getProduct_check());
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
    .form-control[readonly] {
        background-color: #f8f9fa; /* Use your preferred background color */
        border: 1px solid #ced4da; /* Use your preferred border color */
    }
</style>
<script type="text/javascript">

function findAddr(){
	new daum.Postcode({
        oncomplete: function(data) {
        	
        	console.log(data);
        	
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var jibunAddr = data.jibunAddress; // 지번 주소 변수
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('address1').value = data.zonecode;
            if(roadAddr !== ''){
                document.getElementById("address2").value = roadAddr;
            } 
            else if(jibunAddr !== ''){
                document.getElementById("address2").value = jibunAddr;
            }
        }
    }).open();
}







</script>
<!-- 주소록 API를 사용하기 위해 join.jsp에 외부 스크립트 파일을 연결하는 코드 -->
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>


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
			                <a class="btn btn-outline-darkk" type="submit" href="/user/myinfo">
				                <i class="bi-cart-fill me-1"></i>
				                나의 정보
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
                <h1>펀딩 상품 결제</h1>
                    <form action="/banking/orderSave" method="post">
                    	<input type="hidden" name="seq" value="${dto.seq}"/>
<!--                     enctype="multipart/form-data"> -->
                    	<input type="hidden" name="user_id" value="${ldto.id}"/>
                    	<div class="addProduct">                          
<!--                             <input type="hidden" name="seq"/> -->
                        </div>&nbsp;                        
                        <div class="payment">                     
                            <input type="hidden" name="user_seq" value="${ldto.seq}" />
                        </div>&nbsp;
                                  
                        <div class="payment">
                            <label for="user_name" class="form-label" style="font-weight:bold; font-size:18px;">주문자</label>
                            <input type="text" name="user_name" class="form-control" value="${ldto.username}" readonly="readonly" />
                        </div>&nbsp;
                        <div class="payment"> 

                            <label for="title" class="form-label" style="font-weight:bold; font-size:18px;">주문상품</label>
                            <input type="text" name="title" class="form-control" value="${param.title}" readonly="readonly"/>

                        </div>&nbsp;     
<!--                         <div class="payment"> -->
<!--                             <label for="reward_name" class="form-label">선택한 리워드</label> -->
<%--                             <input type="text" name="reward_name" class="form-control" value="${reward_name[0]} ${count[0]}개" /> --%>
<!--                         </div>&nbsp; -->

						<div class="payment">
						    <label for="reward_name" class="form-label" style="font-weight:bold; font-size:18px;">선택한 리워드</label>
						    <c:forEach var="i" begin="0" end="${fn:length(reward_name) - 1}">
						        <input type="text" name="select_reward" class="form-control" readonly="readonly"
						               value="${reward_name[i]} ${count[i]}개" />
						    </c:forEach>
						</div><br/> 
 
						<div class="payment">         
							<div class="address" style="font-weight:bold; font-size:18px;">배송지 입력</div>
							<input id="address1" name="address1" style="width:200px;" readonly="readonly" placeholder="우편번호"> <a class="btn btn-primary" onclick="findAddr()">주소 찾기</a><br>
							<input id="address2" name="address2" style="width:500px;" readonly="readonly" placeholder="주소">
							<br>
							<input id="address3" name="address3" style="width:500px;" placeholder="상세주소">
						</div>
						<br/>
                        <div class="payment">
                            <label for="phone" class="form-label" style="font-weight:bold; font-size:18px;">전화번호</label>
                            <input type="text" name="phone" class="form-control" value="${ldto.phone}"/>
                        </div>&nbsp;
                        <div class="payment" id="payment">
                            <label for="payment_amount" class="form-label" style="font-weight:bold; font-size:18px;">결제금액</label>
                            <input type="text" name="total_price" class="form-control" value="${param.total_price}" readonly="readonly"/>
								 						
                        </div>&nbsp; 
                        
                        <div class="payment">
<!--                             <label for="order_date" class="form-label" style="font-weight:bold; font-size:18px;">주문날짜</label> -->
                            <div id="order_date">
							    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.29.1/moment.min.js"></script>
							    <script>
							        const formattedDate = moment().format('YYYY-MM-DD');
							        document.getElementById("order_date").innerHTML = formattedDate.style.display="none";
							    </script>
							</div>
<!--                             <input type="date" name="order_date" id="order_date" class="form-control"/> -->
							
                        </div>&nbsp;
                        
                        <br><br>
        
<!-- 								<div id="payment-method"></div> -->
<!-- 								<div id="agreement"></div> -->
<!-- 								<a class="btn btn-outline-darkk" type="submit" href="/banking/orderSave"> -->
<!-- 				                <i class="bi-cart-fill me-1"></i> -->
<!-- 				                DB저장 -->
<!-- 				            	</a> -->
								<button type="submit" id="orderSave" class="btn btn-primary">다음</button>
<!-- 								<button type="button" id="payment-button" class="btn btn-primary">결제하기</button> -->
				
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