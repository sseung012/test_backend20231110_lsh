<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Otter</title>
<!-- Favicon-->
<link rel="icon" type="image/x-icon" href="resources/assets/favicon.ico" />
<!-- Core theme CSS (includes Bootstrap)-->
<link href="/resources/css/styles.css" rel="stylesheet" />

        	
<script type="text/javascript">



</script>
</head>
<body class="join">
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
    	<a class="navbar-brand" href="/">Otter</a>
    </div>
</nav>

<section class="pyy-5">
      <div class="container myy-5">
         <div class="roww justify-content-center">
            <div class="coll-lg-6">
            	<div class="contents">
					<h1>사용자 페이지</h1>
					<h2>나의 정보</h2>
					<div id="myinfo">
						<form action="updateUser.user" method="post">
							<input type="hidden" name="id" value="${ldto.id}"/>
							<table class="table">
								<tr>
									<th>아이디</th>
									<td>${dto.id}</td>
								</tr>
								<tr>
								    <th>이름</th>
								    <td>${dto.username}</td>
								</tr>
								<tr>
								    <th>연락처</th>
								    <td>
								        <input type="text" name="phone" value="${dto.phone}" />
								    </td>
								</tr>
								<tr>
								    <th>이메일</th>
								    <td>
								        <input type="email" name="email" value="${dto.useremail}" />
								    </td>
								</tr>
								<tr>
									<th>등급</th>
									<td>${dto.role}</td>
								</tr>
								<tr>
									<th>탈퇴여부</th>
									<td>${dto.delflag}</td>
								</tr>
								<tr>
									<td colspan="2">
										<div style="display: flex;">
											<button type="submit" class="form-control">수정</button>
											<button type="button" class="form-control" onclick="delUser('${dto.id}')">탈퇴</button>
										</div>
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
</body>
</html>