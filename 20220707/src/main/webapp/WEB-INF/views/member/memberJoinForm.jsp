<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memberJoinForm.jsp</title>
</head>
<body>
	<div align="center"><h1> 회원가입 </h1></div>
	<div align="center">
		<form id="frm" action="memberJoin.do" onsubmit="return formCheck()" method="post">
			<table border="1">
				<tr>
					<th width="150">아이디</th>
					<td width="300">
						<input type="text" id="memberId" name="memberId" size="20"> &nbsp;
						<input type="hidden" id="checkId" value="No">
						<!-- input type = hidden : form 태그에서 숨겨진 항목을 하나 만듦(중복체크 확인용) -->
						<button type="button" id="btn" onclick="idCheck()">중복체크</button>
					</td>
				</tr>
				<tr>
					<th width="150">패스워드</th>
					<td width="300">
						<input type="password" id="memberPassword" name="memberPassword" size="20"> &nbsp;
					</td>
				</tr>
				<tr>
					<th width="150">패스워드확인</th>
					<td width="300">
						<input type="password" id="password" size="20"> &nbsp;
					</td>
				</tr>
				<tr>
					<th width="150">이름</th>
					<td width="300">
						<input type="text" id="memberName" name="memberName" size="20"> &nbsp;
					</td>
				</tr>
			</table>
			</div><br>
			<div align="center">
				<input type="submit" value="회원가입"> &nbsp;&nbsp;&nbsp;
				<input type="reset" value="취소"> &nbsp;&nbsp;&nbsp;
				<input type="button" value="홈으로" onclick="location.href='main.do'"> &nbsp;&nbsp;&nbsp;
			</div>
		</form>
	</div>
<script type="text/javascript">
	function formCheck(){
		//form에 memberId 값이 없으면
		if(frm.memberId.value == ""){
			alert("ID를 입력해주세요.");
			frm.memberId.focus();
			return false;
		}
		//중복체크
		if(frm.checkId.value == "No"){
			alert("아이디 중복체크를 해주세요.");
			return false;
		}
		if(frm.memberPassword.value != frm.password.value){
			//패스워드의 값과 패스워드확인의 값이 같지 않으면 알림창 띄우고 초기화
			alert("패스워드가 일치하지 않습니다.");
			frm.memberPassword.value = "";
			frm.password.value = ""; 
			frm.memberPassword.focus();
			return false;
		}
		if(frm.memberName.value == ""){
			alert("이름을 입력해주세요.");
			frm.memberName.focus();
			return false;
		}	
		return true;
	}
	
	function idCheck(){
		let id = frm.memberId.value;
		if(id == ""){
			alert("ID를 입력해주세요.");
			frm.memberId.focus();
		} else{
			//Ajax를 사용 -> 아이디 중복 체크를 수행
			const xht = new XMLHttpRequest();
			xht.onload = function() { //콜백함수
				console.log(this.responseText);
				if(this.readyState == 4 && this.status == 200){
					htmlConvertAjax(this.responseText); //성공했을 때 수행
				} else{
					errorAjaxCall();
				} 
			}
			xht.open('GET', "ajaxMemberIdCheck.do?id="+id); //호출방법(get or post) & url주소(서블릿 호출)
			xht.send(); //post : send에 문자열 실어보내기(+헤더)
		}
		
	}
	
	function htmlConvertAjax(str){
		if(str == "Used"){
			alert("사용가능한 ID입니다.");
			frm.checkId.value = "Yes";
			frm.btn.disabled = true;
			frm.memberPassword.focus();
		} else{
			alert("사용할 수 없는 ID입니다.");
			frm.memberId.value = "";
			frm.memberId.focus();
		}
	}
	
	function errorAjaxCall(){
		alert("네트워크 통신 장애로 인해 처리 불가능. \n 잠시 후에 다시 시도하세요.");
	}
</script>
</body>
</html>