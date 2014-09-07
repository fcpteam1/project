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

	// Creating the main panel this will hold within it all the other panels
	// involved with the customer tab.
	public CustomerMainPanel() throws IOException {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		customerToolbar = new CustomerToolbar();
		customerFormPanel = new CustomerFormPanel();
		customerTablePanel = new CustomerTablePanel();
		model = new Model();
		// Setting the formpanel within the table panel and toolbar
		// so when an event occurs the formpanel can be altered
		customerTablePanel.setFormPanel(customerFormPanel);
		customerToolbar.setFormPanel(customerFormPanel);
		// Sending the arraylist customers to the table panel
		// It then can displayed within the table
		customerTablePanel.setData(model.getShop().getCustomers());

		// Listening for a clicked event to occur within the table panel
		customerTablePanel
				.setCustomerTableListener(new CustomerTableListener() {
					// When "Delete Customer" is clicked the method
					// removeCustomer() is called
					// passing in the row that is highlighted
					@Override
					public void rowDeleted(int row) {
						model.getShop().removeCustomer(row);
						customerTablePanel.refresh();
					}

					// When "Edit Customer" is clicked the method editCustomer()
					// is called
					// passing in the row that is highlighted
					@Override
					public void rowEdited(int row) {
						model.getShop().editCustomer(row);
						customerTablePanel.refresh();
					}
				});

		// Listening for a button press event to occur within the form panel
		customerFormPanel.setFormListener(new CustomerFormListener() {
			// When "Submit" is pressed the addCustomer() method is called
			// within shop
			// the data belonging to that customer is being passed through
			@Override
			public void formEventOccurred(CustomerFormEvent e) {
				model.getShop().addCustomer(e);
				customerTablePanel.refresh();
			}

			// Within the editFormPanel when a button is clicked the new editing
			// data
			// is passed to the NewEditCustomer method within shop.
			@Override
			public void editFormEventOccurred(CustomerFormEvent ee) {
				model.getShop().NewEditCustomer(ee);
				customerTablePanel.refresh();
			}

		});

		// Adding each Customer panel to the main Panel
		mainPanel.add(customerFormPanel, BorderLayout.WEST);
		mainPanel.add(customerToolbar, BorderLayout.NORTH);
		mainPanel.add(customerTablePanel, BorderLayout.CENTER);

		setSize(600, 500);
	}

	// This method is called when the tab Customer is selected it returns the
	// main Panel
	public JPanel getPanel() {
		return mainPanel;

	}
}
