package co.knh.prj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDAO extends DAO {
	//조회
	public ArrayList<DeptVO> selectDept(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		getConnect();
		
		String sql = "select * from departments order by department_id";
		
		try {
			PreparedStatement psmt = conn.prepareStatement(sql); //쿼리문 실행
			ResultSet rs = psmt.executeQuery();
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
}
