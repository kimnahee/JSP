<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>부서목록</h4>
	<a href="DeptInsert">부서등록</a>
	<table>
		<tr><td>부서번호</td><td>부서명</td></tr>
	<%
		ArrayList<DeptVO> list = (ArrayList<DeptVO>)request.getAttribute("list");
		for(DeptVO dept : list){
	%>	
	<tr><td><%=dept.getDeptId() %></td>
		<td><a href="DeptUpdate?departmentId=<%=dept.getDeptId() %>"> 
				<%=dept.getDeptName() %>
				</a></td>
	<% } %>		
	</table>
</body>
</html>