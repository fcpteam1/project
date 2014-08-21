package GUI;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class UserToolbar extends JPanel implements ActionListener {
	private JButton createButton;
	private UserFormPanel formPanel ;
	
	public UserToolbar(){
		setBorder(BorderFactory.createEtchedBorder());
		createButton = new JButton("Create");
		
		createButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.CENTER));
		
		add(createButton);
			
	}
	
	public void setFormPanel(UserFormPanel formPanel){
		this.formPanel = formPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton)e.getSource() ;
		
		if(clicked == createButton) {
			formPanel.removeAll();
			formPanel.CreateFormPanel();
			formPanel.validate();
			formPanel.repaint();
		}
	}
}