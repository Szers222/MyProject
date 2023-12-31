package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import core.Category;
import core.Watch;
import dao.CategoryDAO;
import dao.WatchDAO;

/**
 * Servlet implementation class DeleteWatchServlet
 */
public class DeleteWatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteWatchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String id = request.getParameter("id");
		if(!id.isEmpty()) {
			try {
				int xid = Integer.parseInt(id);
				int status = WatchDAO.deleteProduct(xid);
				ArrayList<Watch> listWatch = WatchDAO.getAllWatches();
				request.setAttribute("listWatch", listWatch);
				request.getRequestDispatcher("watchmanagement.jsp").forward(request, response);
			} catch (Exception e) {
				System.out.println("error" + e);
			}
			
		}
	}

}
