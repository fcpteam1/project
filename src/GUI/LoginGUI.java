package GUI;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
		loginPanel.setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		loginUsername=new JTextField(20);
		loginPassword=new JPasswordField(20);
		usernameLabel=new JLabel("Username:  ");
		passwordLabel=new JLabel("Password:  ");
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		loginPanel.add(usernameLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		loginPanel.add(loginUsername, gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		loginPanel.add(passwordLabel, gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		loginPanel.add(loginPassword, gc);
		
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
