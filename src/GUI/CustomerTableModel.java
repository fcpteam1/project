package GUI;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Customer;

public class CustomerTableModel extends AbstractTableModel {
	private ArrayList<Customer> customers;
	private String[] columnNames = {"ID","Name", "Number", "Address"};
	
	public CustomerTableModel(){
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void setData(ArrayList<Customer> customers) {
		this.customers = customers;
	}

	@Override
	public int getRowCount() {
		return customers.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Customer customer = customers.get(rowIndex); 
		
		switch(columnIndex) {
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

