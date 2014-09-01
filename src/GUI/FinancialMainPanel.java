package GUI;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

import model.Model;
import model.Order;

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
						financialTablePanel.setSaleData(model.getShop()
								.getTodaySales());
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
					}

					@Override
					public void thisWeeksSales() {
						financialTablePanel.setSaleData(model.getShop()
								.getTodaySales());
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
					}

					@Override
					public void thisMonthsSales() {
						financialTablePanel.setSaleData(model.getShop()
								.getMonthlySales());
						financialTablePanel.setTableModel(1);
						financialTablePanel.refresh();
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
