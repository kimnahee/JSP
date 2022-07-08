package co.micol.prj.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.comm.Command;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.serviceImpl.MemberServiceImpl;

public class AjaxMemberIdCheck implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// Ajax를 이용한 아이디 중복체크
		MemberService memberDao = new MemberServiceImpl();
		//return값 : boolean
		String id = request.getParameter("id"); //Ajax에서 가져온 id 값을 getParameter로 읽어들임
		boolean b = memberDao.isMemberIdCheck(id);
		String result = "Used";
		if(!b) {
			result = "Un Used";
		}
		return "ajax:" + result; //결과가 Ajax 호출이라는 것을 view resolve에게 알려주기 위해
	}

}
