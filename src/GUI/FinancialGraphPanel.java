package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import model.Model;
import model.Order;
import model.Sale;

//For the graphs i decided to use the JavaFx as the graphs were visual striking
public class FinancialGraphPanel extends JPanel {

	private ArrayList<Sale> sales = new ArrayList<Sale>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	// Creating multiple double variables to store the total price for each
	// month for sales,expenditures and profit
	private double janSaleSum, febSaleSum, marSaleSum, aprSaleSum, maySaleSum,
			junSaleSum, julSaleSum, augSaleSum, sepSaleSum, octSaleSum,
			novSaleSum, decSaleSum;
	private double janOrderSum, febOrderSum, marOrderSum, aprOrderSum,
			mayOrderSum, junOrderSum, julOrderSum, augOrderSum, sepOrderSum,
			octOrderSum, novOrderSum, decOrderSum;
	private double janTotalSum, febTotalSum, marTotalSum, aprTotalSum,
			mayTotalSum, junTotalSum, julTotalSum, augTotalSum, sepTotalSum,
			octTotalSum, novTotalSum, decTotalSum;

	private JButton barChartBtn, pieChartBtn, lineChartMonthBtn;
	private Model model;
	private Calendar cal;
	private Calendar saleDate;
	private Calendar orderDate;

	public FinancialGraphPanel() throws IOException {

		model = new Model();

	}

	// Getting the sales arrayList
	public void setSaleData(ArrayList<Sale> sales) {
		this.sales = sales;
	}

	// Getting the orders arrayList
	public void setOrderData(ArrayList<Order> orders) {
		this.orders = orders;
	}

	/*
	 * for each sale within sales for each month i am adding up the total sum
	 * for that month and storing it within the appropriate variable. This is
	 * done for Expenditures also
	 */
	public void setGraphData() {
		for (Sale sale : sales) {
			saleDate = model.getShop().dateToCalender(sale.getDate());

			if ((saleDate.get(Calendar.MONTH) == cal.JANUARY)) {
				janSaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.FEBRUARY)) {
				febSaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.MARCH)) {
				marSaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.APRIL)) {
				aprSaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.MAY)) {
				maySaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.JUNE)) {
				junSaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.JULY)) {
				julSaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.AUGUST)) {
				augSaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.SEPTEMBER)) {
				sepSaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.OCTOBER)) {
				octSaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.NOVEMBER)) {
				novSaleSum += sale.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.DECEMBER)) {
				decSaleSum += sale.getTotalPrice();
			}

		}

		for (Order order : orders) {
			saleDate = model.getShop().dateToCalender(order.getDate());

			if ((saleDate.get(Calendar.MONTH) == cal.JANUARY)) {
				janOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.FEBRUARY)) {
				febOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.MARCH)) {
				marOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.APRIL)) {
				aprOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.MAY)) {
				mayOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.JUNE)) {
				junOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.JULY)) {
				julOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.AUGUST)) {
				augOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.SEPTEMBER)) {
				sepOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.OCTOBER)) {
				octOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.NOVEMBER)) {
				novOrderSum += order.getTotalPrice();
			}
			if ((saleDate.get(Calendar.MONTH) == cal.DECEMBER)) {
				decOrderSum += order.getTotalPrice();
			}

			/*
			 * to obtain the total profit for each month the total sale price
			 * minus the total Order price
			 */

			janTotalSum = janSaleSum - janOrderSum;
			febTotalSum = febSaleSum - febOrderSum;
			marTotalSum = marSaleSum - marOrderSum;
			aprTotalSum = aprSaleSum - aprOrderSum;
			mayTotalSum = maySaleSum - mayOrderSum;
			junTotalSum = junSaleSum - junOrderSum;
			julTotalSum = julSaleSum - julOrderSum;
			augTotalSum = augSaleSum - augOrderSum;
			sepTotalSum = sepSaleSum - sepOrderSum;
			octTotalSum = octSaleSum - octOrderSum;
			novTotalSum = novSaleSum - novOrderSum;
			decTotalSum = decSaleSum - decOrderSum;

		}
	}

	// ////////////////////GraphSaleBtnLayout////////////////////////

	// Creating a graph panel for the financials tab
	public void saleGraphPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		barChartBtn = new JButton("Bar Chart");
		pieChartBtn = new JButton("Pie Chart");
		lineChartMonthBtn = new JButton("Line Chart");

		barChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// When barChartBtn is pressed and new dialog box is opened
				final JDialog dialog = new JDialog();
				// Within that dialog box is a JFXPanel which will display the
				// graphs
				final JFXPanel contentPane = new JFXPanel();
				dialog.setContentPane(contentPane);
				// JavaFX applications cannot be run more then once within a
				// session
				// to overcome this issue the Dialog box is just hidden when
				// closed
				dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

				// building the scene graph must be done on the javafx thread
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						// calling the graph method and setting it within the
						// JFXPanel
						contentPane.setScene(createSaleBarChart());

						SwingUtilities.invokeLater(new Runnable() {
							@Override
							public void run() {
								// setting dialog size
								dialog.pack();
								// displaying dialog box
								dialog.setVisible(true);
							}
						});
					}
				});
			}

			// Creating the SaleBarChart
			private Scene createSaleBarChart() {
				System.out.println("creating scene");
				// Setting up the axis
				final CategoryAxis xAxis = new CategoryAxis();
				final NumberAxis yAxis = new NumberAxis();
				// New BarCahrt taking in a String and a Number
				final BarChart<String, Number> bc = new BarChart<String, Number>(
						xAxis, yAxis);
				bc.setTitle("Sales Summary");
				xAxis.setLabel("Customers");
				yAxis.setLabel("Value");

				// Creating a new series of data for the bar chart
				XYChart.Series series1 = new XYChart.Series();

				double total = 0;
				double total1 = 0;
				double total2 = 0;
				double total3 = 0;
				double total4 = 0;
				double total5 = 0;

				for (Sale sale : sales) {
					// For each customer within sales the total is added and
					// then displayed within the bar chart

					/*
					 * This method is not Ideal as it will not show any new
					 * customers added to the system but the other way to do
					 * this was not working out as for sale from the same
					 * customer would only take the total price of the last sale
					 * not all of them
					 */
					if (sale.getCustomer().getName().equals("Get Fresh")) {
						total = total + sale.getTotalPrice();
					}
					series1.getData().add(new XYChart.Data("Get Fresh", total));

					if (sale.getCustomer().getName().equals("Ever Green")) {
						total1 = total1 + sale.getTotalPrice();
					}
					series1.getData().add(
							new XYChart.Data("Ever Green", total1));

					if (sale.getCustomer().getName().equals("Happy Pear")) {
						total2 = total2 + sale.getTotalPrice();
					}
					series1.getData().add(
							new XYChart.Data("Happy Pear", total2));

					if (sale.getCustomer().getName().equals("Asia Market")) {
						total3 = total3 + sale.getTotalPrice();
					}
					series1.getData().add(
							new XYChart.Data("Asia Market", total3));

					if (sale.getCustomer().getName().equals("Donnybrook Fair")) {
						total4 = total4 + sale.getTotalPrice();
					}
					series1.getData().add(
							new XYChart.Data("Donnybrook Fair", total4));

					if (sale.getCustomer().getName().equals("Fresh Veg")) {
						total5 = total5 + sale.getTotalPrice();
					}
					series1.getData()
							.add(new XYChart.Data("Fresh Veg", total5));
				}

				// add all the data within series1 to the bar chart
				bc.getData().addAll(series1);
				// return the bar chart
				return new Scene(bc, 900, 600);
			}

		});

		// same is done for the pieChart
		pieChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JDialog dialog = new JDialog();
				final JFXPanel contentPane = new JFXPanel();
				dialog.setContentPane(contentPane);
				dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

				// building the scene graph must be done on the javafx thread
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						// calling the pie chart
						contentPane.setScene(createSalePieChart());

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

			private Scene createSalePieChart() {
				System.out.println("creating scene");
				final PieChart pc = new PieChart();

				double total = 0;
				double total1 = 0;
				double total2 = 0;
				double total3 = 0;
				double total4 = 0;
				double total5 = 0;

				for (Sale sale : sales) {
					if (sale.getCustomer().getName().equals("Get Fresh")) {
						total = total + sale.getTotalPrice();
					}

					if (sale.getCustomer().getName().equals("Ever Green")) {
						total1 = total1 + sale.getTotalPrice();
					}

					if (sale.getCustomer().getName().equals("Happy Pear")) {
						total2 = total2 + sale.getTotalPrice();
					}

					if (sale.getCustomer().getName().equals("Asia Market")) {
						total3 = total3 + sale.getTotalPrice();
					}

					if (sale.getCustomer().getName().equals("Donnybrook Fair")) {
						total4 = total4 + sale.getTotalPrice();
					}

					if (sale.getCustomer().getName().equals("Fresh Veg")) {
						total5 = total5 + sale.getTotalPrice();
					}
				}
				// Adding the data to the pie chart
				ObservableList<PieChart.Data> pieChartData = FXCollections
						.observableArrayList(new PieChart.Data("Get Fresh",
								total),
								new PieChart.Data("Ever Green", total1),
								new PieChart.Data("Happy Pear", total2),
								new PieChart.Data("Asia Market", total3),
								new PieChart.Data("Donnybrook Fair", total4),
								new PieChart.Data("Fresh Veg", total5));

				pc.setTitle("Sales Pie Chart");

				pc.getData().addAll(pieChartData);

				return new Scene(pc, 800, 600);
			}

		});

		// adding the buttons to the panel
		Border innerBorder = BorderFactory.createTitledBorder("Graphs");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(barChartBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(pieChartBtn, gc);

	}

	// This is then repeated for the Expenses graph panel

	// ////////////////////GraphExpenseBtnLayout////////////////////////

	public void expenseGraphPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		barChartBtn = new JButton("Bar Chart");
		pieChartBtn = new JButton("Pie Chart");
		lineChartMonthBtn = new JButton("Line Chart");

		barChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JDialog dialog = new JDialog();
				final JFXPanel contentPane = new JFXPanel();
				dialog.setContentPane(contentPane);
				dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

				// building the scene graph must be done on the javafx thread
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						contentPane.setScene(createExpenseBarChart());

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

			private Scene createExpenseBarChart() {
				System.out.println("creating scene");
				final CategoryAxis xAxis = new CategoryAxis();
				final NumberAxis yAxis = new NumberAxis();
				final BarChart<String, Number> bc = new BarChart<String, Number>(
						xAxis, yAxis);
				bc.setTitle("Sales Summary");
				xAxis.setLabel("Customers");
				yAxis.setLabel("Value");

				XYChart.Series series1 = new XYChart.Series();

				double total = 0;
				double total1 = 0;
				double total2 = 0;
				double total3 = 0;
				double total4 = 0;
				double total5 = 0;

				for (Order order : orders) {

					if (order.getSupplier().getName().equals("Keelings")) {
						total = total + order.getTotalPrice();
					}
					series1.getData().add(new XYChart.Data("Keelings", total));

					if (order.getSupplier().getName()
							.equals("Wexford Fruit Farm")) {
						total1 = total1 + order.getTotalPrice();
					}
					series1.getData().add(
							new XYChart.Data("Wexford Fruit Farm", total1));

					if (order.getSupplier().getName()
							.equals("Dublin Fruit Market")) {
						total2 = total2 + order.getTotalPrice();
					}
					series1.getData().add(
							new XYChart.Data("Dublin Fruit Market", total2));
				}

				bc.getData().addAll(series1);
				return new Scene(bc, 900, 600);
			}

		});

		pieChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JDialog dialog = new JDialog();
				final JFXPanel contentPane = new JFXPanel();
				dialog.setContentPane(contentPane);
				dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

				// building the scene graph must be done on the javafx thread
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						contentPane.setScene(createExpensePieChart());

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

			private Scene createExpensePieChart() {
				System.out.println("creating scene");
				final PieChart pc = new PieChart();

				double total = 0;
				double total1 = 0;
				double total2 = 0;

				for (Order order : orders) {
					if (order.getSupplier().getName().equals("Keelings")) {
						total = total + order.getTotalPrice();
					}

					if (order.getSupplier().getName()
							.equals("Wexford Fruit Farm")) {
						total1 = total1 + order.getTotalPrice();
					}

					if (order.getSupplier().getName()
							.equals("Dublin Fruit Market")) {
						total2 = total2 + order.getTotalPrice();
					}
				}

				ObservableList<PieChart.Data> pieChartData = FXCollections
						.observableArrayList(new PieChart.Data("Keelings",
								total), new PieChart.Data("Wexford Fruit Farm",
								total1), new PieChart.Data(
								"Dublin Fruit Market", total2));

				pc.setTitle("Sales Pie Chart");

				pc.getData().addAll(pieChartData);

				return new Scene(pc, 800, 600);
			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Graphs");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(barChartBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(pieChartBtn, gc);
	}

	// ////////////////////GraphProfitBtnLayout////////////////////////
	// The profit graph panel only has one button added to the panel
	public void profitGraphPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		lineChartMonthBtn = new JButton("Montly Profit Line Chart");

		lineChartMonthBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final JDialog dialog = new JDialog();
				final JFXPanel contentPane = new JFXPanel();
				dialog.setContentPane(contentPane);
				dialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);

				// building the scene graph must be done on the javafx thread
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						// calling the line chart
						contentPane.setScene(createExpenseLineChart());

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

			// Creating a line chart to display the profit vs loss between
			// the sales and the orders
			private Scene createExpenseLineChart() {
				System.out.println("creating scene");
				final CategoryAxis xAxis = new CategoryAxis();
				final NumberAxis yAxis = new NumberAxis();
				xAxis.setLabel("Month");
				final LineChart<String, Number> lc = new LineChart<String, Number>(
						xAxis, yAxis);

				lc.setTitle("Monthly Total");
				// Listing the sales for each month
				XYChart.Series series1 = new XYChart.Series();
				series1.setName("Sales");
				series1.getData().add(new XYChart.Data("Jan", janSaleSum));
				series1.getData().add(new XYChart.Data("Feb", febSaleSum));
				series1.getData().add(new XYChart.Data("Mar", marSaleSum));
				series1.getData().add(new XYChart.Data("Apr", aprSaleSum));
				series1.getData().add(new XYChart.Data("May", maySaleSum));
				series1.getData().add(new XYChart.Data("Jun", junSaleSum));
				series1.getData().add(new XYChart.Data("Jul", julSaleSum));
				series1.getData().add(new XYChart.Data("Aug", augSaleSum));
				series1.getData().add(new XYChart.Data("Sep", sepSaleSum));
				series1.getData().add(new XYChart.Data("Oct", octSaleSum));
				series1.getData().add(new XYChart.Data("Nov", novSaleSum));
				series1.getData().add(new XYChart.Data("Dec", decSaleSum));
				// Listing the orders for each month
				XYChart.Series series2 = new XYChart.Series();
				series2.setName("Orders");
				series2.getData().add(new XYChart.Data("Jan", janOrderSum));
				series2.getData().add(new XYChart.Data("Feb", febOrderSum));
				series2.getData().add(new XYChart.Data("Mar", marOrderSum));
				series2.getData().add(new XYChart.Data("Apr", aprOrderSum));
				series2.getData().add(new XYChart.Data("May", mayOrderSum));
				series2.getData().add(new XYChart.Data("Jun", junOrderSum));
				series2.getData().add(new XYChart.Data("Jul", julOrderSum));
				series2.getData().add(new XYChart.Data("Aug", augOrderSum));
				series2.getData().add(new XYChart.Data("Sep", sepOrderSum));
				series2.getData().add(new XYChart.Data("Oct", octOrderSum));
				series2.getData().add(new XYChart.Data("Nov", novOrderSum));
				series2.getData().add(new XYChart.Data("Dec", decOrderSum));

				// Listing the total profit or loss for each month
				XYChart.Series series3 = new XYChart.Series();
				series3.setName("Profit");
				series3.getData().add(new XYChart.Data("Jan", janTotalSum));
				series3.getData().add(new XYChart.Data("Feb", febTotalSum));
				series3.getData().add(new XYChart.Data("Mar", marTotalSum));
				series3.getData().add(new XYChart.Data("Apr", aprTotalSum));
				series3.getData().add(new XYChart.Data("May", mayTotalSum));
				series3.getData().add(new XYChart.Data("Jun", junTotalSum));
				series3.getData().add(new XYChart.Data("Jul", julTotalSum));
				series3.getData().add(new XYChart.Data("Aug", augTotalSum));
				series3.getData().add(new XYChart.Data("Sep", sepTotalSum));
				series3.getData().add(new XYChart.Data("Oct", octTotalSum));
				series3.getData().add(new XYChart.Data("Nov", novTotalSum));
				series3.getData().add(new XYChart.Data("Dec", decTotalSum));

				// adding the the data to the line chart
				lc.getData().addAll(series1, series2, series3);
				return new Scene(lc, 800, 600);

			}

		});

		Border innerBorder = BorderFactory.createTitledBorder("Graphs");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(lineChartMonthBtn, gc);

	}
}
