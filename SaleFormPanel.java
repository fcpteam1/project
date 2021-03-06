package GUI;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Customer;
import model.Model;
import model.Product;
import model.Sale;
import model.Stock;

public class SaleFormPanel extends JPanel {

	private JLabel customerLabel, maxLabel;
	private JPanel errorPanel = new JPanel();
	private JComboBox customerBox;
	private JButton enterButton;
	private JButton saleButton;
	private JButton editButton;
	private SaleMainPanel mainPanel;
	private SaleFormListener formListener;
	private ArrayList<Product> totalProducts;
	private ArrayList<Customer> customers;
	private ArrayList<Stock> stocks;
	private String stockFile;
	
	private ArrayList<Stock> availableStock;
	private SaleFormEvent event;
	Customer thisCustomer;
	int size;
	JLabel[] stockName, customerPrice, maxAvailable;
	JTextField[] quantityField;
	private Model model;

	public SaleFormPanel() throws IOException {

	}

	public void setData(ArrayList<Stock> stocks, ArrayList<Customer> customers,
			String stockFile) {

		this.customers = customers;
		this.stockFile = stockFile;
		this.availableStock = stocks;
	}


	public void createCustomerPanel() throws IOException {

		Dimension dim = getPreferredSize();
		dim.width = 450;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Process Sale");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		customerLabel = new JLabel("Customer: ");
		customerBox = new JComboBox();
		enterButton = new JButton("Select");

		// Set up ComboBoxModel
		DefaultComboBoxModel customerModel = new DefaultComboBoxModel();

		for (Customer c : customers) {
			customerModel.addElement(c);
		}

		customerBox.setModel(customerModel);
		customerBox.setEditable(false);

		enterButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent event) {

				Customer thisCustomer = (Customer) customerBox
						.getSelectedItem();

				SaleFormEvent ev = new SaleFormEvent(this, thisCustomer);
				setEvent(ev);
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
		gc.anchor = GridBagConstraints.LINE_END;// controls which side of cell
												// label is placed
		gc.insets = new Insets(0, 0, 0, 5);
		add(customerLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(customerBox, gc);

		gc.gridx = 1;
		gc.gridy = 1;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(enterButton, gc);
		setVisible(true);
	}

	public void createSaleSelectionPanel(SaleFormEvent ev) throws IOException {

		this.removeAll();
		
		thisCustomer = ev.getCustomer();

		Dimension dim = getPreferredSize();
		dim.width = 450;
		setPreferredSize(dim);
		Border innerBorder = (BorderFactory
				.createTitledBorder("Select Product and Amount"));
		Border outerBorder = (BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		saleButton = new JButton("Process Sale");
		// availableStock is created by checkLevel() giving total quantity of each product
		// used to populate the panel JLabels
		size = availableStock.size();
		maxLabel = new JLabel("Quantity in Stock");
		stockName = new JLabel[size];
		customerPrice = new JLabel[size];
		maxAvailable = new JLabel[size];
		quantityField = new JTextField[size];

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		gc.gridy = 0;
		gc.gridx = 2;
		gc.weightx = 1;
		gc.weighty = 0.1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(maxLabel, gc);
		// i set to 1, to fill 2nd row, therefore arrays have i-1, so they start
		// at zero
			for (int i = 1; i < (size + 1); i++) {
				stockName[i - 1] = new JLabel(availableStock.get(i - 1).getName());
				customerPrice[i - 1] = new JLabel(": "
						+ "\u20ac"
						+ Double.toString(availableStock.get(i - 1)
								.getCustomerPrice()));
				maxAvailable[i - 1] = new JLabel(Integer.toString(availableStock
						.get(i - 1).getQuantity()));
				quantityField[i - 1] = new JTextField(3);
	
				gc.gridy = i;
	
				gc.gridx = 0;
				gc.fill = GridBagConstraints.NONE;
				gc.anchor = GridBagConstraints.LINE_END;
				gc.insets = new Insets(0, 0, 0, 5);
				add(stockName[i - 1], gc);
	
				gc.gridx = 1;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(customerPrice[i - 1], gc);
	
				gc.gridx = 2;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(maxAvailable[i - 1], gc);
	
				gc.gridx = 3;
				gc.insets = new Insets(0, 0, 0, 0);
				gc.anchor = GridBagConstraints.LINE_START;
				add(quantityField[i - 1], gc);
			}

		saleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<Integer> quantities = new ArrayList<Integer>();
				ArrayList<String> stockNames = new ArrayList<String>();
				// Get ordered stock and associated quantities
				 ArrayList<Stock> saleStockList = new ArrayList<Stock>();
			
				for (int i = 0; i < size; i++) {
					if (!quantityField[i].getText().equals("")){
						try{
							if (Integer.parseInt(quantityField[i].getText()) <= Integer
									.parseInt(maxAvailable[i].getText())) {
									
									quantities.add(Integer.valueOf(quantityField[i]
									.getText()));
									stockNames.add(stockName[i].getText());
							}
							else {
										JOptionPane.showMessageDialog(errorPanel,"Exceeded max Available",
										"Out of Stock", JOptionPane.ERROR_MESSAGE);
										removeAll();
										try {
											createSaleSelectionPanel(event);
										} catch (IOException e1) {
											e1.printStackTrace();
										}
										//return prevents an empty sale being completed
										return;	
							}
						} catch (NumberFormatException nfEx){
							JOptionPane.showMessageDialog(errorPanel,"Please enter whole number", "ERROR!!", JOptionPane.ERROR_MESSAGE);
							return;
						}
					}
					
				}
				
				// clear stock list from previous runs
				//saleStockList.clear();
				// Loop through ordered stock names and link to actual product
				int i = 0;
				for (String name : stockNames) {
					for (Stock s : availableStock) {
						if (s.getName().equals(name)) {
							Stock saleStockItem = new Stock(s.getProduct(),
									quantities.get(i));
							saleStockList.add(saleStockItem);
						}
					}
					i++;
				}

				
				SaleFormEvent saleEvent = new SaleFormEvent(this, thisCustomer,
						saleStockList);
				if (formListener != null) {
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


	public void setEvent(SaleFormEvent event) {
		this.event = event;
	}

	public JButton getEnterButton() {
		return enterButton;
	}

	public JButton getSaleButton() {
		return saleButton;
	}

}