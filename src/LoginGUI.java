import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginGUI  {

	
	private JPanel framePanel,loginPanel,loginSubmitPanel,centreLoginPanel;
	private JLabel usernameLabel,passwordLabel;
	private JTextField loginUsername;
	private JPasswordField loginPassword;
	private JButton submit;
	
	public LoginGUI(){
		
		framePanel=new JPanel();
		framePanel.setLayout(new GridLayout(3,3,10,10));
		
		submit=new JButton("SUBMIT");
		loginPanel=new JPanel();
		loginPanel.setLayout(new GridLayout(3,2,5,10));
		loginUsername=new JTextField(20);
		loginPassword=new JPasswordField(20);
		usernameLabel=new JLabel("username:");
		passwordLabel=new JLabel("password:");
		
		
		loginPanel.add(usernameLabel);
		loginPanel.add(loginUsername);
		loginPanel.add(passwordLabel);
		loginPanel.add(loginPassword);
		
		
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
		
		
		
		
		
	}
	
	public JPanel getPanel(){
		
		return framePanel;
	}

	public JButton getSubmit() {
		return submit;
	}

	public void setSubmit(JButton submit) {
		this.submit = submit;
	}

	public JTextField getLoginUsername() {
		return loginUsername;
	}

	public void setLoginUsername(JTextField loginUsername) {
		this.loginUsername = loginUsername;
	}

	public JPasswordField getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(JPasswordField loginPassword) {
		this.loginPassword = loginPassword;
	}
	
	
	
	
}
