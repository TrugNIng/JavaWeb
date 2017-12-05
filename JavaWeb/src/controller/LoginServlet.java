package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub 
		String username, password;
		try {
			username=request.getParameter("username");
			password=request.getParameter("password");
			User user = new User(username,password);
			String result = UserDao.checkUser(user);
			
			RequestDispatcher rDispatcher;
			HttpSession session;
			
			if("SUCCESS".equals(result)) {
				session = request.getSession();
				session.setAttribute("user", user);
				rDispatcher = request.getRequestDispatcher("UserLogged.jsp");
				rDispatcher.forward(request, response);
			} else {
				rDispatcher = request.getRequestDispatcher("ViewEmployee.jsp");
				rDispatcher.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			throw new ServletException();
		}
	}
}
