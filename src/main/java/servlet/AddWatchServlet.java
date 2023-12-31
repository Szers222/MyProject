package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


import core.Watch;

import dao.WatchDAO;

/**
 * Servlet implementation class AddWatchServlet
 */
@MultipartConfig
public class AddWatchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddWatchServlet() {
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

		try {
			// Lấy dữ liệu từ request
			String watchName = request.getParameter("name");
			double watchPrice = Double.parseDouble(request.getParameter("price"));
			String watchDescription = request.getParameter("description");
			
			int watchCategoryId = Integer.parseInt(request.getParameter("categoryid"));

			// Kiểm tra và xử lý dữ liệu, có thể thêm validation ở đây

			// Đọc dữ liệu từ Part (file upload) thành mảng bytes
			
			// Tạo đối tượng Watch
			Watch watch = new Watch(watchName, watchPrice, watchDescription, imageBytes, watchCategoryId);

			// Gọi phương thức cập nhật trong lớp quản lý dữ liệu
			WatchDAO.insertProduct(watch);

			ArrayList<Watch> listWatch = WatchDAO.getAllWatches();

			// Chuyển hướng về trang hiển thị danh sách sau khi cập nhật
			request.setAttribute("listWatch", listWatch);
			response.sendRedirect("WatchServlet");
		} catch (Exception ex) {
			// Xử lý lỗi nếu cần
			ex.printStackTrace(); // Log the exception or handle it more gracefully
			response.sendRedirect(request.getContextPath() + "/error.jsp");
		}
	}

	private byte[] readImageBytes(Part imagePart) throws IOException {
		InputStream inputStream = imagePart.getInputStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

		byte[] buffer = new byte[4096];
		int bytesRead;

		while ((bytesRead = inputStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, bytesRead);
		}

		return outputStream.toByteArray();
	}
}
