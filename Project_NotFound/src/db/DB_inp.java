package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;


public class DB_inp {
	static Logger logger = Logger.getLogger(DB_inp.class);
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	public DB_inp() {
		// default constructor
	}

	public Connection dbinit() {
		// DB init
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/notfound", "jsp", "passwd");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

		}
		return conn;
	}

	public void Template_Update(Connection conn, DB_Template temp) {
		try {
			pstmt = temp.QueryTemplate(conn);
			pstmt.executeUpdate(); // ������ �����Ѵ�.

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			logger.info(new Timestamp(System.currentTimeMillis()) + " :: " + pstmt);
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public <T> List<T> Template_Query(Connection conn, DB_Template temp, T object) {
		List<T> list = null;
		try {
			list = new ArrayList<T>();
			pstmt = temp.QueryTemplate(conn);
			rs = pstmt.executeQuery(); 
			while(rs.next()){
				 // ������ ��� ������ ?
				// �� �Խñ� / ��� / ȸ�� ���� ��� �� �޼ҵ忡�� �������������� ?
				rs.getString(1);
				// 1. 2 �߹迭�� ���� �����´� ? 
				// 2. map �� list �� �Բ� ����ؼ� �����´� 
				// 3. �̺κ��� �� �����غ��� ..
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			logger.info(new Timestamp(System.currentTimeMillis()) + " :: " + pstmt);
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

}