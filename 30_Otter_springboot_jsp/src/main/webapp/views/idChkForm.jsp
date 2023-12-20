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
	function confirmId(resultId){
		
		var parentInputId=opener.document.getElementsByName("id")[0];	//id입력 박스
		var idChkSpan=opener.document.getElementById("idChk");	//중복여부 span
		if(resultId=='null'){		//사용 가능한 id는 문자열 'null'
			//사용 가능한 id이므로 다음 입력단계인 이름 입력박스로 커서 이동
			opener.document.getElementsByName("name")[0].focus();
			idChkSpan.textContent='y';	//y는 사용가능한 표시 및 중복 체크 완료 표시
		}else{
			idChkSpan.textContent='n';
			parentInputId.focus();	//중복된 id이기 때문에 다시 id입력칸에 커서를 넣어줌
		}
		
		self.close();
	}
</script>
</head>
<body>
<%
	//request에 저장하면 Object로 형변환 됌 --> (String)request--> 형변환해서 가져오기
	String resultId=(String)request.getAttribute("resultId");
%>
<div>
	<span><%=resultId==null?"사용 가능한 아이디입니다.":"중복된 아이디입니다." %></span>
	<span><button onclick="confirmId('<%=resultId%>')">확인</button></span>
</div>
</body>
</html>