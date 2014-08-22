package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;


public class OrderToolbar extends JPanel implements ActionListener{

	private JButton viewButton;
	private JButton createButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton processButton;
	private OrderFormPanel mainPanel;
	
	public OrderToolbar(){
		setBorder(BorderFactory.createEtchedBorder());
		viewButton = new JButton("View Orders\n");
		createButton = new JButton("Create Order\n");
		editButton = new JButton("Edit Order\n");
		deleteButton = new JButton("Delete Order\n");
		processButton = new JButton("Process Order\n");
		
		viewButton.addActionListener(this);
		createButton.addActionListener(this);
		editButton.addActionListener(this);
		deleteButton.addActionListener(this);
		processButton.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(viewButton);
		add(createButton);
		add(editButton);
		add(deleteButton);
		add(processButton);
		
	}
	
	public void setMainPanel(OrderFormPanel mainPanel){
		this.mainPanel = mainPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if(clicked==viewButton){
			mainPanel.removeAll();
			mainPanel.viewFormPanel();
			mainPanel.validate();
			mainPanel.repaint();
		}
		else if(clicked==createButton){
			mainPanel.removeAll();
			mainPanel.createFormPanel();
			mainPanel.validate();
			mainPanel.repaint();
		}
		else if(clicked==editButton){
			mainPanel.removeAll();
			mainPanel.editFormPanel();
			mainPanel.validate();
			mainPanel.repaint();
		}
		else if(clicked==deleteButton){
			mainPanel.removeAll();
			mainPanel.deleteFormPanel();
			mainPanel.validate();
			mainPanel.repaint();
		}
		else if(clicked==processButton){
			mainPanel.removeAll();
			mainPanel.processFormPanel();
			mainPanel.validate();
			mainPanel.repaint();
		}
	}

}
