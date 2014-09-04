package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class StockToolbar extends JPanel implements ActionListener {
	private JButton allBtn;
	private JButton byDateBtn;
	private JButton predictionBtn;
	private StockFormPanel formPanel;
	private StockToolbarListener listener;
	
	public StockToolbar(){
		setBorder(BorderFactory.createEtchedBorder());
		allBtn = new JButton("View All");
		byDateBtn = new JButton("View By Date");
		predictionBtn = new JButton("Predictions");

		allBtn.addActionListener(this);
		byDateBtn.addActionListener(this);
		predictionBtn.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(allBtn);
		add(byDateBtn);
		add(predictionBtn);
	}
	
	public void setFormPanel(StockFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void setStockToolbarListener(StockToolbarListener listener) {
		this.listener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == allBtn) {
			formPanel.removeAll();
			listener.viewAll();
			formPanel.validate();
			formPanel.repaint();
		}
		if (clicked == byDateBtn) {
			formPanel.removeAll();
			listener.viewByDate();
			formPanel.validate();
			formPanel.repaint();
		}
		if (clicked == predictionBtn) {
			formPanel.removeAll();
			listener.viewPredictions();
			formPanel.validate();
			formPanel.repaint();
		}
	}
}
