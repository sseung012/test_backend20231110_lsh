<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.hk.otter.dtos.ProductDto" %>
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
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>

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
			                    <th>검토요청일</th>
			                    <th>승인일</th>
			                    <th>승인상태</th>
			                </tr>
							<%
							    if (list == null || list.isEmpty()) {
							%>
							    <tr>
							        <td colspan="8">-- 가입된 회원이 없습니다. --</td>
							    </tr>
							<%
							    } else {
							        for (ProductDto dto : list) {
							%>
							            <tr>
							                <td><%= dto.getSeq()%></td>
							                <td>
											    <% 
											        int categorySeq = dto.getCate_seq();
											        String categoryName = "";
											
											        switch (categorySeq) {
											            case 1:
											                categoryName = "홈/리빙";
											                break;
											            case 2:
											                categoryName = "패션/잡화";
											                break;
											            case 3:
											                categoryName = "뷰티";
											                break;
											            case 4:
											                categoryName = "푸드";
											                break;
											            case 5:
											                categoryName = "출판";
											                break;
											            case 6:
											                categoryName = "반려동물";
											                break;
											            default:
											                categoryName = "알 수 없음";
											                break;
											        }
											
											        out.print(categoryName);
											    %>
											</td>
							                <td>
							                    <a href='/product/productApprove?seq=<%= dto.getSeq() %>'>
							                        <span><%= dto.getTitle() %></span>
							                    </a>
							                </td>
							                <td><%= dto.getMaker()%></td>
							                <td>
											    <% 
											        String createdDateStr = "";
											        Date createdDate = dto.getCreated_date();
											
											        if (createdDate != null) {
											            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
											            createdDateStr = dateFormat.format(createdDate);
											        }
											
											        out.print(createdDateStr);
											    %>
											</td>
							                <td><%= dto.getOpen_date()%></td>
							                <td style="<%= (dto.getProduct_check().equals("N") ? "color: red;" : "") %>">
							                	<%= (dto.getProduct_check().equals("Y") ? "승인완료" : "승인대기")%>
							                </td>
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