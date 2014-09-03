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

public class FinancialGraphPanel extends JPanel {

	private ArrayList<Sale> sales = new ArrayList<Sale>();
	private ArrayList<Order> orders = new ArrayList<Order>();
	private ArrayList<Sale> allSales = new ArrayList<Sale>();
	private ArrayList<Order> allOrders = new ArrayList<Order>();
	
	private double janSaleSum,febSaleSum,marSaleSum,aprSaleSum,maySaleSum,junSaleSum,julSaleSum,augSaleSum,sepSaleSum,octSaleSum,novSaleSum,decSaleSum;
	private double janOrderSum,febOrderSum,marOrderSum,aprOrderSum,mayOrderSum,junOrderSum,julOrderSum,augOrderSum,sepOrderSum,octOrderSum,novOrderSum,decOrderSum;
	private double janTotalSum,febTotalSum,marTotalSum,aprTotalSum,mayTotalSum,junTotalSum,julTotalSum,augTotalSum,sepTotalSum,octTotalSum,novTotalSum,decTotalSum;

	private JButton barChartBtn, pieChartBtn, lineChartMonthBtn;
	private Model model;
	private Calendar cal;
	private Calendar saleDate;
	private Calendar orderDate;
	
	public FinancialGraphPanel() throws IOException {
		
	model = new Model();
		

	}
	
	public void setSaleData(ArrayList<Sale> sales){
		this.sales = sales;
	}
	
	public void setOrderData(ArrayList<Order> orders){
		this.orders = orders;
	}
	
	public void setGraphData(){
		for (Sale sale: sales){
        	saleDate = model.getShop().dateToCalender(sale.getDate());
        	
        	if ((saleDate.get(Calendar.MONTH) == cal.JANUARY)){
        		janSaleSum+= sale.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.FEBRUARY)){
        		febSaleSum+= sale.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.MARCH)){
        		marSaleSum+= sale.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.APRIL)){
        		aprSaleSum+= sale.getTotalPrice();
        	}
            if ((saleDate.get(Calendar.MONTH) == cal.MAY)){
            	maySaleSum+= sale.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.JUNE)){
        		junSaleSum+= sale.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.JULY)){
        		julSaleSum+= sale.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.AUGUST)){
        		augSaleSum+= sale.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.SEPTEMBER)){
        		sepSaleSum+= sale.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.OCTOBER)){
        		octSaleSum+= sale.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.NOVEMBER)){
        		novSaleSum+= sale.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.DECEMBER)){
        		decSaleSum+= sale.getTotalPrice();
        	}
        	
        }
        

        for (Order order: orders){
        	saleDate = model.getShop().dateToCalender(order.getDate());
        	
        	if ((saleDate.get(Calendar.MONTH) == cal.JANUARY)){
        		janOrderSum+= order.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.FEBRUARY)){
        		febOrderSum+= order.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.MARCH)){
        		marOrderSum+= order.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.APRIL)){
        		aprOrderSum+= order.getTotalPrice();
        	}
            if ((saleDate.get(Calendar.MONTH) == cal.MAY)){
            	mayOrderSum+= order.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.JUNE)){
        		junOrderSum+= order.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.JULY)){
        		julOrderSum+= order.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.AUGUST)){
        		augOrderSum+= order.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.SEPTEMBER)){
        		sepOrderSum+= order.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.OCTOBER)){
        		octOrderSum+= order.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.NOVEMBER)){
        		novOrderSum+= order.getTotalPrice();
        	}
        	if ((saleDate.get(Calendar.MONTH) == cal.DECEMBER)){
        		decOrderSum+= order.getTotalPrice();
        	}
        	
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

	public void saleGraphPanel() {
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
						contentPane.setScene(createSaleBarChart());
						
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

			private Scene createSaleBarChart() {
				System.out.println("creating scene");
				final CategoryAxis xAxis = new CategoryAxis();
				final NumberAxis yAxis = new NumberAxis();
				final BarChart<String, Number> bc = new BarChart<String, Number>(
						xAxis, yAxis);
				bc.setTitle("Sales Summary");
				xAxis.setLabel("Customers");
				yAxis.setLabel("Value");

				XYChart.Series series1 = new XYChart.Series();

				for (Sale sale : sales) {
					/* series1.setName(sale.getCustomer().getName()); */
					series1.getData().add(
							new XYChart.Data(sale.getCustomer().getName(), sale
									.getTotalPrice()));
				}

				bc.getData().addAll(series1);
				return new Scene(bc, 800, 600);
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
			for (Sale sale: sales) {
	        ObservableList<PieChart.Data> pieChartData =
	                FXCollections.observableArrayList(
	                new PieChart.Data(sale.getCustomer().getName(), sale.getTotalPrice()));
			
	        pc.setTitle("Sales Pie Chart");

	        pc.getData().addAll(pieChartData);
			}
			
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

				for (Order order : orders) {
					/* series1.setName(sale.getCustomer().getName()); */
					series1.getData().add(
							new XYChart.Data(order.getSupplier().getName(), order
									.getTotalPrice()));
				}

				bc.getData().addAll(series1);
				return new Scene(bc, 800, 600);
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

			private Scene createExpenseLineChart() {
				System.out.println("creating scene");
				final CategoryAxis xAxis = new CategoryAxis();
		        final NumberAxis yAxis = new NumberAxis();
		         xAxis.setLabel("Month");
		        final LineChart<String,Number> lc = 
		                new LineChart<String,Number>(xAxis,yAxis);
		       
		        lc.setTitle("Monthly Total");
		                        
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
		        
		        XYChart.Series series2 = new XYChart.Series();
		        series2.setName("Orders");
		        series2.getData().add(new XYChart.Data("Jan",  janOrderSum));
		        series2.getData().add(new XYChart.Data("Feb",  febOrderSum));
		        series2.getData().add(new XYChart.Data("Mar",  marOrderSum));
		        series2.getData().add(new XYChart.Data("Apr",  aprOrderSum));
		        series2.getData().add(new XYChart.Data("May",  mayOrderSum));
		        series2.getData().add(new XYChart.Data("Jun",  junOrderSum));
		        series2.getData().add(new XYChart.Data("Jul",  julOrderSum));
		        series2.getData().add(new XYChart.Data("Aug",  augOrderSum));
		        series2.getData().add(new XYChart.Data("Sep",  sepOrderSum));
		        series2.getData().add(new XYChart.Data("Oct",  octOrderSum));
		        series2.getData().add(new XYChart.Data("Nov",  novOrderSum));
		        series2.getData().add(new XYChart.Data("Dec",  decOrderSum));
		       
		        
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
		        
		        lc.getData().addAll(series1,series2,series3);
		        return new Scene(lc,800,600);       
		    
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
