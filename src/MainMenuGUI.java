import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainMenuGUI {

	
	private JPanel framePanel;
	private JTabbedPane tabbedPane;
	private JPanel logoutPanel;
	private JButton logoutButton;
	
	private CustomerGUI customerTab;
	private UserGUI userTab;
	
	public MainMenuGUI(){
		
		framePanel=new JPanel();
		framePanel.setLayout(new BorderLayout());
		tabbedPane=new JTabbedPane();
		
		
		customerTab=new CustomerGUI();
		userTab=new UserGUI();
		
		tabbedPane.addTab("Customers",customerTab.getPanel());
		tabbedPane.addTab("Users",userTab.getPanel());
		
		framePanel.add(tabbedPane,BorderLayout.CENTER);
		
		logoutPanel=new JPanel();
		logoutPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		logoutButton=new JButton("LOGOUT");
		
		logoutPanel.add(logoutButton);
		
		
		
		framePanel.add(logoutPanel,BorderLayout.SOUTH);
		
		
	}
	
	
	
	public JPanel getPanel(){
		
		return framePanel;
	}



	public JPanel getFramePanel() {
		return framePanel;
	}



	public void setFramePanel(JPanel framePanel) {
		this.framePanel = framePanel;
	}



	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}



	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}



	public JPanel getLogoutPanel() {
		return logoutPanel;
	}



	public void setLogoutPanel(JPanel logoutPanel) {
		this.logoutPanel = logoutPanel;
	}



	public JButton getLogoutButton() {
		return logoutButton;
	}



	public void setLogoutButton(JButton logoutButton) {
		this.logoutButton = logoutButton;
	}



	public CustomerGUI getCustomerTab() {
		return customerTab;
	}



	public void setCustomerTab(CustomerGUI customerTab) {
		this.customerTab = customerTab;
	}



	public UserGUI getUserTab() {
		return userTab;
	}



	public void setUserTab(UserGUI userTab) {
		this.userTab = userTab;
	}
	
	
	
	
}
