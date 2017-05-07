package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import bean.Clip;
import bean.Memo;
import db.DB_TemUpdate;
import db.DB_inp;

public class MemoDao {
	static Logger logger = Logger.getLogger(MemoDao.class);
	private DB_inp dbset = null;
	
	public MemoDao() {
		this.dbset = new DB_inp();
	}

	//insert 부분 
	
	public boolean insert(final Memo memo) {
		return MemoInsertCallBack(memo, "INSERT INTO memo (id,content,date,num) VALUES (?,?,now(),?);");
	}

	private boolean MemoInsertCallBack(final Memo memo, final String query) {
		DB_TemUpdate temp = new DB_TemUpdate() {
			@Override
			public PreparedStatement QueryTemplate(Connection con) throws SQLException {
				// TODO Auto-generated method stub
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, memo.getId());
				pstmt.setString(2, memo.getContext());
				pstmt.setInt(3, memo.getNum());
				logger.info("insert query"+pstmt.toString());
				return pstmt;
			}
		};
		return dbset.Template_Update(dbset.dbinit(), temp);
	}
	
	// Select list 부분 
	public List<Map<String, String>> selectList(final String id,final int num) {
		StringBuilder str = new StringBuilder("SELECT * FROM memo where id = ").append("\'").
				append(id).append("\'").append("and num = ").append(num);
		return dbset.getList(str.toString());
	}

	
	
	public boolean delete(final int idx){
		String query ="DELETE FROM memo WHERE num = ?";
		return MemoDeleteCallBack(query,idx);
	}

	private boolean MemoDeleteCallBack(final String query,final int idx) {
		DB_TemUpdate db_tmp = new DB_TemUpdate() {
			@Override
			public PreparedStatement QueryTemplate(Connection conn) throws SQLException {
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, idx);
				return pstmt;
			}
		};
		return dbset.Template_Update(dbset.dbinit(), db_tmp);
	}
}
