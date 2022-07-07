package co.micol.prj.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
	private static DataSource dataSource = new DataSource(); //인스턴스 생성
	private Connection conn;
	
	private DataSource() { //private 생성자
		
		
	}
	
	public static DataSource getInstance() { //인스턴스 리턴
		return dataSource;
	}
	
	private Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "micol", "1234");
			System.out.println("연결 성공!");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			System.out.println("연결 실패!");
		}
		return conn;
	}
}
