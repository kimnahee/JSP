<%@page import="co.micol.prj.board.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardList.jsp</title>
</head>
<body>
	<h3>목록</h3>
	<table border="1">
	<thead>
		<tr>
			<th>번호</th><th>제목</th><th>내용</th><th>글쓴이</th><th>작성시간</th><th>조회수</th><th>삭제</th><th>수정</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${list}" var="list">
			<tr>
			<td>${list.getId()}</td>
			<td>${list.getTitle()}</td>
			<td>${list.getContent()}</td>
			<td>${list.getWriter()}</td>
			<td>${list.getRdt()}</td>
			<td>${list.getHit()}</td>
			<td><button type="button">삭제</button></td>
			<td><button type="button">수정</button></td>
			
		</c:forEach>
	</tbody>
		
		<%-- <%
			ArrayList<BoardVO> list = (ArrayList<BoardVO>)request.getAttribute("list");
			for(BoardVO board : list){
		%>
				<tr>
					<td><%=board.getId()%></td>
					<td><%=board.getTitle()%></td>
					<td><%=board.getContent()%></td>
					<td><%=board.getWriter()%></td>
					<td><%=board.getRdt()%></td>
					<td><%=board.getHit()%></td>
				</tr>	
		<%
			}
		%> --%>
	</table>
	<button type="button" onclick="location.href='boardInsert'">새 글 작성</button>
</body>
</html>