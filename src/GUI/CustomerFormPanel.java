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

public class CustomerFormPanel extends JPanel {
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

	private String editCustomerName = "";
	private String editCustomerNumber = "";
	private String editCustomerAddress = "";

	private CustomerTablePanel customerTablePanel = new CustomerTablePanel();

	public CustomerFormPanel() {

	}

	public void setData(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	public void setEditDataName(String editCustomerName) {
		this.editCustomerName = editCustomerName;
		System.out.println(editCustomerName);
	}

	public void setEditDataNumber(String editCustomerNumber) {
		this.editCustomerNumber = editCustomerNumber;
	}

	public void setEditDataAddress(String editCustomerAddress) {
		this.editCustomerAddress = editCustomerAddress;
	}

	// ////////////////////CREATE////////////////////////

	public void CreateFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		nameLabel = new JLabel("Name: ");
		numberLabel = new JLabel("Number: ");
		idLabel = new JLabel("ID: ");
		addressLabel = new JLabel("Address: ");

		nameField = new JTextField(10);
		numberField = new JTextField(10);
		addressField = new JTextField(10);

		submitBtn = new JButton("Submit");

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String number = numberField.getText();
				String address = addressField.getText();

				CustomerFormEvent ev = new CustomerFormEvent(this, name,
						number, address);

				if (customerFormListener != null) {
					customerFormListener.formEventOccurred(ev);
				}
			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Add Customer");
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

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(submitBtn, gc);
	}

	// ////////////////////EDIT////////////////////////

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
