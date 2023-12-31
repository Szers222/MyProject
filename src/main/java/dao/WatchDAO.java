package dao;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;

import core.Watch;
import jakarta.servlet.http.Part;

public class WatchDAO extends DatabaseUtil {

	private static Connection conn;

	private static ArrayList<Watch> listWatch;

	// Get all Products
	public static ArrayList<Watch> getAllWatches() {
		ArrayList<Watch> listWatch = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement preparedStmt = conn.prepareStatement("SELECT * FROM `watches`");
				ResultSet rs = preparedStmt.executeQuery()) {

			while (rs.next()) {
				Watch watch;
				try {
					watch = mapResultSetToWatch(rs);
					listWatch.add(watch);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("Error getAllWatches: " + e);
		}

		return listWatch;
	}

	private static Watch mapResultSetToWatch(ResultSet rs) throws SQLException, IOException {
		Watch watch = new Watch();
		watch.setWatchId(rs.getInt("id"));
		watch.setWatchName(rs.getString("name"));
		watch.setWatchPrice(rs.getDouble("price"));
		watch.setWatchDescription(rs.getString("description"));

		// Xử lý ảnh
		Blob blob = rs.getBlob("image");

		InputStream inputStream = blob.getBinaryStream();
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[4096];
		int bytesRead = -1;

		try {
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}

			byte[] imageBytes = outputStream.toByteArray();
			String base64Image = Base64.getEncoder().encodeToString(imageBytes);
			inputStream.close();

			watch.setBase64Image(base64Image);
			watch.setWatchCategoryId(rs.getInt("category_id"));

		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			try {
				inputStream.close();
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw e;
			}
		}

		return watch;
	}

	// Get a product by id
	public static Watch getWatchById(int id) {
		try (Connection conn = getConnection();
				PreparedStatement preparedStmt = conn.prepareStatement("SELECT * FROM `watches` WHERE id = ?")) {

			preparedStmt.setInt(1, id);
			try (ResultSet rs = preparedStmt.executeQuery()) {
				if (rs.next()) {
					return mapResultSetToWatch(rs);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.err.println("Error getWatchById: " + e);
		}

		return null;
	}

	public static ArrayList<Watch> getWatchesByCategoryId(int categoryId) {
		ArrayList<Watch> listWatch = new ArrayList<>();
		try (Connection conn = getConnection();
				PreparedStatement preparedStmt = conn
						.prepareStatement("SELECT * FROM `watches` WHERE category_id = ?")) {

			preparedStmt.setInt(1, categoryId);
			try (ResultSet rs = preparedStmt.executeQuery()) {
				while (rs.next()) {
					Watch watch = mapResultSetToWatch(rs);
					listWatch.add(watch);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.err.println("Error getWatchesByCategoryId: " + e);
		}

		return listWatch;
	}

	// Insert product
	public static int insertProduct(Watch watch) {
		int status = 0;
		try (Connection conn = getConnection();
				PreparedStatement ps = conn.prepareStatement(
						"INSERT INTO `watches` (`name`, `price`, `description`, `image`, `category_id`) VALUES (?, ?, ?, ?, ?)")) {

			ps.setString(1, watch.getWatchName());
			ps.setDouble(2, watch.getWatchPrice());
			ps.setString(3, watch.getWatchDescription());

			// Assuming getImageBytes() returns a byte array
			byte[] imageBytes = watch.getImageBytes();
			ByteArrayInputStream inputStream = new ByteArrayInputStream(imageBytes);
			ps.setBinaryStream(4, inputStream, imageBytes.length);

			ps.setInt(5, watch.getWatchCategoryId());

			status = ps.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Error: insertProduct " + e);
		}
		return status;
	}

	// Update product
	public static int updateProduct(Watch watch, Part filePart) {
		int status = 0;
		try (Connection conn = getConnection()) {

			// Truy vấn để lấy giá trị cũ của cột image
			String selectQuery = "SELECT image FROM watches WHERE id = ?";
			try (PreparedStatement selectPs = conn.prepareStatement(selectQuery)) {
				selectPs.setInt(1, watch.getWatchId());
				try (ResultSet rs = selectPs.executeQuery()) {
					if (rs.next()) {
						// Lấy giá trị cũ của cột image
						Blob oldImageBlob = rs.getBlob("image");

						// Truy vấn cập nhật
						String updateQuery = "UPDATE watches SET name=?, price=?, description=?, image=?, category_id=? WHERE id=?";
						try (PreparedStatement updatePs = conn.prepareStatement(updateQuery)) {
							updatePs.setString(1, watch.getWatchName());
							updatePs.setDouble(2, watch.getWatchPrice());
							updatePs.setString(3, watch.getWatchDescription());

							if (filePart != null && filePart.getSize() > 0) {
								// Nếu có tập tin mới, đọc dữ liệu từ Part và thực hiện cập nhật
								updatePs.setBlob(4, filePart.getInputStream());
							} else if (oldImageBlob != null) {
								// Nếu không có tập tin mới, sử dụng giá trị cũ của cột image nếu có
								updatePs.setBlob(4, oldImageBlob);
							} else {
								// Nếu không có giá trị cũ và không có tập tin mới, đặt cột image thành null
								updatePs.setNull(4, java.sql.Types.BLOB);
							}

							updatePs.setInt(5, watch.getWatchCategoryId());
							updatePs.setInt(6, watch.getWatchId());

							// Thực hiện cập nhật
							status = updatePs.executeUpdate();
						}
					}
				}
			}
		} catch (SQLException | IOException e) {
			System.err.println("Error: updateProduct " + e);
		}
		return status;
	}

	public static byte[] readImageData(InputStream inputStream) throws IOException {
		try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
			byte[] buffer = new byte[4096];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
			return outputStream.toByteArray();
		}
	}

	// Delete product
	public static int deleteProduct(int id) {
		int status = 0;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM `watches` WHERE `id` = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.err.println("Error: deleteProduct " + e);
		}
		return status;
	}

	// Search product
	public static ArrayList<Watch> searchProduct(String key) {
		listWatch = new ArrayList<Watch>();
		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM `watches` WHERE name LIKE ? OR description LIKE ? ");
			ps.setString(1, "%" + key + "%");
			ps.setString(2, "%" + key + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Watch watch = mapResultSetToWatch(rs);
				listWatch.add(watch);
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("Error getProductsByCategoryId : " + e);
		}
		return listWatch;
	}

	// process total
	public static int gettotal() {
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT count(*) FROM `watches`");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	// Get total
	public static int gettotalById(int id) {
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT count(*) FROM `watches` WHERE category_id = ? ");
			ps.setInt(id, 1);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	public static int gettotalByKey(String key) {
		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT count(*) FROM `watches` WHERE name LIKE ? OR description LIKE ?");
			ps.setString(1, "%" + key + "%");
			ps.setString(2, "%" + key + "%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
			}
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}

	// getAllProducts
	public static ArrayList<Watch> getAllProducts(int currentPage, int perPage) {
		int startRecord = (currentPage - 1) * perPage;
		listWatch = new ArrayList<Watch>();
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `watches` LIMIT ?,?");
			ps.setInt(1, startRecord);
			ps.setInt(2, perPage);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Watch watch = mapResultSetToWatch(rs);
				listWatch.add(watch);
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("Error getAllWatch: " + e);
		}
		return listWatch;
	}

	// get all products by catogeries
	public static ArrayList<Watch> getAllProductsByCategoryId(int categoryId, int currentPage, int perPage) {
		ArrayList<Watch> listWatch = new ArrayList<>();
		int startRecord = (currentPage - 1) * perPage;

		try (Connection conn = getConnection();
				PreparedStatement ps = conn
						.prepareStatement("SELECT * FROM watches  WHERE category_id = ? LIMIT ?,?")) {

			ps.setInt(1, categoryId);
			ps.setInt(2, startRecord);
			ps.setInt(3, perPage);

			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Watch watch = mapResultSetToWatch(rs);
					listWatch.add(watch);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.err.println("Error getAllProductsByCategoryId: " + e);
		}

		return listWatch;
	}

	public static ArrayList<Watch> searchAllProductsByCategoryId(String key, int currentPage, int perPage) {
		listWatch = new ArrayList<Watch>();
		int startRecord = (currentPage - 1) * perPage;
		try {
			conn = getConnection();
			PreparedStatement ps = conn
					.prepareStatement("SELECT * FROM watches WHERE name LIKE ? OR description LIKE ? LIMIT ?,?");
			ps.setString(1, "%" + key + "%");
			ps.setString(2, "%" + key + "%");
			ps.setInt(3, startRecord);
			ps.setInt(4, perPage);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Watch watch = mapResultSetToWatch(rs);
				listWatch.add(watch);
			}
			conn.close();
		} catch (Exception e) {
			System.err.println("Error getProductsByCategoryId : " + e);
		}

		return listWatch;
	}

	// Pagination
	public static String getPaginationBar(String url, int total, int page, int perPage, int offset) {
		String link = "";
		String firstLink = "";
		String prevLink = "";
		String nextLink = "";
		String lastLink = "";
		if (total <= 0) {
			return link;
		}
		int totalLinks = (int) Math.ceil(total * 1.0 / perPage);
		if (totalLinks <= 1) {
			return link;
		}
		int from = page - offset;
		int to = page + offset;
		if (from <= 0) {
			from = 1;
		}
		if (to > totalLinks) {
			to = totalLinks;
		}
		if (page > 1) {
			firstLink = "<li class='page-item' " + (page == 1 ? "disabled" : "") + "'><a class='page-link' href='" + url
					+ "?page=1'> << </a></li>";
			prevLink = "<li class='page-item' " + (page == 1 ? "disabled" : "") + "'><a class='page-link' href='" + url
					+ "?page=" + (page - 1) + "'> < </a></li>";
		}

		if (page < totalLinks) {
			lastLink = "<li class='page-item' " + (page == totalLinks ? "disabled" : "")
					+ "'><a class='page-link' href='" + url + "?page=" + totalLinks + "'> >> </a></li>";
			nextLink = "<li class='page-item' " + (page == totalLinks ? "disabled" : "")
					+ "'><a class='page-link' href='" + url + "?page=" + (page + 1) + "'> > </a></li>";
		}
		link = "<nav aria-label='...'> " + "<ul class='pagination' style='justify-content: center;'>" + firstLink
				+ prevLink;

		for (int i = from; i <= to; i++) {

			link += "<li class='" + (i == page ? "page-item active" : "")
					+ "' aria-current='age'><a class='page-link' href='" + url + "?page=" + (i) + "'>" + i
					+ "</a></li>";
		}
		link += nextLink + lastLink + "</ul></nav>";
		return link;
	}

	public static String getSearchPaginationBar(String url, int total, int page, int perPage, int offset, String key) {
		String link = "";
		String firstLink = "";
		String prevLink = "";
		String nextLink = "";
		String lastLink = "";
		if (total <= 0) {
			return link;
		}
		int totalLinks = (int) Math.ceil(total * 1.0 / perPage);
		if (totalLinks <= 1) {
			return link;
		}
		int from = page - offset;
		int to = page + offset;
		if (from <= 0) {
			from = 1;
		}
		if (to > totalLinks) {
			to = totalLinks;
		}
		if (page > 1) {
			firstLink = "<li class='page-item' " + (page == 1 ? "disabled" : "") + "'><a class='page-link' href='" + url
					+ "?page=1&search=" + key + "'> << </a></li>";
			prevLink = "<li class='page-item' " + (page == 1 ? "disabled" : "") + "'><a class='page-link' href='" + url
					+ "?page=" + (page - 1) + "&search=" + key + "'> < </a></li>";
		}

		if (page < totalLinks) {
			lastLink = "<li class='page-item' " + (page == totalLinks ? "disabled" : "")
					+ "'><a class='page-link' href='" + url + "?page=" + totalLinks + "&search=" + key
					+ "'> >> </a></li>";
			nextLink = "<li class='page-item' " + (page == totalLinks ? "disabled" : "")
					+ "'><a class='page-link' href='" + url + "?page=" + (page + 1) + "&search=" + key
					+ "'> > </a></li>";
		}
		link = "<nav aria-label='...'> " + "<ul class='pagination' style='justify-content: center;'>" + firstLink
				+ prevLink;

		for (int i = from; i <= to; i++) {

			link += "<li class='" + (i == page ? "page-item active" : "")
					+ "' aria-current='age'><a class='page-link' href='" + url + "?page=" + (i) + "&search=" + key
					+ "'>" + i + "</a></li>";
		}
		link += nextLink + lastLink + "</ul></nav>";
		return link;
	}

	public static String getPaginationBarById(String url, int total, int page, int perPage, int offset, int key) {
		String link = "";
		String firstLink = "";
		String prevLink = "";
		String nextLink = "";
		String lastLink = "";
		if (total <= 0) {
			return link;
		}
		int totalLinks = (int) Math.ceil(total * 1.0 / perPage);
		if (totalLinks <= 1) {
			return link;
		}
		int from = page - offset;
		int to = page + offset;
		if (from <= 0) {
			from = 1;
		}
		if (to > totalLinks) {
			to = totalLinks;
		}
		if (page > 1) {
			firstLink = "<li class='page-item' " + (page == 1 ? "disabled" : "") + "'><a class='page-link' href='" + url
					+ "?page=1&id=" + key + "'> << </a></li>";
			prevLink = "<li class='page-item' " + (page == 1 ? "disabled" : "") + "'><a class='page-link' href='" + url
					+ "?page=" + (page - 1) + "&id=" + key + "'> < </a></li>";
		}

		if (page < totalLinks) {
			lastLink = "<li class='page-item' " + (page == totalLinks ? "disabled" : "")
					+ "'><a class='page-link' href='" + url + "?page=" + totalLinks + "&id=" + key + "'> >> </a></li>";
			nextLink = "<li class='page-item' " + (page == totalLinks ? "disabled" : "")
					+ "'><a class='page-link' href='" + url + "?page=" + (page + 1) + "&id=" + key + "'> > </a></li>";
		}
		link = "<nav aria-label='...'> " + "<ul class='pagination' style='justify-content: center;'>" + firstLink
				+ prevLink;

		for (int i = from; i <= to; i++) {

			link += "<li class='" + (i == page ? "page-item active" : "")
					+ "' aria-current='age'><a class='page-link' href='" + url + "?page=" + (i) + "&id=" + key + "'>"
					+ i + "</a></li>";
		}
		link += nextLink + lastLink + "</ul></nav>";
		return link;
	}

	public static void main(String[] args) {

	}
}
