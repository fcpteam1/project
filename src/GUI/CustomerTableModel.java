package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Customer;
//Creating the table model for Customer
//It extends the abstractTableModel which is a skeleton for a table model
//Within it I set the data that was needed to populate the JTable

public class CustomerTableModel extends AbstractTableModel {
	private ArrayList<Customer> customers;
	private String[] columnNames = { "ID", "Name", "Number", "Address" };

	public CustomerTableModel() {
	}

	// This just sets the name for each column
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	// Calling this method will set what data is being displayed within the
	// table
	public void setData(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	// Setting the row count based on the size of the customer array
	@Override
	public int getRowCount() {
		return customers.size();
	}

	// Similar for the column count
	@Override
	public int getColumnCount() {
		return 4;
	}

	// Organising the data from the arrayList customers into the appropriate row
	// and column
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Customer customer = customers.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return customer.getId();
		case 1:
			return customer.getName();
		case 2:
			return customer.getNumber();
		case 3:
			return customer.getAddress();
		}

		return null;
	}

}
