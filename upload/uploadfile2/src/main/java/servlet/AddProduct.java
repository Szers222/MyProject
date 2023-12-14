package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@MultipartConfig
/**
 * Servlet implementation class AddProduct
 */
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
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
		String title = request.getParameter("title");
		Part img = request.getPart("image");
		String fileName = img.getSubmittedFileName();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		InputStream is = null;

		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db", "root", "");

		    ps = conn.prepareStatement("INSERT INTO `images`(`title`, `image`) VALUES (?, ?)");
		    ps.setString(1, title);
		    is = img.getInputStream();
		    ps.setBlob(2, is);

		    int count = ps.executeUpdate();

		    System.out.println(title);
		    System.out.println(fileName);

		    if (count > 0) {
		        System.out.println("Successfully inserted");
		    } else {
		        System.out.println("Failed to insert");
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		} finally {
		    try {
		        if (is != null) {
		            is.close();
		        }
		        if (rs != null) {
		            rs.close();
		        }
		        if (ps != null) {
		            ps.close();
		        }
		        if (conn != null) {
		            conn.close();
		        }
		    } catch (Exception e2) {
		        e2.printStackTrace();
		    }
		}
	}
	

}
