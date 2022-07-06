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
<%-- <%@ include file ="/WEB-INF/jsp/header.jsp" %> --%>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<!-- 호출하는 서블릿 url만 적어줌(/제외) -->
	<form name = "frm" action="DeptInsert" method="get">
		부서번호 <input name="departmentId">
		부서명 <input name="departmentName">
		<button type="button" onclick="validationForm()">부서등록</button>
	</form>
</body>
</html>