package GUI;
import java.awt.BorderLayout;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;

public class SaleController extends JFrame {
	
	private JButton button;
	private SaleTextPanel textPanel;
	private  SaleToolbar toolbar;
	private SaleFormPanel formPanel;
	private String[] items;
	private JComboBox comboBox;

	public SaleController() throws IOException {
		super("Sale GUI");
		setLayout(new BorderLayout());
		
		toolbar = new SaleToolbar();
		button = new JButton("Enter");
		textPanel = new SaleTextPanel();
		formPanel = new SaleFormPanel();
		
		toolbar.setStringListener(new SaleStringListener() {

			public void textEmitted(String text) {
				textPanel.appendText(text);
			}
			
		});
		
		formPanel.setFormListener(new SaleFormListener(){
			public void formEventOccurred(SaleFormEvent e) {
				int customerId = e.getCustomerId();
				
				textPanel.appendText(Integer.toString(customerId) + "\n");
			}
		});
		
		add(toolbar,BorderLayout.NORTH);
		//add(button, BorderLayout.SOUTH);
		add(textPanel,BorderLayout.CENTER); 
		add(formPanel,BorderLayout.WEST);
		
		/*
		button.addActionListener( new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				textPanel.appendText("Button Pressed DEEGUI\n");
			}
         });
        */
		/*
        ShopNoGUI shop = new ShopNoGUI();
        
        items=new String[shop.getStocks().size()];
                
                 for (int i=0; i < shop.getStocks().size(); i++) {
                		 items[i] = shop.getStocks().get(i).getName() + "   " + shop.getStocks().get(i).getCustomerPrice();	 
                 }
                 
                 
         comboBox = new JComboBox(items);
		*/
		setSize(800,800); //set frames size in pixels
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
	}

}
