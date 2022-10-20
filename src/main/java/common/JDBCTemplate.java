package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	// OJDBC 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	// DB연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "semitest";
	private static final String PASSWORD = "1234";
	
	//private 생성자
	private JDBCTemplate() {}
	
	//DB연결 객체
	private static Connection conn;
	
	//Connection객체 반환 메소드 - 싱글톤패턴 적용
	public static Connection getConnection() {
		
		//첫 DB연결일 때만 수행
		if ( conn == null ) {
			
			try {
				//드라이버 로드
				Class.forName(DRIVER);
				
				//DB연결
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
				//AutoCommit 설정 끄기
				conn.setAutoCommit(false);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//DB연결 객체 반환
		return conn;
	}

	//Connection 객체 닫기
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Statement 객체 닫기
	public static void close(Statement st) {
		try {
			if(st!=null && !st.isClosed()) st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//PreparedStatement 객체 닫기
	public static void close(PreparedStatement ps) {
		try {
			if(ps!=null && !ps.isClosed()) ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ResultSet 객체 닫기
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed()) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//commit 수행
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//rollback 수행
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed()) conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
