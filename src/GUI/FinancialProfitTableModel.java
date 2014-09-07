package GUI;

import javax.swing.table.AbstractTableModel;
//Table Model for the financial profit table
public class FinancialProfitTableModel extends AbstractTableModel {
	//The column headers to be used in the table
	private String[] columnNames = { "Income", "Expenditure", "Profit", "Loss" };
	//Necessary variables to be added to the table per row
	private double income, expenditure, profit, loss;

	public FinancialProfitTableModel() {
		
	}
	//method called from the main panel through the table panel to set data in table
	public void setData(double income, double expenditure, double profit,
			double loss) {
		this.income = income;
		this.expenditure = expenditure;
		this.profit = profit;
		this.loss = loss;
	}
	
	//sets column name
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	//hardcoded amount of columns
	public int getColumnCount() {
		return 4;
	}
	
	//set amount of rows
	public int getRowCount() {
		return 1;
	}

	//returns value at given row/column intersection
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {

		case 0:
			return income;
		case 1:
			return expenditure;
		case 2:
			return profit;
		case 3:
			return loss;
		}
		return null;
	}
}
