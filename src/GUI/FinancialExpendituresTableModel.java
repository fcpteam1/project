package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Order;
import model.Supplier;

public class FinancialExpendituresTableModel extends AbstractTableModel {

	private ArrayList<Order> orders;
	private String[] columnNames = { "ID", "Supplier", "Total Price",
			"Ordered", "Delivered" };

	public FinancialExpendituresTableModel() {
	}
	
	public void setData(ArrayList<Order> todayOrders) {
		this.orders = todayOrders;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getRowCount() {
		return orders.size();
	}

	public int getColumnCount() {
		return 4;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {

		switch (columnIndex) {
		case 0:
			return orders.get(rowIndex).getId();
		case 1:
			return orders.get(rowIndex).getSupplier().getName();
		case 2:
			return orders.get(rowIndex).getTotalPrice();
		case 3:
			return orders.get(rowIndex).getDate();
		}

		return null;
	}
}
