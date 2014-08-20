import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class UserGUI {

	
	private JPanel mainPanel;
	private JPanel userPanel;
	private JButton viewUserButton, editUserButton, createUserButton, deleteUserButton;
	
	
	private JPanel createUserPanel,mainCreatePanel,createSouthPanel;
	private JLabel createNameLabel,createPasswordLabel,adminLabel;
	private JTextField nameField,errorField;
	private JPasswordField passwordField;
	private JRadioButton isAdmin;
	private JButton createBack,createUser;
	
	
	private JPanel viewUserPanel;
	private JTable viewUserTable;
	private JScrollPane viewUserScroll;
	private JButton backToUserFromView;
	String[] columnNames;
	Object[][] viewUserData;
	
	
	private JPanel deleteUserPanel,deleteSouthPanel,deleteCentrePanel,deleteUserInfoPanel,deleteSearchPanel,deleteSearchSouthPanel,deleteSearchCentrePanel,deleteSearchCentreGridPanel,deleteSearchSouthGridPanel;
	private JButton deleteButton,deleteBackButton,deleteSearchButton,deleteNextSearchButton,deletePreviousSearchButton;
	private JLabel deleteUsername,deletePassword,deleteId,deleteAdmin,deleteSearchUsername;
	private JTextField deleteUsernameText,deletePasswordText,deleteIdText,deleteAdminText,deleteSearchUsernameText;
	private int currentDeleteUser=0;
	
	private JPanel editUserPanel,editSouthPanel,editCentrePanel,editUserInfoPanel,editSearchPanel,editSearchSouthPanel,editSearchCentrePanel,editSearchCentreGridPanel,editSearchSouthGridPanel;
	private JButton editButton,editBackButton,editSearchButton,editNextSearchButton,editPreviousSearchButton;
	private JLabel editUsername,editPassword,editId,editAdmin,editSearchUsername,editNewUsername,editNewPassword,editNewId,editNewAdmin;
	private JTextField editUsernameText,editPasswordText,editIdText,editAdminText,editSearchUsernameText,editNewUsernameText,editNewPasswordText,editNewIdText,editNewSearchUsernameText;
	private JRadioButton editNewAdminText;
	private int currentEditUser=0;
	
	public UserGUI(){
		
		mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		userPanel=new JPanel();
		userPanel.setLayout(new GridLayout(2,2,30,30));
		
		
		viewUserButton=new JButton("ViewUsers");
		editUserButton=new JButton("Edit Users");
		createUserButton=new JButton("Create User");
		deleteUserButton=new JButton("Delete User");
		
		
		userPanel.add(viewUserButton);
		userPanel.add(editUserButton);
		userPanel.add(createUserButton);
		userPanel.add(deleteUserButton);
		
		mainPanel.add(userPanel,BorderLayout.CENTER);
		
		
		createUserPanel();
		viewUserPanel();
		deleteUserPanel();
		editUserPanel();
	}
	
	
	public JPanel getPanel(){
		
		
		return mainPanel;
	}
	
	public void switchToViewPanel(){
		
		viewUserPanel=new JPanel();
		viewUserPanel.setLayout(new BorderLayout());
		
		viewUserTable=new JTable(viewUserData,columnNames);
		
		viewUserScroll=new JScrollPane(viewUserTable);
		
		viewUserPanel.add(viewUserScroll,BorderLayout.CENTER);
		viewUserPanel.add(backToUserFromView,BorderLayout.SOUTH);
		
		
		mainPanel.removeAll();
		mainPanel.add(viewUserPanel,BorderLayout.CENTER);
		mainPanel.validate();
		mainPanel.repaint();
	}
	
	public void viewUserPanel(){
		
		
		backToUserFromView=new JButton("Back");
		
		columnNames=new String[]{"Username","Password","Id","Admin"};
		
	}
	
	public void deleteUserPanel(){
		
		deleteUserPanel=new JPanel();
		deleteUserPanel.setLayout(new BorderLayout());
		
		
		deleteSouthPanel=new JPanel();
		deleteSouthPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		deleteBackButton=new JButton("Back");
		deleteButton=new JButton("Delete");
		deleteSouthPanel.add(deleteBackButton);
		deleteSouthPanel.add(deleteButton);
		
		deleteCentrePanel=new JPanel();
		deleteCentrePanel.setLayout(new GridLayout(1,2,5,5));
		
		
		
		
		
		deleteSearchPanel=new JPanel();
		deleteSearchPanel.setLayout(new BorderLayout());
		
		
		deleteSearchSouthPanel=new JPanel();
		deleteSearchSouthPanel.setLayout(new GridLayout(1,2,5,5));
		deleteNextSearchButton=new JButton(">>");
		deletePreviousSearchButton=new JButton("<<");
		deleteSearchSouthPanel.add(deletePreviousSearchButton);
		deleteSearchSouthPanel.add(deleteNextSearchButton);
		
		
		
		deleteSearchCentrePanel=new JPanel();
		deleteSearchCentrePanel.setLayout(new GridLayout(3,1,5,5));
		deleteSearchButton=new JButton("Search");
		deleteSearchUsername=new JLabel("Search by username:");
		deleteSearchUsernameText=new JTextField(20);
		deleteSearchCentrePanel.add(deleteSearchUsername);
		deleteSearchCentrePanel.add(deleteSearchUsernameText);
		deleteSearchCentrePanel.add(deleteSearchButton);
		
		
		deleteUserInfoPanel=new JPanel();
		deleteUserInfoPanel.setLayout(new GridLayout(4,2,5,5));
		deleteUsername=new JLabel("Username:");
		deletePassword=new JLabel("Password:");
		deleteId=new JLabel("Id:");
		deleteAdmin=new JLabel("Admin:");
		deleteUsernameText=new JTextField(20);
		deleteUsernameText.setPreferredSize(new Dimension(100,20));
		deletePasswordText=new JTextField(20);
		deleteIdText=new JTextField(20);
		deleteAdminText=new JTextField(20);
		deleteUserInfoPanel.add(deleteUsername);
		deleteUserInfoPanel.add(deleteUsernameText);
		deleteUserInfoPanel.add(deletePassword);
		deleteUserInfoPanel.add(deletePasswordText);
		deleteUserInfoPanel.add(deleteId);
		deleteUserInfoPanel.add(deleteIdText);
		deleteUserInfoPanel.add(deleteAdmin);
		deleteUserInfoPanel.add(deleteAdminText);
		
		
		
		
		
		
		deleteSearchPanel.add(deleteSearchCentrePanel,BorderLayout.CENTER);
		deleteSearchPanel.add(deleteSearchSouthPanel,BorderLayout.SOUTH);
		
		
		
		
		
		
		deleteCentrePanel.add(deleteSearchPanel);
		deleteCentrePanel.add(deleteUserInfoPanel);
		
		deleteUserPanel.add(deleteCentrePanel,BorderLayout.CENTER);
		deleteUserPanel.add(deleteSouthPanel,BorderLayout.SOUTH);
		
	}
	
	
	public void editUserPanel(){
		
		editUserPanel=new JPanel();
		editUserPanel.setLayout(new BorderLayout());
		
		
		editSouthPanel=new JPanel();
		editSouthPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		editBackButton=new JButton("Back");
		editButton=new JButton("Edit");
		editSouthPanel.add(editBackButton);
		editSouthPanel.add(editButton);
		
		editCentrePanel=new JPanel();
		editCentrePanel.setLayout(new GridLayout(1,2,5,5));
		
		
		
		
		
		editSearchPanel=new JPanel();
		editSearchPanel.setLayout(new BorderLayout());
		
		
		editSearchSouthPanel=new JPanel();
		editSearchSouthPanel.setLayout(new GridLayout(1,2,5,5));
		editNextSearchButton=new JButton(">>");
		editPreviousSearchButton=new JButton("<<");
		editSearchSouthPanel.add(editPreviousSearchButton);
		editSearchSouthPanel.add(editNextSearchButton);
		
		
		
		editSearchCentrePanel=new JPanel();
		editSearchCentrePanel.setLayout(new GridLayout(3,1,5,5));
		editSearchButton=new JButton("Search");
		editSearchUsername=new JLabel("Search by username:");
		editSearchUsernameText=new JTextField(20);
		editSearchCentrePanel.add(editSearchUsername);
		editSearchCentrePanel.add(editSearchUsernameText);
		editSearchCentrePanel.add(editSearchButton);
		
		
		editUserInfoPanel=new JPanel();
		editUserInfoPanel.setLayout(new GridLayout(8,2,5,5));
		editUsername=new JLabel("Username:");
		editPassword=new JLabel("Password:");
		editId=new JLabel("Id:");
		editAdmin=new JLabel("Admin:");
		
		editNewUsername=new JLabel("New Username:");
		editNewPassword=new JLabel("New Password:");
		editNewId=new JLabel("New Id:");
		editNewAdmin=new JLabel("New Admin:");
		
		editUsernameText=new JTextField(20);
		editPasswordText=new JTextField(20);
		editIdText=new JTextField(20);
		editAdminText=new JTextField(20);
		
		editNewUsernameText=new JTextField(20);
		editNewPasswordText=new JTextField(20);
		editNewIdText=new JTextField(20);
		editNewAdminText=new JRadioButton();
		
		editUserInfoPanel.add(editUsername);
		editUserInfoPanel.add(editUsernameText);
		editUserInfoPanel.add(editNewUsername);
		editUserInfoPanel.add(editNewUsernameText);
		
		editUserInfoPanel.add(editPassword);
		editUserInfoPanel.add(editPasswordText);
		editUserInfoPanel.add(editNewPassword);
		editUserInfoPanel.add(editNewPasswordText);
		
		editUserInfoPanel.add(editId);
		editUserInfoPanel.add(editIdText);
		editUserInfoPanel.add(editNewId);
		editUserInfoPanel.add(editNewIdText);
		
		editUserInfoPanel.add(editAdmin);
		editUserInfoPanel.add(editAdminText);
		editUserInfoPanel.add(editNewAdmin);
		editUserInfoPanel.add(editNewAdminText);
		
		
		
		editSearchPanel.add(editSearchCentrePanel,BorderLayout.CENTER);
		editSearchPanel.add(editSearchSouthPanel,BorderLayout.SOUTH);
		
		
		
		editCentrePanel.add(editSearchPanel);
		editCentrePanel.add(editUserInfoPanel);
		
		editUserPanel.add(editCentrePanel,BorderLayout.CENTER);
		editUserPanel.add(editSouthPanel,BorderLayout.SOUTH);
	}
	
	public void createUserPanel(){
		
		createUserPanel=new JPanel();
		createUserPanel.setLayout(new GridLayout(4,1,15,15));
		JPanel userNamePanel=new JPanel();
		userNamePanel.setLayout(new FlowLayout());
		
		JPanel passwordPanel=new JPanel();
		passwordPanel.setLayout(new FlowLayout());
		
		JPanel adminPanel=new JPanel();
		adminPanel.setLayout(new FlowLayout());
		JPanel errorPanel=new JPanel();
		errorPanel.setLayout(new FlowLayout());
		
		
		nameField=new JTextField(25);
		errorField=new JTextField(25);
		passwordField= new JPasswordField(25);
		isAdmin=new JRadioButton();
		createNameLabel=new JLabel("Username:");
		createPasswordLabel=new JLabel("Password:");
		adminLabel=new JLabel("Is Admin");
		
		
		
		userNamePanel.add(createNameLabel);
		userNamePanel.add(nameField);
		passwordPanel.add(createPasswordLabel);
		passwordPanel.add(passwordField);
		adminPanel.add(adminLabel);
		adminPanel.add(isAdmin);
		errorPanel.add(errorField);
		
		createUserPanel.add(userNamePanel);
		createUserPanel.add(passwordPanel);
		createUserPanel.add(adminPanel);
		createUserPanel.add(errorPanel);
		createBack=new JButton("Back");
		createUser=new JButton("Create");
		createSouthPanel=new JPanel();
		createSouthPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		createSouthPanel.add(createBack);
		createSouthPanel.add(createUser);
		
		
		mainCreatePanel=new JPanel();
		mainCreatePanel.setLayout(new BorderLayout());
		
		mainCreatePanel.add(createUserPanel,BorderLayout.CENTER);
		mainCreatePanel.add(createSouthPanel,BorderLayout.SOUTH);
	}
	
	public void swithToMain(){
		
		mainPanel.removeAll();
		mainPanel.add(userPanel,BorderLayout.CENTER);
		mainPanel.validate();
		mainPanel.repaint();
		
	}
	
	public void swithToDeleteUser(){
		
		mainPanel.removeAll();
		mainPanel.add(deleteUserPanel);
		mainPanel.validate();
		mainPanel.repaint();
		
	}
	
	public void switchToCreateUser(){
		
		mainPanel.removeAll();
		mainPanel.add(mainCreatePanel);
		
		mainPanel.validate();
		mainPanel.repaint();
		
	}
	
	public void switchToEditUser(){
		
		mainPanel.removeAll();
		mainPanel.add(editUserPanel);
		
		mainPanel.validate();
		mainPanel.repaint();
	}


	public JTextField getNameField() {
		return nameField;
	}


	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}


	public JPasswordField getPasswordField() {
		return passwordField;
	}


	public void setPasswordField(JPasswordField passwordField) {
		this.passwordField = passwordField;
	}


	public JRadioButton getIsAdmin() {
		return isAdmin;
	}


	public void setIsAdmin(JRadioButton isAdmin) {
		this.isAdmin = isAdmin;
	}


	public JButton getViewUserButton() {
		return viewUserButton;
	}


	public void setViewUserButton(JButton viewUserButton) {
		this.viewUserButton = viewUserButton;
	}


	public JButton getEditUserButton() {
		return editUserButton;
	}


	public void setEditUserButton(JButton editUserButton) {
		this.editUserButton = editUserButton;
	}


	public JButton getCreateUserButton() {
		return createUserButton;
	}


	public void setCreateUserButton(JButton createUserButton) {
		this.createUserButton = createUserButton;
	}


	public JButton getDeleteUserButton() {
		return deleteUserButton;
	}


	public void setDeleteUserButton(JButton deleteUserButton) {
		this.deleteUserButton = deleteUserButton;
	}


	public JTextField getErrorField() {
		return errorField;
	}


	public void setErrorField(JTextField errorField) {
		this.errorField = errorField;
	}


	public JButton getCreateBack() {
		return createBack;
	}


	public void setCreateBack(JButton createBack) {
		this.createBack = createBack;
	}


	public JButton getCreateUser() {
		return createUser;
	}


	public void setCreateUser(JButton createUser) {
		this.createUser = createUser;
	}


	public Object[][] getViewUserData() {
		return viewUserData;
	}


	public void setViewUserData(Object[][] viewUserData) {
		this.viewUserData = viewUserData;
	}


	public JButton getBackToUserFromView() {
		return backToUserFromView;
	}


	public void setBackToUserFromView(JButton backToUserFromView) {
		this.backToUserFromView = backToUserFromView;
	}


	public JButton getDeleteBackButton() {
		return deleteBackButton;
	}


	public void setDeleteBackButton(JButton deleteBackButton) {
		this.deleteBackButton = deleteBackButton;
	}


	public JTextField getDeleteUsernameText() {
		return deleteUsernameText;
	}


	public void setDeleteUsernameText(JTextField deleteUsernameText) {
		this.deleteUsernameText = deleteUsernameText;
	}


	public JTextField getDeletePasswordText() {
		return deletePasswordText;
	}


	public void setDeletePasswordText(JTextField deletePasswordText) {
		this.deletePasswordText = deletePasswordText;
	}


	public JTextField getDeleteIdText() {
		return deleteIdText;
	}


	public void setDeleteIdText(JTextField deleteIdText) {
		this.deleteIdText = deleteIdText;
	}


	public JTextField getDeleteAdminText() {
		return deleteAdminText;
	}


	public void setDeleteAdminText(JTextField deleteAdminText) {
		this.deleteAdminText = deleteAdminText;
	}


	public JTextField getDeleteSearchUsernameText() {
		return deleteSearchUsernameText;
	}


	public void setDeleteSearchUsernameText(JTextField deleteSearchUsernameText) {
		this.deleteSearchUsernameText = deleteSearchUsernameText;
	}


	public int getCurrentDeleteUser() {
		return currentDeleteUser;
	}


	public void setCurrentDeleteUser(int currentDeleteUser) {
		this.currentDeleteUser = currentDeleteUser;
	}


	public JButton getDeleteNextSearchButton() {
		return deleteNextSearchButton;
	}


	public void setDeleteNextSearchButton(JButton deleteNextSearchButton) {
		this.deleteNextSearchButton = deleteNextSearchButton;
	}


	public JButton getDeletePreviousSearchButton() {
		return deletePreviousSearchButton;
	}


	public void setDeletePreviousSearchButton(JButton deletePreviousSearchButton) {
		this.deletePreviousSearchButton = deletePreviousSearchButton;
	}


	public JButton getDeleteButton() {
		return deleteButton;
	}


	public void setDeleteButton(JButton deleteButton) {
		this.deleteButton = deleteButton;
	}


	public JButton getEditBackButton() {
		return editBackButton;
	}


	public void setEditBackButton(JButton editBackButton) {
		this.editBackButton = editBackButton;
	}


	public JButton getEditButton() {
		return editButton;
	}


	public void setEditButton(JButton editButton) {
		this.editButton = editButton;
	}


	public JButton getEditSearchButton() {
		return editSearchButton;
	}


	public void setEditSearchButton(JButton editSearchButton) {
		this.editSearchButton = editSearchButton;
	}


	public JButton getEditNextSearchButton() {
		return editNextSearchButton;
	}


	public void setEditNextSearchButton(JButton editNextSearchButton) {
		this.editNextSearchButton = editNextSearchButton;
	}


	public JButton getEditPreviousSearchButton() {
		return editPreviousSearchButton;
	}


	public void setEditPreviousSearchButton(JButton editPreviousSearchButton) {
		this.editPreviousSearchButton = editPreviousSearchButton;
	}


	public JLabel getEditUsername() {
		return editUsername;
	}


	public void setEditUsername(JLabel editUsername) {
		this.editUsername = editUsername;
	}


	public JLabel getEditPassword() {
		return editPassword;
	}


	public void setEditPassword(JLabel editPassword) {
		this.editPassword = editPassword;
	}


	public JLabel getEditId() {
		return editId;
	}


	public void setEditId(JLabel editId) {
		this.editId = editId;
	}


	public JLabel getEditAdmin() {
		return editAdmin;
	}


	public void setEditAdmin(JLabel editAdmin) {
		this.editAdmin = editAdmin;
	}


	public JLabel getEditSearchUsername() {
		return editSearchUsername;
	}


	public void setEditSearchUsername(JLabel editSearchUsername) {
		this.editSearchUsername = editSearchUsername;
	}


	public JLabel getEditNewUsername() {
		return editNewUsername;
	}


	public void setEditNewUsername(JLabel editNewUsername) {
		this.editNewUsername = editNewUsername;
	}


	public JLabel getEditNewPassword() {
		return editNewPassword;
	}


	public void setEditNewPassword(JLabel editNewPassword) {
		this.editNewPassword = editNewPassword;
	}


	public JLabel getEditNewId() {
		return editNewId;
	}


	public void setEditNewId(JLabel editNewId) {
		this.editNewId = editNewId;
	}


	public JLabel getEditNewAdmin() {
		return editNewAdmin;
	}


	public void setEditNewAdmin(JLabel editNewAdmin) {
		this.editNewAdmin = editNewAdmin;
	}


	public JTextField getEditUsernameText() {
		return editUsernameText;
	}


	public void setEditUsernameText(JTextField editUsernameText) {
		this.editUsernameText = editUsernameText;
	}


	public JTextField getEditPasswordText() {
		return editPasswordText;
	}


	public void setEditPasswordText(JTextField editPasswordText) {
		this.editPasswordText = editPasswordText;
	}


	public JTextField getEditIdText() {
		return editIdText;
	}


	public void setEditIdText(JTextField editIdText) {
		this.editIdText = editIdText;
	}


	public JTextField getEditAdminText() {
		return editAdminText;
	}


	public void setEditAdminText(JTextField editAdminText) {
		this.editAdminText = editAdminText;
	}


	public JTextField getEditSearchUsernameText() {
		return editSearchUsernameText;
	}


	public void setEditSearchUsernameText(JTextField editSearchUsernameText) {
		this.editSearchUsernameText = editSearchUsernameText;
	}


	public JTextField getEditNewUsernameText() {
		return editNewUsernameText;
	}


	public void setEditNewUsernameText(JTextField editNewUsernameText) {
		this.editNewUsernameText = editNewUsernameText;
	}


	public JTextField getEditNewPasswordText() {
		return editNewPasswordText;
	}


	public void setEditNewPasswordText(JTextField editNewPasswordText) {
		this.editNewPasswordText = editNewPasswordText;
	}


	public JTextField getEditNewIdText() {
		return editNewIdText;
	}


	public void setEditNewIdText(JTextField editNewIdText) {
		this.editNewIdText = editNewIdText;
	}


	public JRadioButton getEditNewAdminText() {
		return editNewAdminText;
	}


	public void setEditNewAdminText(JRadioButton editNewAdminText) {
		this.editNewAdminText = editNewAdminText;
	}


	public JTextField getEditNewSearchUsernameText() {
		return editNewSearchUsernameText;
	}


	public void setEditNewSearchUsernameText(JTextField editNewSearchUsernameText) {
		this.editNewSearchUsernameText = editNewSearchUsernameText;
	}


	public int getCurrentEditUser() {
		return currentEditUser;
	}


	public void setCurrentEditUser(int currentEditUser) {
		this.currentEditUser = currentEditUser;
	}


	public JButton getDeleteSearchButton() {
		return deleteSearchButton;
	}


	public void setDeleteSearchButton(JButton deleteSearchButton) {
		this.deleteSearchButton = deleteSearchButton;
	}
}
