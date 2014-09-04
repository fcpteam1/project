package GUI;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import model.Model;
import model.Stock;

public class StockMainPanel extends JPanel {
	private JPanel mainPanel;
	private StockToolbar stockToolbar;
	private StockFormPanel stockFormPanel;
	private StockTablePanel stockTablePanel;
	private Model model;
	
	public StockMainPanel() throws IOException{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		stockToolbar = new StockToolbar();
		stockFormPanel = new StockFormPanel();
		stockTablePanel = new StockTablePanel();
		model = new Model();
		
		stockToolbar.setFormPanel(stockFormPanel);
		
		stockToolbar.setStockToolbarListener(new StockToolbarListener(){

			@Override
			public void viewAll() {
				stockFormPanel.removeAll();
				stockTablePanel.setData(model.getShop().getUniqueStockList());
				stockFormPanel.viewAllPanel();
				stockTablePanel.setModel(1);
				stockFormPanel.validate();
				stockFormPanel.repaint();
			}

			@Override
			public void viewByDate() {
				stockFormPanel.removeAll();
				stockTablePanel.setData(model.getShop().getStock());
				stockFormPanel.viewByDatePanel();
				stockTablePanel.setModel(2);
				stockFormPanel.validate();
				stockFormPanel.repaint();
			}

			@Override
			public void viewPredictions() {
				stockFormPanel.removeAll();
				stockFormPanel.predictionsPanel();
				stockTablePanel.setModel(3);
				stockFormPanel.validate();
				stockFormPanel.repaint();
			}
			
		});
		
		stockTablePanel.setFormPanel(stockFormPanel);
		stockTablePanel.setData(model.getShop().getUniqueStockList());
		
		stockTablePanel.setListener(new StockTableListener(){
			@Override
			public void editPrice(StockFormEvent e) {
				model.getShop().setEditedStockName(e.getName());
				model.getShop().setEditedStockPrice(e.getPrice());
				stockFormPanel.removeAll();
				stockFormPanel.editPanel(e);
				stockTablePanel.refresh();
			}
		});
		
		stockFormPanel.setData(model.getShop().getStock());
		
		stockFormPanel.setListener(new StockFormListener(){
			public void editPriceOccurred(StockFormEvent ev) {
				model.getShop().setEditedStockName(ev.getName());
				model.getShop().setEditedStockPrice(ev.getPrice());
				model.getShop().editCustomerPrice();
				stockTablePanel.setData(model.getShop().getUniqueStockList());
				stockTablePanel.setModel(1);
				stockTablePanel.refresh();
			}

			@Override
			public void predictWeekOccurredd() {
				Object data[][];
				int count = 0;
				int[] result = new int[5];
				data = new Object[model.getShop().getUniqueStockList().size()][6];
				for (Stock stock : model.getShop().getUniqueStockList()) {
					result = model.getShop().getPredictor().stockPredictor(model.getShop().getSales(), stock, true);
					data[count][0] = stock.getName();
					data[count][1] = result[0];
					data[count][2] = result[1];
					data[count][3] = result[2];
					data[count][4] = result[3];
					data[count][5] = result[4];
					System.out.println(count);
					count++;
				}
				stockTablePanel.setPredictionRowCount(model.getShop().getUniqueStockList().size());
				stockTablePanel.setPredictData(data);
				stockTablePanel.setPredictionColumns(2);
				stockTablePanel.setModel(3);
				stockTablePanel.refresh();
			}

			@Override
			public void predictMonthOccurredd() {
				Object data[][];
				int count = 0;
				int[] result = new int[5];
				data = new Object[model.getShop().getUniqueStockList().size()][6];
				for (Stock stock : model.getShop().getUniqueStockList()) {
					result = model.getShop().getPredictor().stockPredictor(model.getShop().getSales(), stock, false);
					data[count][0] = stock.getName();
					data[count][1] = result[0];
					data[count][2] = result[1];
					data[count][3] = result[2];
					data[count][4] = result[3];
					data[count][5] = result[4];
					count++;
				}
				stockTablePanel.setPredictionRowCount(model.getShop().getUniqueStockList().size());
				stockTablePanel.setPredictData(data);
				stockTablePanel.setPredictionColumns(1);
				stockTablePanel.setModel(3);
				stockTablePanel.refresh();
			}
		});
		
		mainPanel.add(stockFormPanel, BorderLayout.WEST);
		mainPanel.add(stockToolbar, BorderLayout.NORTH);
		mainPanel.add(stockTablePanel, BorderLayout.CENTER);
	}
	
	public JPanel getPanel(){
		return mainPanel;
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

}
