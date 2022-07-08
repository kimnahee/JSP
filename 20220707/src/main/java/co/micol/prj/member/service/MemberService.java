package co.micol.prj.member.service;

import java.util.List;

import co.micol.prj.member.vo.MemberVO;

public interface MemberService {
	
	//회원관련 기능
	
	//Read(전체 or 단건 => 무조건 2개)
	List<MemberVO> memberSelectList(); //회원 전체 조회
	MemberVO memberSelectOne(MemberVO vo); //단건 조회 - Data를 전송할 때 vo 객체를 사용(값을 전부 온전히 전송받음)
	
	int memberInsert(MemberVO vo); //회원 등록 - Create
	int memberUpdate(MemberVO vo); //회원 수정 - Update
	int memberDelete(MemberVO vo); //회원 삭제 - Delete

	boolean isMemberIdCheck(String id); //아이디 중복체크 = 중복 아이디가 존재하면 false(boolean은 default가 false이므로 네이밍에 is 사용)
	MemberVO memberLogin(MemberVO vo); //로그인 처리
}
