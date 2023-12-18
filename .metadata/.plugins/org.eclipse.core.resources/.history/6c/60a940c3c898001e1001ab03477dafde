package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		String username = request.getParameter("username");
		String passwrod = request.getParameter("password");
		boolean isAdmin = UserDAO.iAdmin(username, passwrod);
		boolean isUser = UserDAO.iUser(username, passwrod);
		if(!username.isEmpty() || !passwrod.isEmpty()) {
		try {
			if(isAdmin) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				request.getRequestDispatcher("categorymanagement.jsp").forward(request, response);
			}
			else if(isUser) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				request.getRequestDispatcher("home.jsp").forward(request, response);
			}
			else {
				// Lgoin fail 
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} catch (Exception e) {
			System.err.println("Error Login" + e);
		}
		}
		else {
			//Login Fail
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
	}

}
