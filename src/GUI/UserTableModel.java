//Same set up as Customer Table Model

package GUI;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import model.User;

public class UserTableModel extends AbstractTableModel {

	private ArrayList<User> users;
	private String[] columnNames = { "ID", "Username", "Password", "Admin" };

	public UserTableModel() {
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	public void setData(ArrayList<User> users) {
		this.users = users;
	}

	@Override
	public int getRowCount() {
		return users.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		User user = users.get(rowIndex);

		switch (columnIndex) {
		case 0:
			return user.getId();
		case 1:
			return user.getUsername();
		case 2:
			return user.getPassword();
		case 3:
			return user.isAdmin();
		}

		return null;
	}

}
