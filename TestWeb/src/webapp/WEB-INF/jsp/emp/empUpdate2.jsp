<%@page import="co.micol.prj.emp.EmpVO"%>
<%@page import="co.micol.prj.dept.DeptVO"%>
<%@page import="co.micol.prj.emp.JobsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
<style>
	h2{
		margin-left: 10px;
	}
	form{
		margin-left: 10px;
	}
	form#empInsert > label{
		display: inline-block;
		width: 70px;
		text-align: center;
		padding: 0px 20px;
		margin-right: 20px;
		background-color: orangered;
		color: white;
	}
	
	form#empInsert > input[type=submit]{
		padding: 0px 20px;
	}
	
</style>
<script>

function validateForm(){
	/* window.document.forms["frm"]["employeeId"] 도 가능 */
	if(frm.employeeId.value == ""){
		alert("사번을 입력하세요.");
		/* 커서 이동 */
		frm.employeedId.focus();
		return false;
	}
	
	if(frm.lastName.value == ""){
		alert("이름을 입력하세요.");
		/* 커서 이동 */
		frm.employeedId.focus();
		return false;
	}
	
	if(frm.email.value == ""){
		alert("이메일을 입력하세요.");
		/* 커서 이동 */
		frm.employeedId.focus();
		return false;
	}
	
	if(frm.hireDate.value == ""){
		alert("입사일을 입력하세요.");
		/* 커서 이동 */
		frm.employeedId.focus();
		return false;
	}
	
	if(frm.jobId.value == ""){
		alert("직무를 입력하세요.");
		/* 커서 이동 */
		frm.employeedId.focus();
		return false;
	}
	
	var regExp = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i; //이메일 정규식
	if(regExp.test(frm.email.value) == false){
		alert("이메일을 형식에 맞게 입력해주세요.");
		frm.email.focus();
		return false;
	}
	
	return true;
}
</script>
</head>
<body>
<%-- <%@ include file ="/WEB-INF/jsp/header.jsp" %> --%>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<h2>사원등록</h2>
	<!-- input name은 테이블 열과 같게 해주기 -->
	<%
		EmpVO vo = (EmpVO)request.getAttribute("emp");
	%>
<form name="frm" action="empInsert" method="post" id="empInsert" onsubmit="return validateForm()">
	<label>사원번호</label><input name="employeeId" readonly="readonly" value="<%=vo.getEmployeeId()%>"><br>
	<label>이름</label><input name="lastName" value="<%=vo.getLastName()%>"><br>
	<label>이메일</label><input name="email" value="<%=vo.getEmail()%>"><br>
	<label>입사일</label><input type="date" name="hireDate" value="<%=vo.getHireDate()%>"><br>
	<label>직무</label>
	<select name="jobId">
			<% ArrayList<JobsVO> list = (ArrayList<JobsVO>)request.getAttribute("jobs"); //강제 형변환 | getAttribute는 객체값을 가져오기 때문에/jobs 값을 가지고 옴
				for(JobsVO jobs : list) { %>
				<!-- option tag 반복 / jobs 객체에서 list만큼 가지고 와서 반복 -->
				<option value="<%=jobs.getJobId()%>"> <%=jobs.getJobTitle()%>
			<% } %>
	</select><br>
	<label>부서</label>
	<% ArrayList<DeptVO> deptlist = (ArrayList<DeptVO>)request.getAttribute("depts");
		for(DeptVO depts : deptlist) {%>
		<input type=radio name="departmentId" value="<%=depts.getDeptId()%>">
		<%=depts.getDeptName()%>
		<% } %>
	<br>
	<label>연봉</label><input name="salary" value="<%=vo.getSalary()%>"><br>
	<input type="submit" value="등록">
	<button type="button" onclick="empDelete()">삭제</button>
</form>
<script>
	document.getElementsByName("jobId")[0].value = "<%=vo.getJobId()%>";
	document.querySelector("[name=departmentId][value='<%=vo.getDepartmentId()%>']").checked =true;
	
	function empDelete(){
		/* Get 방식 */
		location.href="empDelete?employeeId=<%=vo.getEmployeeId()%>";
	}
</script>
</body>
</html>