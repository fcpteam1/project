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
import javax.swing.border.Border;

import model.Model;
import model.Order;
import model.Sale;

public class FinancialFormPanel extends JPanel {
	private JButton todayBtn, dailyBtn, weeklyBtn, monthlyBtn, submitBtn;
	private JComboBox dayList, weekList, monthList;
	private JLabel dayLabel, weekLabel, monthLabel;
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
		dailyBtn = new JButton("Daily sales");
		weeklyBtn = new JButton("Weekly sales");
		monthlyBtn = new JButton("Monthly sales");

		todayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.todaySaleSelected();
			}
		});

		dailyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.dailySaleSelected();
			}
		});

		weeklyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.weeklySaleSelected();
			}
		});

		monthlyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.monthlySaleSelected();
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

	public void chooseDayPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		dayLabel = new JLabel("Day: ");
		weekLabel = new JLabel("Week: ");
		monthLabel = new JLabel("Month: ");

		dayList = new JComboBox();
		weekList = new JComboBox();
		monthList = new JComboBox();

		DefaultComboBoxModel dayModel = new DefaultComboBoxModel();
		dayModel.addElement("Monday");
		dayModel.addElement("Tuesday");
		dayModel.addElement("Wednesday");
		dayModel.addElement("Thursday");
		dayModel.addElement("Friday");
		dayModel.addElement("Saturday");
		dayModel.addElement("Sunday");
		dayList.setModel(dayModel);

		DefaultComboBoxModel weekModel = new DefaultComboBoxModel();
		weekModel.addElement("Week1");
		weekModel.addElement("Week2");
		weekModel.addElement("Week3");
		weekModel.addElement("Week4");
		weekList.setModel(weekModel);

		DefaultComboBoxModel monthModel = new DefaultComboBoxModel();
		monthModel.addElement("January");
		monthModel.addElement("February");
		monthModel.addElement("March");
		monthModel.addElement("April");
		monthModel.addElement("May");
		monthModel.addElement("June");
		monthModel.addElement("July");
		monthModel.addElement("August");
		monthModel.addElement("October");
		monthModel.addElement("September");
		monthModel.addElement("November");
		monthModel.addElement("December");
		monthList.setModel(monthModel);

		submitBtn = new JButton("Submit");

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String day = (String) dayList.getSelectedItem();
				String week = (String) weekList.getSelectedItem();
				String month = (String) monthList.getSelectedItem();
				listener.dailySaleSelected();
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
		gc.weighty = .1;

		gc.gridx = 0;
		gc.fill = GridBagConstraints.NONE;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(monthLabel, gc);

		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(monthList, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(weekLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(weekList, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = .1;

		gc.gridx = 0;
		gc.anchor = GridBagConstraints.LINE_END;
		gc.insets = new Insets(0, 0, 0, 5);
		add(dayLabel, gc);

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		gc.insets = new Insets(0, 0, 0, 0);
		add(dayLabel, gc);

		// /////// Fourth row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 2;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(submitBtn, gc);
	}
}