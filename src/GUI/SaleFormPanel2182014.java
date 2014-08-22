package GUI;
import model.Shop;
import model.Stock;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;


public class SaleFormPanel2182014 extends JPanel {
	
	private JLabel customerLabel;
	private JTextField customerField;
	private JButton enterBut;
	private SaleFormListener formListener;
	private JLabel productLabel;
	private JList productList;
	private JComboBox productBox;
	private String[] items;
	

	SaleFormPanel2182014() throws IOException {
		Dimension dim = getPreferredSize();
		dim.width = 450;
		setPreferredSize(dim);
		
		customerLabel = new JLabel("Customer ID");
		customerField = new JTextField(10);
		productLabel = new JLabel("Choose Products");
		productList = new JList();
		//productBox = new JComboBox();
		
		Shop shop = new Shop();
		
		//Set up ListBox
		DefaultListModel stockModel = new DefaultListModel();
		/*
		stockModel.addElement("orange");
		stockModel.addElement("apple");
		productList.setModel(stockModel);
		*/
		productList.setPreferredSize(new Dimension(110, 66));
		productList.setBorder(BorderFactory.createEtchedBorder());
		
		for (Stock s: shop.getStock()){
			stockModel.addElement(s);
			System.out.println(s.getName() + " " + s.getSupplierPrice());
		}
		
		productList.setModel(stockModel);
		
		/*
		//set up comboBox element with Model
		DefaultComboBoxModel stock2Model = new DefaultComboBoxModel();
        
		for (Stock s: shop.getStocks()){
			stockModel.addElement(s);
			//System.out.println(s.getName());
		}
		productBox.setModel(stock2Model);*/
		
		
        /*items=new String[shop.getStocks().size()];
                
                 for (int i=0; i < shop.getStocks().size(); i++) {
                		 items[i] = shop.getStocks().get(i).getName(); // + "   " + shop.getStocks().get(i).getCustomerPrice()
                 }
                 
                 
        productBox = new JComboBox(items);*/
		
		enterBut = new JButton("Enter");
		
		enterBut.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				
				//String product = (String)productBox.getSelectedItem();
				Stock stockItem = (Stock)productList.getSelectedValue();
				int customerId = Integer.parseInt(customerField.getText());
				
				//System.out.println(product);
				System.out.println(stockItem.getName()  + ": print from stockList");
				SaleFormEvent ev = new SaleFormEvent(this, customerId, stockItem );	
				
				if (formListener != null){
					formListener.formEventOccurred(ev);
				}
			}
		});
		
	 
		Border innerBorder =(BorderFactory.createTitledBorder("Select Product and Amount"));
		Border outerBorder = (BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor =GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5); 
		add(customerLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor =GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(customerField, gc);
		
		gc.gridx = 2;
		gc.gridy =0;
		//gc.anchor = GridBagConstraints.FIRST_LINE_START; 
		add(enterBut,gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		add(productLabel, gc);
		
		/*gc.gridx = 1;
		gc.gridy = 1;
		add(productBox, gc);*/
		
		gc.gridx = 2;
		gc.gridy = 1;
		add(productList, gc);
		
	}
	
	public void setFormListener(SaleFormListener listener) {
		this.formListener = listener;
	}

	
}

