package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Model;
import model.Stock;

public class StockGUI extends JPanel {

	private JTextArea textArea;
	private JButton viewStockBtn;
	private JPanel stockPanel;
	private Model model;

	public StockGUI() throws IOException {

		textArea = new JTextArea(5, 20);
		stockPanel = new JPanel();
		stockPanel.setSize(500, 600);
		model = new Model();
		stockPanel.setLayout(new BorderLayout());
		viewStockBtn = new JButton("View Stock");

		stockPanel.add(textArea);
		stockPanel.add(viewStockBtn, BorderLayout.NORTH);

		viewStockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Map<String, Integer> stockLevels = stockLevels();
				textArea.append("Stock Levels:");
				for (Map.Entry<String, Integer> current : stockLevels
						.entrySet()) {
					textArea.append("\n" + current.getKey() + ": "
							+ String.valueOf(current.getValue()));
				}
				textArea.append("\n*********************************\n");
			}

		});
	}

	public Map<String, Integer> stockLevels() {
		for (Stock stock : model.getShop().getStock()) {
			System.out.println(stock.getName() + "" + stock.calculatePrice());
		}

		Map<String, Integer> stockLevels = new HashMap<String, Integer>();

		for (int i = 0; i < model.getShop().getStock().size(); i++) {
			int quantity = 0;
			for (int j = i; j < model.getShop().getStock().size(); j++) {
				boolean inMap = stockLevels.containsKey(model.getShop()
						.getStock().get(i).getName());
				if (inMap && j == i) {
					j = model.getShop().getStock().size();
				} else if (model.getShop().getStock().get(i).getName()
						.equals(model.getShop().getStock().get(j).getName())) {
					quantity = quantity
							+ model.getShop().getStock().get(j).getQuantity();
					System.out.println(model.getShop().getStock().get(j)
							.getQuantity());
					stockLevels.put(
							model.getShop().getStock().get(i).getName(),
							quantity);
					System.out.println(quantity);
				}

			}
		}
		return stockLevels;
	}

	public static void checkStock(ArrayList<Stock> salesList,
			ArrayList<Stock> stockList, int quantity) {

		for (Stock temp : salesList) {
			if (!processSale(temp, stockList, quantity, 0)) {
				System.out.println("Out of Stock Item: " + temp.getName());
				// create an order
				// Order.makeOrder(temp, stockList, quantity);
			}
		}
	}

	public static boolean processSale(Stock sale, ArrayList<Stock> stockList,
			int quantity, int stockIndex) {
		boolean inStock = false;
		for (int i = stockIndex; i < stockList.size(); i++) {
			if (sale.getName().equals(stockList.get(i).getName())) {
				if (stockList.get(i).getQuantity() > quantity) {
					stockList.get(i).setQuantity(
							stockList.get(i).getQuantity() - quantity);
					inStock = true;
					i = stockList.size();
				} else if (stockList.get(i).getQuantity() == quantity) {
					stockList.remove(stockList.get(i));
					inStock = true;
					i = stockList.size();

				} else {
					quantity -= stockList.get(i).getQuantity();
					stockList.remove(stockList.get(i));
					processSale(sale, stockList, quantity, i);
				}
			}

		}
		return inStock;
	}

	public static void checkSellBy(ArrayList<Stock> stockList) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date current = new Date();
		long diff;
		long diffDays;

		for (Stock temp : stockList) {
			diff = Math.abs(temp.getDate().getTime() - current.getTime());
			diffDays = diff / (24 * 60 * 60 * 1000);
			if (diffDays >= 3) {
				stockList.remove(temp);
			}
		}
	}

	public JPanel getPanel() {
		return stockPanel;
	}

}
