package co.micol.prj.emp;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import co.micol.prj.comm.DAO;

public class EmpDAO extends DAO {
	// jobs 전체 조회
	public ArrayList<JobsVO> selectJobs() {
		ArrayList<JobsVO> list = new ArrayList<JobsVO>();
		try {
			getConnect();
			String sql = "select * from jobs order by job_id";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();

			while (rs.next()) {
				JobsVO vo = new JobsVO();
				vo.setJobId(rs.getString("job_id"));
				vo.setJobTitle(rs.getString("job_title"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return list;
	}

	// 전체 조회
	public ArrayList<EmpVO> selectAll(String departmentId) {
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			// 1. 연결
			getConnect();
			// 2. sql 구문 준비
			String sql = "select * from employees ";

			if (departmentId != null && !departmentId.isEmpty()) {
				sql += "where department_id = ? ";
			}

			sql += " order by employee_id";

			psmt = conn.prepareStatement(sql);

			if (departmentId != null && !departmentId.isEmpty()) {
				psmt.setString(1, departmentId);
			}

			rs = psmt.executeQuery(); // 실행
			while (rs.next()) { // 조회결과 처리(list에 담아서 추가)
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setSalary(rs.getString("salary"));
				vo.setJobId(rs.getString("job_id"));
				vo.setHireDate(rs.getString("hire_date"));
				vo.setEmail(rs.getString("email"));
				vo.setDepartmentId(rs.getString("department_id"));

				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 4. 연결 해제
			disConnect();
		}
		return list;
	}

	// 단건 조회
	public EmpVO selectOne(String employeeId) { // 매개변수 : 사원번호
		EmpVO vo = new EmpVO();
		try {
			getConnect();
			String sql = "select * from employees where employee_id = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setString(1, employeeId);
			rs = psmt.executeQuery();
			if (rs.next()) {

				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setLastName(rs.getString("last_name"));
				vo.setSalary(rs.getString("salary"));
				vo.setHireDate(rs.getString("hire_date").substring(0, 10));
				vo.setEmail(rs.getString("email"));
				vo.setJobId(rs.getString("job_id"));
				vo.setDepartmentId(rs.getString("department_id"));
				// deptId 추가
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}

		return vo;
	}

	// 등록
	public int insert(EmpVO vo) { //
		int cnt = 0;
		try {
			getConnect();
			// 실행할 쿼리문
			String sql = "insert into employees(employee_id, last_name, email, hire_date, job_id, salary) "
					+ "values ((select max(employee_id)+1 from employees), ?, ?, ?, ?, ?)";
			// 사번을 서브쿼리로 실행 => 입력
			// sql 실행
			psmt = conn.prepareStatement(sql);
			// 실행했을 때 form에서 받아온 파라미터로 만든 vo가 매개변수
			// vo의 파라미터를 순서대로 입력
			psmt.setString(1, vo.getLastName());
			psmt.setString(2, vo.getEmail());
			psmt.setString(3, vo.getHireDate());
			psmt.setString(4, vo.getJobId());
			psmt.setString(5, vo.getSalary());
			// cnt 반환
			cnt = psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}

	// 수정
	public int update(EmpVO vo) {
		int cnt = 0;
		
		return cnt;
	}

	// 삭제
	public int delete(String employeeId) {
		int cnt = 0;
		try {
			getConnect();
			String sql = "delete from employees where employee_id = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, employeeId);
			cnt = psmt.executeUpdate(); 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			disConnect();
		}
		return cnt;
	}
}
