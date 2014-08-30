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
	private SaleFormPanel mainPanel;

	public SaleToolbar() {
		createSale = new JButton("Add Sale");
		viewSale = new JButton("View Sales");

		createSale.addActionListener(this);
		viewSale.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));
		setBorder(BorderFactory.createEtchedBorder());

		add(createSale);
		add(viewSale);
	}

	public void setMainPanel(SaleFormPanel formPanel) {
		this.mainPanel = formPanel;
	}

	public void actionPerformed(ActionEvent e) {
		try {
			JButton clicked = (JButton) e.getSource();
			if (clicked == createSale) {
				mainPanel.removeAll();
				mainPanel.createCustomerPanel();
				mainPanel.validate();
				mainPanel.repaint();
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
