package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface DB_TemQuery {
	public ResultSet QueryTemplate(Connection con) throws SQLException;
}
