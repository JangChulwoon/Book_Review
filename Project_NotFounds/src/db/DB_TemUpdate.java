package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface DB_TemUpdate {
	public PreparedStatement QueryTemplate(Connection con) throws SQLException;
}
