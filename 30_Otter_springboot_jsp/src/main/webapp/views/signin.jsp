<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<%@ page import="com.hk.otter.dtos.UserDto" %>
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

<%
UserDto ldto = (UserDto)request.getSession().getAttribute("ldto");
%>

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
            	<form action="/user/login" method="post">
				    <table class="table">
				        <tr>
				            <th>아이디</th>
				            <td><input type="text" name="id" class="form-control"/></td>
				        </tr>
				        <tr>
				            <th>비밀번호</th>
				            <td><input type="password" name="userpassword" class="form-control"/></td>
				        </tr>
				        <tr>   
				            <td colspan="2">       
				                <div style="display: flex;">
				                    <button type="submit" class="form-control">Login</button> &nbsp;&nbsp;&nbsp;    
				                    <a class="btn form-control" href="/user/join" style="border: 1px solid #ccc;">SignUp</a>
				                </div>
				            </td>
				        </tr>	            			
				    </table>
				</form>
            </div>
         </div>
      </div>
   </section>
</body>
</html>