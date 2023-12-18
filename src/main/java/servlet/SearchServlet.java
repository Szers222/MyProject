package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import core.Category;
import core.Watch;
import dao.CategoryDAO;
import dao.WatchDAO;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String key = request.getParameter("search");
		String xpage = request.getParameter("page");
		ArrayList<Watch> listWatch = WatchDAO.searchAllProductsByCategoryId(key,1,3);
		
		ArrayList<Category> listCategory = CategoryDAO.getAllCategory();
		
		if(xpage != null) {
			try {
				
				int cpage = Integer.parseInt(request.getParameter("page"));
				if (cpage != 0) {
					listWatch =WatchDAO.searchAllProductsByCategoryId(key,cpage,3);
				} else {
					listWatch = WatchDAO.searchAllProductsByCategoryId(key,1,3);
				}

			} catch (Exception e) {
				System.out.println("Loi ne " + e);
			}
		}
		request.setAttribute("key", key);
		request.setAttribute("listWatch", listWatch);
		request.setAttribute("listCategory", listCategory);
		request.getRequestDispatcher("search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
