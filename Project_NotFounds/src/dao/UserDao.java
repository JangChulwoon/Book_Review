package dao;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import bean.User;
import db.DB_TemQuery;
import db.DB_TemUpdate;
import db.DB_inp;

public class UserDao {
	private DB_inp dbset = null;

	public UserDao() {
		this.dbset = new DB_inp();
	}
	static Logger logger = Logger.getLogger(UserDao.class);

	public void user_insert(User user) {
		insert("insert into user values(?,?,?,now());", user);
	}

	public void user_deleteAll() {
		delete("delete from user;");
	}

	public List<Map<String, String>> user_login(String email) {
		StringBuilder strbuild = new StringBuilder("select * from user where email =");
		strbuild.append("'").append(email).append("'");
		return dbset.getList(strbuild.toString());
	}

	// ID 가 잇으면 TRUE 없으면 False
	public boolean user_check(String email) {
		StringBuilder strbuild = new StringBuilder("select * from user where email =");
		strbuild.append("'").append(email).append("'");
		return dbset.getList(strbuild.toString()).size()==0?false:true;
	}

	private void insert(final String query, final User user) {
		DB_TemUpdate db_tmp = new DB_TemUpdate() {
			@Override
			public PreparedStatement QueryTemplate(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, user.getUseremail());
				pstmt.setString(2, user.getUserpd());
				pstmt.setString(3, user.getUsername());
				return pstmt;
			}
		};
		dbset.Template_Update(dbset.dbinit(), db_tmp);
	}

	private void delete(final String query) {
		DB_TemUpdate db_tmp = new DB_TemUpdate() {
			@Override
			public PreparedStatement QueryTemplate(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(query);
				return pstmt;
			}

		};
		dbset.Template_Update(dbset.dbinit(), db_tmp);
	}

	//  method dosen't suitable for this class ...
	public void jsback(HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('ID or Password incorrect');");
		out.println("history.back();");
		out.println("</script>");

	}

}
