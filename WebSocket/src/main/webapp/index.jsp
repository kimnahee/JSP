<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Web Socket Example</title>
</head>
<body>

	<form>
		<!-- 유저 명을 입력하는 텍스트 박스(기본값은 anonymous) -->
		<input id="user" type="text" value="anonymous">
		<!-- 송신 메시지를 작성하는 텍스트 박스 -->
		<input id="textMessage" type="text">
		<!-- 메시지를 송신하는 버튼 -->
		 <input onclick="sendMessage()" value="Send" type="button">
		<!-- WebSocket 접속 종료하는 버튼 -->    
		<input onclick="disconnect()" value="Disconnect" type="button">
	</form>
	<br />
	<!-- 콘솔 메시지의 역할을 하는 로그 텍스트 공간(수신 메시지도 표시) -->
	<textarea id="messageTextArea" rows="10" cols="50"></textarea>
	<script type="text/javascript">
	//프로젝트 명 : WebSocket
	//호스트명 : ???
	//websocket 오브젝트 생성(자동 접속 시작 - onopen 함수 호출)
	let webSocket = new WebSocket("ws://localhost:8080/WebSocket/broadSocket");
	//콘솔 텍스트 에리어 오브젝트
	let messageTextArea = document.getElementById("messageTextArea");
	webSocket.onopen = function(message){
		messageTextArea.value += "서버 연결\n";
	};
	//websocket 서버와 접속이 끊기면 호출되는 함수
	webSocket.onclose = function(message){
		messageTextArea.value += "서버 연결 종료\n";
	};
	//websocket 서버와 통신 중에 에러가 발생하면 요청되는 함수
	webSocket.onerror = function(message){
		messageTextArea.value += "에러 발생\n";
	};
	//websocket 서버로부터 메시지가 오면 호출되는 함수
	webSocket.onmessage = function(message){
		messageTextArea.value+="서버로부터 수신한 메시지 => " + message.data + "\n";
	};
	
	//send 버튼을 누르면 호출되는 함수
	function sendMessage(){
		let user = document.getElementById("user");
		let message = document.getElementById("textMessage");
		messageTextArea.value += user.value + "(me) => " + message.value + "\n";
		webSocket.send("{{" + user.value + "}}" + message.value);
		message.value = "";
	}
	//disconnect 버튼을 누르면 호출되는 함수
	function disconnect(){
		webSocket.close();
	}
	
	</script>
	

</body>
</html>