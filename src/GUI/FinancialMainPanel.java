package GUI;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import model.Model;

public class FinancialMainPanel {
	private JPanel mainPanel;
	private FinancialToolbar profitToolbar;
	private FinancialFormPanel profitFormPanel;
	private Model model;
	
	public FinancialMainPanel() throws IOException{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		
		profitToolbar = new FinancialToolbar();
		profitFormPanel = new FinancialFormPanel();	
		model = new Model();
		
		profitToolbar.setFormPanel(profitFormPanel);
		
		mainPanel.add(profitFormPanel, BorderLayout.WEST);
		mainPanel.add(profitToolbar, BorderLayout.NORTH);
		mainPanel.setSize(600, 500);
	}
	
	public JPanel getPanel(){
		return mainPanel;
		
	}
}

