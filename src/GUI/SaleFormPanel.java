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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Customer;
import model.Model;
import model.Product;
import model.Sale;
import model.Stock;

public class SaleFormPanel extends JPanel {

	private JLabel customerLabel;
	private JComboBox customerBox;
	private JButton enterButton;
	private JButton saleButton;
	private Sale saleToEdit;
	private ArrayList<Stock> saleStockListToEdit = new ArrayList<Stock>();
	private JButton editButton;
	private SaleMainPanel mainPanel;
	private SaleFormListener formListener;
	private ArrayList<Product> totalProducts;
	private ArrayList<Customer> customers;
	private ArrayList<Stock> stocks;
	private String stockFile;
	private ArrayList<Stock> saleStockList = new ArrayList<Stock>();
	private ArrayList<Stock> availableStock = new ArrayList<Stock>();
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

	/*
	 * public Map<String, Integer> stockLevels() {
	 * 
	 * for (Stock stock : stocks) { System.out.println(stock.getName() + "" +
	 * stock.calculatePrice()); }
	 * 
	 * 
	 * Map<String, Integer> stockLevels = new HashMap<String, Integer>();
	 * 
	 * for (int i = 0; i < stocks.size(); i++) { int quantity = 0; for (int j =
	 * i; j < stocks.size(); j++) { boolean inMap = stockLevels
	 * .containsKey(stocks.get(i).getName()); if (inMap && j == i) { j =
	 * stocks.size(); } else if (stocks.get(i).getName()
	 * .equals(stocks.get(j).getName())) { quantity = quantity +
	 * stocks.get(j).getQuantity(); //
	 * System.out.println(stocks.get(j).getQuantity());
	 * stockLevels.put(stocks.get(i).getName(), quantity); //
	 * System.out.println(quantity); }
	 * 
	 * } } return stockLevels; }
	 * 
	 * public ArrayList<Stock> panelStockList() { for (Product p :
	 * totalProducts) { System.out.println("PanelStockList Method: " +
	 * stockLevels().get(p.getName()));
	 * 
	 * if (stockLevels().get(p.getName()) == null) { Stock stock = new Stock(p,
	 * 0); availableStock.add(stock); } else {
	 * 
	 * Stock stock = new Stock(p, stockLevels().get(p.getName()));
	 * availableStock.add(stock); // } } return availableStock; }
	 */
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

	public void createSaleSelectionPanel(SaleFormEvent e) throws IOException {

		this.removeAll();
		thisCustomer = e.getCustomer();

		Dimension dim = getPreferredSize();
		dim.width = 450;
		setPreferredSize(dim);
		Border innerBorder = (BorderFactory
				.createTitledBorder("Select Product and Amount"));
		Border outerBorder = (BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		saleButton = new JButton("Process Sale");
		// local arraylist for stock to be created by checkLevel() giving
		// product with total quantity
		// will be used in place of stocks
		size = availableStock.size();
		System.out.println("The size of availableStock:" + size);
		stockName = new JLabel[size];
		customerPrice = new JLabel[size];
		maxAvailable = new JLabel[size];
		quantityField = new JTextField[size];

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		for (int i = 0; i < size; i++) {
			stockName[i] = new JLabel(availableStock.get(i).getName());
			customerPrice[i] = new JLabel(": " + "\u20ac"
					+ Double.toString(availableStock.get(i).getCustomerPrice()));
			maxAvailable[i] = new JLabel("("
					+ Double.toString(availableStock.get(i).getQuantity())
					+ ")");
			quantityField[i] = new JTextField(3);

			gc.gridy = i;
			gc.weightx = 1;
			gc.weighty = 0.1;

			gc.gridx = 0;
			gc.fill = GridBagConstraints.NONE;
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 0, 5);
			add(stockName[i], gc);

			gc.gridx = 1;
			gc.insets = new Insets(0, 0, 0, 0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(customerPrice[i], gc);

			gc.gridx = 2;
			gc.insets = new Insets(0, 0, 0, 0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(maxAvailable[i], gc);

			gc.gridx = 3;
			gc.insets = new Insets(0, 0, 0, 0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(quantityField[i], gc);
		}

		saleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> quantities = new ArrayList<Integer>();
				ArrayList<String> stockNames = new ArrayList<String>();
				// Get ordered stock and associated quantities
				for (int i = 0; i < size; i++) {
					if (!quantityField[i].getText().equals("")) {
						try {
							quantities.add(Integer.valueOf(quantityField[i]
									.getText()));
							stockNames.add(stockName[i].getText());
						} catch (NumberFormatException nfEx) {
							System.out.println("Not an integer");
						}
					}
				}
				// clear stock list from previous runs
				saleStockList.clear();
				// Loop through ordered stock names and link to actual product
				int i = 0;
				for (String name : stockNames) {
					for (Stock s : availableStock) {
						// stocks will be replaced by local arraylist derived
						// using checkLevels()
						if (s.getName().equals(name)) {
							Stock saleStockItem = new Stock(s.getProduct(),
									quantities.get(i));
							saleStockList.add(saleStockItem);
						}
					}
					i++;
				}
				int sizeSaleStockList = saleStockList.size();
				System.out.println("SALESTOCKLIST SIZE: " + sizeSaleStockList);
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

	public void editSaleSelectionPanel() {

		this.removeAll();

		Dimension dim = getPreferredSize();
		dim.width = 450;
		setPreferredSize(dim);
		Border innerBorder = (BorderFactory.createTitledBorder("Edit Amount"));
		Border outerBorder = (BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		editButton = new JButton("Finish");

		size = availableStock.size();
		stockName = new JLabel[size];
		customerPrice = new JLabel[size];
		quantityField = new JTextField[size];

		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();

		for (int i = 0; i < size; i++) {
			stockName[i] = new JLabel(availableStock.get(i).getName());
			customerPrice[i] = new JLabel(": " + "\u20ac"
					+ Double.toString(availableStock.get(i).getCustomerPrice()));
			quantityField[i] = new JTextField(3);
			int j = 0;
			for (Stock stock : saleStockListToEdit) {

				if (availableStock.get(i).getName().equals(stock.getName())) {
					quantityField[i].setText(String.valueOf(saleStockListToEdit
							.get(j).getQuantity()));
					break;
				}
				j++;
			}

			gc.gridy = i;
			gc.weightx = 1;
			gc.weighty = 0.1;

			gc.gridx = 0;
			gc.fill = GridBagConstraints.NONE;
			gc.anchor = GridBagConstraints.LINE_END;
			gc.insets = new Insets(0, 0, 0, 5);
			add(stockName[i], gc);

			gc.gridx = 1;
			gc.insets = new Insets(0, 0, 0, 0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(customerPrice[i], gc);

			gc.gridx = 2;
			gc.insets = new Insets(0, 0, 0, 0);
			gc.anchor = GridBagConstraints.LINE_START;
			add(quantityField[i], gc);
		}

		editButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Integer> quantities = new ArrayList<Integer>();
				ArrayList<String> stockNames = new ArrayList<String>();
				// Get ordered stock and associated quantities
				for (int i = 0; i < size; i++) {
					if (!quantityField[i].getText().equals("")) {
						try {
							quantities.add(Integer.valueOf(quantityField[i]
									.getText()));
							stockNames.add(stockName[i].getText());
						} catch (NumberFormatException nfEx) {
							System.out.println("Not an integer");
						}
					}
				}
				// clear stock list from previous runs
				saleStockListToEdit.clear();
				// Loop through ordered stock names and link to actual product
				int i = 0;
				for (String name : stockNames) {
					for (Stock s : availableStock) {
						// stocks will be replaced by local arraylist derived
						// using checkLevels()
						if (s.getName().equals(name)) {
							Stock saleStockItem = new Stock(s.getProduct(),
									quantities.get(i));
							saleStockListToEdit.add(saleStockItem);
						}
					}
					i++;
				}

				SaleFormEvent saleEvent = new SaleFormEvent(this, saleToEdit
						.getCustomer(), saleStockListToEdit);
				if (formListener != null) {
					formListener.editSaleOccurred(saleEvent, saleToEdit.getId());
				}
				setVisible(false);
			}

		});
		gc.gridy++;
		gc.gridx = 1;
		add(editButton, gc);
		this.validate();
		this.repaint();

	}

	public void setFormListener(SaleFormListener listener) {
		this.formListener = listener;
	}

	public void setSaleToEdit(Sale saleToEdit) {
		this.saleToEdit = saleToEdit;
	}

	public void setSaleStockListToEdit(ArrayList<Stock> saleStockListToEdit) {
		this.saleStockListToEdit = saleStockListToEdit;
	}

	public JButton getEnterButton() {
		return enterButton;
	}

	public JButton getSaleButton() {
		return saleButton;
	}

}
