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

		financialToolbar.setFormPanel(financialFormPanel);
		financialToolbar
				.setFinancialToolbarListener(new FinancialToolbarListener() {

					@Override
					public void saleSelected() {
						financialFormPanel.removeAll();
						financialFormPanel.SalesFormPanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void expendituresSelected() {
						/*
						 * financialFormPanel.removeAll();
						 * financialFormPanel.ExpendituresFormPanel();
						 * financialFormPanel.validate();
						 * financialFormPanel.repaint();
						 */
					}

					@Override
					public void profitsSelected() {
						/*
						 * financialFormPanel.removeAll();
						 * financialFormPanel.ProfitFormPanel();
						 * financialFormPanel.validate();
						 * financialFormPanel.repaint();
						 */
					}

				});
		// financialTablePanel.setOrderData(model.getShop().getBlankExpenditureTable());
		financialTablePanel.setSaleData(model.getShop().getBlankSalesTable());

		financialFormPanel
				.setFinancialFormListener(new FinancialFormListener() {

					@Override
					public void todaySaleSelected() {
						financialTablePanel.setSaleData(model.getShop()
								.getTodaySales());
						financialTablePanel.saleRefresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.appendText("");
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");
					}

					@Override
					public void weeklySaleSelected() {
						financialTablePanel.setSaleData(model.getShop()
								.getTodaySales());
						financialTablePanel.saleRefresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.appendText("");
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");

					}

					@Override
					public void dailySaleSelected() {
						// TODO Auto-generated method stub

					}

					@Override
					public void monthlySaleSelected() {
						financialTablePanel.setSaleData(model.getShop()
								.getMonthlySales());
						financialTablePanel.saleRefresh();
						double totalPrice = model.getShop().totalSales();
						financialTextPanel.appendText("");
						financialTextPanel.appendText("Total Price : "
								+ totalPrice + " euro\n");

					}

					/*
					 * @Override public void todayExpenditureSelected() {
					 * financialTablePanel
					 * .setOrderData(model.getShop().getTodayExpenditures());
					 * financialTablePanel.orderRefresh();
					 * 
					 * }
					 * 
					 * @Override public void weekExpenditureSelected() {
					 * financialTablePanel
					 * .setOrderData(model.getShop().getWeekExpenditures());
					 * financialTablePanel.orderRefresh();
					 * 
					 * }
					 * 
					 * @Override public void monthExpenditureSelected() {
					 * financialTablePanel
					 * .setOrderData(model.getShop().getMonthExpenditures());
					 * financialTablePanel.orderRefresh();
					 * 
					 * }
					 */

				});

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
