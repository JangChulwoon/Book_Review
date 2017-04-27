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

	
	public void insert(final Memo memo) {
		MemoInsertCallBack(memo, "INSERT INTO memo (id,content,date,num) VALUES (?,?,now(),?);");
	}

	private void MemoInsertCallBack(final Memo memo, final String query) {
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
		dbset.Template_Update(dbset.dbinit(), temp);
	}
	
	public List<Map<String, String>> selectList(final String id,final int num) {
		StringBuilder str = new StringBuilder("SELECT * FROM memo where id = ").append("\'").
				append(id).append("\'").append("and num = ").append(num);
		return dbset.getList(str.toString());
	}

}
