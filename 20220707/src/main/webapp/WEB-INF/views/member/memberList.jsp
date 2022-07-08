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
<!-- m. 다음에는 무조건 vo 객체명을 넣어줘야함 | list의 개수만큼 m으로 읽어오겠다(forEach문) -->
<table border="1">
	<thead>
		<th>ID</th>
		<th>이름</th>
		<th>권한</th>
	</thead>
	<c:forEach items="${list}" var="m">
		<tr>
			<td>${m.memberId }</td>
			<td>${m.memberName }</td>
			<td>${m.memberAuthor }</td>
		</tr>
	</c:forEach>

</table>
</body>
</html>