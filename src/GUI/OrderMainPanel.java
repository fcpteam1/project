package GUI;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Model;
import model.Order;

public class OrderMainPanel extends JPanel {
	private JPanel mainPanel;
	private OrderToolbar orderToolbar;
	private OrderFormPanel orderFormPanel;
	private OrderTablePanel orderTablePanel;
	private Model model;

	public OrderMainPanel() throws IOException {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		//initialise components for order tab
		orderToolbar = new OrderToolbar();
		orderFormPanel = new OrderFormPanel();
		orderTablePanel = new OrderTablePanel();
		model = new Model();

		orderToolbar.setFormPanel(orderFormPanel);
		//listeners for the toolbar component
		orderToolbar.setOrderToolbarListener(new OrderToolbarListener() {

			@Override
			public void createOrder() {
				orderFormPanel.setVisible(false);
				orderFormPanel.removeAll();
				//set list of suppliers for the combo box from shop data
				orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
				orderTablePanel.refresh();
				//set view to the create panel
				orderFormPanel.createFormPanel();
				orderFormPanel.validate();
				orderFormPanel.repaint();
			}

			//simply list all orders in the table
			@Override
			public void showAll() {
				orderFormPanel.setVisible(false);
				orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
				orderTablePanel.refresh();
			}

			//show the orders that are yet to be processed/delivered
			@Override
			public void showCurrent() {
				orderFormPanel.setVisible(false);
				//create a new list based on delivery status
				ArrayList<Order> current = new ArrayList<Order>();
				for (Order order : model.getShop().getOrders()) {
					if (order.isCurrent()) {
						current.add(order);
					}
				}
				//set the table data to new list
				orderTablePanel.setData(current, model.getShop().getSuppliers());
				orderTablePanel.refresh();
			}

			//similar to the current, but for delivered orders
			@Override
			public void showPrevious() {
				orderFormPanel.setVisible(false);
				ArrayList<Order> previous = new ArrayList<Order>();
				for (Order order : model.getShop().getOrders()) {
					if (!order.isCurrent()) {
						previous.add(order);
					}
				}
				orderTablePanel.setData(previous, model.getShop()
						.getSuppliers());
				orderTablePanel.refresh();
			}

		});

		orderTablePanel.setFormPanel(orderFormPanel);
		orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
		
		//Listener for table buttons
		orderTablePanel.setOrderTableListener(new OrderTableListener() {
			//call the delete function in shop based on the selected order's id
			@Override
			public void rowDeleted(int id) {
				orderFormPanel.setVisible(false);
				model.getShop().deleteOrder(id);
				orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
				orderTablePanel.refresh();
			}
			//edit order
			@Override
			public void rowEdited(int id) {
				orderFormPanel.removeAll();
				Order thisOrder = null;
				for(Order order: model.getShop().getOrders()){
					if(order.getId()==id){
						thisOrder = order;
					}
				}
				if(thisOrder.isCurrent() && thisOrder!=null){
					for(int i=0; i<thisOrder.getProducts().size(); i++){
						System.out.println(thisOrder.getProducts().get(i).getName() + thisOrder.getProducts().get(i).getQuantity());
					}
					orderFormPanel.setEditedOrder(thisOrder);
					orderFormPanel.setEditedProducts(thisOrder.getProducts());
					orderFormPanel.setEditedSupplierProducts(thisOrder.getSupplier().getProducts());
					orderFormPanel.editFormPanel();
				}
				orderTablePanel.refresh();
			}
			//process order
			@Override
			public void rowProcessed(int id) {
				model.getShop().processOrder(id);
				orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
				orderTablePanel.refresh();
			}
		});

		orderFormPanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
		orderFormPanel.setFormListener(new OrderFormListener() {
			//passing the new orders data to shop and update list
			@Override
			public void createOrderOccurred(OrderFormEvent e) {
				model.getShop().createOrder(e);
				orderTablePanel.refresh();
				model.getShop().viewOrders(e);
			}
			//pass edited order's data to the shop and list
			@Override
			public void editOrderOccurred(OrderFormEvent e, int id) {
				model.getShop().editOrder(e, id);
				orderTablePanel.refresh();
				orderFormPanel.setVisible(false);
			}

		});

		mainPanel.add(orderFormPanel, BorderLayout.WEST);
		mainPanel.add(orderToolbar, BorderLayout.NORTH);
		mainPanel.add(orderTablePanel, BorderLayout.CENTER);

		setSize(600, 500);
	}

	public JPanel getPanel() {
		return mainPanel;

	}
}