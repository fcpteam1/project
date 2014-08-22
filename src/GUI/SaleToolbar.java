package GUI;
import java.awt.FlowLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SaleToolbar extends JPanel implements ActionListener {
	private JButton helloBut;
	private JButton goodbyeBut;
	private SaleStringListener  textListener;
	
	public SaleToolbar()  {
		helloBut = new JButton("Hello");
		goodbyeBut = new JButton("BYe");
		
		helloBut.addActionListener(this);
		goodbyeBut.addActionListener(this);
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(helloBut);
		add(goodbyeBut);
	}
	
	public void setStringListener(SaleStringListener listener) {
			this.textListener = listener;
	}
		
	public void actionPerformed(ActionEvent event) {
		JButton clicked = (JButton)event.getSource();
			if (clicked == helloBut) {
				if(textListener != null){
					textListener.textEmitted("Hello\n");
				}
			}
			else {
				if(textListener != null){
					textListener.textEmitted("Bye\n");
				}
			}
	}

}
