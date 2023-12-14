package servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.xdevapi.Statement;

/**
 * Servlet implementation class DisplayImage
 */
public class DisplayImage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayImage() {
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
		String imageId = request.getParameter("imageId");
		int id = Integer.parseInt(imageId);
		
		Connection conn = null;
		int imgId = 0 ;
		String imgFileName = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project_db","root","");
			String query ="SELECT * FROM `image`";
			PreparedStatement ps = conn.prepareStatement(query)  ;
			
		
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				if(rs.getInt(1)==id) {
					
					imgId = rs.getInt(1);
					imgFileName = rs.getString(2);
				}
			}
		
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(imgFileName);
		System.out.println(imgId);
		RequestDispatcher rd;
		request.setAttribute("id", String.valueOf(imgId));
		request.setAttribute("img", imgFileName);
		rd = request.getRequestDispatcher("displayImage.jsp");
		rd.forward(request, response);
	}

}
