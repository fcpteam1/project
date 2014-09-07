package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Order;

//There are three financial table models one for sales one for expenditures and for Profit
public class FinancialExpenditureTableModel extends AbstractTableModel {
	// Creating a arrayList of orders to store the current orders in
	// This table model is very similar to that of User and others
	private ArrayList<Order> orders;
	private String[] columnNames = { "Order ID", "Supplier Name", "Date",
			"Total Price" };

	public FinancialExpenditureTableModel() {
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void setData(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public ArrayList<Order> getData() {
		return orders;
	}

	@Override
	public int getRowCount() {
		return orders.size();
	}

	// As there is only 4 columns we return 4 starting at 1 instead of 0
	@Override
	public int getColumnCount() {
		return 4;
	}

	// Displaying within the table the supplier ID,Name,Date of order and the
	// total price of the order
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex) {
		case 0:
			return orders.get(rowIndex).getId();
		case 1:
			return orders.get(rowIndex).getSupplier().getName();
		case 2:
			return orders.get(rowIndex).getDate();
		case 3:
			return orders.get(rowIndex).getTotalPrice();
		}

		return null;
	}

}

