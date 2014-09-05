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

			@Override
			public void rowEdited(int row) {
				formPanel.setVisible(true);
				formPanel.setSaleToEdit(model.getShop().getSales().get(row));
				formPanel.setSaleStockListToEdit(model.getShop().getSales()
						.get(row).getStocks());
				formPanel.editSaleSelectionPanel();
				tablePanel.refresh();
			}

			public void listItems(int row) {
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

				int k = 0;
				String name;
				int quantity;
				ArrayList<Stock> saleStock = e.getStockList();
				Map<String, Integer> actualStock = StockGUI.stockLevels();
				ArrayList<Stock> saleProcessed = model.getShop().createSale(e);

				tablePanel.refresh();
				for (int i = 0; i < saleStock.size(); i++) {
					for (int j = 0; j <= saleProcessed.size(); j++) {
						name = saleStock.get(i).getName();
						quantity = saleStock.get(i).getQuantity();

						if (saleStock.get(i).getName()
								.equals(saleProcessed.get(j).getName())) {
							textPanel.appendText(name + "  Quantity: "
									+ quantity + "\n");
							j = saleProcessed.size();
						} else if (j + 50 >= saleProcessed.size()) {
							textPanel
									.appendText(name + "  Not In Stock" + "\n");
						}
					}
				}

				/*
				 * for (Map.Entry<String, Integer> current : actualStock
				 * .entrySet()) { textPanel.appendText(current.getKey() +
				 * "  Quantity: " + current.getValue() + "\n"); }
				 * textPanel.appendText("\n------Sale Complete-------\n");
				 */
			@Override
			public void editSaleOccurred(SaleFormEvent e, int id) {

				model.getShop().editSale(e, id);
				tablePanel.refresh();
				ArrayList<Stock> stockItems = e.getStockList();
				for (int i = 0; i < stockItems.size(); i++) {
					textPanel.appendText(stockItems.get(i).getName()
							+ "  Quantity: " + stockItems.get(i).getQuantity()
							+ "\n");
				}
				textPanel.appendText("\n------Sale Edited-------\n");
				textPanel.appendText("\n");
				tablePanel.setVisible(false);
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
