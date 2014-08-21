package GUI;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Order;
import model.Supplier;

public class OrderTablePanel extends JPanel {
	
	private JTable table;
	private OrderTableModel tableModel;
	
	public OrderTablePanel() {
		
		tableModel = new OrderTableModel();
		table = new JTable(tableModel);
		
		setLayout(new BorderLayout());
		
		add(new JScrollPane (table) , BorderLayout.CENTER);
	
	}
		
	public void setData(ArrayList<Order> orders, ArrayList<Supplier> suppliers) {
		tableModel.setData(orders, suppliers);
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}

}
