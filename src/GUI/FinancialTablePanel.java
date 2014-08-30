package GUI;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Sale;

public class FinancialTablePanel extends JPanel {

	private JTable table;
	private FinancialSaleTableModel tableModel;
	private FinancialFormPanel formPanel;

	public FinancialTablePanel() {

		tableModel = new FinancialSaleTableModel();
		table = new JTable(tableModel);

		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setData(ArrayList<Sale> todaySales) {
		tableModel.setData(todaySales);
	}

	public void setFormPanel(FinancialFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
	}
}
