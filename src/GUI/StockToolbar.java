package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class StockToolbar extends JPanel implements ActionListener {
	private JButton allBtn;
	private JButton byDateBtn;
	private JButton predictionBtn;
	private JButton stockBarChartBtn;
	private JButton lowStockBtn;
	private StockFormPanel formPanel;
	private StockToolbarListener listener;
	
	public StockToolbar(){
		setBorder(BorderFactory.createEtchedBorder());
		allBtn = new JButton("View All");
		byDateBtn = new JButton("View By Date");
		predictionBtn = new JButton("Predictions");
		lowStockBtn=new JButton("Low Stock");
		stockBarChartBtn = new JButton("Stock Chart");
		
		stockBarChartBtn.addActionListener(this);
		allBtn.addActionListener(this);
		byDateBtn.addActionListener(this);
		lowStockBtn.addActionListener(this);
		predictionBtn.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(allBtn);
		add(byDateBtn);
		add(predictionBtn);
		add(lowStockBtn);
		add(stockBarChartBtn);
	}
	
	public void setFormPanel(StockFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void setStockToolbarListener(StockToolbarListener listener) {
		this.listener= listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == allBtn) {
			formPanel.removeAll();
			getListener().viewAll();
			formPanel.validate();
			formPanel.repaint();
		}
		if (clicked == byDateBtn) {
			formPanel.removeAll();
			getListener().viewByDate();
			formPanel.validate();
			formPanel.repaint();
		}
		if (clicked == predictionBtn) {
			formPanel.removeAll();
			getListener().viewPredictions();
			formPanel.validate();
			formPanel.repaint();
		}
		if (clicked == stockBarChartBtn) {
			getListener().stockGraph();
		}
		
		if (clicked == lowStockBtn) {
			formPanel.removeAll();
			getListener().viewLowStock();
			formPanel.validate();
			formPanel.repaint();
		}
	}

	public StockToolbarListener getListener() {
		return listener;
	}

}