package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import core.User;

public class UserDAO extends DatabaseUtil {
	private static Connection conn;
	private static ArrayList<User> listUser;
	private static User user;
	//Get All User
	public static ArrayList<User> getAllUser(){
		listUser = new ArrayList<User>();
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `users_db`");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				user = new User (rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
				listUser.add(user);
			}
			conn.close();
		} catch (Exception e) {
			System.out.println("Error getAllUser: " + e);
		}
		
		return listUser;
	}
	//Insert user
	public static int insertUser(User user) {
		int status = 0;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("INSERT INTO `users_db`(`name`, `username`, `password`) VALUES (?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());

			status = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println("Error insertUser: " + e);
		}
		return status;
	}
	//Update user
	public static int updateUser(User user) {
		int status = 0;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("UPDATE `users_db` SET `name`=?,`username`=?,`password`=?,`role`=? WHERE id = ?");
			ps.setString(1, user.getName());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setInt(4, user.getRole());
			ps.setInt(5, user.getIdUser());
			status = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println("Error updateUser: " + e);
		}
		return status;
	}
	public static int deleteUser(int id) {
		int status = 0;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("DELETE FROM `users_db` WHERE `id` = ?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			System.out.println("Error deleteUser: " + e);
		}
		return status;
	}
	public static boolean iAdmin(String username, String password) {
		
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `users_db` WHERE `username` = ? AND `password` = ? AND `role` = ?");
			ps.setString(1, username);
			ps.setString(2, password);
			ps.setInt(3, 1);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	public static boolean iUser(String username, String password) {
		
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement("SELECT * FROM `users_db` WHERE `username` = ? AND `password` = ? ");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
	
}
