package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WelcomeScreenGUI {
	private JPanel welcomePanel;
	private JButton switchToLoginPanelButton;
	private JButton exitButton;

	public WelcomeScreenGUI() throws IOException {

		GridBagConstraints gbc = new GridBagConstraints();

		welcomePanel = new JPanel();
		switchToLoginPanelButton = new JButton("Login");
		exitButton = new JButton("Exit");
		welcomePanel.setBackground(Color.DARK_GRAY);
		welcomePanel.setLayout(new GridBagLayout());
		BufferedImage storeLogo = ImageIO.read(new File(
				"src/images/storeLogoV3.png"));
		JLabel picLabel = new JLabel(new ImageIcon(storeLogo));

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0;
		gbc.weighty = 0;
		gbc.fill = GridBagConstraints.NONE;
		welcomePanel.add(picLabel, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_END;
		welcomePanel.add(switchToLoginPanelButton, gbc);

		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.anchor = GridBagConstraints.LINE_START;
		welcomePanel.add(exitButton, gbc);

		// adding animation to the switchToLoginPanelButton button
		/*switchToLoginPanelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				((JButton) e.getSource()).setEnabled(false);
				new Timer(1, new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						welcomePanel.setLocation(welcomePanel.getX() - 5, 0);
						if (welcomePanel.getX() + welcomePanel.getWidth() == 0) {
							((Timer) e.getSource()).stop();
							System.out.println("Timer stopped");
						}
					}
				}).start();
			}
		});*/
		/*exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});*/

	}

	public JPanel getWelcomePanel() {
		return welcomePanel;
	}

	public void setWelcomePanel(JPanel welcomePanel) {
		this.welcomePanel = welcomePanel;
	}

	public JButton getswitchToLoginPanelButton() {
		return switchToLoginPanelButton;
	}

	public void setswitchToLoginPanelButton(JButton switchToLoginPanelButton) {
		this.switchToLoginPanelButton = switchToLoginPanelButton;
	}

	public JButton getExit() {
		return exitButton;
	}

	public void setExit(JButton exit) {
		this.exitButton = exit;
	}

}
