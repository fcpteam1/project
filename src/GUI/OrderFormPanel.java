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

import model.Order;
import model.Product;
import model.Supplier;

public class OrderFormPanel extends JPanel {

	private JLabel supplierLabel;
	private JComboBox supplierCombo;
	private JButton selectButton;
	private JButton orderButton;
	private OrderFormListener formListener;
	private ArrayList<Order> orders;
	private ArrayList<Supplier> suppliers;
	private ArrayList<Product> products;
	
	public OrderFormPanel() {

		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
	
	/*
		
		submitButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String occupation = occupationField.getText();
				AgeCategory age = (AgeCategory)ageList.getSelectedValue();
				String empCat = (String)empCombo.getSelectedItem();
				String taxID = taxField.getText();
				boolean usCitizen = citizenCheck.isSelected();
				System.out.println(empCat);
				
				FormEvent ev = new FormEvent(this, name, occupation, age.getID(), empCat, taxID, usCitizen);
				
				if(formListener!=null){
					formListener.formEventOccurred(ev);
				}
			}
		});
		*/
		
		
	}
	
	public void setData(ArrayList<Order> orders, ArrayList<Supplier> suppliers) {
		this.orders = orders;
		this.suppliers = suppliers;
	}
	
	public void viewFormPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("View Orders");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
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
			supplierModel.addElement(supplier.getName());
		}
		
		
		supplierCombo.setModel(supplierModel);
		supplierCombo.setSelectedIndex(0);
		supplierCombo.setEditable(false);
		

		selectButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				Supplier thisSupplier = new Supplier();
				String name = (String) supplierCombo.getSelectedItem();
				for(Supplier supplier: suppliers){
					if(supplier.getName().equals(name)){
						thisSupplier = supplier;
						break;
					}
				}
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

	}
	
	public void addProductSelect(OrderFormEvent ev){
		this.removeAll();
		Supplier thisSupplier = ev.getSupplier();
		products = thisSupplier.getProducts();
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Select Products");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		JLabel[] labels = new JLabel[products.size()];
		
		for(int i=0; i<labels.length; i++){
			labels[i] = new JLabel(products.get(i).getName());
			
			gc.gridy = i;
			gc.weightx = 1;
			gc.weighty = 0.1;
			
			gc.gridx = 0;
			gc.fill = GridBagConstraints.NONE;
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0,0,0,5);
			add(labels[i], gc);

			gc.gridx = 1;
			gc.insets = new Insets(0,0,0,0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(new JTextField(3), gc);
		}
		
		
		//Last Row
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
	}
	
	public void deleteFormPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Cancel Order");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
	}	
	
	public void processFormPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Process Deliveryt");
		Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
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
