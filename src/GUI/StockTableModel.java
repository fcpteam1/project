package GUI;

import java.util.ArrayList;
import java.util.Map;

import javax.swing.table.AbstractTableModel;

import model.Stock;

public class StockTableModel extends AbstractTableModel {

	private String[] columnNames = { "Name", "Quantity", "Customer Price"};
	private ArrayList<Stock> stockList;
	public StockTableModel(){
		
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	public void setData(ArrayList<Stock> stockList){
		this.stockList = stockList;
	}
	
	@Override
	public int getColumnCount() {
		return 3;
	}

	@Override
	public int getRowCount() {
		return stockList.size();
	}
	
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return stockList.get(rowIndex).getName();
		case 1:
			return stockList.get(rowIndex).getQuantity();
		case 2:
			return stockList.get(rowIndex).getCustomerPrice();
		}
		return null;
	}

	
	
}
