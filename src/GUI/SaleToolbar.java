package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class SaleToolbar extends JPanel implements ActionListener {
	private JButton createSale, viewSale;
	private SaleFormPanel formPanel;
	private SaleTablePanel tablePanel;

	public SaleToolbar() {
		createSale = new JButton("Create Sale");
		viewSale = new JButton("View Sales");

		createSale.addActionListener(this);
		viewSale.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createEtchedBorder());

		add(createSale);
		add(viewSale);
	}

	public void setMainPanel(SaleFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void setTablePanel(SaleTablePanel tablePanel) {
		this.tablePanel = tablePanel;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			JButton clicked = (JButton) e.getSource();
			if (clicked == createSale) {
				formPanel.removeAll();
				formPanel.createCustomerPanel();
				formPanel.validate();
				formPanel.repaint();
			} else if (clicked == viewSale) {
				formPanel.setVisible(false);
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

}
