<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
<style>
	form#empInsert > label{
		display: inline-block;
		width: 70px;
		text-align: center;
		padding: 0px 20px;
		margin-right: 20px;
		background-color: orangered;
		color: white;
	}
	
	form#empInsert > input[type=submit]{
		margin-left: 15px;
		padding: 0px 20px;
	}
	
</style>
</head>
<body>
<h1>사원등록</h1>
<form id="empInsert">
	<label>사원번호</label><input type="text"><br><br>
	<label>이름</label><input type="text"><br><br>
	<label>이메일</label><input type="text"><br><br>
	<label>입사일</label><input type="date"><br><br>
	<label>직업번호</label><input type="text"><br><br>
	<input type="submit" value="등록">
</form>
</body>
</html>