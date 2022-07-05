<%@page import="co.knh.prj.dept.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function validationForm(){
	if(frm.departmentId.value == ""){
		alert("부서번호를 입력하세요.");
		return;
	}
		frm.submit();
	}
</script>
</head>
<body>
<% DeptVO dept = (DeptVO)request.getAttribute("dept"); %>
	<form name="frm" action="DeptUpdate" method="post">
		부서번호<input name="departmentId">
		부서명<input name="departmentName">
		<button type="button" onclick="validationForm()">부서등록</button>
	</form>
</body>
</html>