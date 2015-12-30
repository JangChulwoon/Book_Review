package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Board;
import bean.User;

public class UserDao {

	private PreparedStatement pstmt = null;
	private ResultSet rs = null;


	public void insertDB(Connection conn, User user) {
		try {
			String sql = "insert into user values(?,?,?);"; // sql ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUseremail());
			pstmt.setString(2, user.getUserpd());
			pstmt.setString(3, user.getUsername());
			pstmt.executeUpdate(); // ������ �����Ѵ�.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("user insert�� ����");
		}
	}

	// ���̵� �޾Ƽ� üũ�� ������ null�� .. ������ User�� �������ٻ��� ...
	public User loginDB(Connection conn, String id) {
		User user = new User();
		try {
			String sql = "select * from user where email =?;"; // sql ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // ������ �����Ѵ�.
			if (rs.next()) {
				user.setUseremail(rs.getString("email"));
				user.setUserpd(rs.getString("pass"));
				user.setUsername(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("loginDB ����");
		}
		if (user.getUseremail() == null) {
			user.setUseremail("");
		}
		return user;
	}
	public boolean idcheck(Connection conn,String id){
		try {
			String sql = "select email from user where email =?;"; // sql ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // ������ �����Ѵ�.
			
			if (rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	
}
