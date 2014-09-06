package GUI;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class SaleTextPanel extends JPanel {

	private JTextArea textArea;
	private JButton finalSaleButton;

	public SaleTextPanel() {
		textArea = new JTextArea();
		textArea.setText("Product and Quantity Selected: \n\n");
		// finalSaleButton = new JButton("Place Sale");
		setLayout(new BorderLayout());

		add(new JScrollPane(textArea), BorderLayout.EAST);
		// add(finalSaleButton, BorderLayout.SOUTH);
	}

	public void setHeader ()
	{
		textArea.setText("Product and Quantity Selected: \n\n");
	}
	
	public void appendText(String text) {
		textArea.append(text);
	}
}