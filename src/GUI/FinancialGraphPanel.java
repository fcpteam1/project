package GUI;

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
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Model;
import model.User;

public class FinancialGraphPanel extends JPanel {

	
	private JButton barChartBtn, pieChartBtn, lineChartMonthBtn;
	private Model model;
	
	public FinancialGraphPanel() {

	}


	// ////////////////////GraphSaleBtnLayout////////////////////////

	public void saleGraphPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		barChartBtn = new JButton("Bar Chart");
		pieChartBtn = new JButton("Pie Chart");
		lineChartMonthBtn = new JButton("Line Chart");
		
		barChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});
		
		pieChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});

		lineChartMonthBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});


		Border innerBorder = BorderFactory.createTitledBorder("Graphs");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(barChartBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(pieChartBtn, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(lineChartMonthBtn, gc);
	}

	// ////////////////////GraphExpenseBtnLayout////////////////////////
	
	public void expenseGraphPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		barChartBtn = new JButton("Bar Chart");
		pieChartBtn = new JButton("Pie Chart");
		lineChartMonthBtn = new JButton("Line Chart");
		
		barChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});
		
		pieChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});

		lineChartMonthBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});


		Border innerBorder = BorderFactory.createTitledBorder("Graphs");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(barChartBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(pieChartBtn, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(lineChartMonthBtn, gc);
	}
	
	// ////////////////////GraphProfitBtnLayout////////////////////////
	
	public void profitGraphPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		barChartBtn = new JButton("Bar Chart");
		pieChartBtn = new JButton("Pie Chart");
		lineChartMonthBtn = new JButton("Line Chart");
		
		barChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});
		
		pieChartBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});

		lineChartMonthBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}

		});


		Border innerBorder = BorderFactory.createTitledBorder("Graphs");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(barChartBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(pieChartBtn, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(lineChartMonthBtn, gc);
	}
}
