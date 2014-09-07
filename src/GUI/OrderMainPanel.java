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

		orderToolbar = new OrderToolbar();
		orderFormPanel = new OrderFormPanel();
		orderTablePanel = new OrderTablePanel();
		model = new Model();

		orderToolbar.setFormPanel(orderFormPanel);

		orderToolbar.setOrderToolbarListener(new OrderToolbarListener() {

			@Override
			public void createOrder() {
				orderFormPanel.setVisible(false);
				orderFormPanel.removeAll();
				orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
				orderTablePanel.refresh();
				orderFormPanel.createFormPanel();
				orderFormPanel.validate();
				orderFormPanel.repaint();
			}

			@Override
			public void showAll() {
				orderFormPanel.setVisible(false);
				orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
				orderTablePanel.refresh();
			}

			
			@Override
			public void showCurrent() {
				orderFormPanel.setVisible(false);
				ArrayList<Order> current = new ArrayList<Order>();
				for (Order order : model.getShop().getOrders()) {
					if (order.isCurrent()) {
						current.add(order);
					}
				}
				orderTablePanel.setData(current, model.getShop().getSuppliers());
				orderTablePanel.refresh();
			}

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

		orderTablePanel.setOrderTableListener(new OrderTableListener() {

			@Override
			public void rowDeleted(int id) {
				orderFormPanel.setVisible(false);
				model.getShop().deleteOrder(id);
				orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
				orderTablePanel.refresh();
			}

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

			@Override
			public void rowProcessed(int id) {
				model.getShop().processOrder(id);
				orderTablePanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
				orderTablePanel.refresh();
			}
		});

		orderFormPanel.setData(model.getShop().getOrders(), model.getShop().getSuppliers());
		orderFormPanel.setFormListener(new OrderFormListener() {

			@Override
			public void createOrderOccurred(OrderFormEvent e) {
				model.getShop().createOrder(e);
				orderTablePanel.refresh();
			}

			@Override
			public void editOrderOccurred(OrderFormEvent e, int id) {
				model.getShop().editOrder(e, id);
				orderTablePanel.refresh();
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