package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

//Creating a customer toolbar panel
public class CustomerToolbar extends JPanel implements ActionListener {
	//This panel will only have one button allowing an option to create a new customer.
	private JButton createButton;
	private CustomerFormPanel formPanel;

	public CustomerToolbar() {
		// created a border along the panel to separate it better
		setBorder(BorderFactory.createEtchedBorder());
		
		//create button
		createButton = new JButton("Create");
		//Adding an action listener to the button
		createButton.addActionListener(this);
		// Using the Flow layout for the toolbar
		setLayout(new FlowLayout(FlowLayout.LEFT));
		// Adding the button to the panel
		add(createButton);

	}
	//Creating an instance of the customerformpanel which will allow me 
	//to edit what will occur when the create button is clicked
	public void setFormPanel(CustomerFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		//When the create button is clicked the formPanel is removed
		//Then the createFormPanel is called, validated and then repainted
		//to the screen. 
		if (clicked == createButton) {
			formPanel.removeAll();
			formPanel.CreateFormPanel();
			formPanel.validate();
			formPanel.repaint();
		}
	}
}
