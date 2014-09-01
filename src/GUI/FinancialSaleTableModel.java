package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Sale;

public class FinancialSaleTableModel extends AbstractTableModel {
	private ArrayList<Sale> sales;
	private String[] columnNames = { "Sale Id", "Customer Name", "Date",
			"Total Price" };

	public FinancialSaleTableModel() {

	}

	public void setData(ArrayList<Sale> todaySales) {
		this.sales = todaySales;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getColumnCount() {
		return 4;
	}

	public int getRowCount() {
		return sales.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			return sales.get(rowIndex).getId();
		case 1:
			return sales.get(rowIndex).getCustomer().getName();
		case 2:
			return sales.get(rowIndex).getDate();
		case 3:
			return sales.get(rowIndex).getTotalPrice();
		}
		return null;
	}

}
