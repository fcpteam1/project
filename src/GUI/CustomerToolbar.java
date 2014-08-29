package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class CustomerToolbar extends JPanel implements ActionListener {
	private JButton createButton;
	private CustomerFormPanel formPanel;

	public CustomerToolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		createButton = new JButton("Create");

		createButton.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(createButton);

	}

	public void setFormPanel(CustomerFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();

		if (clicked == createButton) {
			formPanel.removeAll();
			formPanel.CreateFormPanel();
			formPanel.validate();
			formPanel.repaint();
		}
	}
}
