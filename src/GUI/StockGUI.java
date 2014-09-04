package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import model.Model;
import model.Sale;
import model.Stock;

public class StockGUI extends JPanel {

	private JTextArea textArea;
	private JButton viewStockBtn;
	private JPanel stockPanel;
	private Model model;
	
	//Shane
	private JButton stockBarChartBtn;

	// niall
	private JButton predictStock, predictNextWeek, predictNextMonth, backTo;
	private JComboBox stocks;
	private JPanel predictionPanel;
	private JPanel chartPanel, buttonsPanel, showPanel;
	private String[] predictColumnsWeeks, predictColumnsMonths;
	private Object[][] predictData;
	private JTable predictionTabel;
	private JScrollPane predictionScroll;
	private GridBagConstraints showConstraints,stockConstraints;

	//stock control  , show low stock , show stock expected to run out
	private JPanel stockControlPanel,stockControlButtonsPanel,stockControlScrollPanel;
	private JButton stockControlButton,showLowStock,showExpectedStockRunOutWeek,showExpectedStockRunOutMonth;
	private JTable lowStockTable,expectedRunOutTable;
	private String[] lowStockColumns,expectedRunOutWeekColumns,expectedRunOutMonthColumns;
	private JScrollPane stockControlScroll;
	private JButton backToStock;

	//

	public StockGUI() throws IOException {

		// niall
		predictionPanel();
		showPanel = new JPanel();
		buttonsPanel = new JPanel();
		predictStock = new JButton("Estimated StockSales");
		buttonsPanel.setLayout(new FlowLayout());
		stockConstraints=new GridBagConstraints();
		
		//stockControl panel
		stockControlPanel=new JPanel();
		stockControlPanel.setLayout(new GridBagLayout());
		stockControlButtonsPanel=new JPanel();
		stockControlButtonsPanel.setLayout(new GridBagLayout());
		stockControlScrollPanel=new JPanel();
		stockControlScrollPanel.setLayout(new GridBagLayout());
		
		stockControlButton=new JButton("Check Low Stock");
		showLowStock=new JButton("Show low Stock");
		showExpectedStockRunOutWeek=new JButton("Low end of week");
		showExpectedStockRunOutMonth=new JButton("Low end of Month");
		backToStock=new JButton("Back");
		
		JPanel buttonPanel=new JPanel();
		buttonPanel.setLayout(new GridBagLayout());
		
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.gridheight=1;
		c.gridwidth=1;
		c.weightx=1;
		c.weighty=1;
		c.anchor=GridBagConstraints.WEST;
		buttonPanel.add(showLowStock,c);
		
		c.gridy=1;
		buttonPanel.add(showExpectedStockRunOutWeek,c);
		
		c.gridy=2;
		buttonPanel.add(showExpectedStockRunOutMonth,c);
		
		
		c.gridx=0;
		c.gridy=0;
		c.weighty=0.1;
		c.fill=GridBagConstraints.BOTH;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		stockControlButtonsPanel.add(buttonPanel,c);
		
		c.gridx=0;
		c.gridy=2;
		c.weighty=0.9;
		c.fill=GridBagConstraints.NONE;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		stockControlButtonsPanel.add(backToStock,c);
		
		lowStockColumns=new String[]{"Product","Id","Quantity"};
		expectedRunOutWeekColumns=new String[]{"Product","Id","Supplier","Current Quantity","Expected Quantity at end of Week"};
		expectedRunOutMonthColumns=new String[]{"Product","Id","Supplier","Current Quantity","Expected Quantity at end of Month"};
		Object data[][]=new Object[1][3];
		lowStockTable=new JTable(data,lowStockColumns);
		
		stockControlScroll=new JScrollPane(lowStockTable);
		
		
		c.gridx=0;
		c.gridy=0;
		c.weightx=1;
		c.weighty=1;
		c.fill=GridBagConstraints.BOTH;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		stockControlScrollPanel.add(stockControlScroll,c);
		
		c.gridx=0;
		c.gridy=0;
		c.gridwidth=1;
		c.gridheight=3;
		c.weightx=0.3;
		c.weighty=1;
		c.fill=GridBagConstraints.BOTH;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		stockControlPanel.add(stockControlButtonsPanel,c);
		
		c.gridx=1;
		c.gridy=0;
		c.gridheight=3;
		c.gridwidth=2;
		c.weightx=1;
		c.weighty=1;
		c.fill=GridBagConstraints.BOTH;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		stockControlPanel.add(stockControlScrollPanel,c);
		
		//

		textArea = new JTextArea(5, 20);
		stockPanel = new JPanel();
		//stockPanel.setSize(500, 600);
		model = new Model();
		//stockPanel.setLayout(new BorderLayout());
		viewStockBtn = new JButton("View Stock");
		// shane
		stockBarChartBtn = new JButton("Stock Chart");

		// niall
		//stockPanel.add(textArea);
		buttonsPanel.add(viewStockBtn);
		buttonsPanel.add(predictStock);
		buttonsPanel.add(stockControlButton);
		buttonsPanel.add(stockBarChartBtn);
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
		
		stockBarChartBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event) {
				final JDialog dialog = new JDialog();
				final JFXPanel contentPane = new JFXPanel();
				dialog.setContentPane(contentPane);
				dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

				// building the scene graph must be done on the javafx thread
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						contentPane.setScene(createStockBarChart());
						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								dialog.pack();
								dialog.setVisible(true);
							}
						});
					}
				});
			}

			private Scene createStockBarChart() {
				Map<String, Integer> stockLevels = stockLevels();
				final CategoryAxis xAxis = new CategoryAxis();
				final NumberAxis yAxis = new NumberAxis();
				final BarChart<String, Number> bc = new BarChart<String, Number>(
						xAxis, yAxis);
				bc.setTitle("Stock Summary");
				xAxis.setLabel("Products");
				yAxis.setLabel("Ammount");

				XYChart.Series series1 = new XYChart.Series();

				for (Map.Entry<String, Integer> current : stockLevels.entrySet()){
					series1.getData().add(
							new XYChart.Data(current.getKey(), current.getValue()));
				}
				
				bc.getData().addAll(series1);
				return new Scene(bc, 800, 600);	
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
	
	public void switchToControl(){
		showPanel.removeAll();
		showPanel.add(stockControlPanel,showConstraints);
		showPanel.validate();
		showPanel.repaint();
	}

	public void fillLowStock(Object[][] data){
		stockControlScrollPanel.remove(stockControlScroll);
		lowStockTable=new JTable(data,lowStockColumns);
		
		stockControlScroll=new JScrollPane(lowStockTable);
		System.out.println("fill");
		GridBagConstraints c=new GridBagConstraints();
		c.gridx=0;
		c.gridy=0;
		c.gridheight=3;
		c.gridwidth=3;
		c.weightx=1;
		c.weighty=1;
		c.fill=GridBagConstraints.BOTH;
		c.anchor=GridBagConstraints.FIRST_LINE_START;
		stockControlScrollPanel.add(stockControlScroll,c);
		stockControlScrollPanel.validate();
		stockControlScrollPanel.repaint();
		
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

	public JButton getStockControlButton() {
		return stockControlButton;
	}

	public void setStockControlButton(JButton stockControlButton) {
		this.stockControlButton = stockControlButton;
	}

	public JButton getShowLowStock() {
		return showLowStock;
	}

	public JButton getShowExpectedStockRunOutWeek() {
		return showExpectedStockRunOutWeek;
	}

	public JButton getShowExpectedStockRunOutMonth() {
		return showExpectedStockRunOutMonth;
	}

	public JButton getBackToStock() {
		return backToStock;
	}
	
	

}
