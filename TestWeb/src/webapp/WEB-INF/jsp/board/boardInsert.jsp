<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	label{
		display: inline-block;
		width: 100px;
		background-color: skyblue;
		color: white;
		text-align: center;
		margin-right: 10px;
	}
</style>
</head>
<body>
	<form name="frm" action="boardInsert" method="post">
		<div><label>번호</label><input name="id"></div>
		<div><label>제목</label><input name="title"></div>
		<div><label>내용</label><input name="content"></div>
		<div><label>글쓴이</label><input name="writer"></div>
		<div><label>작성시간</label><input name="rdt"></div>
		<div><label>조회수</label><input name="hit"></div>
		<button type="button" onclick="submitForm()" >등록</button>
	</form>
<script>
	function submitForm(){
		frm.submit();		
	}
</script>
</body>

</html>