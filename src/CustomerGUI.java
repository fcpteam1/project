import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class CustomerGUI {

	private JPanel mainPanel;
	private JLabel label;
	
	
	public CustomerGUI(){
		
		mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		label=new JLabel("Customer Panel");
		mainPanel.add(label,BorderLayout.NORTH);
		
		
		
	}
	
	
	
	public JPanel getPanel(){
		return mainPanel;
		
	}
}
