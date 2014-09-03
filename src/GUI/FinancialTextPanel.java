package GUI;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FinancialTextPanel extends JPanel {

	//private JTextArea textArea;
	private JLabel totalPriceLabel;
	private JTextField totalPriceField;
	private double totalPrice;

	public FinancialTextPanel() {
		totalPriceLabel = new JLabel("Total Price: ");
		totalPriceField = new JTextField(20);
		
		Border innerBorder = BorderFactory.createTitledBorder("");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		// /////// First row ////////

				gc.gridy = 0;

				gc.weightx = 1;
				gc.weighty = .1;

				gc.gridx = 0;
				gc.fill = GridBagConstraints.NONE;
				gc.anchor = GridBagConstraints.FIRST_LINE_START;
				gc.insets = new Insets(0, 0, 0, 0);
				add(totalPriceLabel, gc);
				
				gc.gridx = 0;
				gc.gridy = 100;
				gc.anchor = GridBagConstraints.FIRST_LINE_START;
				gc.insets = new Insets(0, 0, 0, 0);
				add(totalPriceField, gc);
	}
	
	

	public void getTotal(double totalPrice) {
		this.totalPrice = totalPrice;
		System.out.println(totalPrice);
		totalPriceField.setText(String.valueOf(totalPrice));
	}
	
}