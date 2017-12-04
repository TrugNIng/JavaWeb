package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import model.Employee;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/ViewServlet")
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @description Show all employee in table
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
    PrintWriter out=response.getWriter();  
    out.println("<a href='form.jsp'>Add New Employee</a>");  
    out.println("<h1>Employees List</h1>");  
    List<Employee> list = new ArrayList<Employee>();  
    try{
    	list = EmployeeDao.getAllEmployee();  
    } catch (Exception e) {
    	e.printStackTrace();
    	out.println("error");
    }
      
    out.print("<table border='1' width='100%'");  
    out.print("<tr>"
    		+ "<th>Employee Id</th>"
    		+ "<th>First Name</th>"
    		+ "<th>Last Name</th>"
    		+ "<th>Phone Number</th>"
    		+ "<th>Gender</th>"
    		+ "<th>Vehicle</th>"
    		+ "<th>Edit</th>"
    		+ "<th>Delete</th></tr>");  
    for(Employee e:list){  
     out.print("<tr>"
     		+ "<td>"+e.getId()+"</td>"
     		+ "<td>"+e.getfName()+"</td>"
     		+ "<td>"+e.getlName()+"</td>"
     		+ "<td>"+e.getPhoneNumber()+"</td>"
     		+ "<td>"+e.getGender()+"</td>"
     		+ "<td>"+e.getVehicle()+"</td>"
     		+ "<td><a href='EditServlet?id="+e.getId()+"'>Edit</a></td>"
     		+ "<td><a href='DeleteServlet?id="+e.getId()+"'>Delete</a></td></tr>");  
    }  
    out.print("</table>");  
      
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
