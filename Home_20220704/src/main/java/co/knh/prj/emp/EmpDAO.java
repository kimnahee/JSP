package co.knh.prj.emp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.knh.prj.DAO;

public class EmpDAO extends DAO{
	//jobs 전체 조회
	public ArrayList<JobsVO> selectJobs(){
		ArrayList<JobsVO> list = new ArrayList<JobsVO>();
		
		String sql = "select * from jobs order by job_id";
		try {
			getConnect();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				JobsVO vo = new JobsVO();
				vo.setJobId(rs.getString("job_id"));
				vo.setJobTitle(rs.getString("job_title"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}
	//전체 조회
	public ArrayList<EmpVO> selectAll(String departmentId){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			//1. 연결
			getConnect();
			//2. sql 구문 준비
			String sql = "select * from employees order by employee_id";
			
			if(departmentId != null && !departmentId.isEmpty()) {
				sql += "where department_id = ? ";
			}
			
			sql += " order by employee_id";
			
			psmt = conn.prepareStatement(sql);
			
			if(departmentId!=null && !departmentId.isEmpty()) {
				psmt.setString(1, departmentId);
			}
			
			rs = psmt.executeQuery(); //실행
			while(rs.next()) { //조회결과 처리(list에 담아서 추가)
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setSalary(rs.getString("salary"));
				
				list.add(vo);
			}
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			//4. 연결 해제
			disConnect();
		}
		return list;
	}
	//1건 조회
	public EmpVO selectOne(String id) { //매개변수 : 사원번호
		EmpVO vo = new EmpVO();
		try {
			String sql = "select * from employees where employee_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getEmployeeId());
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				vo.setLastName(rs.getString("last_name"));
				vo.setEmail(rs.getString("email"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setJobId(rs.getString("job_id"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
				
		return vo;
	}
	//등록
	public int insert(EmpVO vo) { //
		int cnt = 0;
		String sql = "insert into employees(employee_id, last_name, email, hire_date, job_id) values(?, ?, ?, ?, ?)";
		try {
			getConnect();
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1, vo.getEmployeeId());
			psmt.setString(2, vo.getLastName());
			psmt.setString(3, vo.getEmail());
			psmt.setString(4, vo.getHireDate());
			psmt.setString(5, vo.getJobId());
			
			cnt = psmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		
		return cnt;
	}
	
	//수정
	
	//삭제
	
}
