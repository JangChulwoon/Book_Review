package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import bean.Clip;
import db.DB_TemUpdate;
import db.DB_inp;

public class ClipDao {
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private DB_inp dbset = null;
	static Logger logger = Logger.getLogger(ClipDao.class);

	public ClipDao() {
		this.dbset = new DB_inp();
	}

	private String getTimeStamp() {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return f.format(new Date());
	}



	

/*	public void Board_Update(Clip board, String num) {
		StringBuilder stb = new StringBuilder(
				"update board set subject= ?, writer= ?, contents=?, reg_date=?, bookname=?, author=?, publisher=?, publication_date=?, book_img=?, description=? where num =");
		stb.append("'").append(num).append("';");
		Bupdate(stb.toString(), board);
	}

	*/

	public void insert(Clip clip, final String id) {
		clipInsertCallback(clip, "INSERT INTO clip (id,title,state,date) VALUES (?,?,?,now());",id);
	}
	
	public void update(Clip clip, final String id,final int idx) {
		clipUpdateCallback(clip, "update clip set title = ? , state = ? where id = ? and idx = ?",id,idx);
	}

	public List<Map<String, String>> boarder_count() {
		String sql = "SELECT count(*) as size FROM board;";
		return dbset.getList(sql);
	}

	// delete 부분
	public boolean delete(final int idx,final String id){
		String query ="DELETE FROM clip WHERE idx = ? and id = ?";
		return ClipDeleteCallBack(query,idx,id);
	}

	private boolean ClipDeleteCallBack(final String query,final int idx,final String id) {
		DB_TemUpdate db_tmp = new DB_TemUpdate() {
			@Override
			public PreparedStatement QueryTemplate(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, idx);
				pstmt.setString(2, id);
				return pstmt;
			}
		};
		return dbset.Template_Update(dbset.dbinit(), db_tmp);
	}


	private void clipUpdateCallback(Clip clip,final String query,final String id,final int idx) {
		DB_TemUpdate temp = new DB_TemUpdate() {
			@Override
			public PreparedStatement QueryTemplate(Connection con) throws SQLException {
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, clip.getBook_name());
				pstmt.setString(2, clip.getState());
				pstmt.setString(3, id);
				pstmt.setInt(4, idx);
				return pstmt;
			}
		};
		dbset.Template_Update(dbset.dbinit(), temp);
	}

	

	private void clipInsertCallback(Clip clip, final String query, final String id) {
		DB_TemUpdate temp = new DB_TemUpdate() {
			@Override
			public PreparedStatement QueryTemplate(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, id);
				pstmt.setString(2, clip.getBook_name());
				pstmt.setString(3, clip.getState());
				logger.info("insert query"+pstmt.toString());
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

	public List<Map<String, String>> selectList(final String id) {
		// builder로 하기엔 코드가 너무 난잡한데 ..? 
		StringBuilder str = new StringBuilder("SELECT * FROM clip where id = ").append("\'")
				.append(id).append("\'").append(" order by date desc;");
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
