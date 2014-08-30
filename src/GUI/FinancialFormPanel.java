package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Model;
import model.Order;
import model.Sale;

public class FinancialFormPanel extends JPanel {
	private JButton todayBtn, dailyBtn, weeklyBtn, monthlyBtn;
	private CustomerFormListener customerFormListener;
	private FinancialFormListener listener;
	private Model model;

	private ArrayList<Sale> sales;
	private ArrayList<Order> orders;

	public FinancialFormPanel() {

	}

	public void setSaleData(ArrayList<Sale> sales) {
		this.sales = sales;
	}

	public void setOrderData(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public void setFinancialFormListener(FinancialFormListener listener) {
		this.listener = listener;
	}

	// ////////////////////Sales////////////////////////

	public void SalesFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		todayBtn = new JButton("Todays sales");
		weeklyBtn = new JButton("This weeks sales");
		monthlyBtn = new JButton("This Months sales");

		todayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.todaySaleSelected();
			}
		});

		weeklyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.weekSaleSelected();
			}
		});

		monthlyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.monthSaleSelected();
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Sales");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(todayBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(weeklyBtn, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1000000;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(monthlyBtn, gc);
	}

	// ////////////////////Expenditures////////////////////////

	public void ExpendituresFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		todayBtn = new JButton("Todays expenditures");
		weeklyBtn = new JButton("This weeks expenditures");
		monthlyBtn = new JButton("This Months expenditures");

		Border innerBorder = BorderFactory.createTitledBorder("Sales");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(todayBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(weeklyBtn, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1000000;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(monthlyBtn, gc);
	}

	// ////////////////////Profit////////////////////////

	public void ProfitFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		todayBtn = new JButton("Todays profit");
		weeklyBtn = new JButton("This weeks profit");
		monthlyBtn = new JButton("This Months profit");

		Border innerBorder = BorderFactory.createTitledBorder("Sales");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(todayBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(weeklyBtn, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1000000;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(monthlyBtn, gc);
	}
}
