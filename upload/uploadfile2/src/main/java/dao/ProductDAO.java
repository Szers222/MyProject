package dao;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import core.Product;
 
public class ProductDAO {
	 String databaseURL = "jdbc:mysql://localhost:3306/project_db";
	    String user = "root";
	    String password = "";

	    public Product get(int id) throws SQLException, IOException {
	        Product product = null;

	        String sql = "SELECT * FROM images WHERE id = ?";

	        try (Connection connection = DriverManager.getConnection(databaseURL, user, password)) {
	            PreparedStatement statement = connection.prepareStatement(sql);
	            statement.setInt(1, id);
	            ResultSet result = statement.executeQuery();

	            if (result.next()) {
	                product = new Product();
	                int productId = result.getInt("id");
	                String title = result.getString("title");

	                Blob blob = result.getBlob("image");

	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;

	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);
	                }

	                byte[] imageBytes = outputStream.toByteArray();
	                String base64Image = Base64.getEncoder().encodeToString(imageBytes);

	                inputStream.close();
	                outputStream.close();

	                product.setId(productId);
	                product.setTitle(title);
	                product.setBase64Image(base64Image);
	            }

	        } catch (SQLException | IOException ex) {
	            ex.printStackTrace();
	            throw ex;
	        }

	        return product;
	    }
}

