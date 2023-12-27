<%@page import="com.hk.otter.dtos.ProductDto"%>
<%@ page import="com.hk.otter.dtos.UserDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>productDetail</title>
        <script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
        <!-- Favicon-->
<!--         <link rel="icon" type="image/x-icon" href="assets/favicon.ico" /> -->
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="/resources/css/productdetail.css" rel="stylesheet" />
    </head>
    <%
   UserDto ldto = (UserDto)request.getSession().getAttribute("ldto");
   ProductDto dto = (ProductDto)request.getSession().getAttribute("dto");
   %>
   
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
   <div class="container px-4 px-lg-5">
       <a class="navbar-brand" href="/">Otter</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
         <div class="collapse navbar-collapse" id="navbarSupportedContent">
               <ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
                   <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                    <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                    <li class="nav-item dropdown">
                       <a class="nav-link dropdown-toggle" id="navbarDropdown" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Category</a>
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
                            <!-- Post title-->
<!--                             <h1 class="fw-bolder mb-1">ㅇㅇ</h1> -->
                            <!-- Post meta content-->
<!--                             <div class="text-muted fst-italic mb-2">Posted on January 1, 2023 by Start Bootstrap</div> -->
                            <!-- Post categories-->
                            <a class="badge bg-secondary text-decoration-none link-light" href="#!">카테고리 이름</a>
<!--                             <a class="badge bg-secondary text-decoration-none link-light" href="#!">Freebies</a> -->
                        </header>   
                           
                           
                        <!-- Preview image figure-->
<!--                         <figure class="mb-4"><img class="img-fluid rounded" src="https://dummyimage.com/900x400/ced4da/6c757d.jpg" alt="..." /></figure> -->
                        	 <tr>
                        	 <td>
								<img src="../upload/${dto.img}"/>
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
<!-- 								<input class="form-control" type="text" ></input> -->
<!--                                 <button class="btn btn-primary" id="button-search" type="button">Go!</button> -->
							<tr>
							<td><h2 style="font-weight:bold;">${dto.title}</h2></td>
							</tr>
							<br/>
							<tr>
							<td>${dto.maker}</td>
							</tr>
							<br/>
							<tr>
							<td>${dto.goal_price}원 목표</td>
							</tr>
							<br/>
							<tr>
							<td>${dto.total_price}원 달성</td>
							</tr>
							<br/>
							<tr>
							<td>${dto.remainingdays}</td>
							</tr>
                            </div>
<!--                         </div> -->
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
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script>
    </body>
</html>