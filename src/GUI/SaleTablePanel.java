package GUI;

import java.awt.BorderLayout;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import model.Sale;

public class SaleTablePanel extends JPanel {
	
	private JTable table;
	private SaleTableModel tableModel;
	private SaleFormPanel formPanel;
	
	public SaleTablePanel() {
		
		tableModel = new SaleTableModel();
		table = new JTable(tableModel);
		
		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setData(ArrayList<Sale> sales) {
		tableModel.setData(sales);
	}
	
	public void setFormPanel(SaleFormPanel formPanel) {
		this.formPanel = formPanel;
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}
}
