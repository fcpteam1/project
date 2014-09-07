package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Stock;

public class StockLowStockTableModel extends AbstractTableModel {

	private String[] columnNames = { "Item","Id"," Current Quantity","Predicted"};
//	private String[] monthColumns = { "Item", "3 Months", "2 Months", "Last Month", "This Month", "Next Month"};
//	private String[] weekColumns = { "Item", "3 Week", "2 Week", "Last Week", "This Week", "Next Week"};
	private Object[][] lowData;
	private int rowCount;

	public StockLowStockTableModel(){
		
	}
	
//	public void setColumnNames(int i){
//		if(i==1){
//			for(int j=0; j<6;j++){
//				columnNames[j] = monthColumns[j];
//			}
//		}
//		else if(i==2){
//			for(int j=0; j<6;j++){
//				columnNames[j] = weekColumns[j];
//			}
//		}
//	}
	
	public void setRowCount(int i){
		this.rowCount = i;
	}
	
	public void setData(Object[][] lowData){
		this.lowData = lowData;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public int getRowCount() {
		return rowCount;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return lowData[rowIndex][0];
		case 1:
			return lowData[rowIndex][1];
		case 2:
			return lowData[rowIndex][2];
		case 3:
			return lowData[rowIndex][3];
		
		}
		return null;
	}
}
