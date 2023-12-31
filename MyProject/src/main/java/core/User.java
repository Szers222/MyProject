package core;

public class User {
	//Fields
	private String username,password,name;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private int role;
	private int idUser;
	
	
	//Properties

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	//Constructor
	public User(int idUser, String username, String password, int role) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	public User( String username, String password, int role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}
	//Method
	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", username=" + username + ", password=" + password + ", role=" + role + "]";
	}
	
	
	
}
