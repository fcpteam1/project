package GUI;

import javax.swing.table.AbstractTableModel;

public class FinancialProfitTableModel extends AbstractTableModel {
	private String[] columnNames = { "Income", "Expenditure", "Profit", "Loss" };
	private double income, expenditure, profit, loss;

	public FinancialProfitTableModel() {

	}

	public void setData(double income, double expenditure, double profit,
			double loss) {
		this.income = income;
		this.expenditure = expenditure;
		this.profit = profit;
		this.loss = loss;
	}

	public String getColumnName(int column) {
		return columnNames[column];
	}

	public int getColumnCount() {
		return 4;
	}

	public int getRowCount() {
		return 1;
	}

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
