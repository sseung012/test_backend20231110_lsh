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
	 
      function validatePhoneNumber() {
          var phoneNumberInput = document.getElementsByName("userphone")[0];
          var phoneNumber = phoneNumberInput.value.replace(/\D/g, ''); // 숫자 이외의 문자 제거

          // 입력된 전화번호가 11자리가 아니면 경고 메시지 출력
          if (phoneNumber.length !== 11) {
              alert("전화번호를 11자리로 입력해주세요.");
              phoneNumberInput.value = ""; // 입력 값을 비움
          }
      }
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
	            	<div>
		            	<label for="userid" class="form-label">아이디</label>
		            	<input type="text" name="username" class="form-control"/>
	            	</div>
	            	<div>
		            	<label for="userpassword" class="form-label">비밀번호</label>
		            	<input type="password" name="userpassword" class="form-control"/>
	            	</div>
	            	<div>
		            	<label for="userpassword2" class="form-label">비밀번호 확인</label>
		            	<input type="password" name="userpassword2" class="form-control"/>
	            	</div>
					<div>
		            	<label for="username" class="form-label">이름</label>
		            	<input type="text" name="username" class="form-control"/>
	            	</div>
	            	<div>
		            	<label for="userphone" class="form-label">전화번호</label>
		            	<input type= name="userphone" class="form-control" onblur="validatePhoneNumber()"/>
	            	</div>
	            	<div>
		            	<label for="email" class="form-label">이메일</label>
		            	<input type="email" name="useremail" class="form-control"/>
	            	</div>
	            	<div>
		            	<label for="useraccesstoken" class="form-label">AccessToken</label>
		            	<input type="text" name="useraccesstoken" class="form-control"/>
	            	</div>
	            	<div>
		            	<label for="userrefreshtoken" class="form-label">RefreshToken</label>
		            	<input type="text" name="userrefreshtoken" class="form-control"/>
	            	</div>
	            	<div>
		            	<label for="email" class="form-label">userSeqNo</label>
		            	<input type="text" name="userseqno" class="form-control"/>
	            	</div>
	            	<input type="button" value="인증하기" onclick="authorization()" class="btn"/>
	            	<input type="submit" value="가입하기" class="btn"/>


            	
            	</form>
            </div>
         </div>
      </div>
   </section>
</body>
</html>