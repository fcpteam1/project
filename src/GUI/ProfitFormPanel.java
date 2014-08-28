package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Model;

public class ProfitFormPanel extends JPanel {
	private JButton todayBtn,dailyBtn,weeklyBtn,monthlyBtn;
	private CustomerFormListener customerFormListener; 
	private Model model;
	
	/*private ArrayList<sales> sales;
	private ArrayList<Profit> profits;
	private ArrayList<Expendature> expendatures;*/
	
	public ProfitFormPanel(){
		
	}
	
	/*public void setSaleData(ArrayList<sales> sales) {
		this.sales = sales;
	}
	
	public void setProfitData(ArrayList<Profit> profits) {
		this.profits = profits;
	}
	
	public void setExpendatureData(ArrayList<Expendature> expendatures) {
		this.expendatures = expendatures;
	}*/
	

	
//////////////////////Sales////////////////////////
	
	public void SalesFormPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
	
		
		todayBtn = new JButton("Todays sales");
		dailyBtn = new JButton ("Daily sales");
		weeklyBtn = new JButton ("Weekly sales");
		monthlyBtn = new JButton ("Monthly sales");
				
		
		/*submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String number = numberField.getText();
				String address = addressField.getText(); 
				
				CustomerFormEvent ev = new CustomerFormEvent(this, name, number, address);
				
				if(customerFormListener != null){
					customerFormListener.formEventOccurred(ev);
				}
			}
			
		});
		*/
		
		
		Border innerBorder = BorderFactory.createTitledBorder("Sales");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();
		
		///////// First row ////////
		
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(todayBtn, gc);
		
		///////// Second row ////////
		
		gc.gridy ++;
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(dailyBtn, gc);
		
		///////// Third row /////////
		
		gc.gridy ++;
		
		gc.weightx = 1;
		gc.weighty = 1;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(weeklyBtn, gc);
		
		///////// Fifth row ////////
		
		gc.gridy ++;
		
		gc.weightx = 1;
		gc.weighty = 2;
		
		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(monthlyBtn, gc);
	}


//////////////////////Expenditures////////////////////////

public void ExpendituresFormPanel(){
Dimension dim = getPreferredSize();
dim.width = 250;
setPreferredSize(dim);




todayBtn = new JButton("Todays expenditures");
dailyBtn = new JButton ("Daily expenditures");
weeklyBtn = new JButton ("Weekly expenditures");
monthlyBtn = new JButton ("Monthly expenditures");


/*submitBtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String name = nameField.getText();
String number = numberField.getText();
String address = addressField.getText(); 

CustomerFormEvent ev = new CustomerFormEvent(this, name, number, address);

if(customerFormListener != null){
customerFormListener.formEventOccurred(ev);
}
}

});
*/


Border innerBorder = BorderFactory.createTitledBorder("Sales");
Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

setLayout(new GridBagLayout());

GridBagConstraints gc = new GridBagConstraints();

///////// First row ////////

gc.gridy = 0;
gc.weightx = 1;
gc.weighty = 2;

gc.gridx = 1;
gc.anchor = GridBagConstraints.FIRST_LINE_START;
add(todayBtn, gc);

///////// Second row ////////

gc.gridy ++;

gc.weightx = 1;
gc.weighty = 2;

gc.gridx = 1;
gc.anchor = GridBagConstraints.FIRST_LINE_START;
add(dailyBtn, gc);

///////// Third row /////////

gc.gridy ++;

gc.weightx = 1;
gc.weighty = 2;

gc.gridx = 1;
gc.anchor = GridBagConstraints.FIRST_LINE_START;
add(weeklyBtn, gc);

///////// Fifth row ////////

gc.gridy ++;

gc.weightx = 1;
gc.weighty = 2;

gc.gridx = 1;
gc.anchor = GridBagConstraints.FIRST_LINE_START;
add(monthlyBtn, gc);
}


//////////////////////Profit////////////////////////

public void ProfitFormPanel(){
Dimension dim = getPreferredSize();
dim.width = 250;
setPreferredSize(dim);




todayBtn = new JButton("Todays profits");
dailyBtn = new JButton ("Daily profit");
weeklyBtn = new JButton ("Weekly profit");
monthlyBtn = new JButton ("Monthly profit");


/*submitBtn.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
String name = nameField.getText();
String number = numberField.getText();
String address = addressField.getText(); 

CustomerFormEvent ev = new CustomerFormEvent(this, name, number, address);

if(customerFormListener != null){
customerFormListener.formEventOccurred(ev);
}
}

});
*/


Border innerBorder = BorderFactory.createTitledBorder("Sales");
Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

setLayout(new GridBagLayout());

GridBagConstraints gc = new GridBagConstraints();

///////// First row ////////

gc.gridy = 0;
gc.weightx = 1;
gc.weighty = 2;

gc.gridx = 1;
gc.anchor = GridBagConstraints.FIRST_LINE_START;
add(todayBtn, gc);

///////// Second row ////////

gc.gridy ++;

gc.weightx = 1;
gc.weighty = 2;

gc.gridx = 1;
gc.anchor = GridBagConstraints.FIRST_LINE_START;
add(dailyBtn, gc);

///////// Third row /////////

gc.gridy ++;

gc.weightx = 1;
gc.weighty = 2;

gc.gridx = 1;
gc.anchor = GridBagConstraints.FIRST_LINE_START;
add(weeklyBtn, gc);

///////// Fifth row ////////

gc.gridy ++;

gc.weightx = 1;
gc.weighty = 2;

gc.gridx = 1;
gc.anchor = GridBagConstraints.FIRST_LINE_START;
add(monthlyBtn, gc);
}

}

