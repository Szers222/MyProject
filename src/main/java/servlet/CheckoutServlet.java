package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import core.Order;
import core.Watch;

/**
 * Servlet implementation class CheckoutServlet
 */
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CheckoutServlet() {
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
		 HttpSession session = request.getSession();

	        // Kiểm tra xem người dùng đã đăng nhập chưa
	        User user = (User) session.getAttribute("user");
	        if (user == null) {
	            // Nếu chưa đăng nhập, chuyển hướng đến trang đăng nhập
	            response.sendRedirect("login.jsp");
	            return;
	        }

	        // Lấy thông tin giỏ hàng từ session
	        ArrayList<Watch> cart = (ArrayList<Watch>) session.getAttribute("cart");
	        if (cart == null || cart.isEmpty()) {
	            // Nếu giỏ hàng trống rỗng, chuyển hướng đến trang giỏ hàng
	            response.sendRedirect("cart.jsp");
	            return;
	        }

	        // Tính tổng số tiền cần thanh toán
	        double totalAmount = 0;
	        for (Watch watch : cart) {
	            totalAmount += watch.getTotal();
	        }

	        // Tạo đối tượng Order và OrderItem để lưu thông tin đơn hàng
	        Order order = new Order();
	        order.setUser(user);
	        order.setOrderDate(new Date());
	        order.setTotalAmount(totalAmount);

	        // Lưu đơn hàng vào cơ sở dữ liệu và lấy ID của đơn hàng vừa tạo
	        int orderId = OrderDAO.insertOrder(order);

	        // Lưu thông tin chi tiết đơn hàng (OrderItem) vào cơ sở dữ liệu
	        for (Watch watch : cart) {
	            OrderItem orderItem = new OrderItem();
	            orderItem.setOrder(order);
	            orderItem.setWatch(watch);
	            orderItem.setQuantity(watch.getQuantity());
	            orderItem.setSubtotal(watch.getTotal());
	            OrderDAO.insertOrderItem(orderItem);
	        }

	        // Xoá giỏ hàng sau khi thanh toán
	        session.removeAttribute("cart");

	        // Chuyển hướng đến trang xác nhận đơn hàng
	        response.sendRedirect("orderConfirmation.jsp?orderId=" + orderId);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String address = request.getParameter("address");
        String creditCard = request.getParameter("creditCard");

        // Tạo đối tượng Order để lưu thông tin đơn hàng
        Order order = new Order(firstName, lastName, username, address, creditCard);

        // Lấy thông tin giỏ hàng từ session
        HttpSession session = request.getSession();
        ArrayList<Watch> cart = (ArrayList<Watch>) session.getAttribute("cart");

        // Kiểm tra xem giỏ hàng có sản phẩm hay không
        if (cart != null && !cart.isEmpty()) {
            // Lưu thông tin giỏ hàng vào đơn hàng
            order.setCart(cart);

            // Đặt đối tượng Order vào session
            session.setAttribute("order", order);

            // Xóa thông tin giỏ hàng sau khi thanh toán
            session.removeAttribute("cart");

            // Chuyển hướng đến trang xác nhận đơn hàng
            response.sendRedirect("confirmation.jsp");
        } else {
            // Nếu giỏ hàng trống, chuyển hướng người dùng trở lại giỏ hàng hoặc trang chọn sản phẩm
            response.sendRedirect("cart.jsp");
        }
	}

}
