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
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @description Insert a employee and redirect to View page
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");  
    PrintWriter out=response.getWriter();  
      
    String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String phone = request.getParameter("areacode") + request.getParameter("phonenumber1") + request.getParameter("phonenumber2");
		String gender = request.getParameter("gender");
		String vehicle = request.getParameter("vehicle"); 
      
    Employee e=new Employee();  
    e.setfName(firstName); 
    e.setlName(lastName);
    e.setPhoneNumber(phone);
    e.setGender(gender);
    e.setVehicle(vehicle);
    
    try{
    	EmployeeDao.insert(e);  
    } catch (SQLException ex) {
      ex.printStackTrace();
    } catch (ClassNotFoundException ex) {
      ex.printStackTrace();
    }
    response.sendRedirect("ViewServlet");
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
