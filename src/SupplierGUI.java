import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;


public class SupplierGUI  {

	private JPanel showPanel;
	
	private JPanel tabelPanel,buttonsPanel,borderPanel,nextPrevPanel;
	
	private JButton viewSuppliers,viewSupplierProducts,searchSupplier,nextSupplier,previousSupplier;
	private JTextField supplierTextField;
	
	private JTable supplierTable,productTable;
	private JScrollPane viewSupplierScroll,viewProductScroll;
	String[] columnNames;

	String[] productColumNames;
	Object[][] viewSupplierData,viewProductData;
	
	int currentSupplier=0;
	
	public SupplierGUI() {
		// TODO Auto-generated constructor stub
		showPanel=new JPanel();
		
		borderPanel=new JPanel();
		borderPanel.setLayout(new BorderLayout());
	
		tabelPanel=new JPanel();
		tabelPanel.setLayout(new GridBagLayout());
		
		buttonsPanel=new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());
		
		nextPrevPanel=new JPanel();
		nextPrevPanel.setLayout(new FlowLayout());
		
		viewSuppliers=new JButton("View Supplier");
		viewSupplierProducts=new JButton("View Products");
		searchSupplier=new JButton("Search");
		nextSupplier=new JButton(">>");
		previousSupplier=new JButton("<<");
		
		supplierTextField=new JTextField(15);
		
		GridBagConstraints c=new GridBagConstraints();
		
		c.gridx=0;
		c.gridy=0;
		c.weightx=1;
		c.weighty=1;
		c.fill=GridBagConstraints.NONE;
		buttonsPanel.add(viewSuppliers,c);
		
		
		
		c.gridx=2;
		c.gridy=0;
		c.weightx=1;
		c.weighty=1;
		c.fill=GridBagConstraints.NONE;
		buttonsPanel.add(viewSupplierProducts,c);
		
		c.gridx=0;
		c.gridy=2;
		c.weightx=1;
		c.weighty=1;
		c.fill=GridBagConstraints.NONE;
		buttonsPanel.add(supplierTextField,c);
		
		c.gridx=1;
		c.gridy=2;
		c.weightx=1;
		c.weighty=1;
		c.fill=GridBagConstraints.NONE;
		buttonsPanel.add(searchSupplier,c);
		
		nextPrevPanel.add(previousSupplier);
		nextPrevPanel.add(nextSupplier);
		c.gridx=2;
		c.gridy=2;
		c.weightx=0.33;
		c.weighty=1;
		
		c.fill=GridBagConstraints.NONE;
		buttonsPanel.add(nextPrevPanel,c);
		
		
		borderPanel.add(buttonsPanel,BorderLayout.NORTH);
		borderPanel.add(tabelPanel,BorderLayout.CENTER);
		
		columnNames=new String[]{"Supplier","id","Phone","Address"};
		productColumNames=new String[]{"Product","id","Price"};
		
		
		
		
		showPanel.add(borderPanel);
	}
	
	
	public JPanel getPanel(){
		
		
		return showPanel;
	}

	public void backToMainPanel(){
		
		
		
	}
	
	public void focusViewSuppliers(){
		supplierTable=new JTable(viewSupplierData,columnNames);
		viewSupplierScroll=new JScrollPane(supplierTable);
		
		tabelPanel.removeAll();
		tabelPanel.add(viewSupplierScroll);
		tabelPanel.validate();
		tabelPanel.repaint();
		
		borderPanel.removeAll();
		borderPanel.add(buttonsPanel,BorderLayout.NORTH);
		borderPanel.add(tabelPanel,BorderLayout.CENTER);
		borderPanel.validate();
		borderPanel.repaint();
	}
	
	
	public void focusViewProducts(){
		productTable=new JTable(viewProductData,productColumNames);
		
		viewProductScroll=new JScrollPane(productTable);
		tabelPanel.removeAll();
		tabelPanel.add(viewProductScroll);
		tabelPanel.validate();
		tabelPanel.repaint();
		
		borderPanel.removeAll();
		borderPanel.add(buttonsPanel,BorderLayout.NORTH);
		borderPanel.add(tabelPanel,BorderLayout.CENTER);
		borderPanel.validate();
		borderPanel.repaint();
		
	}


	public JButton getSearchSupplier() {
		return searchSupplier;
	}


	public void setSearchSupplier(JButton searchSupplier) {
		this.searchSupplier = searchSupplier;
	}


	public JButton getNextSupplier() {
		return nextSupplier;
	}


	public void setNextSupplier(JButton nextSupplier) {
		this.nextSupplier = nextSupplier;
	}


	public JButton getPreviousSupplier() {
		return previousSupplier;
	}


	public void setPreviousSupplier(JButton previousSupplier) {
		this.previousSupplier = previousSupplier;
	}


	public Object[][] getViewSupplierData() {
		return viewSupplierData;
	}


	public void setViewSupplierData(Object[][] viewSupplierData) {
		this.viewSupplierData = viewSupplierData;
	}


	public Object[][] getViewProductData() {
		return viewProductData;
	}


	public void setViewProductData(Object[][] viewProductData) {
		this.viewProductData = viewProductData;
	}


	public int getCurrentSupplier() {
		return currentSupplier;
	}


	public void setCurrentSupplier(int currentSupplier) {
		this.currentSupplier = currentSupplier;
	}


	public JButton getViewSuppliers() {
		return viewSuppliers;
	}


	public void setViewSuppliers(JButton viewSuppliers) {
		this.viewSuppliers = viewSuppliers;
	}


	public JButton getViewSupplierProducts() {
		return viewSupplierProducts;
	}


	public void setViewSupplierProducts(JButton viewSupplierProducts) {
		this.viewSupplierProducts = viewSupplierProducts;
	}
	
	
	
}
