package GUI;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FinancialTextPanel extends JPanel {

	private JTextArea textArea;
	private JButton finalSaleButton;

	public FinancialTextPanel() {
		textArea = new JTextArea();
		textArea.append("Product and Quantity Selected: \n\n");
		
		setLayout(new BorderLayout());

		add(new JScrollPane(textArea), BorderLayout.CENTER);
	}
	
	public void clearText(){
		textArea.removeAll();
	}

	public void appendText(String text) {
		textArea.append(text);
	}
	
}