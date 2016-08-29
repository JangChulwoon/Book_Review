package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import bean.Board;
import bean.Reple;
import db.DB_TemQuery;
import db.DB_TemUpdate;
import db.DB_inp;

public class BoarderDao {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DB_inp dbset = null;
	static Logger logger = Logger.getLogger(BoarderDao.class);

	public BoarderDao() {
		this.dbset = new DB_inp();
	}

	private String getTimeStamp() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(new Date());
	}

	public List<Map<String, String>> boarder_detail(String num) {
		StringBuilder strbuild = new StringBuilder(
				"SELECT *,convert(description using utf8) as descriptions ,convert(contents using utf8) as content FROM board where num=");
		strbuild.append("'").append(num).append("'");
		return dbset.getList(strbuild.toString());
	}

	public void Reple_insert(Reple reple) {
		RInsert("insert into reple (num, id, content, date) values(?, ?, ?, ?);", reple);
	}

	public void Board_Update(Board board, String num) {
		StringBuilder stb = new StringBuilder(
				"update board set subject= ?, writer= ?, contents=?, reg_date=?, bookname=?, author=?, publisher=?, publication_date=?, book_img=?, description=? where num =");
		stb.append("'").append(num).append("';");
		Bupdate(stb.toString(), board);
	}

	public void boarder_insert(Board board) {
		Binsert(board,
				"insert into board (subject, writer, contents, reg_date, bookname, author, publisher, publication_date, book_img, description) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);");
		System.out.println(board.getBookname());
	}

	public List<Map<String, String>> reple_selectAll(String num) {
		StringBuilder strbuild = new StringBuilder(
				"SELECT id,date,convert(content using utf8) as contents FROM reple where num = ");
		strbuild.append("'").append(num).append("'").append(" order by count asc;");
		return dbset.getList(strbuild.toString());
	}

	public List<Map<String, String>> boarder_count() {
		String sql = "SELECT count(*) as size FROM board;";
		return dbset.getList(sql);
	}

	public void Board_Delete(String num) {
		StringBuilder stb = new StringBuilder("DELETE from board where num =");
		stb.append("'").append(num).append("';");
		delete(stb.toString());
	}

	public void Reple_Delete(String num) {
		StringBuilder stb = new StringBuilder("DELETE from reple where num =");
		stb.append("'").append(num).append("';");
		delete(stb.toString());
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

	private void Bupdate(final String query, Board board) {
		DB_TemUpdate temp = new DB_TemUpdate() {
			@Override
			public PreparedStatement QueryTemplate(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, board.getSubject());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getContents());
				pstmt.setString(4, getTimeStamp());
				pstmt.setString(5, board.getBookname());
				pstmt.setString(6, board.getAuthor());
				pstmt.setString(7, board.getPublisher());
				pstmt.setString(8, board.getPublication_date());
				pstmt.setString(9, board.getBook_img());
				pstmt.setString(10, board.getDescription());
				return pstmt;
			}
		};
		dbset.Template_Update(dbset.dbinit(), temp);
	}

	private void RInsert(final String query, Reple reple) {
		DB_TemUpdate temp = new DB_TemUpdate() {
			@Override
			public PreparedStatement QueryTemplate(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setInt(1, reple.getNum());
				pstmt.setString(2, reple.getId());
				pstmt.setString(3, reple.getContext());
				pstmt.setString(4, getTimeStamp());
				return pstmt;
			}
		};
		dbset.Template_Update(dbset.dbinit(), temp);
	}

	private void Binsert(Board board, final String query) {
		DB_TemUpdate temp = new DB_TemUpdate() {
			@Override
			public PreparedStatement QueryTemplate(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				System.out.println(board.getBookname());
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, board.getSubject());
				pstmt.setString(2, board.getWriter());
				pstmt.setString(3, board.getContents());
				pstmt.setString(4, getTimeStamp());
				pstmt.setString(5, board.getBookname());
				pstmt.setString(6, board.getAuthor());
				pstmt.setString(7, board.getPublisher());
				pstmt.setString(8, board.getPublication_date());
				pstmt.setString(9, board.getBook_img());
				pstmt.setString(10, board.getDescription());
				logger.info(new Timestamp(System.currentTimeMillis()) + " check :: " + pstmt);
				return pstmt;
			}
		};
		dbset.Template_Update(dbset.dbinit(), temp);
	}

	public List<Map<String, String>> getBoardCount_search(String keyword, String key) {
		StringBuilder str = new StringBuilder("SELECT  count(*) as size FROM board where ");
		str.append(keyword).append(" like '%").append(key).append("%';");
		return dbset.getList(str.toString());
	}

	public List<Map<String, String>> boarder_List(int first) {
		StringBuilder str = new StringBuilder("SELECT num,subject,bookname,writer FROM board order by num desc limit ");
		str.append(first).append(",10;");
		return dbset.getList(str.toString());
	}

	public List<Map<String, String>> boarder_SearchDB(String keyword, String key, int start) {
		StringBuilder str = new StringBuilder(
				"SELECT *,convert(description using utf8) as descriptions FROM board where ");
		str.append(keyword).append(" like '%").append(key).append("%' order by num desc limit ").append(start)
				.append(",10;");
		logger.info(str);
		return dbset.getList(str.toString());
	}

}
