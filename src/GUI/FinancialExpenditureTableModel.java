package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Order;

public class FinancialExpenditureTableModel extends AbstractTableModel {

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

	@Override
	public int getRowCount() {
		return orders.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

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
