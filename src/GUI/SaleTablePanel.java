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

import model.Sale;

public class SaleTablePanel extends JPanel {

	private JTable table;
	private SaleTableModel tableModel;
	private SaleFormPanel formPanel;
	private JPopupMenu popup;
	private SaleTableListener saleTableListener;

	public SaleTablePanel() {

		tableModel = new SaleTableModel();
		table = new JTable(tableModel);
		popup = new JPopupMenu();

		JMenuItem removeItem = new JMenuItem("Delete Sale");
		JMenuItem listItem = new JMenuItem("List Products");
		popup.add(removeItem);
		popup.add(listItem);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				int row = table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);

				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}
		});

		removeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();

				if (saleTableListener != null) {
					saleTableListener.rowDeleted(row);
				}
			}
		});


		listItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (saleTableListener != null) {
					saleTableListener.listItems(row);
				}
			}
		});

		setLayout(new BorderLayout());
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setData(ArrayList<Sale> sales) {
		tableModel.setData(sales);
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
	}

	public void setSaleTableListener(SaleTableListener listener) {
		this.saleTableListener = listener;
	}

	public void setFormPanel(SaleFormPanel formpanel) {
		this.formPanel = formpanel;
	}
}