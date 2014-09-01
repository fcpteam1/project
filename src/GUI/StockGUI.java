package GUI;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import model.Model;
import model.Stock;

public class StockGUI extends JPanel {

	private JTextArea textArea;
	private JButton viewStockBtn, checkSellByBtn;
	private JPanel stockPanel;
	private static Model model;

	public StockGUI() throws IOException {

		textArea = new JTextArea(5, 20);
		stockPanel = new JPanel(new GridBagLayout());
		stockPanel.setSize(500, 600);
		JScrollPane scrollPane = new JScrollPane(textArea);

		model = new Model();
		GridBagConstraints c = new GridBagConstraints();

		viewStockBtn = new JButton("View Stock");
		checkSellByBtn = new JButton("Remove Out of Date Items");

		c.insets = new Insets(0, 0, 0, 0); // top padding
		c.anchor = GridBagConstraints.NORTH;
		c.weightx = 0.75;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		stockPanel.add(viewStockBtn, c);

		c.insets = new Insets(0, 0, 0, 0); // top padding
		c.anchor = GridBagConstraints.NORTH;
		c.weightx = 0.25;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 4;
		c.gridy = 0;
		stockPanel.add(checkSellByBtn, c);

		c.anchor = GridBagConstraints.NORTH;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 300;
		c.weighty = 1;
		c.gridwidth = 20;
		c.gridheight = 20;

		c.gridx = 0;
		c.gridy = 1;

		stockPanel.add(scrollPane, c);

		viewStockBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Map<String, Integer> stockLevels = stockLevels();
				textArea.setText(null);
				for (Map.Entry<String, Integer> current : stockLevels
						.entrySet()) {
					textArea.append("\n" + current.getKey() + ": "
							+ String.valueOf(current.getValue()));
				}

			}
		});

		checkSellByBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				checkSellBy();
				viewStockBtn.doClick();
			}
		});
	}

	public static Map<String, Integer> stockLevels() {
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
					stockLevels.put(
							model.getShop().getStock().get(i).getName(),
							quantity);
				}

			}
		}
		return stockLevels;
	}

	public static ArrayList<Stock> checkStock(ArrayList<Stock> saleList,
			ArrayList<Stock> stockList) {
		printArray(saleList);

		for (Stock temp : saleList) {
			if (!processSale(temp, stockList, 0)) {
				System.out.println("Out of Stock Item: "
						+ temp.getProduct().getName());
				if (saleList.get(saleList.size() - 1) == temp) {
					saleList.remove(temp);
					break;
				} else {
					saleList.remove(temp);
				}
			}
		}
		printArray(saleList);
		return saleList;
	}

	public static boolean processSale(Stock saleItem,
			ArrayList<Stock> stockList, int stockIndex) {
		System.out.println("Processing");
		boolean inStock = false;
		for (int i = stockIndex; i < stockList.size(); i++) {
			int quantity = saleItem.getQuantity();
			String name = saleItem.getProduct().getName();
			if (name.equals(stockList.get(i).getName())) {
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
					processSale(saleItem, stockList, i);
				}
			}

		}
		return inStock;
	}

	public void checkSellBy() {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date current = new Date();
		long diff;
		long diffDays;

		for (Stock temp : model.getShop().getStock()) {
			diff = Math.abs(temp.getDate().getTime() - current.getTime());
			diffDays = diff / (24 * 60 * 60 * 1000);
			if (diffDays >= 3) {
				model.getShop().getStock().remove(temp);
			}
		}
	}

	public JPanel getPanel() {
		return stockPanel;
	}

	public static void printArray(ArrayList<Stock> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println("LIST: " + list.get(0).getName());
		}
	}

}