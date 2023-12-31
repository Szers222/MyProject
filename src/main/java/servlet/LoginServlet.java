package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import core.User;
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String username = request.getParameter("username");
		String passwrod = request.getParameter("password");
		String name = request.getParameter("name");
		boolean isAdmin = UserDAO.iAdmin(username, passwrod);
		boolean isUser = UserDAO.iUser(username, passwrod);
		
		if (name == null) {
			if (!username.isEmpty() && !passwrod.isEmpty() ) {
				try {
					if (isAdmin) {
						HttpSession session = request.getSession();
						session.setAttribute("username", username);
						request.getRequestDispatcher("WatchServlet").forward(request, response);
					} else if (isUser) {
						HttpSession session = request.getSession();
						session.setAttribute("username", username);
						request.getRequestDispatcher("ShowAllProductServlet").forward(request, response);
					} else {
						// Lgoin fail
						request.getRequestDispatcher("login.jsp").forward(request, response);
					}
				} catch (Exception e) {
					System.err.println("Error Login" + e);
				}
			} else {
				// Login Fail
				int status = -2;
				request.setAttribute("status", status);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}

		}else {
			int status = -2;
			if (!username.isEmpty() && !passwrod.isEmpty() &&!name.isEmpty()) {
			User newUser = new User(username, passwrod, name);
			 status = UserDAO.insertUser(newUser);
			request.setAttribute("status", status);
			request.getRequestDispatcher("login.jsp").forward(request, response);
			}
			else {
				request.setAttribute("status", status);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}

}
