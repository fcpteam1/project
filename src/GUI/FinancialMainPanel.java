package GUI;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import model.Model;

//The main panel for the finance tab
public class FinancialMainPanel {
	//necessary main panel and all components to be added
	private JPanel mainPanel;
	private FinancialToolbar financialToolbar;
	private FinancialFormPanel financialFormPanel;
	private FinancialTablePanel financialTablePanel;
	private FinancialTextPanel financialTextPanel;
	private FinancialGraphPanel financialGraphPanel;
	private Model model;

	public FinancialMainPanel() throws IOException {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		financialTablePanel = new FinancialTablePanel();
		financialToolbar = new FinancialToolbar();
		financialFormPanel = new FinancialFormPanel();
		financialTextPanel = new FinancialTextPanel();
		financialGraphPanel = new FinancialGraphPanel();
		//reference to the model to access all necessary data
		model = new Model();
		//set listeners for buttons in the form panel
		financialFormPanel
				.setFinancialFormListener(new FinancialFormListener() {

					@Override
					public void allSales() {
						//set data in table from the shop's data
						financialTablePanel.setSaleData(model.getShop()
								.getAllSales());
						//set the table model to the sale model
						financialTablePanel.setTableModel(1);
						//refresh the data in the table
						financialTablePanel.refresh();
						//get the total price for all sales
						double totalPrice = model.getShop().totalSales();
						//add to text panel
						financialTextPanel.getTotal(totalPrice);
						//set data for graph panel
						financialGraphPanel.setSaleData(model.getShop().getAllSales());
					}

					//similar to allSales: just for today
					@Override
					public void todaysSales() {
						financialTablePanel.setSaleData(model.getShop()
								.getTodaySales());
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.getTotal(totalPrice);
						financialGraphPanel.setSaleData(model.getShop().getTodaySales());
						
					}
					
					//opens new form panel to select precise day.
					public void dailySales() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseDaySalePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					//opens new form panel to select precise week.
					public void weeklySales() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseWeekSalePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					//opens new form panel to select precise month.
					@Override
					public void monthlySales() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseMonthSalePanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}
					
					//Same as Sales but for expenses
					@Override
					public void allExpenses() {
						financialTablePanel.setExpenditureData(model.getShop()
								.getAllOrders());
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().getAllExpenses();
						financialTextPanel.getTotal(totalPrice);
						financialGraphPanel.setOrderData(model.getShop().getAllOrders());
						
					}

					@Override
					public void todaysExpenses() {
						financialTablePanel.setExpenditureData(model.getShop()
								.getTodayOrders());
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalOrders();
						financialTextPanel.getTotal(totalPrice);
						financialGraphPanel.setOrderData(model.getShop().getTodayOrders());
					
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
					
					//Similar to sales and expenses
					@Override
					public void allProfits() {
						//all income, expenses and associated profit and loss calculated
						double income = model.getShop().getAllIncome();
						double expenses = model.getShop().getAllExpenses();
						double profit = model.getShop()
								.profit(income, expenses);
						double loss = model.getShop().loss(income, expenses);
						//set the table data
						financialTablePanel.setProfitData(income, expenses,
								profit, loss);
						//set the model (column headers)
						financialTablePanel.setTableModel(3);
						financialTablePanel.refresh();
					}

					//Similar to sales and expenses but with profit data for today
					@Override
					public void todaysProfits() {
						double income = model.getShop().getTodaysIncome();
						double expenses = model.getShop().getTodaysExpenses();
						double profit = model.getShop()
								.profit(income, expenses);
						double loss = model.getShop().loss(income, expenses);
						financialTablePanel.setProfitData(income, expenses,
								profit, loss);
						financialTablePanel.setTableModel(3);
						financialTablePanel.refresh();
					}
					
					//choose day for profit information
					@Override
					public void dailyProfits() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseDayProfitPanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					//choose week for profit information
					@Override
					public void weeklyProfits() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseWeekProfitPanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					//choose month for profit information
					@Override
					public void monthlyProfits() {
						financialFormPanel.removeAll();
						financialFormPanel.chooseMonthProfitPanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					//all listeners for data chosen from form panels
					//Sales/Expenses/Profits per day/week/month selected
					@Override
					public void saleMonthSelected(FinancialFormEvent e) {
						financialTablePanel.setSaleData(model.getShop()
								.getMonthlySales(e));
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.getTotal(totalPrice);
						financialGraphPanel.setSaleData(model.getShop().getMonthlySales(e));
					}

					@Override
					public void saleWeekSelected(FinancialFormEvent e) {
						financialTablePanel.setSaleData(model.getShop()
								.getWeeklySales(e));
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.getTotal(totalPrice);
						financialGraphPanel.setSaleData(model.getShop().getWeeklySales(e));
					}

					@Override
					public void saleDaySelected(FinancialFormEvent e) {
						financialTablePanel.setSaleData(model.getShop()
								.getDailySales(e));
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.getTotal(totalPrice);
						financialGraphPanel.setSaleData(model.getShop().getDailySales(e));
					}

					@Override
					public void expenseMonthSelected(FinancialFormEvent e) {
						financialTablePanel.setExpenditureData(model.getShop()
								.getMonthlyOrders(e));
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalOrders();
						financialTextPanel.getTotal(totalPrice);
						financialGraphPanel.setOrderData(model.getShop().getMonthlyOrders(e));
					}

					@Override
					public void expenseWeekSelected(FinancialFormEvent e) {
						financialTablePanel.setExpenditureData(model.getShop()
								.getWeeklyOrders(e));
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalOrders();
						financialTextPanel.getTotal(totalPrice);
						financialGraphPanel.setOrderData(model.getShop().getWeeklyOrders(e));
					}

					@Override
					public void expenseDaySelected(FinancialFormEvent e) {
						financialTablePanel.setExpenditureData(model.getShop()
								.getDailyOrders(e));
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						double totalPrice = model.getShop().totalOrders();
						financialTextPanel.getTotal(totalPrice);
						financialGraphPanel.setOrderData(model.getShop().getDailyOrders(e));
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
						financialTablePanel.setTableModel(3);
						financialTablePanel.refresh();
					}

				});

		//Give the table panel a reference to the form panel
		financialTablePanel.setFormPanel(financialFormPanel);
		//set the intitial sale data to all sales
		financialTablePanel.setSaleData(model.getShop().getSales());
		//same for expenses
		financialTablePanel.setExpenditureData(model.getShop().getOrders());
		//give the toolbar a reference to the form panel
		financialToolbar.setFormPanel(financialFormPanel);
		//setting the view after toolbar button is pressed
		financialToolbar
				.setFinancialToolbarListener(new FinancialToolbarListener() {
					//listener for sales button selected
					@Override
					public void saleSelected() {
						financialFormPanel.removeAll();
						//set form panel to sales
						financialFormPanel.SalesFormPanel();
						//set data
						financialTablePanel.setSaleData(model.getShop()
								.getSales());
						//set model to sales model
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						financialFormPanel.validate();
						financialFormPanel.repaint();
						
						financialGraphPanel.removeAll();
						financialGraphPanel.saleGraphPanel();
						financialGraphPanel.validate();
						financialGraphPanel.repaint();
					}

					//similar to sales, but for expenses
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
						
						financialGraphPanel.removeAll();
						financialGraphPanel.expenseGraphPanel();
						financialGraphPanel.validate();
						financialGraphPanel.repaint();
					}

					//profit form panel
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
						
						financialGraphPanel.removeAll();
						financialGraphPanel.profitGraphPanel();
						financialGraphPanel.validate();
						financialGraphPanel.repaint();
						
						financialGraphPanel.setSaleData(model.getShop().getAllSales());
						financialGraphPanel.setOrderData(model.getShop().getAllOrders());
						financialGraphPanel.setGraphData();
					}

				});
		
		financialTablePanel.setSaleData(model.getShop().getBlankSalesTable());
		financialTablePanel.setVisible(true);
		//add all components to main panel
		mainPanel.add(financialFormPanel, BorderLayout.WEST);
		mainPanel.add(financialToolbar, BorderLayout.NORTH);
		mainPanel.add(financialTablePanel, BorderLayout.CENTER);
		mainPanel.add(financialTextPanel, BorderLayout.SOUTH);
		mainPanel.add(financialGraphPanel, BorderLayout.EAST);
		mainPanel.setSize(600, 500);
	}

	public JPanel getPanel() {
		return mainPanel;

	}

}
