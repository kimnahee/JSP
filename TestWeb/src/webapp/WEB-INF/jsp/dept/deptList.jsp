<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%@ include file ="/WEB-INF/jsp/header.jsp" %> --%>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
	<h4>부서목록</h4>
	<a href="DeptInsert">부서등록</a>
	<table>
		<tr><td>부서번호</td><td>부서명</td></tr>
		
	<c:forEach items="${list}" var="dept">
		<tr><td>${dept.getDeptId()}</td>
		<td><a href="DeptUpdate?departmentId="${dept.getDeptId()}">
			${ dept.getDeptName()}
		</a></td>
	</c:forEach>
	
	</table>
</body>
</html>