package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Model;
import model.User;

public class UserFormPanel extends JPanel {

	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JLabel idLabel;
	private JLabel adminLabel;
	private JLabel userLabel;
	private JTextField usernameField;
	private JTextField passwordField;
	private JTextField idField;
	private JTextField adminField;
	private JButton submitBtn, editBtn;
	private UserFormListener userFormListener;
	private JComboBox adminList, usernameList;
	private Model model;
	private ArrayList<User> users;

	private String editUserUsername = "";
	private String editUserPassword = "";

	private UserTablePanel userTablePanel = new UserTablePanel();

	public UserFormPanel() {

	}

	public void setData(ArrayList<User> users) {
		this.users = users;
	}

	public void setEditDataUsername(String editUserUsername) {
		this.editUserUsername = editUserUsername;
	}

	public void setEditDataPassword(String editUserPassword) {
		this.editUserPassword = editUserPassword;
	}

	// ////////////////////CREATE////////////////////////

	public void CreateFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		idLabel = new JLabel("ID: ");
		adminLabel = new JLabel("Admin: ");

		usernameField = new JTextField(10);
		passwordField = new JTextField(10);
		idField = new JTextField(10);
		adminList = new JComboBox();

		DefaultComboBoxModel adminModel = new DefaultComboBoxModel();
		adminModel.addElement(true);
		adminModel.addElement(false);
		adminList.setModel(adminModel);

		submitBtn = new JButton("Submit");

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				String id = idField.getText();
				Boolean admin = (Boolean) adminList.getSelectedItem();

				UserFormEvent ev = new UserFormEvent(this, username, password,
						id, admin);

				if (userFormListener != null) {
					userFormListener.formEventOccurred(ev);
				}
			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Add User");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(usernameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(usernameField, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(passwordLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(passwordField, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(adminLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(adminList, gc);

		// /////// Fifth row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(submitBtn, gc);
	}

	// ////////////////////EDIT////////////////////////

	public void EditFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		usernameLabel = new JLabel("Username: ");
		passwordLabel = new JLabel("Password: ");
		idLabel = new JLabel("ID: ");
		adminLabel = new JLabel("Admin: ");

		usernameField = new JTextField(editUserUsername, 10);
		passwordField = new JTextField(editUserPassword, 10);

		adminList = new JComboBox();

		DefaultComboBoxModel adminModel = new DefaultComboBoxModel();
		adminModel.addElement(true);
		adminModel.addElement(false);
		adminList.setModel(adminModel);

		editBtn = new JButton("Finish");

		editBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ee) {
				String username = usernameField.getText();
				String password = passwordField.getText();
				String id = "";
				Boolean admin = (Boolean) adminList.getSelectedItem();

				UserFormEvent eev = new UserFormEvent(this, username, password,
						id, admin);

				if (userFormListener != null) {
					userFormListener.editFormEventOccurred(eev);
				}
			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Edit User");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(usernameLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(usernameField, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(passwordLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(passwordField, gc);

		// /////// Third row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(adminLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(adminList, gc);

		// /////// Fifth row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(editBtn, gc);
	}

	public void setFormListener(UserFormListener userFormListener) {
		this.userFormListener = userFormListener;
	}

}
