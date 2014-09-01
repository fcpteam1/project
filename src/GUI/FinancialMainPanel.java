package GUI;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import model.Model;
import model.Order;
import model.Sale;

public class FinancialMainPanel {
	private JPanel mainPanel;
	private FinancialToolbar financialToolbar;
	private FinancialFormPanel financialFormPanel;
	private FinancialTablePanel financialTablePanel;
	private FinancialTableModel financialTableModel;
	private FinancialTextPanel financialTextPanel;
	private double totalPrice;
	private Model model;

	public FinancialMainPanel() throws IOException {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		financialTablePanel = new FinancialTablePanel();
		financialToolbar = new FinancialToolbar();
		financialFormPanel = new FinancialFormPanel();
		financialTextPanel = new FinancialTextPanel();
		model = new Model();

		financialFormPanel
				.setFinancialFormListener(new FinancialFormListener() {

					@Override
					public void allSales() {
						financialTablePanel.setSaleData(model.getShop()
								.getSales());
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().getAllIncome();
						financialTextPanel.clearText();
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void todaysSales() {
						financialTablePanel.setSaleData(model.getShop()
								.getTodaySales());
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.clearText();
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void weeklySales() {
						financialTablePanel.setSaleData(model.getShop()
								.getTodaySales());
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.clearText();
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void monthlySales() {
						financialTablePanel.setSaleData(model.getShop()
								.getMonthlySales());
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.clearText();
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void allExpenses() {
						financialTablePanel.setExpenditureData(model.getShop()
								.getOrders());
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().getAllExpenses();
						financialTextPanel.clearText();
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void todaysExpenses() {
						financialTablePanel.setExpenditureData(model.getShop()
								.getTodayOrders());
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalOrders();
						financialTextPanel.clearText();
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void weeklyExpenses() {
						financialTablePanel.setExpenditureData(model.getShop()
								.getWeeklyOrders());
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalOrders();
						financialTextPanel.clearText();
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void monthlyExpenses() {
						financialTablePanel.setExpenditureData(model.getShop()
								.getMonthlyOrders());
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalOrders();
						financialTextPanel.clearText();
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void allProfits() {
						double income = model.getShop().getAllIncome();
						double expenses = model.getShop().getAllExpenses();
						double profit = model.getShop()
								.profit(income, expenses);
						double loss = model.getShop().loss(income, expenses);
						financialTablePanel.setProfitData(income, expenses,
								profit, loss);
						financialTextPanel.clearText();
						financialTablePanel.setTableModel(3);
						financialTablePanel.refresh();
					}

					@Override
					public void todaysProfits() {
						double income = model.getShop().getTodaysIncome();
						double expenses = model.getShop().getTodaysExpenses();
						double profit = model.getShop()
								.profit(income, expenses);
						double loss = model.getShop().loss(income, expenses);
						financialTablePanel.setProfitData(income, expenses,
								profit, loss);
						financialTextPanel.clearText();
						financialTablePanel.setTableModel(3);
						financialTablePanel.refresh();
					}

					@Override
					public void weeklyProfits() {
						// //financialTablePanel.setProfitData(model.getShop()
						// .totalSales(), model.getShop().totalOrders(),
						// model.getShop().profit(), model.getShop()
						// .loss());
						financialTextPanel.clearText();
						financialTablePanel.setTableModel(3);
						financialTablePanel.refresh();
					}

					@Override
					public void monthlyProfits() {
						double expenses = 0;
						for (Order order : model.getShop().getMonthlyOrders()) {
							expenses += order.getTotalPrice();
						}
						double income = 0;
						for (Sale sale : model.getShop().getMonthlySales()) {
							income += sale.getTotalPrice();
						}
						double profit = model.getShop()
								.profit(income, expenses);
						double loss = model.getShop().loss(income, expenses);
						income = round(income);
						expenses = round(expenses);
						profit = round(profit);
						loss = round(loss);
						financialTablePanel.setProfitData(income, expenses,
								profit, loss);
						financialTextPanel.clearText();
						financialTablePanel.setTableModel(3);
						financialTablePanel.refresh();
					}

					@Override
					public void dailySaleSelected() {
						// TODO Auto-generated method stub

					}

					@Override
					public void dailyExpenses() {
						// TODO Auto-generated method stub

					}

					@Override
					public void dailyProfits() {
						// TODO Auto-generated method stub

					}

				});

		financialTablePanel.setFormPanel(financialFormPanel);
		financialTablePanel.setSaleData(model.getShop().getSales());
		financialTablePanel.setExpenditureData(model.getShop().getOrders());
		// financialTablePanel.setProfitData(model.getShop().totalSales(), model
		// .getShop().totalOrders(), model.getShop().profit(), model
		// .getShop().loss());

		financialToolbar.setFormPanel(financialFormPanel);
		financialToolbar
				.setFinancialToolbarListener(new FinancialToolbarListener() {

					@Override
					public void saleSelected() {
						financialFormPanel.removeAll();
						financialFormPanel.SalesFormPanel();
						financialTablePanel.setSaleData(model.getShop()
								.getSales());
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void expendituresSelected() {
						financialFormPanel.removeAll();
						financialFormPanel.ExpendituresFormPanel();
						financialTablePanel.setExpenditureData(model.getShop()
								.getOrders());
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void profitsSelected() {
						financialFormPanel.removeAll();
						financialFormPanel.ProfitFormPanel();
						// financialTablePanel.setProfitData(model.getShop()
						// .totalSales(), model.getShop().totalOrders(),
						// model.getShop().profit(), model.getShop()
						// .loss());
						financialTablePanel.setTableModel(3);
						financialTablePanel.refresh();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

				});
		financialTablePanel.setSaleData(model.getShop().getBlankSalesTable());

		financialTablePanel.setVisible(true);

		mainPanel.add(financialFormPanel, BorderLayout.WEST);
		mainPanel.add(financialToolbar, BorderLayout.NORTH);
		mainPanel.add(financialTablePanel, BorderLayout.CENTER);
		mainPanel.add(financialTextPanel, BorderLayout.EAST);
		mainPanel.setSize(600, 500);
	}

	public JPanel getPanel() {
		return mainPanel;

	}

	public double round(double val) {
		val = Math.round(val * 100) / 100.00;
		return val;
	}
}
