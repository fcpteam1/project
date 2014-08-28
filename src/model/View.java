package model;

import java.awt.Container;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import GUI.LoginGUI;
import GUI.MainMenuGUI;
import GUI.UserFormPanel;

public class View extends JFrame {

	JPanel currentPanel;
	Container thisContainer;

	private LoginGUI login;
	private MainMenuGUI mainmenu;
	private UserFormPanel formPanel;

	public View() throws IOException {
		// TODO Auto-generated constructor stub

		setSize(600, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		thisContainer = getContentPane();

		login = new LoginGUI();
		mainmenu = new MainMenuGUI();
		formPanel = new UserFormPanel();

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
		formPanel.removeAll();
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

	public void changeToMaineMenu() {

		thisContainer.removeAll();
		thisContainer.add(mainmenu.getPanel());

		thisContainer.validate();
		thisContainer.repaint();
	}

	public void logout() {
		thisContainer.removeAll();
		thisContainer.add(login.getPanel());

		thisContainer.validate();
		thisContainer.repaint();

	}

}
