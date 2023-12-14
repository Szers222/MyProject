package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

import core.Product;
import dao.ProductDAO;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        int productId = Integer.parseInt(request.getParameter("id"));
       
         
        try {
            // Validate and retrieve the product ID from the request parameter
            try {
                productId = Integer.parseInt(request.getParameter("id"));
            } catch (NumberFormatException e) {
                throw new ServletException("Invalid product ID format", e);
            }

            ProductDAO dao = new ProductDAO();
            Product product = dao.get(productId);

            // Set the product as a request attribute
            request.setAttribute("sanpham", product); // Changed attribute name to "sanpham"

            // Forward the request to the JSP page
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("displayproduct.jsp");
            requestDispatcher.forward(request, response);
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
