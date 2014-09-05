package GUI;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainMenuGUI {

	private JPanel framePanel;
	private JTabbedPane tabbedPane;
	private JPanel logoutPanel;
	private JButton logoutButton;

	private CustomerMainPanel customerTab;
	private UserMainPanel userTab;
	private OrderMainPanel orderTab;
	private SupplierGUI supplierTab;
	private StockMainPanel stockTab;
	private SaleMainPanel saleTab;
	private FinancialMainPanel profitAndLossTab;
	protected boolean adminLogged = false;

	private static MainMenuGUI instance;

	public static MainMenuGUI getInstance() throws IOException {

		if (instance == null) {
			instance = new MainMenuGUI();
		}


		return instance;
	}

	private MainMenuGUI() throws IOException {

		framePanel = new JPanel();
		framePanel.setLayout(new GridBagLayout());

		tabbedPane = new JTabbedPane();

		GridBagConstraints c = new GridBagConstraints();

		customerTab = new CustomerMainPanel();
		userTab = new UserMainPanel();
		supplierTab = new SupplierGUI();
		orderTab = new OrderMainPanel();
		stockTab = new StockMainPanel();
		saleTab = new SaleMainPanel();
		profitAndLossTab = new FinancialMainPanel();

		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 2;
		c.gridwidth = 3;
		c.weighty = 0.95;
		c.weightx = 1;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.BOTH;
		framePanel.add(tabbedPane, c);

		logoutPanel = new JPanel();
		logoutPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		logoutButton = new JButton("LOGOUT");

		logoutPanel.add(logoutButton);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		c.gridheight = 1;
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		framePanel.add(logoutPanel, c);
		
/*		tabbedPane.addChangeListener(new ChangeListener()
		    {
				public void stateChanged(ChangeEvent e) {
					if (tabbedPane.getSelectedIndex()==4)
					{
						System.out.println("Stock");
						
					}
	
			}
		    });*/


	}

	public JPanel getPanel() {

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

	public CustomerMainPanel getCustomerTab() {
		return customerTab;
	}

	public void setCustomerTab(CustomerMainPanel customerTab) {
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

	private ImageIcon createIcon(String path) {
		URL url = getClass().getResource(path);

		if (url == null) {
			System.out.println("Unable to load image: " + path);
		}

		ImageIcon icon = new ImageIcon(url);

		return icon;

	}

	public void addTabs(boolean admin) {

		adminLogged = admin;

		/*try {
			customerTab = new CustomerMainPanel();
			userTab = new UserMainPanel();
			supplierTab = new SupplierGUI();
			orderTab = new OrderMainPanel();
			stockTab = new StockGUI();
			saleTab = new SaleMainPanel();
			profitAndLossTab = new FinancialMainPanel();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}*/
		
		
		tabbedPane.removeAll();
		if (admin) {
			tabbedPane.addTab("Customers", customerTab.getPanel());
			tabbedPane.addTab("Users", userTab.getPanel());

			tabbedPane.addTab("Supplier", supplierTab.getMain());
			supplierTab.setAdminLogged(adminLogged);
			tabbedPane.addTab("Orders", orderTab.getPanel());
			tabbedPane.addTab("Stock", stockTab.getPanel());
			tabbedPane.addTab("Sales", saleTab.getPanel());
			tabbedPane.addTab("Financials", profitAndLossTab.getPanel());

			tabbedPane.setIconAt(0, createIcon("/images/customer.png"));
			tabbedPane.setIconAt(1, createIcon("/images/user.png"));
			tabbedPane.setIconAt(2, createIcon("/images/supplier.png"));
			tabbedPane.setIconAt(3, createIcon("/images/order.png"));
			tabbedPane.setIconAt(4, createIcon("/images/stock.png"));
			tabbedPane.setIconAt(5, createIcon("/images/sale.png"));
			tabbedPane.setIconAt(6, createIcon("/images/profitandloss.png"));
		} else {
			tabbedPane.addTab("Customers", customerTab.getPanel());
			// tabbedPane.addTab("Users",userTab.getPanel());
			tabbedPane.addTab("Supplier", supplierTab.getMain());
			supplierTab.setAdminLogged(adminLogged);
			// tabbedPane.addTab("Orders", orderTab.getPanel());
			tabbedPane.addTab("Stock", stockTab.getPanel());
			tabbedPane.addTab("Sales", saleTab.getPanel());

			tabbedPane.setIconAt(0, createIcon("/images/customer.png"));
			// tabbedPane.setIconAt(1, createIcon("/images/user.png"));
			tabbedPane.setIconAt(1, createIcon("/images/supplier.png"));
			// tabbedPane.setIconAt(3, createIcon("/images/order.png"));
			tabbedPane.setIconAt(2, createIcon("/images/stock.png"));
			tabbedPane.setIconAt(3, createIcon("/images/sale.png"));
		}

		tabbedPane.validate();
		tabbedPane.repaint();

	}

	public void removeTabs() {
		tabbedPane.removeAll();
	}

	public boolean isAdminLogged() {
		return adminLogged;
	}

	public void setAdminLogged(boolean adminLogged) {
		this.adminLogged = adminLogged;
	}

	public StockMainPanel getStockTab() {
		return stockTab;
	}

	public void setStockTab(StockMainPanel stockTab) {
		this.stockTab = stockTab;
	}
}
