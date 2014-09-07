package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Customer;
import model.Model;

//The CustomerFormPanel is where the details for creating or editing a user will be shown
public class CustomerFormPanel extends JPanel {
	// Crating the multiple variables needed
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel idLabel;
	private JLabel addressLabel;
	private JLabel userLabel;
	private JTextField nameField;
	private JTextField numberField;
	private JTextField idField;
	private JTextField addressField;
	private JButton submitBtn, editBtn;
	private CustomerFormListener customerFormListener;
	private Model model;
	private ArrayList<Customer> customers;

	// Creating String variables to hold the data to be edited within Customer
	private String editCustomerName = "";
	private String editCustomerNumber = "";
	private String editCustomerAddress = "";

	private CustomerTablePanel customerTablePanel = new CustomerTablePanel();

	public CustomerFormPanel() {

	}

	// calling setData will set the store the arrayList of customers within the
	// local Arraylist customers
	public void setData(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	// Taking in the edited customer name
	public void setEditDataName(String editCustomerName) {
		this.editCustomerName = editCustomerName;
		System.out.println(editCustomerName);
	}

	// Taking in the edited customer number
	public void setEditDataNumber(String editCustomerNumber) {
		this.editCustomerNumber = editCustomerNumber;
	}

	// Taking in the edited customer address
	public void setEditDataAddress(String editCustomerAddress) {
		this.editCustomerAddress = editCustomerAddress;
	}

	// ////////////////////CREATE////////////////////////

	// This panel is called when the "Create" button is clicked within the
	// toolbar
	public void CreateFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		// Setting the labels
		nameLabel = new JLabel("Name: ");
		numberLabel = new JLabel("Number: ");
		idLabel = new JLabel("ID: ");
		addressLabel = new JLabel("Address: ");
		// Creating Text Fields to enter the data about the customer
		// Set the length also
		nameField = new JTextField(10);
		numberField = new JTextField(10);
		addressField = new JTextField(10);
		// Submit button
		submitBtn = new JButton("Submit");
		// Adding an listener for when the button is clicked
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Taking in the text within the information fields
				// This data is then stored within local variables
				String name = nameField.getText();
				String number = numberField.getText();
				String address = addressField.getText();

				// Sending the data to the createCustomer method in shop
				// Where the new customer will be added to the customer array
				// list
				CustomerFormEvent ev = new CustomerFormEvent(this, name,
						number, address);

				if (customerFormListener != null) {
					customerFormListener.formEventOccurred(ev);
				}
			}

		});

		// Creating a border around the Create Customer form panel to make it
		// stand out
		Border innerBorder = BorderFactory.createTitledBorder("Add Customer");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		// Using GridBagLayout for the panel
		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		// Setting the positions for the labels and text fields
		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		// Setting the size of the labels and text fields to there initial size
		gc.fill = GridBagConstraints.NONE;
		// Setting the label
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);

		// Setting the text field
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gc);

		// /////// Second row ////////

		// Increasing gridy by one each row will allow the Labels and text
		// fields to line up perfectly
		// underneath each other
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(numberLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(numberField, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(addressLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(addressField, gc);

		// /////// Fifth row ////////

		// Adding the button at the end underneath everything else
		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(submitBtn, gc);
	}

	// ////////////////////EDIT////////////////////////

	// same layout for the edit form panel as that for the create customer
	public void EditFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		nameLabel = new JLabel("Name: ");
		numberLabel = new JLabel("Number: ");
		idLabel = new JLabel("ID: ");
		addressLabel = new JLabel("Address: ");

		nameField = new JTextField(editCustomerName, 10);
		numberField = new JTextField(editCustomerNumber, 10);
		addressField = new JTextField(editCustomerAddress, 10);

		editBtn = new JButton("Finish");

		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				String name = nameField.getText();
				String number = numberField.getText();
				String address = addressField.getText();

				CustomerFormEvent eev = new CustomerFormEvent(this, name,
						number, address);

				if (customerFormListener != null) {
					customerFormListener.editFormEventOccurred(eev);
				}
			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Edit Customer");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(nameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(nameField, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(numberLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(numberField, gc);

		// /////// Third row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(addressLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(addressField, gc);

		// /////// Fifth row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(editBtn, gc);
	}

	public void setFormListener(CustomerFormListener customerFormListener) {
		this.customerFormListener = customerFormListener;
	}

}
