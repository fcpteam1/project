package GUI;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Order;
import model.Sale;

public class FinancialTablePanel extends JPanel {

	private JTable table;
	private JTable expenditureTable;
	private JTable saleTable;
	private JTable profitTable;
	private FinancialExpenditureTableModel expenditureModel;
	private FinancialSaleTableModel saleModel;
	private FinancialProfitTableModel profitModel;
	private FinancialFormPanel formPanel;

	public FinancialTablePanel() {

		table = new JTable();
		expenditureModel = new FinancialExpenditureTableModel();
		saleModel = new FinancialSaleTableModel();
		profitModel = new FinancialProfitTableModel();
		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setFormPanel(FinancialFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void setExpenditureData(ArrayList<Order> orders) {
		expenditureModel.setData(orders);
	}

	public void setSaleData(ArrayList<Sale> sales) {
		saleModel.setData(sales);
	}

	public void setProfitData(ArrayList<Order> orders, ArrayList<Sale> sales) {
		profitModel.setData(orders, sales);
	}

	public void refresh() {
		expenditureModel.fireTableDataChanged();
		saleModel.fireTableDataChanged();
		profitModel.fireTableDataChanged();
	}

	public void setTableModel(int i) {
		switch (i) {
		case 1:
			table.setModel(saleModel);
			System.out.println("Sale");
			break;
		case 2:
			table.setModel(expenditureModel);
			System.out.println("Expense");
			break;
		case 3:
			table.setModel(profitModel);
			System.out.println("Profit");
			break;
		}
	}
}
