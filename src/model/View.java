package model;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import GUI.LoginGUI;
import GUI.MainMenuGUI;
import GUI.UserFormPanel;
import GUI.WelcomeScreenGUI;

public class View extends JFrame {
	JPanel currentPanel;
	JPanel errorPanel = new JPanel();
	GridBagConstraints current;
	Container thisContainer;
	JLayeredPane layeredPanel;
	
	private JPanel testPanel;
	private LoginGUI login;
	private MainMenuGUI mainmenu;
	private WelcomeScreenGUI welcomeScreen;
	private UserFormPanel formPanel;

	public View() throws IOException {
		// TODO Auto-generated constructor stub

		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		thisContainer = getContentPane();

		layeredPanel=new JLayeredPane();
		layeredPanel.setLayout(new GridBagLayout());
		
		
		login = new LoginGUI();
		mainmenu=MainMenuGUI.getInstance();
		formPanel = new UserFormPanel();
		welcomeScreen = new WelcomeScreenGUI();
		
		currentPanel=new JPanel();
		currentPanel.setLayout(new GridBagLayout());
		current=new GridBagConstraints();
		current.gridheight=3;
		current.gridwidth=3;
		current.gridx=0;
		current.gridy=0;
		current.weightx=1;
		current.weighty=1;
		current.fill=GridBagConstraints.BOTH;
		current.anchor=GridBagConstraints.FIRST_LINE_START;
		currentPanel.add(login.getPanel(),current);
		
		layeredPanel.add(welcomeScreen.getWelcomePanel(),current,new Integer(2));
		layeredPanel.add(currentPanel,current, new Integer(1));
		login.getPanel().setVisible(false);
		login.getSubmit().setEnabled(false);
		
		thisContainer.add(layeredPanel);
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
		
		currentPanel.removeAll();
		currentPanel.add(mainmenu.getPanel(),current);

		currentPanel.validate();
		currentPanel.repaint();
	}

	public void logout() {
	
		currentPanel.removeAll();
		currentPanel.add(login.getPanel(),current);

		welcomeScreen.getWelcomePanel().setVisible(false);
		login.startTimer();
		
		currentPanel.validate();
		currentPanel.repaint();
		
	}

	public WelcomeScreenGUI getWelcomeScreen() {
		return welcomeScreen;
	}

	public void setWelcomeScreen(WelcomeScreenGUI welcomeScreen) {
		this.welcomeScreen = welcomeScreen;
	}
	
	public void idle(){
		welcomeScreen.getWelcomePanel().setLocation(0,0);
		login.getSubmit().setEnabled(false);
		welcomeScreen.getWelcomePanel().setVisible(true);
		
	}

	public void getErrorMessage() {
		JOptionPane.showMessageDialog(errorPanel,"Incorrect Password", "ERROR!!", JOptionPane.ERROR_MESSAGE);		
	}

}
