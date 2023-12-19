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
    	<a class="navbar-brand" href="#!">Otter</a>
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
						            <a class="nav-link" href="/user/signin">Login</a> &nbsp;&nbsp;&nbsp;    
						            <a class="nav-link" href="/user/join">SignUp</a>
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