<%@ page import="com.hk.otter.dtos.RewardDto"%>
<%@ page import="com.hk.otter.dtos.ProductDto"%>
<%@ page import="com.hk.otter.dtos.UserDto" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>productDetail</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
        <script type="text/javascript">
//            function approve() {
//                // 승인 버튼을 눌렀을 때 실행되어야 할 로직을 여기에 추가
//                alert('프로젝트를 승인합니다.'); // 예시로 경고창을 띄우는 코드
//                // 실제로 서버로 승인 요청을 보내거나 다른 로직을 수행해야 합니다.
//            }


			
			 $(document).ready(function(){
        		// $("#description").val().replace()
        		
//         		calculateTotalPrice();
        		
        		<!-- count 값이 변경될때마다 호출 -->
//         		$("#count").change(function(){
//         			calculateTotalPrice();//         		
// 				});

// 				$(".count").on('keyup', function(e){
// 					var amount = (10000 * $(".count").val());
// 					alert(amount);
// 				});




        		$("#reward_name").change(function(){
// 					alert($("#reward_name option:selected").text());	
					var seq=$("#reward_name").val();
// 					alert($("#test > ."+seq).text());
					if($("#test > ."+seq).text() == ""){
						
						var optionSelTxt=$("#reward_name option:selected").text();
						var optionPrice=$("#reward_name option:selected").text().split("_");
// 						console.log(optionPrice[0]);
						
// 						int total = 0;
// 						for (var i = 0; i < $("#count").length; i++) {
// 							var total = parseInt(optionPrice[1].replace("원", " ").text()) * count;
// 						}

						var countEle=
							'<div class="'+seq+'">'+optionSelTxt+'</div>'
							+'<input type="number" id="count" name="count" class="form-class"' 
	                    	+'placeholder="수량" value="1" style="max-width: 5rem" min="1"/>'
// 	                    	+'<input type="text" id="per" name="per" class="form-control"/>'
	                    	+'<div class="'+seq+'">'+ parseInt(optionPrice[1].replace("원", " ")) +'</div>';
	                   $("#test").append(countEle); 							
					}else{
						alert("이미 추가했어요");
					}
				});
				
				
        	});

			<!-- 총 상품 금액 계산 -->
// 		    function calculateTotalPrice(){
		
// 		        var count = $("#count").val();
// 		        var price = $("#price").val();
		
// 		        var total_price = price*count;
// 		        $("#total_price").html(totalPrice + '원');
// 		    }

           
        </script>
        <!-- Favicon-->
<!--         <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/resources/css/productdetail.css" rel="stylesheet" />
        
    </head>
    <%
   UserDto ldto = (UserDto)request.getSession().getAttribute("ldto");
   ProductDto dto = (ProductDto)request.getSession().getAttribute("dto");
   RewardDto rdto = (RewardDto)request.getSession().getAttribute("rdto");
   boolean isAdmin = ldto != null && "ADMIN".equals(ldto.getRole());
//    boolean isProductNotApproved = dto != null && "N".equals(dto.getProduct_check());
   %>
   
    <body>
        <!-- Responsive navbar-->
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
                if (ldto == null) {
            %>
                <!-- 로그인되지 않은 경우의 버튼들 -->
                <form class="d-flex">
                    &nbsp;
                    <a class="btn btn-outline-dark" type="submit" href="/user/signin">
                        <i class="bi-cart-fill me-1"></i>
                        로그인/회원가입
                    </a> 
                    &nbsp; 
                </form>
            <%
                } else {
                    if ("ADMIN".equals(ldto.getRole())) {
            %>
                        <!-- ADMIN인 경우의 버튼들 -->
                        <form class="d-flex">
                            &nbsp;
                            <a class="btn btn-outline-darkk" type="submit" href="/user/manage">
                                <i class="bi-cart-fill me-1"></i>
                                회원관리
                            </a>  
                            &nbsp;
                            <a class="btn btn-outline-darkk" type="submit" href="/product/productList">
                                <i class="bi-cart-fill me-1"></i>
                                프로젝트 관리
                            </a>
                            &nbsp;
                            <a class="btn btn-outline-darkk" type="submit" href="/user/logout">
                                <i class="bi-cart-fill me-1"></i>
                                로그아웃
                            </a> 
                        </form>
            <% 
                    } else {
            %>
                        <!-- ADMIN이 아닌 경우의 버튼들 -->
                        <form class="d-flex">
                            &nbsp;
                            <a class="btn btn-outline-darkk" type="submit" href="/product/insertProductForm">
                                <i class="bi-cart-fill me-1"></i>
                                프로젝트 만들기
                            </a> 
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
                }
            %>

 
         </div>
   </div>
</nav>

        <!-- Page content-->
        <div class="container mt-5">
            <div class="row">
                <div class="col-lg-8">
                    <!-- Post content-->
                    <article>
                        <!-- Post header-->
                           
                       <header class="mb-4">
                       <c:choose>
                           <c:when test="${dto != null && dto.cate_seq eq 1}">
                               <a class="badge bg-secondary text-decoration-none link-light" href="#!">홈/리빙</a>
                           </c:when>
                           <c:when test="${dto != null && dto.cate_seq eq 2}">
                               <a class="badge bg-secondary text-decoration-none link-light" href="#!">패션/잡화</a>
                           </c:when>
                           <c:when test="${dto != null && dto.cate_seq eq 3}">
                               <a class="badge bg-secondary text-decoration-none link-light" href="#!">뷰티</a>
                           </c:when>
                           <c:when test="${dto != null && dto.cate_seq eq 4}">
                               <a class="badge bg-secondary text-decoration-none link-light" href="#!">푸드</a>
                           </c:when>
                           <c:when test="${dto != null && dto.cate_seq eq 5}">
                               <a class="badge bg-secondary text-decoration-none link-light" href="#!">출판</a>
                           </c:when>
                           <c:when test="${dto != null && dto.cate_seq eq 6}">
                               <a class="badge bg-secondary text-decoration-none link-light" href="#!">반려동물</a>
                           </c:when>
                           <c:otherwise>
                               <a class="badge bg-secondary text-decoration-none link-light" href="#!">알수없음</a>
                           </c:otherwise>
                       </c:choose>
                   </header>
                              
                        <!-- Preview image figure-->
<!--                         <figure class="mb-4"><img class="img-fluid rounded" src="https://dummyimage.com/900x400/ced4da/6c757d.jpg" alt="..." /></figure> -->
                            <tr>
                            <td>
                        <img style="width:700px; height:400px;" src="/upload/${dto.img}"/>
                     </td>
                     </tr>
                        <!-- Post content-->
                        <section class="mb-5">
                            <tr>
                     <td><h4>${dto.content}</h4></td>
                     </tr>
                        </section>
                    </article>
                    <!-- Comments section-->
                    <section class="mb-5">
<!--                         <div class="card bg-light"> -->
<!--                             <div class="card-body"> -->
                                <!-- Comment form-->
<!--                                 <form class="mb-4"><textarea class="form-control" rows="3" placeholder="Join the discussion and leave a comment!"></textarea></form> -->
                                <!-- Comment with nested comments-->
                                <div class="d-flex mb-4">
                                    <!-- Parent comment-->
<!--                                     <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div> -->
<!--                                     <div class="ms-3"> -->
<!--                                         <div class="fw-bold">Commenter Name</div> -->
<!--                                         If you're going to lead a space frontier, it has to be government; it'll never be private enterprise. Because the space frontier is dangerous, and it's expensive, and it has unquantified risks. -->
                                        <!-- Child comment 1-->
<!--                                         <div class="d-flex mt-4"> -->
<!--                                             <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div> -->
<!--                                             <div class="ms-3"> -->
<!--                                                 <div class="fw-bold">Commenter Name</div> -->
<!--                                                 And under those conditions, you cannot establish a capital-market evaluation of that enterprise. You can't get investors. -->
<!--                                             </div> -->
<!--                                         </div> -->
                                        <!-- Child comment 2-->
<!--                                         <div class="d-flex mt-4"> -->
<!--                                             <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div> -->
<!--                                             <div class="ms-3"> -->
<!--                                                 <div class="fw-bold">Commenter Name</div> -->
<!--                                                 When you put money directly to a problem, it makes a good headline. -->
<!--                                             </div> -->
<!--                                         </div> -->
<!--                                     </div> -->
<!--                                 </div> -->
                                <!-- Single comment-->
<!--                                 <div class="d-flex"> -->
<!--                                     <div class="flex-shrink-0"><img class="rounded-circle" src="https://dummyimage.com/50x50/ced4da/6c757d.jpg" alt="..." /></div> -->
<!--                                     <div class="ms-3"> -->
<!--                                         <div class="fw-bold">Commenter Name</div> -->
<!--                                         When I look at the universe and all the ways the universe wants to kill us, I find it hard to reconcile that with statements of beneficence. -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </div> -->    
                        </div>
                    </section>
                </div>
                <!-- Side widgets-->
                <div class="col-lg-4">
                    <!-- Search widget-->
                    <div class="card mb-4">
<!--                         <div class="card-header">Search</div> -->
                        <div class="card-body">
                            <div class="input-group">
<!--                                 <input class="form-control" type="text" placeholder="Enter search term..." aria-label="Enter search term..." aria-describedby="button-search" /> -->
<!--                         <input class="form-control" type="text" ></input> -->
<!--                                 <button class="btn btn-primary" id="button-search" type="button">Go!</button> -->   
                     <c:choose>
                  <c:when test="${dto.remainingDays lt 0}">
                       <td><font color="red">마감된 상품</font></td>
                   </c:when>
                   <c:otherwise>
                       <td><font color="red">D-${dto.remainingDays}</font></td>
                   </c:otherwise>
                     </c:choose>
                <tr>
                     <td><h2 style="font-weight:bold;">${dto.title}</h2></td>
                </tr>
                <br/>
                     
                <tr>
                    <th>창작자</th>
                    <br/>
                    <td><strong>${dto.maker}</strong></td>
                </tr>
                <br/>
                     
                <tr>
                	<th>목표금액</th>
                	<td><strong>${dto.goal_price}원</strong></td>
                </tr>
                <br/>
                     
                <tr>
                	<th>모인금액</th>
                	<br/>
                    <td><strong>${dto.total_price}원</strong></td>
                </tr>
                <br/>
             </div>
<!--                         </div> -->
         </div>
                       
                    <!-- 리워드 선택 -->
                     <div class="rewardselect">
                            <select class="form-select" aria-label="Default select example" name="reward_name" id="reward_name">
                               <option>리워드 선택하기</option>

                               <c:forEach items="${rlist}" var="rlist">
                                   <option value="${rlist.seq}"> ${rlist.reward_name}_${rlist.price}원</option>
                                </c:forEach>
                            </select>                 
                    </div> 
                    <br/>
<!--                     <th>수량</th> -->
                    <div id="test"></div>
                    
                     <br/>
                     <tr>
                     	<th>총 금액</th>
                     	<input name="total_price" id="total_price" class="form-control" />
                     </tr>
                     <br/>
                     <tr>
                     	<td>배송비 ㅣ 무료</td>
                     </tr>
                     <button class="btn btn-primary" id="button-search" type="submit">펀딩 참여하기</button>
                    </div> 
                    <br/>
                    <br/>
                    
                    <div class="mb-3">
  						<h4><label for="exampleFormControlTextarea1" class="form-label">리워드 안내</label></h4>
  						<label class="form-control" id="exampleFormControlTextarea1" rows="3">
  							<c:forEach items="${rlist}" var="rlist">
  								   <p style="font-size:20px; font-weight:bold;">${rlist.price}원</p>
                                   <p style="font-size:20px;">${rlist.reward_name}</p>           
                                   <p>${rlist.combination}</p>
                                   <hr/>
                            </c:forEach>
  						
  						</label>
					</div>
                        
                       
 					<div>
						<c:choose>
				            <c:when test="${ldto != null && ldto.role eq 'ADMIN' && dto.product_check eq 'N' && dto != null }">
<!-- 				                <input class="btn btn-outline-darkk" id="approve" type="submit" value="승인" onclick="approve()"  -->
<!-- 				                    style="float:right; margin:10px; height:40px; width:100px;"/> -->
								<input type="hidden" name="id" value="${dto.seq}"/>
				            	<a class="btn btn-outline-darkk" id="approve" href="/product/approve/${dto.seq}"
   									style="float:right; margin:10px; height:40px; width:100px; font-size:17px; font-align:center; background-color:#DCFAFD;">승인</a>
				            </c:when>
				            <c:when test="${ldto == null}">
				                <!-- ldto가 null일 경우, 승인 버튼을 보이지 않게 함 -->
				            </c:when>
				            <c:otherwise>
				                <!-- 승인된 프로젝트일경우 승인 버튼을 보이지 않게 함 -->
				            </c:otherwise>
				        </c:choose>
 					</div>


				</div>


         
                        </div>

                    <!-- Categories widget-->
<!--                     <div class="card mb-4"> -->
<!--                         <div class="card-header">Categories</div> -->
<!--                         <div class="card-body"> -->
<!--                             <div class="row"> -->
<!--                                 <div class="col-sm-6"> -->
<!--                                     <ul class="list-unstyled mb-0"> -->
<!--                                         <li><a href="#!">Web Design</a></li> -->
<!--                                         <li><a href="#!">HTML</a></li> -->
<!--                                         <li><a href="#!">Freebies</a></li> -->
<!--                                     </ul> -->
<!--                                 </div> --> 
<!--                                 <div class="col-sm-6"> -->
<!--                                     <ul class="list-unstyled mb-0"> -->
<!--                                         <li><a href="#!">JavaScript</a></li> -->
<!--                                         <li><a href="#!">CSS</a></li> -->
<!--                                         <li><a href="#!">Tutorials</a></li> -->
<!--                                     </ul> -->
<!--                                 </div> -->
<!--                             </div> -->
<!--                         </div> -->
<!--                     </div> -->
                    <!-- Side widget-->
<!--                     <div class="card mb-4"> -->
<!--                         <div class="card-header">Side Widget</div> -->
<!--                         <div class="card-body">You can put anything you want inside of these side widgets. They are easy to use, and feature the Bootstrap 5 card component!</div> -->
<!--                     </div> -->
                </div> 
            </div>
        </div>
        </div>

        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>




