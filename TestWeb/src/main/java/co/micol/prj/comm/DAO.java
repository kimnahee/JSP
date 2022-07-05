package co.micol.prj.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO {
	public Connection conn; //다른 패키지에서도 쓸 수 있게 public
	public PreparedStatement psmt;
	//Statement, PreparedStatment, CallableStatement
	//sql 쿼리문 실행 : DML => int r = executeUpdate(건수 반환)
	//             : select(조회) => ResultSet rs = executeQuery()
	
	public ResultSet rs;
	//              : rs => 결과 집합
	//커서 이동 메소드 : rs.next(), previous(), first, absolrute(4)
	//컬럼 값을 읽는 메소드 : getXXX()(데이터 타입별로)
	
	public void getConnect() {
		try {
			//jar(다운로드) => 드라이버, 라이브러리 : ojdbcX.jar
			//드라이버 메모리 로딩(class.forname)
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//DB 연결 Connection 생성(클래스)
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr"); //계정 변경 
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//연결 해제 = conn.close()
	public void disConnect() {
		if(conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(psmt != null) {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
