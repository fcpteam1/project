package GUI;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import model.Model;

public class UserMainPanel extends JPanel {
	private JPanel mainPanel;
	private UserToolbar userToolbar;
	private UserFormPanel userFormPanel;
	private UserTablePanel userTablePanel;
	private Model model;

	public UserMainPanel() throws IOException {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		userToolbar = new UserToolbar();
		userFormPanel = new UserFormPanel();
		userTablePanel = new UserTablePanel();
		model = new Model();

		userTablePanel.setFormPanel(userFormPanel);
		userToolbar.setFormPanel(userFormPanel);

		userTablePanel.setData(model.getShop().getUsers());

		userTablePanel.setUserTableListener(new UserTableListener() {

			@Override
			public void rowDeleted(int row) {
				model.getShop().removeUser(row);
				userTablePanel.refresh();
			}

			@Override
			public void rowEdited(int row) {
				model.getShop().editUser(row);
				userTablePanel.refresh();
			}
		});

		userFormPanel.setData(model.getShop().getUsers());

		userFormPanel.setFormListener(new UserFormListener() {

			@Override
			public void formEventOccurred(UserFormEvent e) {
				model.getShop().addUser(e);
				userTablePanel.refresh();
			}

			@Override
			public void editFormEventOccurred(UserFormEvent ee) {
				model.getShop().NewEditUser(ee);
				userTablePanel.refresh();
			}

		});

		userToolbar.setFormPanel(userFormPanel);
		;

		mainPanel.add(userFormPanel, BorderLayout.WEST);
		mainPanel.add(userToolbar, BorderLayout.NORTH);
		mainPanel.add(userTablePanel, BorderLayout.CENTER);

		setSize(600, 500);
	}

	public JPanel getPanel() {
		return mainPanel;

	}
}
