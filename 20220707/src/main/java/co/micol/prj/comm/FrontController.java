package co.micol.prj.comm;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.MainCommand;
import co.micol.prj.member.command.AjaxMemberIdCheck;
import co.micol.prj.member.command.MemberJoin;
import co.micol.prj.member.command.MemberJoinForm;
import co.micol.prj.member.command.MemberList;
import co.micol.prj.member.command.MemberLogin;
import co.micol.prj.member.command.MemberLoginForm;
import co.micol.prj.member.command.MemberLogout;

//확장자 패턴 이용 => 모든 .do 확장자를 가진 요청을 처리
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//Key : request/ Value : Command | 요청과 실행문을 맵 구조로 만든다
	private HashMap<String, Command> map = new HashMap();
	
	public FrontController() {
		super();
	}

	public void init(ServletConfig config) throws ServletException {
		//초기화 메소드(Mapping)
		//request와 command를 1:1 Mapping
		map.put("/main.do", new MainCommand()); //처음 접속하는 페이지(/main.do가 들어오면 mainCommand() 실행)
		map.put("/memberLoginForm.do", new MemberLoginForm());//로그인 폼 호출
		map.put("/memberLogin.do", new MemberLogin()); //로그인 처리
		map.put("/memberLogout.do", new MemberLogout()); //로그아웃 처리
		map.put("/memberList.do", new MemberList()); //회원 목록 보기
		map.put("/memberJoinForm.do", new MemberJoinForm()); //회원가입 화면
		map.put("/ajaxMemberIdCheck.do", new AjaxMemberIdCheck()); //Ajax를 이용한 아이디 중복체크
		map.put("/memberJoin.do", new MemberJoin()); //회원가입 처리
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//서비스 - 실행 메소드
		//한글 처리
		request.setCharacterEncoding("UTF-8");
		
		//요청 분석
		String uri = request.getRequestURI(); //요청된 URI 가져옴
		String contextPath = request.getContextPath(); //요청된 URL에서 contextpath 가져옴
		String page = uri.substring(contextPath.length()); //실제 요청한 것 = page (URI에서 ContextPath의 길이만큼 자름)
		
//		System.out.println("uri : " + uri);
//		System.out.println("contextPath : " + contextPath);
//		System.out.println("page : " + page);
		
		Command command = map.get(page); //실제 수행할 Command => map에서 key값을 넘겨줘서 value값인 new MainCommand가 불러짐
		//=> command는 인터페이스이므로 new MainCommand() 객체를 통해서 초기화된다
		String viewPage = command.exec(request, response); //(interface) 요청 Command를 수행하고 그 결과를 String 타입으로 받아옴
//		System.out.println("viewPage : " + viewPage);
		
		//viewResolve
		if(!viewPage.endsWith(".do") && !viewPage.equals(null)) {
			//결과의 마지막이 .do 가 붙어있지 않고 / 결과가 null이 아니면
			if(viewPage.startsWith("ajax:")) {
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			viewPage = "WEB-INF/views/" + viewPage + ".jsp"; //시스템에서 접근 가능한 폴더를 더해줌
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response); //원하는 페이지 호출&전달(내가 가져온 데이터를 활용)
		} else {
			//.do 혹은 null이 들어온 경우
			response.sendRedirect(viewPage); //.do로 권한 위임 처리
		}
	}

}
