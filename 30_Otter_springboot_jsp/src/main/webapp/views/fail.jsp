<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%request.setCharacterEncoding("utf-8"); %>
<%response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html lang="ko">
  <head>
  <link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
    <meta charset="utf-8" />
  </head>
  <script>
	  const urlParams = new URLSearchParams(window.location.search);
	
	  const codeElement = document.getElementById("code");
	  const messageElement = document.getElementById("message");
	
	  codeElement.textContent = "에러코드: " + urlParams.get("code");
	  messageElement.textContent = "실패사유 : " + urlParams.get("message"); 
	</script>  

  <body>
    <h2>결제 실패 </h2>
    <p id="code"></p>
    <p id="message"></p>
  </body>
</html>

  