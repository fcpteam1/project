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
import model.Order;
import model.Product;
import model.Supplier;

public class OrderFormPanel extends JPanel {

	private JLabel supplierLabel;
	private JComboBox supplierCombo;
	private JButton selectButton;
	private JButton orderButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton processButton;
	private OrderFormListener formListener;
	private ArrayList<Order> orders;
	private ArrayList<Supplier> suppliers;
	private ArrayList<Product> products;
	Supplier thisSupplier;
	private ArrayList<Product> orderProducts = new ArrayList<Product>();
	private OrderTablePanel orderTablePanel = new OrderTablePanel();
	private Model model;
	int size;
	JLabel[] names;
	JLabel[] prices;
	JTextField[] fields;
	
	public OrderFormPanel() {
		
	}
	
	public void setData(ArrayList<Order> orders, ArrayList<Supplier> suppliers) {
		this.orders = orders;
		this.suppliers = suppliers;
	}
	
	public void viewFormPanel(){
		this.removeAll();
		setVisible(false);
	}
	
	public void createFormPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Create Order");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		supplierLabel = new JLabel("Supplier: ");
		supplierCombo = new JComboBox();
		selectButton = new JButton("Select");
		
		//Set up combo box
		DefaultComboBoxModel supplierModel = new DefaultComboBoxModel();
		
		for(Supplier supplier: suppliers){
			supplierModel.addElement(supplier);
		}
		
		
		supplierCombo.setModel(supplierModel);
		supplierCombo.setSelectedIndex(0);
		supplierCombo.setEditable(false);
		

		selectButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Supplier thisSupplier = (Supplier)supplierCombo.getSelectedItem();
				OrderFormEvent ev = new OrderFormEvent(e, thisSupplier);
				addProductSelect(ev);
			}			
		});
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		//First Row
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0,0,0,5);
		add(supplierLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(supplierCombo, gc);
		
		//Next Row
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(selectButton, gc);
		setVisible(true);
	}
	
	public void addProductSelect(OrderFormEvent ev){
		this.removeAll();
		thisSupplier = ev.getSupplier();
		products = thisSupplier.getProducts();
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Select Products");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		orderButton = new JButton("Place Order");
		
		
		size = products.size();
		names = new JLabel[size];
		prices = new JLabel[size];
		fields = new JTextField[size];
		
		//Dynamically create labels and text fields for products
		for(int i=0; i<size; i++){
			names[i] = new JLabel(products.get(i).getName());
			prices[i] = new JLabel(": \u20ac" + Double.toString(products.get(i).getSupplierPrice()*100.00/100.00) + " each");
			fields[i] = new JTextField(3);
			gc.gridy = i;
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			gc.gridx = 0;
			gc.fill = GridBagConstraints.NONE;
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0,0,0,5);
			add(names[i], gc);

			gc.gridx = 1;
			gc.insets = new Insets(0,0,0,0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(prices[i], gc);
			
			gc.gridx = 2;
			gc.insets = new Insets(0,0,0,0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(fields[i], gc);
		}
		
		orderButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				orderProducts.clear();
				ArrayList<Integer> quantities = new ArrayList<Integer>();
				ArrayList<String> productNames = new ArrayList<String>();
				//Get ordered products and associated quantities
				for(int i=0; i<size; i++){
					if(!fields[i].getText().equals("")){
						try{
							quantities.add(Integer.valueOf(fields[i].getText()));
							productNames.add(names[i].getText());
						}catch(NumberFormatException nfEx){
							System.out.println("Not an integer");
						}
					}
				}
				//Loop through ordered product names and link to actual product
				int i = 0;
				for(String name: productNames){
					for(Product product: products){
						if(product.getName().equals(name)){
							product.setQuantity(quantities.get(i));
							orderProducts.add(product);
						}
					}
					i++;
				}
				OrderFormEvent orderEvent = new OrderFormEvent(this, thisSupplier, orderProducts);
				if(formListener != null){
					formListener.createOrderOccurred(orderEvent);
				}
				setVisible(false);
			}
		});
		
		//Order Button
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;
		
		gc.gridx = 1;
		gc.insets = new Insets(0,0,0,0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(orderButton, gc);
		this.validate();
		this.repaint();
	}
	
	public void editFormPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Edit Order");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setVisible(true);

		editButton = new JButton("Edit Order");
	}
	
	public void deleteFormPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Cancel Order");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setVisible(true);
		editButton = new JButton("Delete Order");
	}	
	
	public void processFormPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Process Order");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setVisible(true);
		editButton = new JButton("Process Order");
	}
	
	public void setFormListener(OrderFormListener formListener) {
		this.formListener = formListener;
	}
}

/*
//Next Row
gc.gridy++;
gc.weightx = 1;
gc.weighty = 0.2;

gc.gridx = 0;
gc.anchor = GridBagConstraints.FIRST_LINE_END;
gc.insets = new Insets(0,0,0,5);
add(new JLabel("Age: "), gc);

gc.gridx = 1;
gc.insets = new Insets(0,0,0,0);
gc.anchor = GridBagConstraints.FIRST_LINE_START;
//add(ageList, gc);

//Next Row
gc.gridy++;
gc.weightx = 1;
gc.weighty = 0.2;

gc.gridx = 0;
gc.anchor = GridBagConstraints.FIRST_LINE_END;
gc.insets = new Insets(0,0,0,5);
add(new JLabel("Employment: "), gc);

gc.gridx = 1;
gc.insets = new Insets(0,0,0,0);
gc.anchor = GridBagConstraints.FIRST_LINE_START;
//add(empCombo, gc);

//Next Row
gc.gridy++;
gc.weightx = 1;
gc.weighty = 0.2;

gc.gridx = 0;
gc.anchor = GridBagConstraints.FIRST_LINE_END;
gc.insets = new Insets(0,0,0,5);
add(new JLabel("US Citizen: "), gc);

gc.gridx = 1;
gc.insets = new Insets(0,0,0,0);
gc.anchor = GridBagConstraints.FIRST_LINE_START;
//add(citizenCheck, gc);

//Next Row
gc.gridy++;
gc.weightx = 1;
gc.weighty = 0.2;

gc.gridx = 0;
gc.anchor = GridBagConstraints.FIRST_LINE_END;
gc.insets = new Insets(0,0,0,5);
//add(taxLabel, gc);

gc.gridx = 1;
gc.insets = new Insets(0,0,0,0);
gc.anchor = GridBagConstraints.FIRST_LINE_START;
//add(taxField, gc);

//Next Row
gc.gridy++;
gc.weightx = 1;
gc.weighty = 2;

gc.gridx = 1;
gc.insets = new Insets(0,0,0,0);
gc.anchor = GridBagConstraints.FIRST_LINE_START;
//add(submitButton, gc);	
 * 
 */
