<%@page import="co.micol.prj.board.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>boardUpdate.jsp</title>
</head>
<body>
	<h3>작성글</h3>
	<%
		BoardVO vo = (BoardVO)request.getAttribute("board");
	%>
	<form name="frm" action="boardUpdate" method="post">
		<div><label>번호</label><input name="id" readonly="readonly" value="<%=vo.getId()%>"></div>
		<div><label>제목</label><input name="title" value="<%=vo.getTitle()%>"></div>
		<div><label>내용</label><textarea name="content"><%=vo.getContent()%></textarea></div>
		<div><label>작성자</label><input name="writer" value="<%=vo.getWriter()%>"></div>
		<div><label>작성시간</label><input name="rdt" value="<%=vo.getRdt()%>"></div>
		<div><label>조회수</label><input name="hit" value="<%=vo.getHit()%>"></div>
		<!-- <input type="submit" value="수정"> -->
		<button type="button" onclick="boardUpdate()">수정</button>
		<button type="button" onclick="boardDelete()">삭제</button>
	</form>
	
	<script>
		function boardDelete(){
			alert('삭제완료');
			location.href="boardDelete?id=<%=vo.getId()%>";
		}
		
		function boardUpdate(){
			frm.submit();			
		}
	</script>
</body>
</html>