package co.micol.prj.dept;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class DeptDAO extends DAO {
	//조회
	public ArrayList<DeptVO> selectDept(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		
		try {
			getConnect();
			String sql = "select * from departments order by department_id";
			psmt = conn.prepareStatement(sql); //쿼리문 실행
			rs = psmt.executeQuery();
			while(rs.next()) {
				DeptVO vo = new DeptVO();
				vo.setDeptId(rs.getString("department_id"));
				vo.setDeptName(rs.getString("department_name"));
				vo.setManagerId(rs.getString("manager_id"));
				vo.setLocId(rs.getString("location_id"));
				
				list.add(vo);
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return list;
	}
	
	//단건 조회
	public DeptVO selectOne(String department_id){
		DeptVO vo = new DeptVO();
		try {
			getConnect();
			String sql = "select * from departments where department_id = ?";
			psmt = conn.prepareStatement(sql); //쿼리문 실행
			psmt.setString(1, department_id);
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setDeptId(rs.getString("department_id"));
				vo.setDeptName(rs.getString("department_name"));
				vo.setManagerId(rs.getString("manager_id"));
				vo.setLocId(rs.getString("location_id"));
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return vo;
	}
	
	//등록
	public int deptInsert(DeptVO vo) {
		int cnt = 0;
		try {
			getConnect();
			String sql = " insert into departments(department_id, department_name) values(?, ?) ";
			psmt = conn.prepareStatement(sql);
			// ?에 값 넣기
			psmt.setString(1, vo.getDeptId());
			psmt.setString(2, vo.getDeptName());
			cnt = psmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return cnt;
	}
	
	//수정
	public int deptUpdate(DeptVO vo) {
		int r = 0;
		
		return r;
	}
	
	
	
	//삭제
}
