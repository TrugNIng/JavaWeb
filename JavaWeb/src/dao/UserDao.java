/**
 *
 */


package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import model.User;
import util.ConnectDatabase;
import util.SqlQuery;

/**
 * @author User
 * Create date Dec 5, 2017
 */
public class UserDao {
	public static String checkUser(User user) throws SQLException, ServletException, ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(ConnectDatabase.db_Url);
		PreparedStatement ps=conn.prepareStatement(SqlQuery.User.SELECT_ONE);
		ps.setString(1, user.getUserName());
		ps.setString(2, user.getPassWord());
		try {
	    ResultSet rs=ps.executeQuery();
	    if (rs.next())
				return "SUCCESS";
			else
				return "FAIL";
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					throw new ServletException();
				}
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					throw new ServletException();
				}
			}
		}
	}
}
