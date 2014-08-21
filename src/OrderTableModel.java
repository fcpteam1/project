import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;


public class OrderTableModel extends AbstractTableModel {
	
	private ArrayList<Order> orders;
	private ArrayList<Supplier> suppliers;
	private String[] columnNames = {"Product","Price", "Quantity"};
	
	public OrderTableModel(){
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void setData(ArrayList<Order> orders, ArrayList<Supplier> suppliers) {
		this.orders = orders;
		this.suppliers = suppliers;
	}

	@Override
	public int getRowCount() {
		return orders.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Order order = orders.get(rowIndex); 
		
		switch(columnIndex) {
		case 0:
			return order.getProducts().get(rowIndex).getName();
		case 1:
			return order.getProducts().get(rowIndex).getSupplierPrice();
		case 2:
			return order.getProducts().get(rowIndex).getQuantity();
		}
		
		return null;
	}

}
