package model;
public class User {

	private static int count = 0;
	
	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		User.count = count;
	}

	private String username;
	private String password;
	private int id;
	private boolean admin = false;
	
	public User() {
		this.username = "";
		this.password = "";
		this.id = 0;
	}

	public User(String username, String password, boolean admin) {
		this.username = username;
		this.password = password;
		this.admin = admin;
		this.id = count;
		
		count++;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
	
}
