<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
<style>
	form#empInsert > div{
		display: inline-block;
		width: 70px;
		text-align: center;
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
	<div><label>사번</label></div><input type="text"><br><br>
	<div><label>이름</label></div><input type="text"><br><br>
	<div><label>급여</label></div><input type="text"><br><br>
	<input type="submit" value="등록">
</form>
</body>
</html>