<%@include file="../header.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript">
     $(function(){
//        alert("jquery 연결"); 
		$("#replyBtn").click(function(){
			$("#replyForm").toggle();	//답글 폼 보여주기
			document.getElementsByTagName("form")[0].reset();	//JS
		});
     });
</script>
<style type="text/css">
   /*답글 폼 안 보이게 처리*/
   #replyForm{
      display: none;
   }
</style>
</head>
<body>
<h1>답변형 게시판</h1>
<div id="container">
	<h2>상세보기</h2>
	<table class="table table-striped">
		<tr>
			<th>작성자</th>
			<td>${dto.id}</td>
		</tr>
		<tr>
			<th>제목</th>
			<td>${dto.title}</td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" readonly="readonly" rows="10" cols="60">${dto.content}</textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="btn btn-light rounded-pill px-3" type="button" id="replyBtn">답글</button>
				<button class="btn btn-light rounded-pill px-3" type="button"
						onclick="location.href='updateBoardForm.do?seq=${dto.seq}'">수정</button>
				<button class="btn btn-light rounded-pill px-3" type="button"
						onclick="location.href='mulDel.do?chk=${dto.seq}'">삭제</button>
				<button class="btn btn-light rounded-pill px-3" type="button"
						onclick="location.href='boardList.do'">목록</button>
			</td>
		</tr>
	</table>
	
	<div id="replyForm">
	<h1>답글 작성하기</h1>
	<form action="replyBoard.do" method="post">
	<input type="hidden" name="seq" value="${dto.seq}"/>
	<table class="table table-striped">
		<tr>
			<th>작성자</th>
			<td><input class="form-control" type="text" name="id" pattern="^[a-zA-Z]+$" required="required"/></td>
		</tr>
		<tr>
			<th>제목</th>
			<td><input class="form-control" type="text" name="title" required="required"/></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea class="form-control" name="content" required="required" rows="10" cols="60"></textarea></td>
		</tr>
		<tr>
			<td colspan="2">
				<button class="btn btn-light rounded-pill px-3" type="submit" >답글등록</button>
            	<button class="btn btn-light rounded-pill px-3" type="button" onclick="location.href='boardList.do'">목록</button>
			</td>
		</tr>
	</table>
	</form>
	</div>
</div>
</body>
</html>
<%@include file="../footer.jsp"%>









