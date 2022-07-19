package co.knh.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/broadSocket")
public class BroadSocket {
	//접속 된 클라이언트 Websocket session 관리 리스트
	 private static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<>());
	 private static Pattern pattern = Pattern.compile("^\\{\\{.*?\\}\\}");
	 
	 //웹소켓으로 브라우저가 접속하면 요청되는 함수
	 @OnOpen
	 public void handleOpen(Session userSession) {
		 //클라이언트 접속 시 websocket 세션을 리스트에 저장
		 sessionUsers.add(userSession);
		 //콘솔에 접속 로그 출력
		 System.out.println("클라이언트 연결 완료");
	 }
	 
	 @OnMessage
	 public void handleMessage(String message, Session userSession) throws IOException{
		 //메시지 내용을 콘솔에 출력한다
		 System.out.println(message);
		 //초기 유저 명
		 String name = "anonymous";
		 //메시지로 유저 명 추출
		 Matcher matcher = pattern.matcher(message);
		 //메시지 예 : {{유저명}}메시지
		 if(matcher.find()) {
			 name=matcher.group();
		 }
		 
		 final String msg = message.replaceAll(pattern.pattern(), "");
		 final String username = name.replaceFirst("^\\{\\{", "").replaceFirst("\\}\\}$", "");
		 // session관리 리스트에서 Session을 취득한다.
		 sessionUsers.forEach(session -> {
			 if(session == userSession) {
				 return;
			 }
		 try{
			 session.getBasicRemote().sendText(username+ "=>" + msg);
		 } catch(IOException e) {
			 e.printStackTrace();
		 }
				 
		 });
	 
	 }
	 
	 @OnClose
	 public void handleClose(Session userSession) {
		 sessionUsers.remove(userSession);
		 System.out.println("연결 종료됨");
	 }
}
