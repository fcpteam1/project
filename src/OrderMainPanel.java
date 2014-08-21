import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

public class OrderMainPanel extends JPanel {	
	private JPanel mainPanel;
	private OrderToolbar orderToolbar;
	private OrderFormPanel orderFormPanel;
	private OrderTablePanel orderTablePanel;
	private Model model;
	
	public OrderMainPanel() throws IOException	{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		
		orderToolbar = new OrderToolbar();
		orderFormPanel = new OrderFormPanel();
		orderTablePanel = new OrderTablePanel();
		model = new Model();
		
		orderToolbar.setMainPanel(orderFormPanel);
		
		
	
		orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
		orderFormPanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
		
		orderFormPanel.setFormListener(new OrderFormListener(){

			@Override
			public void formEventOccurred(OrderFormEvent e){
				orderFormPanel.viewFormPanel();
			}
			
		});
		
		orderToolbar.setMainPanel(orderFormPanel);;
		
		mainPanel.add(orderFormPanel, BorderLayout.WEST);
		mainPanel.add(orderToolbar, BorderLayout.NORTH);
		mainPanel.add(orderTablePanel, BorderLayout.CENTER); 
		
		setSize(600, 500);
	}
	
	public JPanel getPanel(){
		return mainPanel;
		
	}
}