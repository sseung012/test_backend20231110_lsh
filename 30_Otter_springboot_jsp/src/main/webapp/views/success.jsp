<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Base64"%>
<%@ page import="java.util.Base64.Encoder"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.net.URL" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.Reader" %>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE html>
<html lang="ko">
  <head>
    <meta charset="utf-8" />
    <!-- Favicon-->
	<link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
	<!-- Core theme CSS (includes Bootstrap)-->
	<link href="/resources/css/styles.css" rel="stylesheet" />
  </head>
  <body>
    <h1>펀딩이 완료되었습니다. 감사합니다 :)</h1>
    <p id="orderId"></p>
    <p id="paymentKey"></p>
    <p id="amount"></p>

    <script>
      // 쿼리 파라미터 값이 결제 요청할 때 보낸 데이터와 동일한지 반드시 확인하세요.
      // 클라이언트에서 결제 금액을 조작하는 행위를 방지할 수 있습니다.
      const urlParams = new URLSearchParams(window.location.search);
      const orderId = urlParams.get("orderId");
      const paymentKey = urlParams.get("paymentKey");
      const amount = urlParams.get("amount");

      async function confirm() {
        const requestData = {
          orderId: orderId,
          paymentKey: paymentKey,
          amount: amount,
        };

        const response = await fetch("/confirm", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(requestData),
        });

        const json = await response.json();

        if (!response.ok) {
          // 결제 실패 비즈니스 로직을 구현하세요.
          console.log(json);
          window.location.href = `/fail?message=${json.message}&code=${json.code}`;
        }

        // 결제 성공 비즈니스 로직을 구현하세요.
        console.log(json);
      }
      confirm();

      const orderIdElement = document.getElementById("orderId");
      const paymentKeyElement = document.getElementById("paymentKey");
      const amountElement = document.getElementById("amount");

      orderIdElement.textContent = "주문번호: " + orderId;
      amountElement.textContent = "결제 금액: " + amount;
      paymentKeyElement.textContent = "paymentKey: " + paymentKey;
    </script>
  </body>
</html>



