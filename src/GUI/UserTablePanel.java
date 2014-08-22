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

import model.Shop;
import model.User;


public class UserTablePanel extends JPanel {
	
	private JTable table;
	private UserTableModel tableModel;
	private JPopupMenu popup;
	private UserTableListener userTableListener;
	private UserFormPanel formPanel ;
	
	
	public UserTablePanel() {
		
		tableModel = new UserTableModel();
		table = new JTable(tableModel);
		popup = new JPopupMenu();
		
		JMenuItem removeItem = new JMenuItem("Delete User");
		JMenuItem editItem = new JMenuItem("Edit User");
		popup.add(removeItem);
		popup.add(editItem);
		
		table.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				
				int row = table.rowAtPoint(e.getPoint());
				
				table.getSelectionModel().setSelectionInterval(row, row);
				
				if(e.getButton() == MouseEvent.BUTTON3){
					popup.show(table, e.getX(),e.getY());
				}
			}
			
		});
		
		
		removeItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				System.out.println("Row: " + row);
				if(userTableListener != null) {
					userTableListener.rowDeleted(row);
				}
			}
		});
		
		editItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				
				if(userTableListener != null) {
					userTableListener.rowEdited(row);
					formPanel.removeAll();
					try {
						formPanel.setEditDataPassword(Shop.getInstance().getEditUserPassword());
					} catch (IOException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						formPanel.setEditDataUsername(Shop.getInstance().getEditUserUsername());
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
		
		add(new JScrollPane (table) , BorderLayout.CENTER);
	
	}
	
	public void setFormPanel(UserFormPanel formPanel){
		this.formPanel = formPanel;
	}
		
	public void setData(ArrayList<User> users) {
		tableModel.setData(users);
	}
	
	public void refresh() {
		tableModel.fireTableDataChanged();
	}
	
	public void setUserTableListener(UserTableListener listener){
		this.userTableListener = listener;
	}

}
