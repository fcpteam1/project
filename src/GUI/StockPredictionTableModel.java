package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.Stock;

public class StockPredictionTableModel extends AbstractTableModel {

	private String[] columnNames = { "Item", "3 Ago", "2 Ago", "Last", "This", "Next"};
//	private String[] monthColumns = { "Item", "3 Months", "2 Months", "Last Month", "This Month", "Next Month"};
//	private String[] weekColumns = { "Item", "3 Week", "2 Week", "Last Week", "This Week", "Next Week"};
	private Object[][] predictData;
	private int rowCount;

	public StockPredictionTableModel(){
		
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
	
	public void setData(Object[][] predictData){
		this.predictData = predictData;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public int getRowCount() {
		return rowCount;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return predictData[rowIndex][0];
		case 1:
			return predictData[rowIndex][1];
		case 2:
			return predictData[rowIndex][2];
		case 3:
			return predictData[rowIndex][3];
		case 4:
			return predictData[rowIndex][4];
		case 5:
			return predictData[rowIndex][5];
		}
		return null;
	}
}
