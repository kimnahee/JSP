package co.micol.prj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class EmpDAO extends DAO{
	//전체 조회
	public ArrayList<EmpVO> selectAll(){
		ArrayList<EmpVO> list = new ArrayList<EmpVO>();
		try {
			//1. 연결
			getConnect();
			//2. sql 구문 준비
			String sql = "select * from employees order by employee_id";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql); //실행
			while(rs.next()) { //조회결과 처리(list에 담아서 추가)
				EmpVO vo = new EmpVO();
				vo.setEmployeeId(rs.getString("employee_id"));
				vo.setFirstName(rs.getString("first_name"));
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
		
		return vo;
	}
	//등록
	public int insert(EmpVO vo) {
		int cnt = 0;
		
		return cnt;
	}
	
	//수정
	
	//삭제
	
}
