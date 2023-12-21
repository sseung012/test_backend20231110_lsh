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
window.onload = function() {
   today = new Date();
   console.log("today.toISOString() >>>" + today.toISOString());
   today = today.toISOString().slice(0, 10);
   console.log("today >>>> " + today);
   bir = document.getElementById("created_date");
   bir.value = today;
}

</script>
<script src="//cdn.ckeditor.com/4.22.1/standard/ckeditor.js"></script>

</head>
<body class="addProductForm">
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
                    <form action="/prodcut/insertProduct" method="post" >
                                  
                        <div class="addProduct">
                            <label for="img" class="form-label">대표 이미지</label>
                            <input type="file" name="img" class="form-control" />
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="maker" class="form-label">회사명</label>
                            <input type="text" name="maker" class="form-control" />
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="goal_price" class="form-label">목표 금액</label>
                            <input type="text" name="goal_price" class="form-control" />
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="title" class="form-label">제목</label>
                            <input type="text" name="title" class="form-control" />
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="created_date" class="form-label">신청 날짜</label>
                            
                            <input type="date" name="created_date" id="created_date" class="form-control" />
							
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="close_date" class="form-label">마감일</label>
                            <input type="date" name="close_date" class="form-control" />
                        </div>&nbsp;
                        <div class="addProduct" id="addProduct">
                            <label for="content" class="form-label">상세내용</label>
                            <textarea id = "content" name = "content"></textarea>
							<script>CKEDITOR.replace('content',
									{filebrowserUploadUrl:'/file/imageUpload.do'});</script>
<!--                             <input type="text" name="content" class="form-control" style="height:300px; width:510px;"/> -->
								 						
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="userseqno" class="form-label">카테고리 선택</label>
                            <select name="category" id="category">
                            	<option>-- 카테고리 선택 --</option>
                            	<option>전체</option>
                            	<option>홈/리빙</option>
                            	<option>패션/잡화</option>
                            	<option>뷰티</option>
                            	<option>푸드</option>
                            	<option>출판</option>
                            	<option>반려동물</option>
                            </select>
                        </div>&nbsp;
                        <div class="addProduct">
                            <label for="userseqno" class="form-label">리워드</label>
                            <input type="text" name="reward_name" class="form-control" placeholder="리워드 제목" />&nbsp;
                            <input type="text" name="price" class="form-control" placeholder="리워드 가격"/>&nbsp;
                            <input type="text" name="combination" class="form-control" placeholder="리워드 설명"/>&nbsp;
                            <input type="number" name="stock" class="form-control" placeholder="리워드 수량"/>
                        
                            <input type="submit" value="추가" class="btn btn-outline-dark" />
                            
                        </div>
                        <br/>
                        <input type="submit" value="등록" class="btn btn-outline-dark" />
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>