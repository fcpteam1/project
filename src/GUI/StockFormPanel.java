package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Stock;
import model.Supplier;

public class StockFormPanel extends JPanel {
	
	private JLabel newPriceLabel;
	private JTextField newPriceField;
	private JButton confirmBtn;
	private ArrayList<Stock> stock;
	private StockFormListener listener;
	private double price;
	private String name;
	private JButton predictNextWeek;
	private JButton predictNextMonth;
	private JButton viewCurrentLowStock;
	private JButton viewWeekLowStock;
	private JButton viewMonthLowStock;
	
	public StockFormPanel(){
		
	}
	
	public void viewAllPanel(){
		setVisible(false);
	}
	
	public void viewByDatePanel(){
		setVisible(false);
	}
	
	public void editPanel(StockFormEvent e){

		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Edit Price");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setVisible(true);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		name = e.getName();
		newPriceLabel = new JLabel("New Price for "+ name);
		newPriceField = new JTextField(3);
		confirmBtn = new JButton("Confirm");
		confirmBtn.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(!newPriceField.getText().equals("")){
					try{
						price = Double.valueOf(newPriceField.getText());
					}
					catch(NumberFormatException nfEx){
						System.out.println("Not a valid amount");
					}
					if(listener!=null){
						StockFormEvent ev = new StockFormEvent(this, name, price);
						listener.editPriceOccurred(ev);
					}
					setVisible(false);
				}
			}
		});

		// First Row
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(newPriceLabel, gc);

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(newPriceField, gc);

		// Next Row
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 1;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(confirmBtn, gc);

		this.validate();
		this.repaint();
	}
	
	public void predictionsPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Predictions");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setVisible(true);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		predictNextWeek = new JButton("Estimate next Week");
		predictNextMonth = new JButton("Estimate next Month");
		
		predictNextWeek.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(listener!=null){
					listener.predictWeekOccurredd();
				}
			}
		});
		
		predictNextMonth.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(listener!=null){
					listener.predictMonthOccurredd();
				}
			}
		});

		// First Row
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(predictNextWeek, gc);

		// Next Row
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(predictNextMonth, gc);

		this.validate();
		this.repaint();
	}
	
	
	public void	viewLowStockPanel(){
		Dimension dim = getPreferredSize();
		dim.width = 300;
		setPreferredSize(dim);
		Border innerBorder = BorderFactory.createTitledBorder("Low Stock");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));
		setVisible(true);
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		
		viewCurrentLowStock = new JButton("Current Low Stock");
		viewWeekLowStock = new JButton("Est Next Wk. Low Stock");
		viewMonthLowStock = new JButton("Est Next Mth. Low Stock");
		
		viewCurrentLowStock.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(listener!=null){
					listener.viewCurrentLowStock();
				}
			}
		});
		
		viewWeekLowStock.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(listener!=null){
					listener.viewWeekLowStock();
				}
			}
		});
		
		viewMonthLowStock.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				if(listener!=null){
					listener.viewMonthLowStock();
				}
			}
		});

		// First Row
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 5);
		add(viewCurrentLowStock, gc);

		// Next Row
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(viewWeekLowStock, gc);

		
		gc.gridy++;
		gc.weightx = 1;
		gc.weighty = 0.1;

		gc.gridx = 0;
		gc.insets = new Insets(0, 0, 0, 0);
		gc.anchor = GridBagConstraints.LINE_START;
		add(viewMonthLowStock, gc);
		this.validate();
		this.repaint();
	}
	
	public void setData(ArrayList<Stock> stock){
		this.stock = stock;
	}

	public StockFormListener getListener() {
		return listener;
	}

	public void setListener(StockFormListener listener) {
		this.listener = listener;
	}
	
}
