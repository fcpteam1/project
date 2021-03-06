package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

//Toolbar that listens for button selection within finance tab
public class FinancialToolbar extends JPanel implements ActionListener {
	private JButton saleButton;
	private JButton profitButton;
	private JButton expenditureButton;
	private FinancialToolbarListener listener;

	private FinancialFormPanel formPanel;

	public FinancialToolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		saleButton = new JButton("Sales");
		expenditureButton = new JButton("Expenditures");
		profitButton = new JButton("Profit");

		saleButton.addActionListener(this);
		expenditureButton.addActionListener(this);
		profitButton.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(saleButton);
		add(expenditureButton);
		add(profitButton);

	}

	public void setFormPanel(FinancialFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void setFinancialToolbarListener(FinancialToolbarListener listener) {
		this.listener = listener;
	}

	//set the view based on the button clicked
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == saleButton) {
			listener.saleSelected();
		} else if (clicked == expenditureButton) {
			listener.expendituresSelected();
		} else if (clicked == profitButton) {
			listener.profitsSelected();
		}
	}
}
