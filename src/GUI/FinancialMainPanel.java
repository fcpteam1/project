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
	private Model model;

	public FinancialMainPanel() throws IOException {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		financialTableModel = new FinancialTableModel();
		financialTablePanel = new FinancialTablePanel();
		financialToolbar = new FinancialToolbar();
		financialFormPanel = new FinancialFormPanel();
		model = new Model();

		financialToolbar.setFormPanel(financialFormPanel);
		financialToolbar.setFinancialToolbarListener(new FinancialToolbarListener() {

					@Override
					public void saleSelected() {
						financialFormPanel.removeAll();
						financialFormPanel.SalesFormPanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void expendituresSelected() {
						financialFormPanel.removeAll();
						financialFormPanel.ExpendituresFormPanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

					@Override
					public void profitsSelected() {
						financialFormPanel.removeAll();
						financialFormPanel.ProfitFormPanel();
						financialFormPanel.validate();
						financialFormPanel.repaint();
					}

				});
		financialTablePanel.setData(model.getShop().getBlankTable());
		financialFormPanel.setFinancialFormListener(new FinancialFormListener(){
		
			@Override
			public void todaySaleSelected() {
				financialTablePanel.setData(model.getShop().getTodaySales());
				financialTablePanel.refresh();
			}

			@Override
			public void weekSaleSelected() {
				financialTablePanel.setData(model.getShop().getTodaySales());
				financialTablePanel.refresh();
				
			}

			@Override
			public void monthSaleSelected() {
				financialTablePanel.setData(model.getShop().getTodaySales());
				financialTablePanel.refresh();
			}
			
		});

		mainPanel.add(financialFormPanel, BorderLayout.WEST);
		mainPanel.add(financialToolbar, BorderLayout.NORTH);
		mainPanel.add(financialTablePanel,BorderLayout.CENTER);
		mainPanel.setSize(600, 500);
	}

	public JPanel getPanel() {
		return mainPanel;

	}
}
