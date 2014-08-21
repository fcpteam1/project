package GUI;
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import model.Model;

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
		orderTablePanel.setFormPanel(orderFormPanel);
		orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());

		orderFormPanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
		orderFormPanel.setFormListener(new OrderFormListener(){

			@Override
			public void createOrderOccurred(OrderFormEvent e){
				model.getShop().createOrder(e);
				orderTablePanel.refresh();
				model.getShop().viewOrders(e);
			}

			@Override
			public void editOrderOccurred(OrderFormEvent e) {
				model.getShop().editOrder(e);
				orderTablePanel.refresh();
				model.getShop().viewOrders(e);
			}

			@Override
			public void deleteOrderOccurred(OrderFormEvent e) {
				model.getShop().deleteOrder(e);
				orderTablePanel.refresh();
				model.getShop().viewOrders(e);
			}

			@Override
			public void processOrderOccurred(OrderFormEvent e) {
				model.getShop().processOrder(e);
				orderTablePanel.refresh();
				model.getShop().viewOrders(e);
			}
			
		});
		
		mainPanel.add(orderFormPanel, BorderLayout.WEST);
		mainPanel.add(orderToolbar, BorderLayout.NORTH);
		mainPanel.add(orderTablePanel, BorderLayout.CENTER); 
		
		setSize(600, 500);
	}
	
	public JPanel getPanel(){
		return mainPanel;
		
	}
}