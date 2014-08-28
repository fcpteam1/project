package GUI;

import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JPanel;

import model.Model;

public class ProfitMainPanel {
	private JPanel mainPanel;
	private ProfitToolbar profitToolbar;
	private ProfitFormPanel profitFormPanel;
	private Model model;
	
	public ProfitMainPanel() throws IOException{
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		
		
		profitToolbar = new ProfitToolbar();
		profitFormPanel = new ProfitFormPanel();	
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

