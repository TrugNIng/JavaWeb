/**
 *
 */


package util;

/**
 * @author User
 * Create date Dec 4, 2017
 */
public class SqlQuery {
	public static class User{
		public static final String FIRST_COLUMN = "ID";
		public static final String SECOND_COLUMN = "USERNAME";
		public static final String THIRD_COLUMN = "PASSWORD";
		public static final String SELECT_ONE = "SELECT * FROM [User] WHERE "+SECOND_COLUMN+"=? AND "+THIRD_COLUMN+"=?";
	}
	public static class Employee{
		public static final String FIRST_COLUMN = "ID";
		public static final String SECOND_COLUMN = "FNAME";
		public static final String THIRD_COLUMN = "LNAME";
		public static final String FOUTH_COLUMN = "PHONENUM";
		public static final String FIFTH_COLUMN = "GENDER";
		public static final String SIXTH_COLUMN = "VEHICLE";
		
		public static final String SELECT_ALL = "SELECT * FROM Employee ORDER BY "+FIRST_COLUMN+" ASC";
		public static final String SELECT_ONE = "SELECT * FROM Employee WHERE "+FIRST_COLUMN+"=?";
		public static final String INSERT = "INSERT INTO Employee("+SECOND_COLUMN+","
				+THIRD_COLUMN+","+FOUTH_COLUMN+","+FIFTH_COLUMN+","
				+SIXTH_COLUMN+") VALUES (?,?,?,?,?)";
		public static final String UPDATE = "UPDATE Employee SET "+SECOND_COLUMN+"=?,"
				+THIRD_COLUMN+"=?,"+FOUTH_COLUMN+"=?,"+FIFTH_COLUMN+"=?,"
				+SIXTH_COLUMN+"=? WHERE "+FIRST_COLUMN+"=?";
		public static final String DELETE = "DELETE FROM Employee WHERE "+FIRST_COLUMN+"=?";
	}
}
