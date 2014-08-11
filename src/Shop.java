import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Shop extends JFrame {
	
	private JPanel loginPanel,framePanel,emptyPanel;
	private JTextField loginUsername, loginPassword;
	private Container container;
	private JButton submit;
	private JLabel empty;
	
	
	
	private JPanel mainMenuPanel,mainCentrePanel,customerPanel,userPanel,salePanel,stockPanel,logoutPanel;
	private JButton customerButton,saleButton,userButton,stockButton,logoutButton;
	
	public Shop(){
		
		setSize(500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		
		////main
		
		mainMenuPanel=new JPanel();
		mainMenuPanel.setLayout(new BorderLayout());
		
		mainCentrePanel=new JPanel();
		mainCentrePanel.setLayout(new GridLayout(2,2,5,5));
		
		customerPanel=new JPanel();
		customerButton=new JButton("CUSTOMERS");
		customerPanel.add(customerButton);
		
		salePanel=new JPanel();
		saleButton=new JButton("SALES");
		salePanel.add(saleButton);
		
		userPanel=new JPanel();
		userButton=new JButton("USERS");
		userPanel.add(userButton);
		
		stockPanel=new JPanel();
		stockButton=new JButton("STOCK");
		stockPanel.add(stockButton);
		
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
		
		mainMenuPanel.add(mainCentrePanel,BorderLayout.CENTER);
		mainMenuPanel.add(logoutPanel,BorderLayout.SOUTH);
		
		
		//main
		
		
		
		empty=new JLabel("Hello");
		emptyPanel=new JPanel();
		framePanel=new JPanel();
		framePanel.setLayout(new GridLayout(3,3,10,10));
		emptyPanel.add(empty);
		
		submit=new JButton("SUBMIT");
		container=getContentPane();
		loginPanel=new JPanel();
		loginPanel.setLayout(new GridLayout(3,1,5,10));
		loginUsername=new JTextField("username",20);
		loginPassword=new JTextField("password",20);
		
		
		submit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				changeToMainMenu();
			}
		});
		
		loginPanel.add(loginUsername);
		loginPanel.add(loginPassword);
		loginPanel.add(submit);
		
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		framePanel.add(loginPanel,BorderLayout.CENTER);
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		framePanel.add(new JPanel());
		
		container.add(framePanel);
		
		setVisible(true);
		
	}
	
	
	public void changeToMainMenu(){
		container.removeAll();
		
		container.add(mainMenuPanel);
		
		validate();
		
	}
	
	
	public void logout(){
		
		container.removeAll();
		
		container.add(framePanel);
		
		validate();
	}
	
	public static void main(String []args){
		
		
		
		new Shop();
		
		
	}
	
	
	

}
