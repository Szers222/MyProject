package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import core.Category;
import core.Watch;
import dao.WatchDAO;

/**
 * Servlet implementation class CartServlet
 */
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String id = request.getParameter("id");
		String action = request.getParameter("action");
		String totalAllParam = request.getParameter("total");
	
		

		double getTotalAll = 0; // Giá trị mặc định hoặc bất kỳ giá trị mặc định phù hợp khác

		if (totalAllParam != null && !totalAllParam.trim().isEmpty()) {
		    try {
		        getTotalAll = Double.parseDouble(totalAllParam);

		    } catch (NumberFormatException e) {
		        // Xử lý trường hợp tham số không phải là số double hợp lệ
		        e.printStackTrace(); // Ghi log cho ngoại lệ hoặc thực hiện xử lý lỗi khác
		    }
		}

		try {
		    int xid = Integer.parseInt(id);

		    HttpSession sessionCart = request.getSession();
		    ArrayList<Watch> cart = (ArrayList<Watch>) sessionCart.getAttribute("cart");

		    if (cart == null) {
		        cart = new ArrayList<>();
		        sessionCart.setAttribute("cart", cart);
		    }
		    Watch watch = WatchDAO.getWatchById(xid);

		    if (watch != null) {
		        if (action != null && action.equals("remove")) {
		            if (!cart.isEmpty()) {
		                for (Watch cartWatch : cart) {
		                    if (cartWatch.getWatchId() == xid) {
		                        // Trừ đi tổng của sản phẩm đã xóa khỏi tổng chung
		                        getTotalAll -= cartWatch.getTotal();
		                        cart.remove(cartWatch);
		                        break;
		                    }
		                }

		                // Nếu giỏ hàng trống rỗng sau khi xóa sản phẩm, đặt tổng về 0
		                if (cart.isEmpty()) {
		                    getTotalAll = 0;
		                    // Xóa thuộc tính phiên khi giỏ hàng trống rỗng
		                    sessionCart.removeAttribute("getTotalAll");
		                }
		            }
		            sessionCart.setAttribute("getTotalAll", getTotalAll);
		            response.sendRedirect("cart.jsp");
		        }else if (action != null && action.equals("updateQuantity")) {
		            String quantity = request.getParameter("quantity");
		            int newQuantity = Integer.parseInt(quantity);

		            for (Watch cartWatch : cart) {
		                if (cartWatch.getWatchId() == xid) {
		                    // Cập nhật số lượng và tổng của sản phẩm
		                    cartWatch.setQuantity(newQuantity);
		                   getTotalAll = cartWatch.setTotal(cartWatch.getWatchPrice() * newQuantity);
		                    break;
		                }
		            }

		            // Cập nhật tổng chung của giỏ hàng
		            double totalAll = 0;
		            for (Watch cartWatch : cart) {
		                totalAll += cartWatch.getTotal();
		            }
		            sessionCart.setAttribute("getTotalAll", totalAll);
		            
		            response.getWriter().write("Success");
		        }
		        else {

		            // Kiểm tra xem sản phẩm đã tồn tại trong giỏ hàng chưa
		            boolean productExists = false;

		            for (Watch cartWatch : cart) {
		                if (cartWatch.getWatchId() == xid) {
		                    // Nếu sản phẩm đã tồn tại, tăng số lượng của nó
		                    cartWatch.setQuantity(cartWatch.getQuantity() + 1);
		                    productExists = true;
		                    break;
		                }

		            }

		            // Nếu sản phẩm không tồn tại, thêm nó vào giỏ hàng
		            if (!productExists) {
		                cart.add(watch);
		                watch.setQuantity(1);
		            }
		            for (Watch cartWatch : cart) {
		                getTotalAll += cartWatch.getTotal();
		            }
		        }
		        
		        int size = cart.size();
		        
		        // Đặt giỏ hàng được cập nhật vào phiên
		        sessionCart.setAttribute("cart", cart);
		        sessionCart.setAttribute("size", size);
		        // Đặt watchList trong yêu cầu để sử dụng trong JSP
		        sessionCart.setAttribute("watchList", cart);
		        sessionCart.setAttribute("getTotalAll", getTotalAll);
		    }

		    response.sendRedirect("index.jsp");

		} catch (Exception e) {
		    // TODO: xử lý ngoại lệ
		}
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
