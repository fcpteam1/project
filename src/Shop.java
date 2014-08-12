import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Shop extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// all components used for the login screen
	private JPanel loginPanel,framePanel,centreLoginPanel,loginSubmitPanel;
	private JTextField loginUsername, loginPassword;
	private Container container;
	private JButton submit;
	private JLabel usernameLabel,passwordLabel;
	// all components used for login screen
	
	// main menu screen
	private JPanel mainMenuPanel,mainCentrePanel,customerPanel,userPanel,salePanel,stockPanel,logoutPanel,productPanel,supplierPanel,orderPanel,invoicePanel;
	private JButton customerButton,saleButton,userButton,stockButton,productButton,supplierButton,orderButton,invoiceButton,logoutButton;
	private JLabel customerLabel,saleLabel,userLabel,stockLabel,productLabel,supplierLabel,invoiceLabel,orderLabel;
	// main menu screen
	
	
	// customer gui components
	
	// customer gui components
	
	
	// user gui components
	
	// user gui components
	
	
	public Shop(){
		
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		////main
		
		mainMenuPanel=new JPanel();
		mainMenuPanel.setLayout(new BorderLayout());
		
		mainCentrePanel=new JPanel();
		mainCentrePanel.setLayout(new GridLayout(2,4,20,20));
		
		customerPanel=new JPanel();
		customerButton=new JButton("CUSTOMERS");
		customerPanel.setLayout(new BorderLayout());
		customerPanel.add(customerButton,BorderLayout.NORTH);
		customerLabel=new JLabel(new ImageIcon("icon.png"));
		customerPanel.add(customerLabel,BorderLayout.CENTER);
		
		salePanel=new JPanel();
		saleButton=new JButton("SALES");
		salePanel.setLayout(new BorderLayout());
		salePanel.add(saleButton,BorderLayout.NORTH);
		saleLabel=new JLabel(new ImageIcon("icon.png"));
		salePanel.add(saleLabel,BorderLayout.CENTER);
		
		userPanel=new JPanel();
		userButton=new JButton("USERS");
		userPanel.setLayout(new BorderLayout());
		userPanel.add(userButton,BorderLayout.NORTH);
		userLabel=new JLabel(new ImageIcon("icon.png"));
		userPanel.add(userLabel,BorderLayout.CENTER);
		
		stockPanel=new JPanel();
		stockButton=new JButton("STOCK");
		stockPanel.setLayout(new BorderLayout());
		stockPanel.add(stockButton,BorderLayout.NORTH);
		stockLabel=new JLabel(new ImageIcon("icon.png"));
		stockPanel.add(stockLabel,BorderLayout.CENTER);
		
		productPanel=new JPanel();
		productButton=new JButton("PRODUCTS");
		productPanel.setLayout(new BorderLayout());
		productPanel.add(productButton,BorderLayout.NORTH);
		productLabel=new JLabel(new ImageIcon("icon.png"));
		productPanel.add(productLabel,BorderLayout.CENTER);
		
		supplierPanel=new JPanel();
		supplierButton=new JButton("SUPPLIERS");
		supplierPanel.setLayout(new BorderLayout());
		supplierPanel.add(supplierButton,BorderLayout.NORTH);
		supplierLabel=new JLabel(new ImageIcon("icon.png"));
		supplierPanel.add(supplierLabel,BorderLayout.CENTER);
		
		invoicePanel=new JPanel();
		invoiceButton=new JButton("INVOICES");
		invoicePanel.setLayout(new BorderLayout());
		invoicePanel.add(invoiceButton,BorderLayout.NORTH);
		invoiceLabel=new JLabel(new ImageIcon("icon.png"));
		invoicePanel.add(invoiceLabel,BorderLayout.CENTER);
		
		orderPanel=new JPanel();
		orderButton=new JButton("ORDERS");
		orderPanel.setLayout(new BorderLayout());
		orderPanel.add(orderButton,BorderLayout.NORTH);
		orderLabel=new JLabel(new ImageIcon("icon.png"));
		orderPanel.add(orderLabel,BorderLayout.CENTER);
		
		logoutPanel=new JPanel();
		logoutPanel.setLayout(new FlowLayout());
		logoutButton=new JButton("LOGOUT");
		logoutButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				logout();
			}
		});
		logoutPanel.add(logoutButton);
		
		
		
		
		mainCentrePanel.add(customerPanel);
		mainCentrePanel.add(salePanel);
		mainCentrePanel.add(userPanel);
		mainCentrePanel.add(stockPanel);
		mainCentrePanel.add(productPanel);
		mainCentrePanel.add(supplierPanel);
		mainCentrePanel.add(invoicePanel);
		mainCentrePanel.add(orderPanel);
		
		
		mainMenuPanel.add(mainCentrePanel,BorderLayout.CENTER);
		mainMenuPanel.add(logoutPanel,BorderLayout.SOUTH);
		
		//////////////////////////////////////////
		//main
		//////////////////////////////////////////
		
		
		//////////////////////////////////////////
		//login screen
		//////////////////////////////////////////
		framePanel=new JPanel();
		framePanel.setLayout(new GridLayout(3,3,10,10));
		
		submit=new JButton("SUBMIT");
		container=getContentPane();
		loginPanel=new JPanel();
		loginPanel.setLayout(new GridLayout(3,2,5,10));
		loginUsername=new JTextField("username",20);
		loginPassword=new JTextField("password",20);
		usernameLabel=new JLabel("username:");
		passwordLabel=new JLabel("password:");
		
		
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				changeToMainMenu();
			}
		});
		
		loginPanel.add(usernameLabel);
		loginPanel.add(loginUsername);
		loginPanel.add(passwordLabel);
		loginPanel.add(loginPassword);
		//loginPanel.add(submit);
		
		loginSubmitPanel=new JPanel();
		loginSubmitPanel.setLayout(new FlowLayout());
		loginSubmitPanel.add(submit);
		
		centreLoginPanel=new JPanel();
		centreLoginPanel.setLayout(new BorderLayout());
		
		centreLoginPanel.add(loginPanel,BorderLayout.CENTER);
		centreLoginPanel.add(loginSubmitPanel,BorderLayout.SOUTH);
		
		
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		framePanel.add(centreLoginPanel);
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		////////////////////////////////////////////////
		//login screen
		////////////////////////////////////////////////
		
		container.add(framePanel);
		
		setVisible(true);
		
	}
	
	
	public boolean changeToMainMenu(){
		container.removeAll();
		
		container.add(mainMenuPanel);
		
		validate();

		repaint();
		
		return true;
		
	}
	
	
	public boolean logout(){
		
		container.removeAll();
		
		container.add(framePanel);
		
		validate();
		
		repaint();
		
		return true;
	}
	
	public static void main(String []args){
		
		
		
		new Shop();
		
		
	}
	
	
	

}