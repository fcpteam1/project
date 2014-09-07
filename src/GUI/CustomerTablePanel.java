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
// This panel is created to display the Customer details onto a JTable
//This panel is called when the Customer Panel is selected
public class CustomerTablePanel extends JPanel {
	//Setting up my variables for the CustomerFormPanel
	private JTable table;
	private CustomerTableModel tableModel;
	private JPopupMenu popup;
	private CustomerTableListener customerTableListener;
	private CustomerFormPanel formPanel;

	public CustomerTablePanel() {
		//Calling the constructor for a new table model 
		tableModel = new CustomerTableModel();
		//Creating a new table and passing it the new table model
		table = new JTable(tableModel);
		//Creating a new Popup menu
		popup = new JPopupMenu();
		
		//creating the two items within the popup menu
		//Delete Customer and Edit Customer
		JMenuItem removeItem = new JMenuItem("Delete User");
		JMenuItem editItem = new JMenuItem("Edit User");
		//Adding them to the popup menu
		popup.add(removeItem);
		popup.add(editItem);

		//adding a listener to wait for a mouse click
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {

				//setting the point on the table the mouse is on to an int
				//and storing it row
				int row = table.rowAtPoint(e.getPoint());
				table.getSelectionModel().setSelectionInterval(row, row);

				//If a right click is pressed on the table the popup
				//menu is displayed allowing you to choose edit or delete customer
				if (e.getButton() == MouseEvent.BUTTON3) {
					popup.show(table, e.getX(), e.getY());
				}
			}

		});
		
		//When delete customer is clicked and actionlistener 
		//will call the rowDeleted method within the table listener
		//passing the row selected
		removeItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				if (customerTableListener != null) {
					customerTableListener.rowDeleted(row);
				}
			}
		});

		/*When the edit customer is selected the row that is to be edited
		 * is passed to the method rowEdited then the data assigned to that row
		 * is sent to the formPanel by calling methods within shop 
		 * Here a try catch are set up to make sure there is no input output exceptions
		 * the name, number nad address of the customer is then displayed within
		 * the eddited form which is called here. This data can then be altered and submitted*/
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

	//setting the form Panel to a variable within the table panel class so we can remove and
	//change the form panel and insert new panels or data
	public void setFormPanel(CustomerFormPanel formPanel) {
		this.formPanel = formPanel;
	}
	//getting the customer arraylist from shop so we can access the data within
	public void setData(ArrayList<Customer> customers) {
		tableModel.setData(customers);
	}
	//Calling this method will refresh the table instantly when a customer has been edited
	//deleted or created
	public void refresh() {
		tableModel.fireTableDataChanged();
	}
	public void setCustomerTableListener(CustomerTableListener listener) {
		this.customerTableListener = listener;
	}

}
