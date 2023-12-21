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
					<h1>나의 정보</h1>
					<div id="myinfo">
						<form action="/user/updateUser" method="post">
							<input type="hidden" name="id" value="${ldto.id}"/>
							<table class="table1">
								<tr>
									<th>아이디</th>
									<td>
										<input type="text" name="id" value="${dto.id}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
								    <th>이름</th>
								    <td>
								    	<input type="text" name="username" value="${dto.username}" readonly="readonly" class="form-control1"/>
								    </td>
								</tr>
								<tr>
								    <th>연락처</th>
								    <td>
								        <input type="text" name="phone" value="${dto.phone}" class="form-control"/>
								    </td>
								</tr>
								<tr>
								    <th>이메일</th>
								    <td>
								        <input type="email" name="useremail" value="${dto.useremail}" class="form-control"/>
								    </td>
								</tr>
								<tr>
									<th>등급</th>
									<td>
										<input type="text" name="role" value="${dto.role}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
									<th>탈퇴여부</th>
									<td>
										<input type="text" name="delflag" value="${dto.delflag}" readonly="readonly" class="form-control1"/>
									</td>
								</tr>
								<tr>
									<td colspan="2">
										<input type="button" value="탈퇴" onclick="delUser('${dto.id}')" class="btn btn-outline-darkk" style="float:right; margin-left:5px;" />
										<input type="submit" value="수정" class="btn btn-outline-darkk" style="float:right;"/>
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