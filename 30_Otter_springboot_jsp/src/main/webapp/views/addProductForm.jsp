<%@page import="com.hk.otter.dtos.ProductDto"%>
<%@page import="com.hk.otter.dtos.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html> 
<head>
<%
	UserDto ldto = (UserDto)request.getSession().getAttribute("ldto");
	ProductDto dto = (ProductDto)request.getSession().getAttribute("dto");
%>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Otter</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />
   	
<script type="text/javascript">
//현재 날짜 나타내기
window.onload = function() {
   today = new Date();
   console.log("today.toISOString() >>>" + today.toISOString());
   today = today.toISOString().slice(0, 10);
   console.log("today >>>> " + today);
   bir = document.getElementById("created_date");
   bir.value = today;
}

let rewardAddCount = 0;

const add_textbox = () => {
    if (rewardAddCount < 2) {
        const box = document.getElementById("rewardbox");
        const addRewardForm = document.getElementsByClassName("addReward")[0];
        const rewardEle = addRewardForm.cloneNode(true);
        rewardEle.children[1].value = "";  // 리워드 제목 입력란
        rewardEle.children[2].value = "";  // 리워드 가격 입력란
        rewardEle.children[3].value = "";  // 리워드 설명 입력란
        rewardEle.children[4].value = "";  // 리워드 수량 입력란
        box.append(rewardEle);

        rewardAddCount++; 

        // 만약 특정 횟수에 도달하면 추가 버튼을 비활성화
        if (rewardAddCount === 2) {
            document.getElementById('addButton').disabled = true;
        }
    }
}
const remove = (obj) => {
    document.getElementById('rewardbox').removeChild(obj.parentNode);
}
</script>

<!-- ckeditor 추가 -->
<script src="//cdn.ckeditor.com/4.22.1/standard/ckeditor.js">
	


</script>

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
                <h1>펀딩 상품 등록</h1>
                    <form action="/product/insertProduct" method="post" 
                    enctype="multipart/form-data">
                    	<input type="hidden" name="id" value="${ldto.id}"/>
                    	<div class="addProduct">                          
<!--                             <input type="hidden" name="seq"/> -->
                        </div>&nbsp;                        
                        <div class="addProduct">                     
                            <input type="hidden" name="user_seq" value="${ldto.seq}" />
                        </div>&nbsp;
                                  
                        <div class="addProduct">
                            <label for="img" class="form-label">대표 이미지</label>
                            <input type="file" name="img" class="form-control" />
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="maker" class="form-label">회사명</label>
                            <input type="text" name="maker" class="form-control" />
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="goal_price" class="form-label">목표 금액</label>
                            <input type="text" name="goal_price" class="form-control" />
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="title" class="form-label">제목</label>
                            <input type="text" name="title" class="form-control" />
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="created_date" class="form-label">신청 날짜</label>
                            <input type="date" name="created_date" id="created_date" class="form-control" />
							
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="close_date" class="form-label">마감일</label>
                            <input type="date" name="close_date" class="form-control" />
                        </div>&nbsp;
                        <div class="addProduct" id="addProduct">
                            <label for="content" class="form-label">상세내용</label>
                            <textarea id = "content" name = "content"></textarea>
							<script>CKEDITOR.replace('content',
									{filebrowserUploadUrl:'/file/imageUpload.do'});</script>
<!--                             <input type="text" name="content" class="form-control" style="height:300px; width:510px;"/> -->
								 						
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="userseqno" class="form-label">카테고리 선택</label>
                            <select name="cate_seq" id="category">
                            	<option>-- 카테고리 선택 --</option>
                            	<option>전체</option>
                            	<option value="1">홈/리빙</option>
                            	<option value="2">패션/잡화</option>
                            	<option value="3">뷰티</option>
                            	<option value="4">푸드</option>
                            	<option value="5">출판</option>
                            	<option value="6">반려동물</option>
                            	<option value="7">기타</option>
                            </select>
                        </div>&nbsp;
                        <div  id="rewardbox">
                        	<div class="addReward">
	                            <label for="userseqno" class="form-label">리워드</label>
	                            <input type="text" name="reward_name" class="form-control" placeholder="리워드 제목" />&nbsp;
	                            <input type="text" name="price" class="form-control" placeholder="리워드 가격(숫자만 입력해주세요)"/>&nbsp;
	                            <input type="text" name="combination" class="form-control" placeholder="리워드 설명"/>&nbsp;
	                            <input type="number" name="stock" class="form-control" placeholder="리워드 수량"/>
                        	</div>
                        </div>   
                        <input type="button" value="추가" class="btn btn-outline-dark" onclick="add_textbox()" />
<!--                             <input type="submit" value="삭제" class="btn btn-outline-dark" /> -->
                        <br><br>
                        <input type="submit" value="프로젝트 등록" class="btn btn-primary" />
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