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

import model.Order;
import model.Supplier;

public class OrderTablePanel extends JPanel {

	private JTable table;
	private OrderTableModel tableModel;
	private JPopupMenu popup;
	private OrderTableListener orderTableListener;
	private OrderFormPanel formPanel;

	public OrderTablePanel() {

		tableModel = new OrderTableModel();
		table = new JTable(tableModel);

		//popup menu to allow edit/delete/process functionality
		popup = new JPopupMenu();

		JMenuItem deleteItem = new JMenuItem("Delete Order");
		JMenuItem editItem = new JMenuItem("Edit Order");
		JMenuItem processItem = new JMenuItem("Process Order");
		popup.add(deleteItem);
		popup.add(editItem);
		popup.add(processItem);

		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				int row = table.rowAtPoint(e.getPoint());

				table.getSelectionModel().setSelectionInterval(row, row);
				//done through right click
				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}
		});

		deleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int id = (Integer)table.getValueAt(row, 0);
				if (orderTableListener != null) {
					orderTableListener.rowDeleted(id);
				}
			}
		});

		editItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int id = (Integer)table.getValueAt(row, 0);
				if (orderTableListener != null) {
					orderTableListener.rowEdited(id);
				}
			}
		});

		processItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				int id = (Integer)table.getValueAt(row, 0);
				if (orderTableListener != null) {
					orderTableListener.rowProcessed(id);
				}
			}
		});

		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);

	}

	public void setFormPanel(OrderFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void setData(ArrayList<Order> orders, ArrayList<Supplier> suppliers) {
		tableModel.setData(orders, suppliers);
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
	}

	public void setOrderTableListener(OrderTableListener listener) {
		this.orderTableListener = listener;
	}

}
