package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

	private JPanel showPanel,buttonsPanel,tablePanel,borderPanel,nextPrevPanel,supplierTextPanel,holder;
	private JTable viewSupplierTabel;
	private JScrollPane viewScroll;
	Object supplierData[][],productData[][];
	String supplierNames[],productNames[];
	
	private JButton search,next,previous,supplierButton,productButton;
	private JTextField searchText,supplierText;
	boolean supplier;
	int current=0;
	public SupplierGUI() {
		// TODO Auto-generated constructor stub
		
		supplierNames=new String[]{"Name","Id","Phone","Address"};
		productNames=new String[]{"Name","Id","Supplier Price"};
		
		showPanel=new JPanel();
		showPanel.setLayout(new GridBagLayout());
		
		borderPanel=new JPanel();
		borderPanel.setLayout(new BorderLayout());
		
		buttonsPanel=new JPanel();
		buttonsPanel.setLayout(new GridBagLayout());
		
		tablePanel=new JPanel();
		tablePanel.setLayout(new BorderLayout());
		
		nextPrevPanel=new JPanel();
		nextPrevPanel.setLayout(new FlowLayout());
		
		holder=new JPanel();
		holder.setLayout(new GridBagLayout());
		
		search=new JButton("Search");
		next=new JButton(">>");
		previous=new JButton("<<");
		supplierButton=new JButton("View Suppliers");
		productButton=new JButton("View Products");
		searchText=new JTextField(15);
		
		supplierTextPanel=new JPanel();
		supplierTextPanel.setLayout(new FlowLayout());
		supplierText=new JTextField(25);
		supplierTextPanel.add(supplierText);
		
		
		GridBagConstraints c=new GridBagConstraints();
		
		c.gridx=0;
		c.gridy=0;
		c.weightx=1;
		c.weighty=1;
		c.anchor=GridBagConstraints.CENTER;
		buttonsPanel.add(supplierButton,c);
		
		c.gridx=2;
		c.gridy=0;
		c.weightx=1;
		c.weighty=1;
		c.anchor=GridBagConstraints.CENTER;
		buttonsPanel.add(productButton,c);
		
		c.gridx=0;
		c.gridy=2;
		c.weightx=1;
		c.weighty=1;
		c.anchor=GridBagConstraints.CENTER;
		buttonsPanel.add(searchText,c);
		
		
		c.gridx=1;
		c.gridy=2;
		c.weightx=1;
		c.weighty=1;
		c.anchor=GridBagConstraints.CENTER;
		buttonsPanel.add(search,c);
		
		nextPrevPanel.add(previous);
		nextPrevPanel.add(next);
		
		c.gridx=2;
		c.gridy=2;
		c.weightx=1;
		c.weighty=1;
		c.anchor=GridBagConstraints.CENTER;
		buttonsPanel.add(nextPrevPanel,c);
		
		supplierData=new Object[1][4];
		supplierData[0][0]="null";
		supplierData[0][1]="null";
		supplierData[0][2]="null";
		supplierData[0][3]="null";
		
		viewSupplierTabel=new JTable(supplierData,supplierNames);
		viewScroll=new JScrollPane(viewSupplierTabel);
		c.gridx=0;
		c.gridy=0;
		c.gridheight=3;
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=1;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		tablePanel.add(viewScroll,BorderLayout.CENTER);
		
		c.gridx=1;
		c.gridy=2;
		c.gridheight=1;
		c.gridwidth=1;
		c.anchor=GridBagConstraints.PAGE_END;
		supplierTextPanel.add(supplierText,c);
		
		
		c.gridx=0;
		c.gridy=0;
		c.weighty=0.2;
		c.weightx=1;
		c.gridwidth=3;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.fill=GridBagConstraints.BOTH;
		c.gridwidth=3;
		showPanel.add(buttonsPanel,c);
		
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=0.8;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		showPanel.add(tablePanel,c);
		
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=0.1;
		c.anchor=GridBagConstraints.PAGE_END;
		showPanel.add(supplierTextPanel,c);
		
		search.setEnabled(false);
		next.setEnabled(false);
		previous.setEnabled(false);
		
	}
	
	
	public JPanel getMain(){
		
		
		return showPanel;
	}

	public void backToMainPanel(){
		
		
		
	}
	
	public void focusViewSuppliers(){
	showPanel.removeAll();
		
		GridBagConstraints c=new GridBagConstraints();
		
		
		
		tablePanel.removeAll();
		viewSupplierTabel=new JTable(supplierData,supplierNames);
		viewScroll=new JScrollPane(viewSupplierTabel);
		c.gridx=0;
		c.gridy=0;
		c.gridheight=3;
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=1;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		tablePanel.add(viewScroll,BorderLayout.CENTER);
		tablePanel.validate();
		tablePanel.repaint();
		
		
		c.gridheight=1;
		c.gridx=0;
		c.gridy=0;
		c.weighty=0.2;
		c.weightx=1;
		c.gridwidth=3;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.fill=GridBagConstraints.BOTH;
		c.gridwidth=3;
		showPanel.add(buttonsPanel,c);
		
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=0.8;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		showPanel.add(tablePanel,c);
		
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=0.1;
		c.anchor=GridBagConstraints.PAGE_END;
		showPanel.add(supplierTextPanel,c);
		
		showPanel.revalidate();
		showPanel.repaint();
		
		supplier=true;
		
	}
	
	
	public void focusViewProducts(){
		
		showPanel.removeAll();
		
		GridBagConstraints c=new GridBagConstraints();
		
		
		
		tablePanel.removeAll();
		viewSupplierTabel=new JTable(productData,productNames);
		viewScroll=new JScrollPane(viewSupplierTabel);
		c.gridx=0;
		c.gridy=0;
		c.gridheight=3;
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=1;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		tablePanel.add(viewScroll,BorderLayout.CENTER);
		tablePanel.validate();
		tablePanel.repaint();
		
		
		c.gridheight=1;
		c.gridx=0;
		c.gridy=0;
		c.weighty=0.2;
		c.weightx=1;
		c.gridwidth=3;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		c.fill=GridBagConstraints.BOTH;
		c.gridwidth=3;
		showPanel.add(buttonsPanel,c);
		
		c.gridx=0;
		c.gridy=1;
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=0.8;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		showPanel.add(tablePanel,c);
		
		c.gridx=0;
		c.gridy=2;
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=0.1;
		c.anchor=GridBagConstraints.PAGE_END;
		showPanel.add(supplierTextPanel,c);
		
		showPanel.validate();
		showPanel.repaint();
		
		supplier=false;
		
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
	
	
}
