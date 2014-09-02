package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Model;
import model.Stock;
import model.Supplier;

public class StockGUI extends JPanel {

	private JTextArea textArea;
	private JButton viewStockBtn;
	private JPanel stockPanel;
	private Model model;
	//Darren
	private JButton byDateBtn;
	private JButton allBtn;
	private StockTablePanel tablePanel;
	private StockTableModel tableModel;
	private JLabel newPriceLabel;
	private JTextField newPriceField;
	private JButton confirmBtn;
	
	// miall
	private JButton predictStock, predictNextWeek, predictNextMonth, backTo;
	private JComboBox stocks;
	private int next, current, last, lastTwo, lastThree;
	double dnext, dcurrent, dlast, dlastTwo, dlastThree;
	private JPanel predictionPanel;
	private JPanel chartPanel, buttonsPanel, showPanel;
	private String[] predictColumnsWeeks, predictColumnsMonths;
	private Object[][] predictData;
	private JTable predictionTabel;
	private JScrollPane predictionScroll;
	private GridBagConstraints showConstraints,stockConstraints;


	//

	public StockGUI() throws IOException {

		// niall
		predictionPanel();
		showPanel = new JPanel();
		buttonsPanel = new JPanel();
		predictStock = new JButton("Estimated StockSales");
		buttonsPanel.setLayout(new FlowLayout());
		stockConstraints=new GridBagConstraints();
		
		//Darren
		byDateBtn = new JButton("View By Date");
		allBtn = new JButton("View All");
		tablePanel = new StockTablePanel();
		
		tablePanel.setListener(new StockTableListener(){
			@Override
			public void editPrice(String name) {
				for(Stock stock: model.getShop().getStock()){
					if(stock.getName().equals(name)){
						//editPanel();
					}
				}
			}
		});
		
		textArea = new JTextArea(5, 20);
		stockPanel = new JPanel();
		//stockPanel.setSize(500, 600);
		model = new Model();
		//stockPanel.setLayout(new BorderLayout());
		viewStockBtn = new JButton("View Stock");

		// niall
		//stockPanel.add(textArea);
		buttonsPanel.add(viewStockBtn);
		buttonsPanel.add(predictStock);
		// stockPanel.add(viewStockBtn, BorderLayout.NORTH);
		//stockPanel.add(buttonsPanel, BorderLayout.NORTH);
		//

		viewStockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Map<String, Integer> stockLevels = stockLevels();
				textArea.append("Stock Levels:");
				for (Map.Entry<String, Integer> current : stockLevels
						.entrySet()) {
					textArea.append("\n" + current.getKey() + ": "
							+ String.valueOf(current.getValue()));
				}
				textArea.append("\n*********************************\n");
			}

		});
		stockPanel.setLayout(new GridBagLayout());
		stockConstraints.gridx=0;
		stockConstraints.gridy=0;
		stockConstraints.gridheight=1;
		stockConstraints.gridwidth=3;
		stockConstraints.weightx=1;
		stockConstraints.weighty=0.2;
		stockConstraints.fill = GridBagConstraints.BOTH;
		stockPanel.add(buttonsPanel,stockConstraints);
		stockConstraints.gridx=0;
		stockConstraints.gridy=1;
		stockConstraints.gridheight=2;
		stockConstraints.gridwidth=3;
		stockConstraints.weighty=1;
		stockConstraints.fill = GridBagConstraints.BOTH;
		stockPanel.add(textArea,stockConstraints);
		
		showPanel.setLayout(new GridBagLayout());
		showConstraints=new GridBagConstraints();
		showConstraints.gridx=0;
		showConstraints.gridy=0;
		showConstraints.gridwidth=3;
		showConstraints.gridheight=3;
		
		showConstraints.weightx=1;
		showConstraints.weighty=1;
		showConstraints.anchor=GridBagConstraints.FIRST_LINE_START;
		showConstraints.fill = GridBagConstraints.BOTH;
		// showPanel.add(stockPanel);
		showPanel.add(stockPanel,showConstraints);
	}

	public Map<String, Integer> stockLevels() {
		for (Stock stock : model.getShop().getStock()) {
			System.out.println(stock.getName() + "" + stock.calculatePrice());
		}

		Map<String, Integer> stockLevels = new HashMap<String, Integer>();

		for (int i = 0; i < model.getShop().getStock().size(); i++) {
			int quantity = 0;
			for (int j = i; j < model.getShop().getStock().size(); j++) {
				boolean inMap = stockLevels.containsKey(model.getShop()
						.getStock().get(i).getName());
				if (inMap && j == i) {
					j = model.getShop().getStock().size();
				} else if (model.getShop().getStock().get(i).getName()
						.equals(model.getShop().getStock().get(j).getName())) {
					quantity = quantity
							+ model.getShop().getStock().get(j).getQuantity();
					System.out.println(model.getShop().getStock().get(j)
							.getQuantity());
					stockLevels.put(
							model.getShop().getStock().get(i).getName(),
							quantity);
					System.out.println(quantity);
				}

			}
		}
		return stockLevels;
	}

	public static void checkStock(ArrayList<Stock> salesList,
			ArrayList<Stock> stockList, int quantity) {

		for (Stock temp : salesList) {
			if (!processSale(temp, stockList, quantity, 0)) {
				System.out.println("Out of Stock Item: " + temp.getName());
				// create an order
				// Order.makeOrder(temp, stockList, quantity);
			}
		}
	}

	public static boolean processSale(Stock sale, ArrayList<Stock> stockList,
			int quantity, int stockIndex) {
		boolean inStock = false;
		for (int i = stockIndex; i < stockList.size(); i++) {
			if (sale.getName().equals(stockList.get(i).getName())) {
				if (stockList.get(i).getQuantity() > quantity) {
					stockList.get(i).setQuantity(
							stockList.get(i).getQuantity() - quantity);
					inStock = true;
					i = stockList.size();
				} else if (stockList.get(i).getQuantity() == quantity) {
					stockList.remove(stockList.get(i));
					inStock = true;
					i = stockList.size();

				} else {
					quantity -= stockList.get(i).getQuantity();
					stockList.remove(stockList.get(i));
					processSale(sale, stockList, quantity, i);
				}
			}

		}
		return inStock;
	}

	public static void checkSellBy(ArrayList<Stock> stockList) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date current = new Date();
		long diff;
		long diffDays;

		for (Stock temp : stockList) {
			diff = Math.abs(temp.getDate().getTime() - current.getTime());
			diffDays = diff / (24 * 60 * 60 * 1000);
			if (diffDays >= 3) {
				stockList.remove(temp);
			}
		}
	}

	public JPanel getPanel() {
		return showPanel;
	}

//	public void editPanel(StockEvent ev){
//		Dimension dim = getPreferredSize();
//		dim.width = 300;
//		setPreferredSize(dim);
//		Border innerBorder = BorderFactory.createTitledBorder("Edit Item Price");
//		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
//		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
//		newPriceLabel = new JLabel("New Price: ");
//		newPriceField = new JTextField(3);
//		confirmBtn = new JButton("Confirm");
//
//		confirmBtn.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if(!newPriceField.getText().equals("")){
//					double price = Double.valueOf(newPriceField.getText());
//					for(Stock stock: model.getShop().getStock()){
//						if(stock.getName().equals(name)){
//							stock.setCustomerPrice(price);
//						}
//					}
//				}
//			}
//		});
//
//		setLayout(new GridBagLayout());
//		GridBagConstraints gc = new GridBagConstraints();
//
//		// First Row
//		gc.gridy = 0;
//		gc.weightx = 1;
//		gc.weighty = 0.1;
//
//		gc.gridx = 0;
//		gc.fill = GridBagConstraints.NONE;
//		gc.anchor = GridBagConstraints.LINE_END;
//		gc.insets = new Insets(0, 0, 0, 5);
//		add(supplierLabel, gc);
//
//		gc.gridx = 1;
//		gc.insets = new Insets(0, 0, 0, 0);
//		gc.anchor = GridBagConstraints.LINE_START;
//		add(supplierCombo, gc);
//
//		// Next Row
//		gc.gridy++;
//		gc.weightx = 1;
//		gc.weighty = 0.1;
//
//		gc.gridx = 1;
//		gc.insets = new Insets(0, 0, 0, 0);
//		gc.anchor = GridBagConstraints.LINE_START;
//		add(selectButton, gc);
//		setVisible(true);
//	}
	
	public void predictionPanel() {

		predictNextWeek = new JButton("Estimate next Week");
		predictNextMonth = new JButton("Estimate next Month");
		backTo = new JButton("Back");

		chartPanel = new JPanel();
		predictionPanel = new JPanel();
		predictionPanel.setLayout(new BorderLayout());

		predictColumnsWeeks = new String[] { "Stock", "3 Weeks", "2 Weeks",
				"Last Week", "This Week", "Estimated next Week" };
		predictColumnsMonths = new String[] { "Stock", "3 Months", "2 Months",
				"Last Month", "This Month", "Estimated next Month" };

		chartPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		predictData = new Object[1][6];
		predictData[0][0] = null;
		predictData[0][1] = null;
		predictData[0][2] = null;
		predictData[0][3] = null;
		predictData[0][4] = null;
		predictData[0][5] = null;
		predictionTabel = new JTable(predictData, predictColumnsWeeks);
		predictionScroll = new JScrollPane(predictionTabel);
		predictionPanel.add(predictionScroll, BorderLayout.CENTER);

		c.gridx = 0;
		c.gridy = 0;
		c.weighty = 0.1;
		c.weightx = 1;
		c.gridwidth = 3;
		c.anchor = GridBagConstraints.FIRST_LINE_START;

		chartPanel.add(predictNextWeek, c);

		c.gridy = 1;

		chartPanel.add(predictNextMonth, c);

		c.gridy = 2;
		c.weighty = 0.9;
		chartPanel.add(backTo, c);

		predictionPanel.add(chartPanel, BorderLayout.WEST);

	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getCurrent() {
		return current;
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public int getLast() {
		return last;
	}

	public void setLast(int last) {
		this.last = last;
	}

	public int getLastTwo() {
		return lastTwo;
	}

	public void setLastTwo(int lastTwo) {
		this.lastTwo = lastTwo;
	}

	public int getLastThree() {
		return lastThree;
	}

	public void setLastThree(int lastThree) {
		this.lastThree = lastThree;
	}

	public double getDnext() {
		return dnext;
	}

	public void setDnext(double dnext) {
		this.dnext = dnext;
	}

	public double getDcurrent() {
		return dcurrent;
	}

	public void setDcurrent(double dcurrent) {
		this.dcurrent = dcurrent;
	}

	public double getDlast() {
		return dlast;
	}

	public void setDlast(double dlast) {
		this.dlast = dlast;
	}

	public double getDlastTwo() {
		return dlastTwo;
	}

	public void setDlastTwo(double dlastTwo) {
		this.dlastTwo = dlastTwo;
	}

	public double getDlastThree() {
		return dlastThree;
	}

	public void setDlastThree(double dlastThree) {
		this.dlastThree = dlastThree;
	}

	public Object[][] getPredictData() {
		return predictData;
	}

	public void setPredictData(Object[][] predictData) {
		this.predictData = predictData;
	}

	public JButton getBackTo() {
		return backTo;
	}

	public void fillWeekPrediction(Object[][] data) {
		predictionPanel.remove(predictionScroll);

		predictionTabel = new JTable(data, predictColumnsWeeks);
		predictionScroll = new JScrollPane(predictionTabel);

		predictionPanel.add(predictionScroll, BorderLayout.CENTER);
		predictionPanel.validate();
		predictionPanel.repaint();

	}

	public void fillMonthPrediction(Object[][] data) {

		predictionPanel.remove(predictionScroll);

		predictionTabel = new JTable(data, predictColumnsMonths);
		predictionScroll = new JScrollPane(predictionTabel);

		predictionPanel.add(predictionScroll, BorderLayout.CENTER);
		predictionPanel.validate();
		predictionPanel.repaint();
	}

	public void switchToStockPredict() {
		showPanel.removeAll();
		showPanel.add(predictionPanel,showConstraints);
		showPanel.validate();
		showPanel.repaint();
	}

	public void switchToMain() {
		showPanel.removeAll();
		showPanel.add(stockPanel,showConstraints);
		showPanel.validate();
		showPanel.repaint();
	}

	public JButton getPredictNextWeek() {
		return predictNextWeek;
	}

	public void setPredictNextWeek(JButton predictNextWeek) {
		this.predictNextWeek = predictNextWeek;
	}

	public JButton getPredictNextMonth() {
		return predictNextMonth;
	}

	public void setPredictNextMonth(JButton predictNextMonth) {
		this.predictNextMonth = predictNextMonth;
	}

	public JButton getPredictStock() {
		return predictStock;
	}

	public void setPredictStock(JButton predictStock) {
		this.predictStock = predictStock;
	}

}
