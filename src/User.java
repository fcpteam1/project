public class User {

	private String username;
	private String password;
	private int id;
	private boolean admin = false;
	
	public User() {
		this.username = "";
		this.password = "";
		this.id = 0;
	}

	public User(String username, String password, int id, boolean admin) {
		this.username = username;
		this.password = password;
		this.id = id;
		this.admin = admin;
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
