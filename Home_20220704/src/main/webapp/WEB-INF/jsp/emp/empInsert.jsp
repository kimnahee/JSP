<%@page import="co.knh.prj.dept.DeptVO"%>
<%@page import="co.knh.prj.emp.JobsVO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empInsert.jsp</title>
<style>
	label{
		display: inline-block;
		width: 150px;
		background-color: lightpink;
		color: white;
		text-align: center;
		margin-right: 20px;
	}
</style>
<script>
function validateForm(){
	if(frm.employeeId.value == ""){
		alert("사번을 입력하세요.");
		frm.employeeId.focus();
		return false;
	}
	if(frm.lastName.value ==""){
		alert("이름을 입력하세요.");
		frm.lastName.focus();
		return false;
	}
	if(frm.email.value == ""){
		alert("이메일을 입력하세요.");
		frm.email.focus();
		return false;
	}
	if(frm.hireDate.value == ""){
		alert("입사일을 입력하세요.");
		frm.hireDate.focus();
		return false;
	}
	if(frm.jobId.value == ""){
		alert("직무를 입력하세요.");
		frm.jobId.focus();
		return false;
	}
	return true;
}
</script>
</head>
<body>
	<form name="frm" action="EmpInsertServ" method="post" onsubmit="return validateForm()">
		<label>사원번호</label><input name="employeeId"><br>
		<label>사원이름</label><input name="lastName"><br>
		<label>Email</label><input name="email"><br>
		<label>입사일</label><input type="date" name="hireDate"><br>
		<label>직무</label>
		<select name="jobId" >
			<% ArrayList<JobsVO> list = (ArrayList<JobsVO>)request.getAttribute("jobs"); 
			   for(JobsVO jobs : list) { %>
			   <option value="<%=jobs.getJobId()%>"><%=jobs.getJobTitle()%>
			<% } %>
		</select><br>
		<label>부서</label>
		<% ArrayList<DeptVO> deptlist = (ArrayList<DeptVO>)request.getAttribute("depts"); 
			for(DeptVO depts : deptlist) { %>
			<input type=radio name="departmentId" value="<%=depts.getDeptId()%>"><%=depts.getDeptName() %>
		<% } %>
		<br><input type="submit" value="등록">
	</form>
</body>
</html>