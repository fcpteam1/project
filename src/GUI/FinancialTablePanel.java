package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import model.Order;
import model.Sale;

public class FinancialTablePanel extends JPanel {

	private int choice;
	private JTable table;
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

	public void setProfitData(double income, double expenditure, double profit,
			double loss) {
		profitModel.setData(income, expenditure, profit, loss);
	}

	public void refresh() {
		expenditureModel.fireTableDataChanged();
		saleModel.fireTableDataChanged();
		profitModel.fireTableDataChanged();
	}

	public void setTableModel(int i) {
		switch (i) {
		case 1:
			choice = 1;
			table.setModel(saleModel);
			System.out.println("Sale");
			break;
		case 2:
			choice = 2;
			table.setModel(expenditureModel);
			System.out.println("Expense");
			break;
		case 3:
			choice = 3;
			table.setModel(profitModel);
			System.out.println("Profit");
			break;
		}
	}
}
