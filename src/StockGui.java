import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import test.Stock;


public class StockGui {
	public static void main (String []  args)
	{
		new StockGui();
	}
	
	public void StockGui()
	{
		 	textArea = new JTextArea(5, 20);
			JPanel stockPanel= new JPanel ();
			stockPanel.setSize(500,600);
			
			stockPanel.setLayout(new BorderLayout());
			
			viewStockBtn = new JButton ("View Stock");
			
			stockPanel.add(textArea);

			stockPanel.add(viewStockBtn,BorderLayout.NORTH);
			
			viewStockBtn.addActionListener(new ActionListener ()
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					Map <String , Integer> stockLevels= Stock.stockLevels(stockList);
					textArea.append("Stock Levels:");
					for(Map.Entry<String, Integer > current : stockLevels.entrySet()) 
					{
						textArea.append("\n"+current.getKey()+": "+ current.getValue());
					}
					textArea.append("\n*********************************");
				}
				
			});
	}
	
	public JPanel getPanel ()
	{
		return stockPanel;
	}

}
