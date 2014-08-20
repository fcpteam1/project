
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class View extends JFrame {

	JPanel currentPanel;
	Container thisContainer;
	
	private LoginGUI login;
	private MainMenuGUI mainmenu;
	
	public View() {
		// TODO Auto-generated constructor stub
		
		setSize(600,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		thisContainer=getContentPane();
		
		login=new LoginGUI();
		mainmenu=new MainMenuGUI();
		
		thisContainer.add(login.getPanel());
		pack();
		setVisible(true);
		
		
	}

	public JPanel getCurrentPanel() {
		return currentPanel;
	}

	public void setCurrentPanel(JPanel currentPanel) {
		this.currentPanel = currentPanel;
	}

	public Container getThisContainer() {
		return thisContainer;
	}

	public void setThisContainer(Container thisContainer) {
		this.thisContainer = thisContainer;
	}

	public LoginGUI getLogin() {
		return login;
	}

	public void setLogin(LoginGUI login) {
		this.login = login;
	}

	public MainMenuGUI getMainmenu() {
		return mainmenu;
	}

	public void setMainmenu(MainMenuGUI mainmenu) {
		this.mainmenu = mainmenu;
	}
	
	
	public void changeToMaineMenu(){
		
		thisContainer.removeAll();
		thisContainer.add(mainmenu.getPanel());
		
		thisContainer.validate();
		thisContainer.repaint();
	}
	
	
	public void logout(){
		thisContainer.removeAll();
		thisContainer.add(login.getPanel());
		
		thisContainer.validate();
		thisContainer.repaint();
		
	}

}
