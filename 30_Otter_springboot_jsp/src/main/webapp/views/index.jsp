<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.hk.otter.dtos.UserDto" %>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> --%>
<!DOCTYPE html>
<html>

<head>
<%
	UserDto ldto = (UserDto)request.getSession().getAttribute("ldto");
    // 이제 ldto 변수를 사용할 수 있음
%>
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
<link href="resources/css/styles.css" rel="stylesheet" />
</head>

<body>
<!-- Navigation-->
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
            


<!--             	<form class="d-flex"> -->
<!-- 					&nbsp; -->
<!-- 					<a class="btn btn-outline-dark" type="submit" href="/user/signin"> -->
<!--                     <i class="bi-cart-fill me-1" ></i> -->
<!--                     	login/signUp -->
<!-- 					</a>  -->
<!-- 					&nbsp;  -->
<!-- 					<a class="btn btn-outline-dark" type="submit" href="/product/insertProductForm"> -->
<!--                     <i class="bi-cart-fill me-1" ></i> -->
<!--                     	프로젝트 만들기 -->
<!-- 					</a>  -->
<!-- 				</form> -->
<!-- 				<form class="d-flex"> -->
<!-- 					&nbsp; -->
<!-- 					<a class="btn btn-outline-dark" type="submit" href="/user/myinfo"> -->
<!--                     <i class="bi-cart-fill me-1" ></i> -->
<!--                     	나의정보 -->
<!-- 					</a>  -->
<!-- 				</form>	 -->
            
				
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
				                <a class="btn btn-outline-dark" type="submit" href="/user/manage">
				                    <i class="bi-cart-fill me-1"></i>
				                    회원관리
				                </a> 
				                &nbsp;
				                <a class="btn btn-outline-dark" type="submit" href="/project/manage">
				                    <i class="bi-cart-fill me-1"></i>
				                    프로젝트 관리
				                </a>
				                &nbsp;
				                <a class="btn btn-outline-dark" type="submit" href="/user/logout">
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
				                <a class="btn btn-outline-dark" type="submit" href="/user/logout">
				                    <i class="bi-cart-fill me-1"></i>
				                    로그아웃
				                </a> 
				                &nbsp;
				                <a class="btn btn-outline-dark" type="submit" href="/project/insertProductForm">
				                    <i class="bi-cart-fill me-1"></i>
				                    프로젝트 만들기
				                </a> 
				            </form>
				            <form class="d-flex">
				                &nbsp;
				                <a class="btn btn-outline-dark" type="submit" href="/user/myinfo">
				                    <i class="bi-cart-fill me-1"></i>
				                    나의 정보
				                </a> 
				            </form>
				<%
				        }
				    }
				%>

 
         </div>
   </div>
</nav>
        
<!-- Header-->
   <header class="bg-dark py-5">
       <div class="container px-4 px-lg-5 my-5">
           <div class="text-center text-white">
            <h1 class="display-4 fw-bolder">Shop in style</h1>
                   <p class="lead fw-normal text-white-50 mb-0">With this shop hompeage template</p>
         </div>
      </div>
   </header>
   
<!-- Section-->
   <section class="py-5">
      <div class="container px-4 px-lg-5 mt-5">
           <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
               <div class="col mb-5">
                   <div class="card h-100">
                        <!-- Product image-->
                        <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                        <!-- Product details-->
                        <div class="card-body p-4">
                           <div class="text-center">
                               <!-- Product name-->
                                <h5 class="fw-bolder">Fancy Product</h5>
                                <!-- Product price-->
                                   $40.00 - $80.00
                     </div>
                  </div>
                  <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                              </div>
                        </div>
            </div>
            <div class="col mb-5">
                   <div class="card h-100">
                       <!-- Sale badge-->
                        <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                        <!-- Product image-->
                        <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                        <!-- Product details-->
                        <div class="card-body p-4">
                           <div class="text-center">
                               <!-- Product name-->
                                <h5 class="fw-bolder">Special Item</h5>
                                <!-- Product reviews-->
                                <div class="d-flex justify-content-center small text-warning mb-2">
                                   <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                                    <div class="bi-star-fill"></div>
                        </div>
                                <!-- Product price-->
                                <span class="text-muted text-decoration-line-through">$20.00</span>
                                    $18.00
                     </div>
                  </div>
                        <!-- Product actions-->
                        <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                           <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                  </div>
               </div>
            </div>
                <div class="col mb-5">
                   <div class="card h-100">
                       <!-- Sale badge-->
                        <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                        <!-- Product image-->
                        <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                           <!-- Product details-->
                           <div class="card-body p-4">
                               <div class="text-center">
                                <!-- Product name-->
                                <h5 class="fw-bolder">Sale Item</h5>
                                <!-- Product price-->
                                <span class="text-muted text-decoration-line-through">$50.00</span>
                                    $25.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Popular Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    $40.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Sale Item</h5>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">$50.00</span>
                                    $25.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Fancy Product</h5>
                                    <!-- Product price-->
                                    $120.00 - $280.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">View options</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Sale badge-->
                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">Sale</div>
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Special Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    <span class="text-muted text-decoration-line-through">$20.00</span>
                                    $18.00  
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                    <div class="col mb-5">
                        <div class="card h-100">
                            <!-- Product image-->
                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder">Popular Item</h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    $40.00
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
<!-- Footer-->
<footer class="py-5 bg-dark">
   <div class="container"><p class="m-0 text-center text-white">Otter &copy; Your Website 2023</p></div>
</footer>

<!-- Bootstrap core JS-->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
<!-- Core theme JS-->
<script src="resources/js/scripts.js"></script>
</body>
</html>