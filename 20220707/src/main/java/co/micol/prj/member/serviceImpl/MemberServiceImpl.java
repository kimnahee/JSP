package co.micol.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import co.micol.prj.comm.DataSource;
import co.micol.prj.member.service.MemberService;
import co.micol.prj.member.vo.MemberVO;

public class MemberServiceImpl implements MemberService {
	//DAO
	private DataSource dao = DataSource.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	
	@Override
	public List<MemberVO> memberSelectList() {
		//전체조회
		List<MemberVO> list = new ArrayList<MemberVO>(); //결과를 담을 리스트 객체
		MemberVO vo; //사용할 vo
		String sql = "SELECT * FROM MEMBER";
		
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new MemberVO();
				vo.setMemberId(rs.getString("member_id")); //DB에 있는 Column 이름으로
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuthor(rs.getString("member_author"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally{
			close();
		}
		return list;
	}

	@Override
	public MemberVO memberSelectOne(MemberVO vo) {
		//vo 객체가 매개변수로 넘어와서 vo 객체를 만들 필요가 x
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setMemberId(rs.getString("member_id"));
				//vo.setMemberPassword(rs.getString("member_password")); //보통 패스워드는 보여주지도 않고 암호화되어서 볼수도 없음
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuthor(rs.getString("member_author"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}

	@Override
	public int memberInsert(MemberVO vo) {
		int r = 0;
		String sql = "INSERT INTO MEMBER (MEMBER_ID, MEMBER_PASSWORD, MEMBER_NAME, MEMBER_AUTHOR) VALUES(?, ?, ?, ?)";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			psmt.setString(3, vo.getMemberName());
			psmt.setString(4, vo.getMemberAuthor());
			r = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int memberUpdate(MemberVO vo) {
		//권한, 패스워드만 변경가능
		int r = 0;
		String sql = "UPDATE MEMBER SET MEMBER_PASSWORD = ?, MEMBER_AUTHOR = ? WHERE MEMBER_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberPassword());
			psmt.setString(2, vo.getMemberAuthor());
			psmt.setString(3, vo.getMemberId());
			r = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public int memberDelete(MemberVO vo) {
		int r = 0;
		String sql = "DELETE FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			r = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return r;
	}

	@Override
	public boolean isMemberIdCheck(String id) {
		//id를 조회했을 때 나오는 데이터(rs.next())가 없으면 true 반환, 아니면 false
		boolean check = false;
		String sql = "SELECT MEMBER_ID FROM MEMBER WHERE MEMBER_ID = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			if(!rs.next()) {
				check = true;
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return check;
	}

	@Override
	public MemberVO memberLogin(MemberVO vo) {
		//id, password 체크해서 맞는 회원의 정보를 조회?
		String sql = "SELECT * FROM MEMBER WHERE MEMBER_ID = ? AND MEMBER_PASSWORD = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getMemberId());
			psmt.setString(2, vo.getMemberPassword());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setMemberId(rs.getString("member_id"));
				vo.setMemberPassword(rs.getString("member_password"));
				vo.setMemberName(rs.getString("member_name"));
				vo.setMemberAuthor(rs.getString("member_author"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return vo;
	}
	
	private void close() {
		//disConnect(열린 순서의 반대로 닫아야함 rs>psmt>conn)
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
	}

}
