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
                    <form action="/user/adduser" method="post" onsubmit="return isPW(this)">
                        <div class="signup">
                            <label for="id" class="form-label">아이디</label>
                            <input type="text" name="id" class="form-control" required="required" />
							<span id="idChk" style="display:none;">n</span>
							<a href="#" onclick="idChk()">중복체크</a>
							<span id="enabledId"></span>
					                            
                        </div>
                        <div class="signup">
                            <label for="userpassword" class="form-label">비밀번호</label>
                            <input type="password" name="userpassword" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="userpassword2" class="form-label">비밀번호 확인</label>
                            <input type="password" name="userpassword2" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="username" class="form-label">이름</label>
                            <input type="text" name="username" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="phone" class="form-label">전화번호</label>
                            <input type="text" name="phone" class="form-control" onblur="validatePhoneNumber()" />
                        </div>
                        <div class="signup">
                            <label for="useremail" class="form-label">이메일</label>
                            <input type="email" name="useremail" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="useraccesstoken" class="form-label">AccessToken</label>
                            <input type="text" name="useraccesstoken" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="userrefreshtoken" class="form-label">RefreshToken</label>
                            <input type="text" name="userrefreshtoken" class="form-control" />
                        </div>
                        <div class="signup">
                            <label for="userseqno" class="form-label">userSeqNo</label>
                            <input type="text" name="userseqno" class="form-control" />
                        </div>
                        <input type="button" value="인증하기" onclick="authorization()" class="btn" />
                        <input type="submit" value="가입하기" class="btn" />
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>