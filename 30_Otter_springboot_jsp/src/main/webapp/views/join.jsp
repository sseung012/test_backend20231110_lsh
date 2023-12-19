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
	 //사용자 인증 요청하기(사용자 인증하면서 계좌등록까지 진행함)
      function authorization(){
         var url="https://testapi.openbanking.or.kr/oauth/2.0/authorize?"
               +"response_type=code&" //고정갑 code:인증요청시 반환되는 값의 형식 의미
               +"client_id=4987e938-f84b-4e23-b0a2-3b15b00f4ffd&" //이용기관의 ID
               +"redirect_uri=http://localhost:8087/user/authresult&" //응답URL
               +"scope=login inquiry transfer&" //토큰의 권한
               +"state=12345678123456781234567812345678&" //32자리 난수 설정
               +"auth_type=0"; //0: 최초 한번 인증, 2: 인증생략
               
         window.open(url,"인증하기","width=400px, height=600px");
      }
	 
//       document.addEventListener("DOMContentLoaded", function () {
//     	    // 아이디 입력란에 키 입력 시 중복 체크
//     	    var idInput = document.querySelector("input[name=id]");
//     	    idInput.addEventListener("keyup", function () {
//     	        var id = this.value;
//     	        var xhr = new XMLHttpRequest();

//     	        xhr.onreadystatechange = function () {
//     	            if (xhr.readyState == 4) {
//     	                if (xhr.status == 200) {
//     	                    var data = JSON.parse(xhr.responseText);
//     	                    var idChkElement = document.getElementById("idChk");

//     	                    if (data.id !== null) {
//     	                        idChkElement.className = "n";
//     	                        idChkElement.style.color = "red";
//     	                        idChkElement.textContent = "사용할 수 없는 아이디입니다.";
//     	                    } else {
//     	                        idChkElement.className = "y";
//     	                        idChkElement.style.color = "green";
//     	                        idChkElement.textContent = "사용 가능한 아이디입니다.";
//     	                    }
//     	                } else {
//     	                    alert("통신 오류: " + xhr.status);
//     	                }
//     	            }
//     	        };

//     	        xhr.open("GET", "/user/idChk?id=" + id, true);
//     	        xhr.send();
//     	    });

//     	    // 중복된 아이디로 submit할 경우 처리
//     	    function submitChk() {
//     	        var classValue = document.getElementById("idChk").className;
//     	        if (classValue === "n") {
//     	            alert("아이디를 확인하세요");
//     	            return false;
//     	        }
//     	        return true;
//     	    }
//     	});

</script>
</head>
<body>
<!-- Navigation-->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<div class="container px-4 px-lg-5">
    	<a class="navbar-brand" href="#!">Otter</a>
    </div>
</nav>

<section class="py-5">
      <div class="container my-5">
         <div class="row justify-content-center">
            <div class="col-lg-6">
            	<form action="/user/adduser" method="post">
            			<table class="table">
	            		<tr>
	            			<th>아이디</th>
	            			<td><input type="text" name="id" class="form-control"/></td>
	            		</tr>
	            		<tr>
	            			<th>이름</th>
	            			<td><input type="text" name="username" class="form-control"/></td>
	            		</tr>            		
	            		<tr>
	            			<th>이메일</th>
	            			<td><input type="email" name="useremail" class="form-control"/></td>
	            		</tr>
	            		<tr>
	            			<th>비밀번호</th>
	            			<td><input type="password" name="userpassword" class="form-control"/></td>
	            		</tr>
	            		<tr>
	            			<th>AccessToken</th>
	            			<td><input type="text" name="useraccesstoken" class="form-control"/></td>
	            		</tr>
	            		<tr>
	            			<th>RefreshToken</th>
	            			<td><input type="text" name="userrefreshtoken" class="form-control"/></td>
	            		</tr>
	            		<tr>
	            			<th>userSeqNo</th>
	            			<td><input type="text" name="userseqno" class="form-control"/></td>
	            		</tr>
	            		<tr>
	            			<th>전화번호</th>
	            			<td><input type="text" name="phone" class="form-control"/></td>
	            		</tr>
	            		<tr>
	            			<td colspan="2">
	            				<input type="button" value="인증하기" onclick="authorization()" class="btn"/>
	            				<input type="submit" value="가입하기" class="btn"/>
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