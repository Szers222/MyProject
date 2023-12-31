package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import core.Category;
import core.Watch;
import dao.CategoryDAO;
import dao.WatchDAO;

/**
 * Servlet implementation class UpdateWatchServlet
 */
@MultipartConfig
public class UpdateWatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateWatchServlet() {
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
		Part imagePart = request.getPart("image");
		InputStream imageStream = imagePart.getInputStream();
		byte[] imageBytes = imageStream.readAllBytes();
		
		String id = request.getParameter("id");
		if (id != null && !id.isEmpty()) {
		    try {
		        int watchId = Integer.parseInt(id);
				String watchName = request.getParameter("name");
				double watchPrice = Double.parseDouble(request.getParameter("price"));
				String watchDescription = request.getParameter("description");

				// Lấy dữ liệu của file ảnh từ trường form có tên là "image"
				

				int watchCategoryId = Integer.parseInt(request.getParameter("categoryid"));

				// Thực hiện cập nhật thông tin trong cơ sở dữ liệu hoặc nơi bạn lưu trữ dữ liệu
				WatchDAO watchDAO = new WatchDAO();
				Watch watchToUpdate = new Watch(watchId, watchName, watchPrice, watchDescription, imageBytes,
						watchCategoryId);
				int success = watchDAO.updateProduct(watchToUpdate,imagePart);
			

				// Kiểm tra xem cập nhật thành công hay không
				if (success > 0) {
					// Nếu thành công, chuyển hướng về trang danh sách sản phẩm hoặc trang chi tiết
					// sản phẩm
					ArrayList<Watch> listWatch = WatchDAO.getAllWatches();
					request.setAttribute("listWatch", listWatch);
					request.getRequestDispatcher("watchmanagement.jsp").forward(request, response);
				} else {
					// Xử lý trường hợp cập nhật không thành công (ví dụ: hiển thị thông báo lỗi)
					response.getWriter().println("Update failed!");
				}
		    } catch (NumberFormatException e) {
		        e.printStackTrace();
		        // Xử lý lỗi chuyển đổi số nguyên (NumberFormatException) ở đây
		    }
		}
	}
}

