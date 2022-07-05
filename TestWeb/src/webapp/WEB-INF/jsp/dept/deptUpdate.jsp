<%@page import="co.micol.prj.dept.DeptVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deptUpdate</title>
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
	<!-- 호출하는 서블릿 url만 적어줌(/제외) -->
<% DeptVO dept = (DeptVO)request.getAttribute("dept"); %>
	<form name = "frm" action="DeptUpdate" method="post">
	<!-- value: 수정할 값을 미리 보여줌 ++ 단건조회 -->
		부서번호 <input name="departmentId" value="<%=dept.getDeptId()%>">
		부서명 <input name="departmentName" value="<%=dept.getDeptName()%>">
		<button type="button" onclick="validationForm()">부서등록</button>
	</form>
</body>
</html>