package GUI;
import java.awt.event.ActionListener;
import java.util.EventObject;


public class UserFormEvent extends EventObject {
	
	private String username;
	private String password;
	private String id;
	private Boolean admin;

	public UserFormEvent(Object source) {
		super(source);
	}
	
	public UserFormEvent(Object source, String username, String password, String id, Boolean admin) {
		super(source);
		
		this.username = username;
		this.password = password;
		this.id = id;
		this.admin = admin;
	}

	
	public UserFormEvent(Object source, String username, String password) {
		super(source);
		
		this.username = username;
		this.password = password;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}



}
