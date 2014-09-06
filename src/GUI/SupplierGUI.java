package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class SupplierGUI {

	private boolean adminLogged = false;

	private JPanel showPanel, buttonsPanel, tablePanel, borderPanel,
			nextPrevPanel, supplierTextPanel, holder;
	private JTable viewSupplierTabel;
	private JScrollPane viewScroll;
	private JButton edit, create, add, delete;
	Object supplierData[][], productData[][];
	String supplierNames[], productNames[];

	private JButton search, next, previous, supplierButton, productButton;
	private JTextField searchText, supplierText;
	private JMenuItem viewProducts, editSupplier, addProducts,
			editSupplierFromProducts, addProductFromProducts, deleteSupplier;
	private JPopupMenu viewProductsPopup;

	// add products
	private JPanel addProductsPanel;
	private JTextField productName, supplierPrice;
	private JLabel productNameLabel, supplierPriceLabel;
	private JButton addProduct, exitProductPanel;

	// edit supplier name etc
	private JPanel editSupplierPanel;
	private JTextField supplierName, supplierPhone, supplierAddress;
	private JButton editSupName, editSupPhone, editSupAddress, exitEditPanel;
	private JLabel editNameLabel, editPhoneLabel, editAddressLabel;

	// create supplier
	private JPanel createSupplierPanel;
	private JTextField createName, createPhone, createAddress;
	private JLabel createNameLabel, createPhoneLabel, createAddressLabel;
	private JButton createSupplierButton, exitCreatePanelButton;

	// delete supplier
	private JPanel deletePanel;
	private JFrame deleteFrame;
	private JButton yes, no;
	private JLabel warning;

	boolean supplier;
	int current = 0;

	public SupplierGUI() throws IOException {
		// TODO Auto-generated constructor stub

		addNewProducts();
		editSupplier();
		createSupplier();
		deletePanel();
		supplierNames = new String[] { "Name", "Id", "Phone", "Address" };
		productNames = new String[] { "Name", "Id", "Supplier Price" };

		viewProducts = new JMenuItem("View Supplier Products");
		editSupplier = new JMenuItem("Edit Supplier");
		addProducts = new JMenuItem("Add Product");
		deleteSupplier = new JMenuItem("Delete Supplier");
		editSupplierFromProducts = new JMenuItem("Edit this Supplier");
		addProductFromProducts = new JMenuItem("Create new Product");
		viewProductsPopup = new JPopupMenu();

		showPanel = new JPanel();
		showPanel.setLayout(new GridBagLayout());

		borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout());

		
		buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());

		tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout());

		nextPrevPanel = new JPanel();
		nextPrevPanel.setLayout(new FlowLayout());

		holder = new JPanel();
		holder.setLayout(new GridBagLayout());

		search = new JButton("Search");
		next = new JButton(">>");
		previous = new JButton("<<");
		supplierButton = new JButton("View Suppliers");
		productButton = new JButton("View Products");
		searchText = new JTextField(15);

		supplierTextPanel = new JPanel();
		supplierTextPanel.setLayout(new FlowLayout());
		supplierText = new JTextField(25);
		supplierTextPanel.add(supplierText);

		edit = new JButton("Edit Supplier");
		create = new JButton("Create Supplier");
		add = new JButton("Add Products");
		delete = new JButton("Delete Supplier");

		GridBagConstraints c = new GridBagConstraints();

		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		buttonsPanel.add(supplierButton, c);

		JPanel crudPanel = new JPanel();
		crudPanel.setLayout(new FlowLayout());
		crudPanel.add(edit);
		crudPanel.add(create);
		crudPanel.add(delete);
		crudPanel.add(add);

		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		buttonsPanel.add(crudPanel, c);

		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		buttonsPanel.add(productButton, c);

		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		buttonsPanel.add(searchText, c);

		c.gridx = 1;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		buttonsPanel.add(search, c);

		nextPrevPanel.add(previous);
		nextPrevPanel.add(next);

		c.gridx = 2;
		c.gridy = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.CENTER;
		buttonsPanel.add(nextPrevPanel, c);

		supplierData = new Object[1][4];
		supplierData[0][0] = "null";
		supplierData[0][1] = "null";
		supplierData[0][2] = "null";
		supplierData[0][3] = "null";

		viewSupplierTabel = new JTable(supplierData, supplierNames);
		viewScroll = new JScrollPane(viewSupplierTabel);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 3;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		tablePanel.add(viewScroll, BorderLayout.CENTER);
		tablePanel.add(new JPanel(), BorderLayout.WEST);

		c.gridx = 1;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		supplierTextPanel.add(supplierText, c);

		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.2;
		c.weightx = 1;
		c.gridwidth = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 3;
		showPanel.add(buttonsPanel, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 0.8;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		showPanel.add(tablePanel, c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.PAGE_END;
		showPanel.add(supplierTextPanel, c);

		search.setEnabled(false);
		next.setEnabled(false);
		previous.setEnabled(false);

	}

	public JPanel getMain() {

		return showPanel;
	}

	public void backToMainPanel() {

	}

	public void focusViewSuppliers() {
		showPanel.removeAll();

		GridBagConstraints c = new GridBagConstraints();

		tablePanel.removeAll();
		viewSupplierTabel = new JTable(supplierData, supplierNames);
		viewScroll = new JScrollPane(viewSupplierTabel);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 3;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		tablePanel.add(viewScroll, BorderLayout.CENTER);
		tablePanel.add(new JPanel(), BorderLayout.WEST);
		tablePanel.validate();
		tablePanel.repaint();

		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.2;
		c.weightx = 1;
		c.gridwidth = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 3;
		showPanel.add(buttonsPanel, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 0.8;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		showPanel.add(tablePanel, c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.PAGE_END;
		showPanel.add(supplierTextPanel, c);

		showPanel.revalidate();
		showPanel.repaint();

		viewProductsPopup.removeAll();
		viewProductsPopup.add(viewProducts);
		viewProductsPopup.add(editSupplier);
		viewProductsPopup.add(addProducts);
		viewProductsPopup.add(deleteSupplier);

		next.setEnabled(false);
		previous.setEnabled(false);
		search.setEnabled(false);

		if (adminLogged == true) {
			add.setEnabled(false);
			delete.setEnabled(true);
			edit.setEnabled(true);
			create.setEnabled(true);
		} else {
			add.setEnabled(false);
			delete.setEnabled(false);
			edit.setEnabled(false);
			create.setEnabled(false);

		}

		supplier = true;

	}

	public void focusViewProducts() {

		showPanel.removeAll();

		GridBagConstraints c = new GridBagConstraints();

		tablePanel.removeAll();
		viewSupplierTabel = new JTable(productData, productNames);
		viewScroll = new JScrollPane(viewSupplierTabel);
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 3;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		tablePanel.add(viewScroll, BorderLayout.CENTER);
		tablePanel.add(new JPanel(), BorderLayout.WEST);
		tablePanel.validate();
		tablePanel.repaint();

		c.gridheight = 1;
		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.2;
		c.weightx = 1;
		c.gridwidth = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 3;
		showPanel.add(buttonsPanel, c);

		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 0.8;
		c.anchor = GridBagConstraints.FIRST_LINE_START;
		showPanel.add(tablePanel, c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 0.1;
		c.anchor = GridBagConstraints.PAGE_END;
		showPanel.add(supplierTextPanel, c);

		showPanel.revalidate();
		showPanel.repaint();

		supplier = false;

		viewProductsPopup.removeAll();

		viewProductsPopup.add(editSupplierFromProducts);
		viewProductsPopup.add(addProductFromProducts);

		next.setEnabled(true);
		previous.setEnabled(true);
		search.setEnabled(true);
		if (adminLogged == true) {
			add.setEnabled(true);
			delete.setEnabled(false);
			edit.setEnabled(true);
			create.setEnabled(false);
		} else {
			add.setEnabled(false);
			delete.setEnabled(false);
			edit.setEnabled(false);
			create.setEnabled(false);
		}

	}

	public void addNewProducts() {
		addProductsPanel = new JPanel();

		JPanel namePanel = new JPanel();
		JPanel pricePanel = new JPanel();

		addProductsPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		productName = new JTextField(15);
		supplierPrice = new JTextField(15);
		productNameLabel = new JLabel("New Product Name");
		supplierPriceLabel = new JLabel("Supplier Price");
		addProduct = new JButton("Add Product");
		exitProductPanel = new JButton("Exit Panel");

		Border titleBorder = BorderFactory.createTitledBorder("New Product");

		addProductsPanel.setBorder(titleBorder);
		/*
		 * addProductsPanel.add(productNameLabel);
		 * addProductsPanel.add(productName);
		 * addProductsPanel.add(supplierPriceLabel);
		 * addProductsPanel.add(supplierPrice);
		 * addProductsPanel.add(exitProductPanel);
		 * addProductsPanel.add(addProduct);
		 */

		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.WEST;
		addProductsPanel.add(productNameLabel, c);

		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.EAST;
		addProductsPanel.add(productName, c);

		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		addProductsPanel.add(supplierPriceLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.EAST;
		addProductsPanel.add(supplierPrice, c);

		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		addProductsPanel.add(exitProductPanel, c);

		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.EAST;
		addProductsPanel.add(addProduct, c);

	}

	public void editSupplier() {

		editSupplierPanel = new JPanel();
		editSupplierPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		JPanel editPanel = new JPanel();
		editPanel.setLayout(new GridBagLayout());

		supplierName = new JTextField(15);
		supplierPhone = new JTextField(15);
		supplierAddress = new JTextField(15);

		editSupName = new JButton("Edit Name");
		editSupPhone = new JButton("Edit Phone");
		editSupAddress = new JButton("Edit Address");
		exitEditPanel = new JButton("Exit Panel");

		editNameLabel = new JLabel("New Name");
		editPhoneLabel = new JLabel("New Phone");
		editAddressLabel = new JLabel("New Address");

		Border titleBorder = BorderFactory.createTitledBorder("Edit Supplier");
		editSupplierPanel.setBorder(titleBorder);

		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.WEST;
		editPanel.add(editNameLabel, c);

		c.gridx = 1;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		editPanel.add(supplierName, c);

		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.EAST;
		editPanel.add(editSupName, c);

		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		editPanel.add(editPhoneLabel, c);

		c.gridx = 1;
		c.gridy = 1;
		c.anchor = GridBagConstraints.CENTER;
		editPanel.add(supplierPhone, c);

		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.EAST;
		editPanel.add(editSupPhone, c);

		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		editPanel.add(editAddressLabel, c);

		c.gridx = 1;
		c.gridy = 2;
		c.anchor = GridBagConstraints.CENTER;
		editPanel.add(supplierAddress, c);

		c.gridx = 2;
		c.gridy = 2;
		c.anchor = GridBagConstraints.EAST;
		editPanel.add(editSupAddress, c);

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 2;
		c.anchor = GridBagConstraints.CENTER;
		editSupplierPanel.add(editPanel, c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.WEST;
		editSupplierPanel.add(exitEditPanel, c);

	}

	public void createSupplier() {

		createSupplierPanel = new JPanel();
		createSupplierPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		exitCreatePanelButton = new JButton("Exit Panel");
		createSupplierButton = new JButton("Create Supplier");

		JPanel createPanel = new JPanel();
		createPanel.setLayout(new GridBagLayout());

		createName = new JTextField(15);
		createPhone = new JTextField(15);
		createAddress = new JTextField(15);

		createNameLabel = new JLabel("Name");
		createPhoneLabel = new JLabel("Phone");
		createAddressLabel = new JLabel("Address");

		Border titleBorder = BorderFactory.createTitledBorder("Edit Supplier");
		editSupplierPanel.setBorder(titleBorder);

		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.WEST;
		createPanel.add(createNameLabel, c);

		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.EAST;
		createPanel.add(createName, c);

		c.gridx = 0;
		c.gridy = 1;
		c.anchor = GridBagConstraints.WEST;
		createPanel.add(createPhoneLabel, c);

		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.EAST;
		createPanel.add(createPhone, c);

		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.WEST;
		createPanel.add(createAddressLabel, c);

		c.gridx = 2;
		c.gridy = 2;
		c.anchor = GridBagConstraints.CENTER;
		createPanel.add(createAddress, c);

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 2;
		c.anchor = GridBagConstraints.CENTER;
		createSupplierPanel.add(createPanel, c);

		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LAST_LINE_START;
		createSupplierPanel.add(exitCreatePanelButton, c);

		c.gridx = 2;
		c.gridy = 2;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.anchor = GridBagConstraints.LAST_LINE_END;
		createSupplierPanel.add(createSupplierButton, c);
	}

	public void deletePanel() {

	}

	public void refreshSupplier(Object data[][]) {

		tablePanel.remove(viewScroll);
		viewSupplierTabel = new JTable(data, supplierNames);
		viewScroll = new JScrollPane(viewSupplierTabel);

		tablePanel.add(viewScroll, BorderLayout.CENTER);
		tablePanel.validate();
		tablePanel.repaint();

	}

	public void refreshProducts(Object data[][]) {

		tablePanel.remove(viewScroll);
		viewSupplierTabel = new JTable(data, productNames);
		viewScroll = new JScrollPane(viewSupplierTabel);

		tablePanel.add(viewScroll, BorderLayout.CENTER);
		tablePanel.validate();
		tablePanel.repaint();

	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public Object[][] getSupplierData() {
		return supplierData;
	}

	public void setSupplierData(Object[][] supplierData) {
		this.supplierData = supplierData;
	}

	public Object[][] getProductData() {
		return productData;
	}

	public void setProductData(Object[][] productData) {
		this.productData = productData;
	}

	public JButton getSupplierButton() {
		return supplierButton;
	}

	public void setSupplierButton(JButton supplierButton) {
		this.supplierButton = supplierButton;
	}

	public JButton getProductButton() {
		return productButton;
	}

	public void setProductButton(JButton productButton) {
		this.productButton = productButton;
	}

	public JButton getNext() {
		return next;
	}

	public void setNext(JButton next) {
		this.next = next;
	}

	public JTextField getSupplierText() {
		return supplierText;
	}

	public void setSupplierText(JTextField supplierText) {
		this.supplierText = supplierText;
	}

	public JButton getPrevious() {
		return previous;
	}

	public void setPrevious(JButton previous) {
		this.previous = previous;
	}

	public boolean isSupplier() {
		return supplier;
	}

	public void setSupplier(boolean supplier) {
		this.supplier = supplier;
	}

	public JButton getSearch() {
		return search;
	}

	public void setSearch(JButton search) {
		this.search = search;
	}

	public JTextField getSearchText() {
		return searchText;
	}

	public void setSearchText(JTextField searchText) {
		this.searchText = searchText;
	}

	public JTable getViewSupplierTabel() {
		return viewSupplierTabel;
	}

	public void setViewSupplierTabel(JTable viewSupplierTabel) {
		this.viewSupplierTabel = viewSupplierTabel;
	}

	public JPopupMenu getViewProductsPopup() {
		return viewProductsPopup;
	}

	public void setViewProductsPopup(JPopupMenu viewProductsPopup) {
		this.viewProductsPopup = viewProductsPopup;
	}

	public JMenuItem getViewProducts() {
		return viewProducts;
	}

	public void setViewProducts(JMenuItem viewProducts) {
		this.viewProducts = viewProducts;
	}

	public JMenuItem getEditSupplier() {
		return editSupplier;
	}

	public void setEditSupplier(JMenuItem editSupplier) {
		this.editSupplier = editSupplier;
	}

	public void showAddProductPanel() {
		BorderLayout layout = (BorderLayout) tablePanel.getLayout();
		tablePanel.remove(layout.getLayoutComponent(BorderLayout.WEST));
		tablePanel.add(addProductsPanel, BorderLayout.WEST);
		tablePanel.validate();
		tablePanel.repaint();

	}

	public void removeAddProductsPanel() {

		tablePanel.remove(addProductsPanel);
		tablePanel.add(new JPanel(), BorderLayout.WEST);
		tablePanel.validate();
		tablePanel.repaint();
	}

	public void showEditPanel() {
		BorderLayout layout = (BorderLayout) tablePanel.getLayout();
		tablePanel.remove(layout.getLayoutComponent(BorderLayout.WEST));
		tablePanel.add(editSupplierPanel, BorderLayout.WEST);
		tablePanel.validate();
		tablePanel.repaint();
	}

	public void removeEditPanel() {

		tablePanel.remove(editSupplierPanel);
		tablePanel.add(new JPanel(), BorderLayout.WEST);
		tablePanel.validate();
		tablePanel.repaint();
	}

	public void showCreateSupplierPanel() {
		BorderLayout layout = (BorderLayout) tablePanel.getLayout();
		tablePanel.remove(layout.getLayoutComponent(BorderLayout.WEST));
		tablePanel.add(createSupplierPanel, BorderLayout.WEST);
		tablePanel.validate();
		tablePanel.repaint();
	}

	public void removeCreateSupplierPanel() {
		tablePanel.remove(createSupplierPanel);
		tablePanel.add(new JPanel(), BorderLayout.WEST);
		tablePanel.validate();
		tablePanel.repaint();
	}

	public JMenuItem getAddProducts() {
		return addProducts;
	}

	public void setAddProducts(JMenuItem addProducts) {
		this.addProducts = addProducts;
	}

	public JButton getExitProductPanel() {
		return exitProductPanel;
	}

	public JButton getEdit() {
		return edit;
	}

	public JButton getCreate() {
		return create;
	}

	public JButton getAdd() {
		return add;
	}

	public JButton getDelete() {
		return delete;
	}

	public JMenuItem getEditSupplierFromProducts() {
		return editSupplierFromProducts;
	}

	public JMenuItem getAddProductFromProducts() {
		return addProductFromProducts;
	}

	public JTextField getSupplierPrice() {
		return supplierPrice;
	}

	public JTextField getSupplierPhone() {
		return supplierPhone;
	}

	public JTextField getSupplierAddress() {
		return supplierAddress;
	}

	public JTextField getSupplierName() {
		return supplierName;
	}

	public JButton getExitEditPanel() {
		return exitEditPanel;
	}

	public JButton getEditSupName() {
		return editSupName;
	}

	public JButton getEditSupPhone() {
		return editSupPhone;
	}

	public JButton getEditSupAddress() {
		return editSupAddress;
	}

	public JTextField getProductName() {
		return productName;
	}

	public JButton getCreateSupplierButton() {
		return createSupplierButton;
	}

	public JTextField getCreateName() {
		return createName;
	}

	public JTextField getCreatePhone() {
		return createPhone;
	}

	public JTextField getCreateAddress() {
		return createAddress;
	}

	public JButton getAddProduct() {
		return addProduct;
	}

	public JPanel getDeletePanel() {
		return deletePanel;
	}

	public JFrame getDeleteFrame() {
		return deleteFrame;
	}

	public JButton getYes() {
		return yes;
	}

	public JButton getNo() {
		return no;
	}

	public JLabel getWarning() {
		return warning;
	}

	public JMenuItem getDeleteSupplier() {
		return deleteSupplier;
	}

	public JButton getExitCreatePanelButton() {
		return exitCreatePanelButton;
	}

	public void setAdminLogged(boolean admin) {
		adminLogged = admin;
		System.out.println(adminLogged);

		editSupplier.setEnabled(admin);
		addProducts.setEnabled(admin);
		deleteSupplier.setEnabled(admin);
		editSupplierFromProducts.setEnabled(admin);
		addProductFromProducts.setEnabled(admin);

		if (adminLogged == true) {
			add.setEnabled(false);
			delete.setEnabled(true);
			edit.setEnabled(true);
			create.setEnabled(true);
		} else {
			add.setEnabled(false);
			delete.setEnabled(false);
			edit.setEnabled(false);
			create.setEnabled(false);

		}
	}

}