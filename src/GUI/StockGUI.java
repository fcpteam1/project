package GUI;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Model;
import model.Stock;
 
 
public class StockGUI extends JPanel {
	private JTextArea textArea;
	private JButton viewStockBtn;
	private JPanel stockPanel;
	private Model stockModel;
	 
    public StockGUI()
    {
    	
            textArea = new JTextArea(5, 20);
            stockPanel= new JPanel ();
            stockPanel.setSize(500,600);
             
            stockPanel.setLayout(new BorderLayout());
             
            viewStockBtn = new JButton ("View Stock");
             
            stockPanel.add(textArea);
 
            stockPanel.add(viewStockBtn,BorderLayout.NORTH);
             
            viewStockBtn.addActionListener(new ActionListener ()
            {
                public void actionPerformed(ActionEvent arg0) 
                {
                    Map <String , Integer> stockLevels= stockModel.getStock().stockLevels();
                    textArea.append("Stock Levels:");
                    for(Map.Entry<String, Integer > current : stockLevels.entrySet()) 
                    {
                        textArea.append("\n"+current.getKey()+": "+ current.getValue());
                    }
                    textArea.append("\n*********************************");
                }
                 
            });
    }
     
    public JPanel getPanel (){
        return stockPanel;
    }
 
}