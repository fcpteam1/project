package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Customer;
import model.Shop;

public class CustomerTablePanel extends JPanel {
	private JTable table;
	private CustomerTableModel tableModel;
	private JPopupMenu popup;
	private CustomerTableListener customerTableListener;
	private CustomerFormPanel formPanel;

	public CustomerTablePanel() {

		tableModel = new CustomerTableModel();
		table = new JTable(tableModel);
		popup = new JPopupMenu();

		JMenuItem removeItem = new JMenuItem("Delete Customer");
		JMenuItem editItem = new JMenuItem("Edit Customer");
		popup.add(removeItem);
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

		removeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (customerTableListener != null) {
					customerTableListener.rowDeleted(row);
				}
			}
		});

		editItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();

				if (customerTableListener != null) {
					customerTableListener.rowEdited(row);
					formPanel.removeAll();
					try {
						formPanel.setEditDataAddress(Shop.getInstance()
								.getEditCustomerAddress());
					} catch (IOException e3) {
						// TODO Auto-generated catch block
						e3.printStackTrace();
					}
					try {
						formPanel.setEditDataNumber(Shop.getInstance()
								.getEditCustomerNumber());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						formPanel.setEditDataName(Shop.getInstance()
								.getEditCustomerName());
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					formPanel.EditFormPanel();
					formPanel.validate();
					formPanel.repaint();
				}
			}
		});

		setLayout(new BorderLayout());

		add(new JScrollPane(table), BorderLayout.CENTER);

	}

	public void setFormPanel(CustomerFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void setData(ArrayList<Customer> customers) {
		tableModel.setData(customers);
	}

	public void refresh() {
		tableModel.fireTableDataChanged();
	}

	public void setCustomerTableListener(CustomerTableListener listener) {
		this.customerTableListener = listener;
	}

}
