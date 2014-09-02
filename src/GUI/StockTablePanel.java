package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Stock;

public class StockTablePanel extends JPanel {

	private JTable table;
	private StockTableModel tableModel;
	private JPopupMenu popup;
	private StockTableListener listener;
	private JTextField price;
	
	public StockTablePanel() {
		
		tableModel = new StockTableModel();
		table = new JTable(tableModel);
		popup = new JPopupMenu();
		
		JMenuItem editItem = new JMenuItem("Edit Price");
		popup.add(editItem);
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				int row = table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);
				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}
		});
		
		editItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int column = 0;
				String name = (String)table.getValueAt(row, column);
				if(listener!=null){
				//	listener.editPrice(StockEvent ev);
				}
			}
		});
		
		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);
		
	}
	
	public void setData(ArrayList<Stock> stock){
		tableModel.setData(stock);
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}
	
	public void setListener(StockTableListener listener) {
		this.listener = listener;
	}
	
}
