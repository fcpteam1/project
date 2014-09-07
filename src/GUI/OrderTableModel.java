package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Order;
import model.Supplier;
//Table with necessary columns for order data
public class OrderTableModel extends AbstractTableModel {

	private ArrayList<Order> orders;
	private String[] columnNames = { "ID", "Supplier", "Total Price",
			"Ordered", "Delivered" };

	public OrderTableModel() {
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void setData(ArrayList<Order> orders, ArrayList<Supplier> suppliers) {
		this.orders = orders;
	}

	@Override
	public int getRowCount() {
		return orders.size();
	}

	@Override
	public int getColumnCount() {
		return 5;
	}

	public Order getOrderByRow(int row){
		for(int i=0; i<orders.size(); i++){
			System.out.println(orders.get(i).getId());
		}
		return orders.get(row);
	}
	
	@Override
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
		case 4:
			return !orders.get(rowIndex).isCurrent();
		}

		return null;
	}

}
