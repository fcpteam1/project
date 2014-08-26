package GUI;

import java.awt.BorderLayout;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Model;
import model.Stock;


public class SaleMainPanel extends JFrame {
	
	private JPanel mainPanel;
	private SaleToolbar toolBar;
	private SaleTextPanel textPanel;
	private SaleFormPanel formPanel;
	private SaleTablePanel tablePanel;
	private Model model;
	
	public  SaleMainPanel() throws IOException {		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());

		toolBar = new SaleToolbar();
		formPanel = new SaleFormPanel();
		tablePanel = new SaleTablePanel();
		textPanel = new SaleTextPanel();
		model = new Model();
		
		toolBar.setMainPanel(formPanel);
		tablePanel.setFormPanel(formPanel);
		formPanel.setData(model.getShop().getStock(), model.getShop().getCustomers());
		tablePanel.setData(model.getShop().getSales());
		
		mainPanel.add(toolBar, BorderLayout.NORTH);
		mainPanel.add(formPanel, BorderLayout.WEST );
		mainPanel.add(tablePanel, BorderLayout.EAST);
		mainPanel.add(textPanel, BorderLayout.CENTER);
		
		
		formPanel.setFormListener(new SaleFormListener () {

			public void createSaleOccurred(SaleFormEvent e) {
						
				model.getShop().createSale(e);	
				System.out.println(model.getShop().getSales().get(0).getTotalPrice());		
				tablePanel.refresh();
				ArrayList<Stock> stockItems = e.getStockList();
					for (int i=0; i < stockItems.size(); i++) {
						textPanel.appendText(stockItems.get(i).getName() + "  Quantity: " + stockItems.get(i).getQuantity()+ "\n");
					}
				textPanel.appendText("\n------Sale Complete-------\n");
			}
		});
	}
	
	
	
	public SaleTextPanel getTextPanel() {
		return textPanel;
	}

	public void setTextPanel(SaleTextPanel textPanel) {
		this.textPanel = textPanel;
	}

	public JPanel getPanel(){
		return mainPanel;
	}
}
