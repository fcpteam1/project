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

				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}
		});

		deleteItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (orderTableListener != null) {
					orderTableListener.rowDeleted(row);
				}
			}
		});

		editItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				Order order = tableModel.getOrderByRow(row);
				if (orderTableListener != null) {
					orderTableListener.rowEdited(order);
				}
			}
		});

		processItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				Order order = tableModel.getOrderByRow(row);
				if (orderTableListener != null) {
					orderTableListener.rowProcessed(order);
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
