package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;

import model.Sale;

public class FinancialTablePanel extends JPanel {

	private JTable tableOrder;
	private JTable tableSale;
	private FinancialSaleTableModel tableModel;
	private FinancialExpendituresTableModel tableOrderModel;
	private FinancialFormPanel formPanel;
	private ArrayList<Sale> financialSales = new ArrayList<Sale>();

	public FinancialTablePanel() {
		JButton graphBtn = new JButton("Barchart");
		tableModel = new FinancialSaleTableModel();
		/*tableOrderModel = new FinancialExpendituresTableModel();
		tableOrder = new JTable(tableOrderModel);*/
		tableSale = new JTable(tableModel);
		
	    graphBtn.addActionListener(new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent event) {
	          final JDialog dialog = new JDialog();
	          final JFXPanel contentPane = new JFXPanel();
	          dialog.setContentPane(contentPane);
	          dialog.setDefaultCloseOperation(
	              JDialog.HIDE_ON_CLOSE);

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
	              final BarChart<String,Number> bc = 
	                  new BarChart<String,Number>(xAxis,yAxis);
	              bc.setTitle("Sales Summary");
	              xAxis.setLabel("Products");       
	              yAxis.setLabel("Value");
	              
	             	 XYChart.Series series1 = new XYChart.Series();
	             	 
	             	 for (Sale sale: financialSales){
	                  /*series1.setName(sale.getCustomer().getName());*/       
	                  series1.getData().add(new XYChart.Data(sale.getCustomer().getName(), sale.getTotalPrice()));
	              }
	   
	
	          bc.getData().addAll(series1);
	          return new Scene(bc, 800, 600);
	        }
	      });


		setLayout(new BorderLayout());
		add(graphBtn, BorderLayout.SOUTH);
		add(new JScrollPane(tableSale), BorderLayout.CENTER);
		
	}

	public void setSaleData(ArrayList<Sale> todaySales) {
		this.financialSales = todaySales;
		tableModel.setData(todaySales);	
	}

/*	public void setOrderData(ArrayList<Order> todayOrders) {
		tableOrderModel.setData(todayOrders);
		add(new JScrollPane(tableOrder), BorderLayout.CENTER);
	}*/

	public void setFormPanel(FinancialFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void saleRefresh() {
		tableModel.fireTableDataChanged();
	}

/*	public void orderRefresh() {
		tableOrderModel.fireTableDataChanged();
	}*/
}
