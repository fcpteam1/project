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
	private StockByDateTableModel byDateTableModel;
	private StockPredictionTableModel predictionModel;
	private StockLowStockTableModel lowStockModel;
	private JPopupMenu popup;
	private StockTableListener listener;
	private StockFormPanel formPanel;
	
	public StockTablePanel() {
		
		predictionModel = new StockPredictionTableModel();
		byDateTableModel = new StockByDateTableModel();
		lowStockModel=new  StockLowStockTableModel();
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
				StockFormEvent stockEv = new StockFormEvent(e, name);
				if(listener!=null){
					listener.editPrice(stockEv);
				}
				refresh();
			}
		});
		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);
		
	}
	
	public void setData(ArrayList<Stock> stock){
		tableModel.setData(stock);
		byDateTableModel.setData(stock);
	}
	
	public void setPredictData(Object[][] predictData){
		predictionModel.setData(predictData);
	}
	
	public void setLowStockData(Object[][] low){
		lowStockModel.setData(low);
	}
	
//	public void setPredictionColumns(int i){
//		predictionModel.setColumnNames(i);
//	}
	
	public void setPredictionRowCount(int i){
		predictionModel.setRowCount(i);
	}
	
	public void setLowStockRowCount(int i){
		lowStockModel.setRowCount(i);
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
		byDateTableModel.fireTableDataChanged();
		predictionModel.fireTableDataChanged();
		lowStockModel.fireTableDataChanged();
	}
	
	public void setListener(StockTableListener listener) {
		this.listener = listener;
	}
	
	public void setFormPanel(StockFormPanel formPanel){
		this.formPanel = formPanel;
	}
	
	public void setModel(int i){
		switch (i) {
		case 1:
			table.setModel(tableModel);
			break;
		case 2:
			table.setModel(byDateTableModel);
			break;
		case 3:
			table.setModel(predictionModel);
			break;
		case 4:
			table.setModel(lowStockModel);
			break;
		}
	}
	
}
