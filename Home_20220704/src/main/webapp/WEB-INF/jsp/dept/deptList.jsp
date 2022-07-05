<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DeptList</title>
</head>
<body>
	<h4>부서목록</h4>
	<a href="DeptInsert">부서등록</a>
	<table>
		<thead>
			<tr>
				<th>부서번호</th>
				<th>부서이름</th>
				<th>매니저번호</th>
				<th>위치번호</th>
			</tr>
		</thead>
		<tbody>
<c:forEach var="vo" items="${list}">
			<tr>
				<td>${vo.deptId}</td>
				<td>${vo.deptName}</td>
				<td>${vo.managerId}</td>
				<td>${vo.locId}</td>
			</tr>
</c:forEach>
		</tbody>
	</table>
</body>
</html>