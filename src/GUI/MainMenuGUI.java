package GUI;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class MainMenuGUI {

	private JPanel framePanel;
	private JTabbedPane tabbedPane;
	private JPanel logoutPanel;
	private JButton logoutButton;
	
	private CustomerGUI customerTab;
	private UserMainPanel userTab;

	private SupplierGUI supplierTab;
	
public MainMenuGUI() throws IOException{
		
		framePanel=new JPanel();
		framePanel.setLayout(new GridBagLayout());
		
		tabbedPane=new JTabbedPane();
		
		GridBagConstraints c = new GridBagConstraints();
		
		customerTab=new CustomerGUI();
		userTab=new UserMainPanel();
		supplierTab = new SupplierGUI();
		
		tabbedPane.addTab("Customers",customerTab.getPanel());
		tabbedPane.addTab("Users",userTab.getPanel());
		tabbedPane.addTab("Supplier",supplierTab.getMain());
	
		c.gridx=0;
		c.gridy=0;
		c.gridheight=2;
		c.gridwidth=3;
		c.weighty=0.95;
		c.weightx=1;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.fill=GridBagConstraints.BOTH;
		framePanel.add(tabbedPane,c);
		
		logoutPanel=new JPanel();
		logoutPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		logoutButton=new JButton("LOGOUT");
		
		logoutPanel.add(logoutButton);
		
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=3;
		c.gridheight=1;
		c.weighty=0.1;
		c.anchor=GridBagConstraints.LAST_LINE_END;
		framePanel.add(logoutPanel,c);
		
		
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

	public UserMainPanel getUserTab() {
		return userTab;
	}

	public void setUserTab(UserMainPanel userTab) {
		this.userTab = userTab;
	}

	public SupplierGUI getSupplierTab() {
		return supplierTab;
	}

	public void setSupplierTab(SupplierGUI supplierTab) {
		this.supplierTab = supplierTab;
	}
	
	
	
	
}
