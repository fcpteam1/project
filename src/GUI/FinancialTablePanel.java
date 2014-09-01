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

import model.Order;
import model.Sale;

public class FinancialTablePanel extends JPanel {

	private JTable table;
	private FinancialExpenditureTableModel expenditureModel;
	private FinancialSaleTableModel saleModel;
	private FinancialProfitTableModel profitModel;
	private FinancialSaleTableModel tableModel;
	private FinancialFormPanel formPanel;

	public FinancialTablePanel() {
		table = new JTable();
		expenditureModel = new FinancialExpenditureTableModel();
		saleModel = new FinancialSaleTableModel();
		profitModel = new FinancialProfitTableModel();
		JButton graphBtn = new JButton("Barchart");

		graphBtn.addActionListener(new ActionListener() {
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

				for (Sale sale : saleModel.getData()) {
					/* series1.setName(sale.getCustomer().getName()); */
					series1.getData().add(
							new XYChart.Data(sale.getCustomer().getName(), sale
									.getTotalPrice()));
				}

				bc.getData().addAll(series1);
				return new Scene(bc, 800, 600);
			}

			private Scene createExpensesBarChart() {
				System.out.println("creating scene");
				final CategoryAxis xAxis = new CategoryAxis();
				final NumberAxis yAxis = new NumberAxis();
				final BarChart<String, Number> bc = new BarChart<String, Number>(
						xAxis, yAxis);
				bc.setTitle("Expenses Summary");
				xAxis.setLabel("Suppliers");
				yAxis.setLabel("Value");

				XYChart.Series series1 = new XYChart.Series();

				for (Order order : expenditureModel.getData()) {
					/* series1.setName(sale.getCustomer().getName()); */
					series1.getData().add(
							new XYChart.Data(order.getSupplier().getName(),
									order.getTotalPrice()));
				}

				bc.getData().addAll(series1);
				return new Scene(bc, 800, 600);
			}

		});

		setLayout(new BorderLayout());
		add(graphBtn, BorderLayout.SOUTH);
		add(new JScrollPane(table), BorderLayout.CENTER);
	}

	public void setFormPanel(FinancialFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void setExpenditureData(ArrayList<Order> orders) {
		expenditureModel.setData(orders);
	}

	public void setSaleData(ArrayList<Sale> sales) {
		saleModel.setData(sales);
	}

	public void setProfitData(double income, double expenditure, double profit,
			double loss) {
		profitModel.setData(income, expenditure, profit, loss);
	}

	public void refresh() {
		expenditureModel.fireTableDataChanged();
		saleModel.fireTableDataChanged();
		profitModel.fireTableDataChanged();
	}

	public void setTableModel(int i) {
		switch (i) {
		case 1:
			table.setModel(saleModel);
			System.out.println("Sale");
			break;
		case 2:
			table.setModel(expenditureModel);
			System.out.println("Expense");
			break;
		case 3:
			table.setModel(profitModel);
			System.out.println("Profit");
			break;
		}
	}
}
