package GUI;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import model.Model;
import model.Stock;

public class SaleMainPanel extends JPanel {

	private JPanel mainPanel;
	private SaleToolbar toolBar;
	private SaleTextPanel textPanel;
	private SaleFormPanel formPanel;
	private SaleTablePanel tablePanel;
	private Model model;

	public SaleMainPanel() throws IOException {
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		toolBar = new SaleToolbar();
		formPanel = new SaleFormPanel();
		tablePanel = new SaleTablePanel();
		textPanel = new SaleTextPanel();
		model = new Model();

		formPanel.setData(model.getShop().getAvailableStock(), model.getShop()
				.getCustomers(), model.getShop().getStockFile());
		tablePanel.setData(model.getShop().getSales());
		toolBar.setMainPanel(formPanel);
		tablePanel.setFormPanel(formPanel);

		mainPanel.add(toolBar, BorderLayout.NORTH);
		mainPanel.add(formPanel, BorderLayout.WEST);
		mainPanel.add(tablePanel, BorderLayout.CENTER);
		mainPanel.add(textPanel, BorderLayout.EAST);

		tablePanel.setSaleTableListener(new SaleTableListener() {
			public void rowDeleted(int row) {
				model.getShop().removeSale(row);
				tablePanel.refresh();
			}

			public void listItems(int row) {
				textPanel.setHeader();
				ArrayList<Stock> itemsBought = model.getShop().getSales()
						.get(row).getStocks();

				textPanel.appendText("\n------Products from Sale Id: " + row
						+ "-------\n");

				for (int i = 0; i < itemsBought.size(); i++) {
					textPanel.appendText(itemsBought.get(i).getName()
							+ "  Quantity: " + itemsBought.get(i).getQuantity()
							+ "\n");
				}

				textPanel.appendText("\n");

			}
		});

		formPanel.setFormListener(new SaleFormListener() {

			public void createSaleOccurred(SaleFormEvent e) {

				model.getShop().createSale(e);
				tablePanel.refresh();
				textPanel.setHeader();
				ArrayList<Stock> stockItems = e.getStockList();
				for (int i = 0; i < stockItems.size(); i++) {
					textPanel.appendText(stockItems.get(i).getName()
							+ "  Quantity: " + stockItems.get(i).getQuantity()
							+ "\n");
				}
				textPanel.appendText("\n------Sale Complete-------\n");
				textPanel.appendText("\n");
				


			}
		});
	}

	public SaleTextPanel getTextPanel() {
		return textPanel;
	}

	public void setTextPanel(SaleTextPanel textPanel) {
		this.textPanel = textPanel;
	}

	public JPanel getPanel() {
		return mainPanel;
	}
	

}