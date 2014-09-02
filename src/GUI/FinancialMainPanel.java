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

					public void dailySales() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseDaySalePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}
					
					public void weeklySales() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseWeekSalePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void monthlySales() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseMonthSalePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
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
					public void dailyExpenses() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseDayExpensePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}
					
					public void weeklyExpenses() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseWeekExpensePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void monthlyExpenses() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseMonthExpensePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
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
					public void dailyProfits() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseDayProfitPanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void weeklyProfits() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseWeekProfitPanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void monthlyProfits() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseMonthProfitPanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void saleMonthSelected(FinancialFormEvent e) {
						financialTablePanel.setSaleData(model.getShop()
								.getMonthlySales(e));
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.appendText("");
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void saleWeekSelected(FinancialFormEvent e) {
						financialTablePanel.setSaleData(model.getShop()
								.getWeeklySales(e));
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.appendText("");
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void saleDaySelected(FinancialFormEvent e) {
						financialTablePanel.setSaleData(model.getShop()
								.getDailySales(e));
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.appendText("");
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void expenseMonthSelected(FinancialFormEvent e) {
						financialTablePanel.setExpenditureData(model.getShop()
								.getMonthlyOrders(e));
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalOrders();
						financialTextPanel.appendText("");
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");

					}

					@Override
					public void expenseWeekSelected(FinancialFormEvent e) {
						financialTablePanel.setExpenditureData(model.getShop()
								.getWeeklyOrders(e));
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalOrders();
						financialTextPanel.appendText("");
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");

					}

					@Override
					public void expenseDaySelected(FinancialFormEvent e) {
						financialTablePanel.setExpenditureData(model.getShop()
								.getDailyOrders(e));
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalOrders();
						financialTextPanel.appendText("");
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");

					}

					@Override
					public void profitMonthSelected(FinancialFormEvent e) {
						double income = model.getShop().getMonthlyIncome(e);
						double expenses = model.getShop().getMonthlyExpenses(e);
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
					public void profitWeekSelected(FinancialFormEvent e) {
						double income = model.getShop().getWeeklyIncome(e);
						double expenses = model.getShop().getWeeklyExpenses(e);
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
					public void profitDaySelected(FinancialFormEvent e) {
						double income = model.getShop().getDailyIncome(e);
						double expenses = model.getShop().getDailyExpenses(e);
						double profit = model.getShop()
								.profit(income, expenses);
						double loss = model.getShop().loss(income, expenses);
						financialTablePanel.setProfitData(income, expenses,
								profit, loss);
						financialTextPanel.clearText();
						financialTablePanel.setTableModel(3);
						financialTablePanel.refresh();
					}

				});

		financialTablePanel.setFormPanel(financialFormPanel);
		financialTablePanel.setSaleData(model.getShop().getSales());
		financialTablePanel.setExpenditureData(model.getShop().getOrders());

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
						double income = model.getShop().getAllIncome();
						double expenses = model.getShop().getAllExpenses();
						double profit = model.getShop()
								.profit(income, expenses);
						double loss = model.getShop().loss(income, expenses);
						financialTablePanel.setProfitData(income, expenses,
								profit, loss);
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
