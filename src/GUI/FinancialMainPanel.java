package GUI;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import model.Model;

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

					}

					@Override
					public void todaysSales() {
						financialTablePanel.setSaleData(model.getShop()
								.getTodaySales());
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.appendText("");
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void dailySales() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseDaySalePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
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
					}

					@Override
					public void todaysExpenses() {
						financialTablePanel.setExpenditureData(model.getShop()
								.getTodayOrders());
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
					}

					@Override
					public void dailyExpenses() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseDayExpensePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();

					}

					@Override
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
						// TODO Auto-generated method stub

					}

					@Override
					public void todaysProfits() {
						// TODO Auto-generated method stub

					}

					@Override
					public void dailyProfits() {
						// TODO Auto-generated method stub

					}

					@Override
					public void weeklyProfits() {
						// TODO Auto-generated method stub

					}

					@Override
					public void monthlyProfits() {

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
					public void profitMonthSelected(FinancialFormEvent ev) {
						// TODO Auto-generated method stub

					}

					@Override
					public void profitWeekSelected(FinancialFormEvent ev) {
						// TODO Auto-generated method stub

					}

					@Override
					public void profitDaySelected(FinancialFormEvent ev) {
						// TODO Auto-generated method stub

					}

				});

		financialTablePanel.setFormPanel(financialFormPanel);
		financialTablePanel.setSaleData(model.getShop().getSales());
		financialTablePanel.setExpenditureData(model.getShop().getOrders());
		financialTablePanel.setProfitData(model.getShop().getOrders(), model
				.getShop().getSales());

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
						financialTablePanel.setProfitData(model.getShop()
								.getOrders(), model.getShop().getSales());
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
}
