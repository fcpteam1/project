package GUI;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import model.Model;

public class CustomerMainPanel extends JPanel {
	private JPanel mainPanel;
	private CustomerToolbar customerToolbar;
	private CustomerFormPanel customerFormPanel;
	private CustomerTablePanel customerTablePanel;
	private Model model;

	public CustomerMainPanel() throws IOException {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		customerToolbar = new CustomerToolbar();
		customerFormPanel = new CustomerFormPanel();
		customerTablePanel = new CustomerTablePanel();
		model = new Model();

		customerTablePanel.setFormPanel(customerFormPanel);
		customerToolbar.setFormPanel(customerFormPanel);

		customerTablePanel.setData(model.getShop().getCustomers());

		customerTablePanel
				.setCustomerTableListener(new CustomerTableListener() {

					@Override
					public void rowDeleted(int row) {
						model.getShop().removeCustomer(row);
						customerTablePanel.refresh();
					}

					@Override
					public void rowEdited(int row) {
						model.getShop().editCustomer(row);
						customerTablePanel.refresh();
					}
				});

		customerFormPanel.setData(model.getShop().getCustomers());

		customerFormPanel.setFormListener(new CustomerFormListener() {

			@Override
			public void formEventOccurred(CustomerFormEvent e) {
				model.getShop().addCustomer(e);
				customerTablePanel.refresh();
			}

			@Override
			public void editFormEventOccurred(CustomerFormEvent ee) {
				model.getShop().NewEditCustomer(ee);
				customerTablePanel.refresh();
			}

		});

		customerToolbar.setFormPanel(customerFormPanel);
		;

		mainPanel.add(customerFormPanel, BorderLayout.WEST);
		mainPanel.add(customerToolbar, BorderLayout.NORTH);
		mainPanel.add(customerTablePanel, BorderLayout.CENTER);

		setSize(600, 500);
	}

	public JPanel getPanel() {
		return mainPanel;

	}
}
