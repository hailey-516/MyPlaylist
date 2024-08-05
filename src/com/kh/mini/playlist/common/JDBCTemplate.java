package com.kh.mini.playlist.common;

import java.sql.*;

public class JDBCTemplate {

	/**
	 * Connection 객체 생성 메소드
	 * 	DB접속 후 해당 Connection 객체를 반환
	 * @return 생성된 Connection 객체
	 */
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe"
												, "C##JDBC"
												, "JDBC");
			conn.setAutoCommit(false);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * Connection 객체를 close 처리해주는 메소드
	 * @param conn
	 */
	public static void close(Connection conn) {
		try {
			
			if (conn != null && !conn.isClosed())
				conn.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
		
	/**
	 * Statement 관련 객체를 전달받아서 close 처리해주는 메소드
	 * @param stmt Statement 객체 또는 그 자식 객체 (PreparedStatement...)
	 */
	public static void close(Statement stmt) {
		try {
			
			if (stmt != null && !stmt.isClosed())
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	/**
	 * ResultSet 객체를 close 처리해주는 메소드
	 * @param rset
	 */
	public static void close(ResultSet rset) {
		try {
			
			if (rset != null && !rset.isClosed())
			rset.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
		
	}