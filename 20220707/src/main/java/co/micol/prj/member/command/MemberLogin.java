package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;
import co.micol.prj.member.vo.MemberVO;

public class MemberLogin implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그인 처리, DAO 하나 호출
		//인터페이스는 생성불가 >> MemberServiceImpl()를 사용해서 초기화
		HttpSession session = request.getSession(); //서버가 만들어놓은 세션을 가져온다
		
		MemberService memberDao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		vo.setMemberId(request.getParameter("memberId")); //form 의 input 태그가 가지는 Name(java에서 사용하는 변수이름)
		vo.setMemberPassword(request.getParameter("memberPassword"));
		vo = memberDao.memberLogin(vo);
		
		if(vo.getMemberName() != null) { //name이 not null이면 (존재하면)
			session.setAttribute("id", vo.getMemberId()); //세션에 (id, author) 정보를 담는다
			session.setAttribute("name", vo.getMemberName());
			session.setAttribute("author", vo.getMemberAuthor());
			request.setAttribute("message", vo.getMemberName() + "님 환영합니다.");
		} else {
			request.setAttribute("message", "아이디 또는 패스워드가 일치하지 않습니다.");
		}
		
		return "member/memberLogin";
	}

}
