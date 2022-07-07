package co.micol.prj.board;
import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class BoardDAO extends DAO{
	//전체조회
	public ArrayList<BoardVO> selectAll(){
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			getConnect();
			String sql = "select * from board order by id desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRdt(rs.getString("rdt"));
				vo.setHit(rs.getString("hit"));
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
	//단건 조회
	public BoardVO selectOne(String id) {
		BoardVO vo = new BoardVO();
		try {
			getConnect();
			String sql = "select * from board where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setId(rs.getString("id"));
				vo.setTitle(rs.getString("title"));
				vo.setContent(rs.getString("content"));
				vo.setWriter(rs.getString("writer"));
				vo.setRdt(rs.getString("rdt"));
				vo.setHit(rs.getString("hit"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return vo;
	}
	
	//등록
	public int insert(BoardVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "insert into board(id, title, content, writer, rdt, hit) "
					+ "values((select max(id)+1 from board), ?, ?, ?, sysdate, ?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getHit());
			
			cnt = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}
	//삭제
	public int delete(String id) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "delete from board where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			cnt = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}
	//수정
	public int update(BoardVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "update board set title = ?, content = ?, writer = ?"
						 + " where id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getTitle());
			psmt.setString(2, vo.getContent());
			psmt.setString(3, vo.getWriter());
			psmt.setString(4, vo.getId());
			cnt = psmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}
}
