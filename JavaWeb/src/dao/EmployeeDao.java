/**
 *
 */


package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;
import util.ConnectDatabase;
import util.SqlQuery;

/**
 * @author User
 * Create date Dec 4, 2017
 */
public class EmployeeDao {
	/**
	 * @description Get all employee in database and return to ViewServlet
	 * @author User
	 * @date Dec 4, 2017
	 * @exception SQLException
	 */
	public static List<Employee> getAllEmployee() throws SQLException{
		List<Employee> list = new ArrayList<Employee>();
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(ConnectDatabase.db_Url);
			PreparedStatement ps = conn.prepareStatement(SqlQuery.SELECT_ALL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){  
	      Employee e=new Employee();  
	      e.setId(rs.getInt(1));  
	      e.setfName(rs.getString(2));  
	      e.setlName(rs.getString(3));  
	      e.setPhoneNumber(rs.getString(4));  
	      e.setGender(rs.getString(5));  
	      e.setVehicle(rs.getString(7));  
	      list.add(e);
			}
		} catch (Exception ex){
			ex.printStackTrace();
			System.out.println("error");
		}
		return list;  
	}
	
	/**
	 * @description Update a employee by id
	 * @author User
	 * @date Dec 4, 2017
	 * @exception SQLException, ClassNotFoundException
	 */
	public static boolean update(Employee e) throws SQLException,ClassNotFoundException{ 
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection conn = DriverManager.getConnection(ConnectDatabase.db_Url);
    PreparedStatement ps=conn.prepareStatement(SqlQuery.UPDATE);  
    ps.setString(1,e.getfName());  
    ps.setString(2,e.getlName());  
    ps.setString(3,e.getPhoneNumber());  
    ps.setString(4,e.getGender());
    ps.setString(5,e.getVehicle());    
    ps.setInt(6,e.getId());  
    try {
    	ps.executeUpdate();             
    } catch(Exception ex){
    	 ex.printStackTrace();
    	 System.out.println("error");
    	 return false;
     }  
     return true;
	}
	
	/**
	 * @description Insert a employee into database
	 * @author User
	 * @date Dec 4, 2017
	 * @exception SQLException, ClassNotFoundException
	 */
	public static boolean insert(Employee e) throws SQLException,ClassNotFoundException{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(ConnectDatabase.db_Url);
 	 	PreparedStatement ps=conn.prepareStatement(SqlQuery.INSERT);
   	ps.setString(1,e.getfName());  
   	ps.setString(2,e.getlName());  
   	ps.setString(3,e.getPhoneNumber());  
   	ps.setString(4,e.getGender());  
   	ps.setString(5,e.getVehicle()); 
    try {   
   	 	ps.executeUpdate();   	 	  
		} catch(Exception ex){
			ex.printStackTrace();
			return false;
		}  
		return true;  
	}
	

	/**
	 * @description 
	 * @author User
	 * @date Dec 4, 2017
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 * @param id
	 */
	public static boolean delete(int id) throws SQLException,ClassNotFoundException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(ConnectDatabase.db_Url);
   	PreparedStatement ps=conn.prepareStatement(SqlQuery.DELETE);
   	ps.setInt(1,id);
   	try {
   		ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * @description Get info of a employee by id
	 * @author User
	 * @date Dec 4, 2017
	 * @exception SQLException, ClassNotFoundException
	 */
	public static Employee getEmployeeById(int id) throws SQLException, ClassNotFoundException{  
    Employee e=new Employee();  
    Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    Connection conn = DriverManager.getConnection(ConnectDatabase.db_Url);
    PreparedStatement ps=conn.prepareStatement(SqlQuery.SELECT_ONE);  
    ps.setInt(1,id);  
    ResultSet rs=ps.executeQuery();
    while (rs.next()) {
	    e.setId(rs.getInt(1));  
	    e.setfName(rs.getString(2));  
	    e.setlName(rs.getString(3));  
	    e.setPhoneNumber(rs.getString(4));  
	    e.setGender(rs.getString(5));  
	    e.setVehicle(rs.getString(7));    
    }
    return e;
	}  
}
