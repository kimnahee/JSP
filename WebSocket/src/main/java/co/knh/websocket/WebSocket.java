package co.knh.websocket;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.server.ServerEndpoint;

//WebSocket의 호스트 주소 설정
@ServerEndpoint("/WebSocket")
public class WebSocket {
	//웹소켓으로 브라우저가 접속하면 요청되는 함수
	@OnOpen
	public void handleOpen() {
		//콘솔에 접속 로그 출력(connect)
		System.out.println("연결되었습니다.");
	}
	
	@OnMessage
	public String handleMessage(String message) {
		//메시지 내용을 콘솔에 출력
		System.out.println("클라이언트로부터 온 메시지 : " + message);
		//에코 메시지 작성(보낼 메시지)
		String replymessage = "echo : " + message;
		//에코 메시지를 브라우저(클라이언트)에 전송
		System.out.println("클라이언트에게 보내는 메시지 : " + replymessage);
		return replymessage;
	}
	
	@OnClose
	public void handleClose() {
		//콘솔에 접속 연결 해제 로그 출력
		System.out.println("연결이 종료되었습니다.");
	}

	@OnError
	public void handleError(Throwable t){
		//에러 발생시 요청하는 함수
		t.printStackTrace();
	}
	
}
