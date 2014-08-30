package GUI;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import model.Model;
import model.Order;
import model.Sale;

public class FinancialMainPanel {
	private JPanel mainPanel;
	private FinancialToolbar financialToolbar;
	private FinancialFormPanel financialFormPanel;
	private FinancialTablePanel financialTablePanel;
	private Model model;

	public FinancialMainPanel() throws IOException {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		financialTablePanel = new FinancialTablePanel();
		financialToolbar = new FinancialToolbar();
		financialFormPanel = new FinancialFormPanel();
		model = new Model();

		financialFormPanel
				.setFinancialFormListener(new FinancialFormListener() {

					@Override
					public void todaysSales() {
						ArrayList<Sale> sales = new ArrayList<Sale>();
						Date today = new Date();
						int day = today.getDay();
						int month = today.getMonth();
						int year = today.getYear();
						for (Sale sale : model.getShop().getSales()) {
							if (sale.getDate().getDay() == day
									&& sale.getDate().getMonth() == month
									&& sale.getDate().getYear() == year) {
								sales.add(sale);
								System.out.println("added");
							}
						}
						financialFormPanel.removeAll();
						financialFormPanel.SalesFormPanel();
						financialTablePanel.setSaleData(sales);
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void thisWeeksSales() {
						// TODO Auto-generated method stub

					}

					@Override
					public void thisMonthsSales() {
						ArrayList<Sale> sales = new ArrayList<Sale>();
						Date today = new Date();
						int month = today.getMonth();
						int year = today.getYear();
						for (Sale sale : model.getShop().getSales()) {
							if (sale.getDate().getMonth() == month
									&& sale.getDate().getYear() == year) {
								sales.add(sale);
								System.out.println("added");
							}
						}
						financialFormPanel.removeAll();
						financialFormPanel.SalesFormPanel();
						financialTablePanel.setSaleData(sales);
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void todaysExpenses() {
						ArrayList<Order> orders = new ArrayList<Order>();
						Date today = new Date();
						int day = today.getDay();
						int month = today.getMonth();
						int year = today.getYear();
						for (Order order : model.getShop().getOrders()) {
							if (order.getDate().getDay() == day
									&& order.getDate().getMonth() == month
									&& order.getDate().getYear() == year) {
								orders.add(order);
								System.out.println("added");
							}
						}
						financialFormPanel.removeAll();
						financialFormPanel.ExpendituresFormPanel();
						financialTablePanel.setExpenditureData(orders);
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void thisWeeksExpenses() {
						ArrayList<Order> orders = new ArrayList<Order>();
						Date today = new Date();

						int day = today.getDay();
						int month = today.getMonth();
						int year = today.getYear();
						for (Order order : model.getShop().getOrders()) {
							if (order.getDate().getDay() == day
									&& order.getDate().getMonth() == month
									&& order.getDate().getYear() == year) {
								orders.add(order);
								System.out.println("added");
							}
						}
						financialFormPanel.removeAll();
						financialFormPanel.ExpendituresFormPanel();
						financialTablePanel.setExpenditureData(orders);
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void thisMonthsExpenses() {
						ArrayList<Order> orders = new ArrayList<Order>();
						Date today = new Date();
						int month = today.getMonth();
						int year = today.getYear();
						for (Order order : model.getShop().getOrders()) {
							if (order.getDate().getMonth() == month
									&& order.getDate().getYear() == year) {
								orders.add(order);
								System.out.println("added");
							}
						}
						financialFormPanel.removeAll();
						financialFormPanel.ExpendituresFormPanel();
						financialTablePanel.setExpenditureData(orders);
						financialTablePanel.setTableModel(2);
						financialTablePanel.refresh();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void todaysProfits() {
						// TODO Auto-generated method stub

					}

					@Override
					public void thisWeeksProfits() {
						// TODO Auto-generated method stub

					}

					@Override
					public void thisMonthsProfits() {
						// TODO Auto-generated method stub

					}

				});

		financialTablePanel.setFormPanel(financialFormPanel);
		financialTablePanel.setTableModel(1);
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

		mainPanel.add(financialFormPanel, BorderLayout.WEST);
		mainPanel.add(financialToolbar, BorderLayout.NORTH);
		mainPanel.add(financialTablePanel, BorderLayout.CENTER);
		mainPanel.setSize(600, 500);
	}

	public JPanel getPanel() {
		return mainPanel;

	}
}
