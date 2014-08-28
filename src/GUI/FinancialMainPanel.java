package GUI;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import model.Model;

public class FinancialMainPanel {
	private JPanel mainPanel;
	private FinancialToolbar financialToolbar;
	private FinancialFormPanel profitFormPanel;
	private FinancialTablePanel financialTablePanel;
	private FinancialTableModel financialTableModel;
	private Model model;
	
	public FinancialMainPanel() throws IOException{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		financialTableModel = new FinancialTableModel();
		financialTablePanel = new FinancialTablePanel();
		financialToolbar = new FinancialToolbar();
		profitFormPanel = new FinancialFormPanel();	
		model = new Model();
		
		financialToolbar.setFormPanel(profitFormPanel);
		financialToolbar.setFinancialToolbarListener(new FinancialToolbarListener(){

			@Override
			public void saleSelected() {
				//financialTablePanel.setData();
			}

			@Override
			public void expendituresSelected() {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void profitsSelected() {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		mainPanel.add(profitFormPanel, BorderLayout.WEST);
		mainPanel.add(financialToolbar, BorderLayout.NORTH);
		mainPanel.setSize(600, 500);
	}
	
	public JPanel getPanel(){
		return mainPanel;
		
	}
}

