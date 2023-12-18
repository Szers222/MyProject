package servlet;

import jakarta.servlet.ServletException;

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
 * Servlet implementation class ShowAllProductServlet
 */

public class ShowAllProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShowAllProductServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String pageParameter = request.getParameter("page");
		int cpage = (pageParameter != null && !pageParameter.isEmpty()) ? Integer.parseInt(pageParameter) : 1;
		int perPage = 9;
		ArrayList<Category> listCategory = CategoryDAO.getAllCategory();
		ArrayList<Watch> listWatch = new ArrayList<>();

		if (id == null || !id.matches("\\d+")) {
		    try {
		        // Lấy danh sách tất cả sản phẩm
		        listWatch = WatchDAO.getAllProducts(cpage, perPage);
		    } catch (Exception e) {
		        System.out.println("Loi ne" + e);
		    }
		} else {
		    try {
		        int idWatch = Integer.parseInt(id);

		        // Lấy danh sách sản phẩm theo danh mục
		        listWatch = WatchDAO.getAllProductsByCategoryId(idWatch, cpage, perPage);
		    } catch (Exception e) {
		        System.out.println("Loi ne " + e);
		    }
		}

		request.setAttribute("perPage", perPage);
		request.setAttribute("id", id);
		request.setAttribute("listWatch", listWatch);
		request.setAttribute("listCategory", listCategory);
		request.getRequestDispatcher("home.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
