package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SaleToolbar extends JPanel implements ActionListener {
	private JButton createSale, viewSale;
	private SaleFormPanel mainPanel;
	private SaleTablePanel tablePanel;
	private JLabel instruction;

	public SaleToolbar() {
		createSale = new JButton("Create\\Edit Sale");
		viewSale = new JButton("View Sales");
		instruction = new JLabel(
				"Right click table to delete and list Products, edit function enabled in Create\\Edit Sale");

		createSale.addActionListener(this);
		viewSale.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createEtchedBorder());

		add(createSale);
		add(viewSale);
		add(instruction);
	}

	public void setMainPanel(SaleFormPanel formPanel) {
		this.mainPanel = formPanel;
	}

	public void setTablePanel(SaleTablePanel tablePanel) {
		this.tablePanel = tablePanel;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			JButton clicked = (JButton) e.getSource();
			if (clicked == createSale) {
				mainPanel.removeAll();
				mainPanel.createCustomerPanel();
				mainPanel.validate();
				mainPanel.repaint();
			} else if (clicked == viewSale) {
				mainPanel.setVisible(false);
				tablePanel.refresh();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
