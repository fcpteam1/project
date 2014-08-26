
package GUI;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

import model.Customer;
import model.Stock;


public class SaleFormPanel extends JPanel {
	
	private JLabel customerLabel;
	private JComboBox customerBox;
	private JButton enterButton;
	private JButton saleButton;
	private SaleMainPanel mainPanel;
	private SaleFormListener formListener;
	private ArrayList<Stock> stocks;
	private ArrayList<Customer> customers;
	private ArrayList<Stock> saleStockList = new ArrayList<Stock>();
	Customer thisCustomer;
	int size;
	JLabel[] stockName;
	JLabel[] customerPrice;
	JTextField[] quantityField;

	public SaleFormPanel() throws IOException {
		
	}
	public void setData(ArrayList<Stock> stocks, ArrayList<Customer> customers) {
		this.stocks = stocks;
		this.customers = customers;
	}
	
	public void createCustomerPanel() throws IOException { 
		
		Dimension dim = getPreferredSize();
		dim.width = 450;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Process Sale");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		customerLabel = new JLabel("Customer: ");
		customerBox = new JComboBox();
		enterButton = new JButton("Select");

		//Set up ComboBoxModel
		DefaultComboBoxModel customerModel = new DefaultComboBoxModel();
		
		
		for (Customer c: customers){
			customerModel.addElement(c);
		}
		
		customerBox.setModel(customerModel);
		customerBox.setEditable(false);
		
		enterButton.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent event) {
				
				Customer thisCustomer = (Customer)customerBox.getSelectedItem();
				
				SaleFormEvent ev = new SaleFormEvent(this, thisCustomer);	
				
				try {
					createSaleSelectionPanel(ev);
				} catch (IOException e) {
					
					e.printStackTrace();
				}
				
			}
		});
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor =GridBagConstraints.LINE_END;//controls which side of cell label is placed
		gc.insets = new Insets(0,0,0,5); 
		add(customerLabel,gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor =GridBagConstraints.LINE_START;
		gc.insets = new Insets(0,0,0,0);
		add(customerBox, gc);
		
		gc.gridx = 1;
		gc.gridy =1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START; 
		add(enterButton,gc);
		setVisible(true);
	}

	public void createSaleSelectionPanel(SaleFormEvent e)throws IOException {
		
		this.removeAll();
		thisCustomer = e.getCustomer();
		
		Dimension dim = getPreferredSize();
		dim.width = 450;
		setPreferredSize(dim);
		Border innerBorder =(BorderFactory.createTitledBorder("Select Product and Amount"));
		Border outerBorder = (BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		saleButton = new JButton("Process Sale");
		
		size = stocks.size();
		stockName = new JLabel[size];
		customerPrice = new JLabel[size];
		quantityField = new JTextField[size];
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		
		
		for(int i=0; i < size; i++) {
			stockName[i] = new JLabel(stocks.get(i).getName());
			customerPrice[i] = new JLabel(": " + "\u20ac"  + Double.toString(stocks.get(i).getCustomerPrice()));
			quantityField[i] = new JTextField(3);
			
			gc.gridy = i;
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			gc.gridx = 0;
			gc.fill = GridBagConstraints.NONE;
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0,0,0,5);
			add(stockName[i], gc);

			gc.gridx = 1;
			gc.insets = new Insets(0,0,0,0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(customerPrice[i], gc);
			
			gc.gridx = 2;
			gc.insets = new Insets(0,0,0,0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(quantityField[i], gc);
		}
		
		saleButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> quantities = new ArrayList<Integer>();
				ArrayList<String> stockNames = new ArrayList<String>();
				//Get ordered stock and associated quantities
				for(int i=0; i<size; i++){
					if(!quantityField[i].getText().equals("")){
						try{
							quantities.add(Integer.valueOf(quantityField[i].getText()));
							stockNames.add(stockName[i].getText());
						}catch(NumberFormatException nfEx){
							System.out.println("Not an integer");
						}
					}
				}
				//clear stock list from previous runs
				saleStockList.clear();
				//Loop through ordered stock names and link to actual product
				int i = 0;
				for(String name: stockNames){
					for(Stock  s: stocks){
						if(s.getName().equals(name)){
							s.setQuantity(quantities.get(i));
							saleStockList.add(s);
						}
					}
					i++;
				}
				SaleFormEvent saleEvent = new SaleFormEvent(this, thisCustomer, saleStockList);
				if(formListener != null){
					formListener.createSaleOccurred(saleEvent);
				}
				setVisible(false);
			}
			
		});
			gc.gridy++;
			gc.gridx = 1;
			add(saleButton, gc);
			this.validate();
			this.repaint();
		
	}
	
	public void setFormListener(SaleFormListener listener) {
		this.formListener = listener;
	}
	public JButton getEnterButton() {
		return enterButton;
	}
	
	public JButton getSaleButton() {
		return saleButton;
	}
	
	
	
}


