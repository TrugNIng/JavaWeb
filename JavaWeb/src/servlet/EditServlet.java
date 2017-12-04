package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

/**
 * Servlet implementation class EditServlet
 */
@WebServlet("/EditServlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @description Edit info of a employee by id and redirect to View page
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
    PrintWriter out=response.getWriter();  
    out.println("<h1>Update Employee</h1>");  
    String sid=request.getParameter("id");  
    int id=Integer.parseInt(sid);
    Employee e = new Employee();  
    try{
    	e = EmployeeDao.getEmployeeById(id);
    } catch (SQLException ex) {
      ex.printStackTrace();
      System.out.println("error1");
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    out.print("<form action='EditServlet2' method='POST'>");  
    out.print("<table>");  
    out.print("<tr><td></td><td><input type='hidden' name='id' value='"+e.getId()+"'/></td></tr>");  
    out.print("<tr><td>First Name:</td><td><input type='text' name='fname' value='"+e.getfName()+"'/></td></tr>");  
    out.print("<tr><td>Last Name:</td><td><input type='text' name='lname' value='"+e.getlName()+"'/></td></tr>");  
    out.print("<tr><td>Phone Number:</td><td><input type='text' name='phonenumber' value='"+e.getPhoneNumber()+"'/></td></tr>");  
    out.print("<tr><td>Gender:</td><td><input type='text' name='gender' value='"+e.getGender()+"'/></td></tr>"); 
    out.print("<tr><td>Vehicle:</td><td><input type='text' name='vehicle' value='"+e.getVehicle()+"'/></td></tr>");    
    out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
    out.print("</table>");  
    out.print("</form>");
      
    out.close();  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
