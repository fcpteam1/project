package GUI;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class OrderToolbar extends JPanel implements ActionListener {

	private JButton allButton;
	private JButton createButton;
	private JButton currentButton;
	private JButton previousButton;
	private OrderFormPanel formPanel;
	private OrderToolbarListener listener;

	public OrderToolbar() {
		setBorder(BorderFactory.createEtchedBorder());
		createButton = new JButton("Create");
		allButton = new JButton("All");
		currentButton = new JButton("Current");
		previousButton = new JButton("Previous");

		createButton.addActionListener(this);
		allButton.addActionListener(this);
		currentButton.addActionListener(this);
		previousButton.addActionListener(this);

		setLayout(new FlowLayout(FlowLayout.LEFT));

		add(createButton);
		add(allButton);
		add(currentButton);
		add(previousButton);
	}

	public void setFormPanel(OrderFormPanel formPanel) {
		this.formPanel = formPanel;
	}

	public void setOrderToolbarListener(OrderToolbarListener listener) {
		this.listener = listener;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == createButton) {
			formPanel.removeAll();
			listener.createOrder();
			formPanel.validate();
			formPanel.repaint();
		}
		if (clicked == allButton) {
			formPanel.removeAll();
			listener.showAll();
			formPanel.validate();
			formPanel.repaint();
		}
		if (clicked == currentButton) {
			formPanel.removeAll();
			listener.showCurrent();
			formPanel.validate();
			formPanel.repaint();
		}
		if (clicked == previousButton) {
			formPanel.removeAll();
			listener.showPrevious();
			formPanel.validate();
			formPanel.repaint();
		}
	}

}
