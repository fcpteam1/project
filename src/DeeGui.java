import javax.swing.*;
import java.awt.Container;

import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DeeGui extends JFrame implements ItemListener{
	private JList list; 
	private JPanel panel = new JPanel();
	private JButton button = new JButton("Enter");
	private JTextField quantityField = new JTextField(5);
	private JTextArea textArea = new JTextArea(2,15);
	private JComboBox comboBox; 
	private String[] items = {"apple 0.5","orange 0.5", "banana 0.2"};
	
	public DeeGui(){
			super("Sale GUI");
			setSize(400,400); //set frames size in pixels
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	                 
	                 list = new JList(items);
	                 comboBox = new JComboBox(items);
	                 comboBox.addItemListener(this);
	                 panel.add(list);
	                 panel.add(comboBox);
	                 panel.add(quantityField);
	                 panel.add(button);
	                 panel.add(textArea);
	                 Container cp = getContentPane();
		             cp.add(panel);
		             setVisible(true);             
	 }

	public void itemStateChanged(ItemEvent event) {
		
		
		if(event.getSource().equals(comboBox)){
			textArea.setText("item seleected");
		}
		
	}
	     
	  public static void main(String[] args){
	        DeeGui gui = new DeeGui();  
	  }         		
	           
	            
	            /*This is an inner class that acts as a listener
	            private class MyButtonListener implements ActionListener{

					public void actionPerformed(ActionEvent event) {
						System.out.println("Inner class listener handling this click!");
						
						if(event.getSource().equals(but1)){
							System.out.println("That was the first button");
						}
						else if(event.getSource().equals(but2)){
							System.out.println("That was the second button");
						}
						
					}
	            }*/

}



