package GUI;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;

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

	private JButton allBtn, todayBtn, dailyBtn, weeklyBtn, monthlyBtn,
			submitBtn;
	private JComboBox dayList, weekList, monthList;
	private JLabel dayLabel, weekLabel, monthLabel;
	private Model model;
	private FinancialFormListener listener;
	private Calendar cal;
	private int day, week, month;

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

		allBtn = new JButton("All Sales");
		todayBtn = new JButton("Todays Sales");
		dailyBtn = new JButton("Daily Sales");
		weeklyBtn = new JButton("Weekly Sales");
		monthlyBtn = new JButton("Monthly Sales");

		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.allSales();
			}
		});

		todayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.todaysSales();
			}
		});

		dailyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.dailySales();
			}
		});

		weeklyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.weeklySales();

			}
		});

		monthlyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.monthlySales();
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
		add(allBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(todayBtn, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(dailyBtn, gc);

		// /////// Fourth row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(weeklyBtn, gc);

		// /////// Fifth row /////////

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

		allBtn = new JButton("All Expenses");
		todayBtn = new JButton("Todays Expenses");
		dailyBtn = new JButton("Daily Expenses");
		weeklyBtn = new JButton("Weekly Expenses");
		monthlyBtn = new JButton("Monthly Expenses");

		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.allExpenses();
			}
		});

		todayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.todaysExpenses();
			}
		});

		dailyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.dailyExpenses();
			}
		});

		weeklyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.weeklyExpenses();

			}
		});

		monthlyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.monthlyExpenses();
			}
		});

		Border innerBorder = BorderFactory.createTitledBorder("Expenses");
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
		add(allBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(todayBtn, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(dailyBtn, gc);

		// /////// Fourth row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(weeklyBtn, gc);

		// /////// Fifth row /////////

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

		allBtn = new JButton("All Profits");
		todayBtn = new JButton("Today's Profits");
		dailyBtn = new JButton("Daily Profits");
		weeklyBtn = new JButton("Weekly Profits");
		monthlyBtn = new JButton("Monthly Profits");

		Border innerBorder = BorderFactory.createTitledBorder("Sales");
		Border outerBorder = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

		setLayout(new GridBagLayout());

		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.allProfits();
			}
		});
		dailyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.dailyProfits();
			}
		});
		todayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listener.dailyProfits();
			}
		});
		weeklyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listener.weeklyProfits();
			}
		});
		monthlyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listener.monthlyProfits();
			}
		});

		GridBagConstraints gc = new GridBagConstraints();

		// /////// First row ////////

		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(allBtn, gc);

		// /////// Second row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(todayBtn, gc);

		// /////// Third row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(dailyBtn, gc);

		// /////// Fourth row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(weeklyBtn, gc);

		// /////// Fifth row /////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(monthlyBtn, gc);
	}

	// ////////////////////DailySale////////////////////////

	public void chooseDaySalePanel() {
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
		monthModel.addElement("September");
		monthModel.addElement("October");
		monthModel.addElement("November");
		monthModel.addElement("December");
		monthList.setModel(monthModel);

		submitBtn = new JButton("Submit");

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dayList.getSelectedItem() == ("Monday")) {
					day = cal.MONDAY;
				} else if (dayList.getSelectedItem() == ("Tuesday")) {
					day = cal.TUESDAY;
				} else if (dayList.getSelectedItem() == ("Wednesday")) {
					day = cal.WEDNESDAY;
				} else if (dayList.getSelectedItem() == ("Thursday")) {
					day = cal.THURSDAY;
				} else if (dayList.getSelectedItem() == ("Friday")) {
					day = cal.FRIDAY;
				} else if (dayList.getSelectedItem() == ("Saturday")) {
					day = cal.SATURDAY;
				} else if (dayList.getSelectedItem() == ("Sunday")) {
					day = cal.SUNDAY;
				}

				if (weekList.getSelectedItem() == ("Week1")) {
					week = 1;
				} else if (weekList.getSelectedItem() == ("Week2")) {
					week = 2;
				} else if (weekList.getSelectedItem() == ("Week3")) {
					week = 3;
				} else if (weekList.getSelectedItem() == ("Week4")) {
					week = 4;
				}

				if (monthList.getSelectedItem() == ("January")) {
					month = cal.JANUARY;
				} else if (monthList.getSelectedItem() == ("February")) {
					month = cal.FEBRUARY;
				} else if (monthList.getSelectedItem() == ("March")) {
					month = cal.MARCH;
				} else if (monthList.getSelectedItem() == ("April")) {
					month = cal.APRIL;
				} else if (monthList.getSelectedItem() == ("May")) {
					month = cal.MAY;
				} else if (monthList.getSelectedItem() == ("June")) {
					month = cal.JUNE;
				} else if (monthList.getSelectedItem() == ("July")) {
					month = cal.JULY;
				} else if (monthList.getSelectedItem() == ("August")) {
					month = cal.AUGUST;
				} else if (monthList.getSelectedItem() == ("September")) {
					month = cal.SEPTEMBER;
				} else if (monthList.getSelectedItem() == ("October")) {
					month = cal.OCTOBER;
				} else if (monthList.getSelectedItem() == ("November")) {
					month = cal.NOVEMBER;
				} else if (monthList.getSelectedItem() == ("December")) {
					month = cal.DECEMBER;
				}

				FinancialFormEvent ev = new FinancialFormEvent(this, day, week,month);

				if (listener != null) {
					listener.saleDaySelected(ev);
				}
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
		add(dayList, gc);

		// /////// Fourth row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(submitBtn, gc);
	}

	// ////////////////////WeeklySale////////////////////////

	public void chooseWeekSalePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		weekLabel = new JLabel("Week: ");
		monthLabel = new JLabel("Month: ");

		weekList = new JComboBox();
		monthList = new JComboBox();

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
		monthModel.addElement("September");
		monthModel.addElement("October");
		monthModel.addElement("November");
		monthModel.addElement("December");
		monthList.setModel(monthModel);

		submitBtn = new JButton("Submit");

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weekList.getSelectedItem() == ("Week1")) {
					week = 1;
				} else if (weekList.getSelectedItem() == ("Week2")) {
					week = 2;
				} else if (weekList.getSelectedItem() == ("Week3")) {
					week = 3;
				} else if (weekList.getSelectedItem() == ("Week4")) {
					week = 4;
				}

				if (monthList.getSelectedItem() == ("January")) {
					month = cal.JANUARY;
				} else if (monthList.getSelectedItem() == ("February")) {
					month = cal.FEBRUARY;
				} else if (monthList.getSelectedItem() == ("March")) {
					month = cal.MARCH;
				} else if (monthList.getSelectedItem() == ("April")) {
					month = cal.APRIL;
				} else if (monthList.getSelectedItem() == ("May")) {
					month = cal.MAY;
				} else if (monthList.getSelectedItem() == ("June")) {
					month = cal.JUNE;
				} else if (monthList.getSelectedItem() == ("July")) {
					month = cal.JULY;
				} else if (monthList.getSelectedItem() == ("August")) {
					month = cal.AUGUST;
				} else if (monthList.getSelectedItem() == ("September")) {
					month = cal.SEPTEMBER;
				} else if (monthList.getSelectedItem() == ("October")) {
					month = cal.OCTOBER;
				} else if (monthList.getSelectedItem() == ("November")) {
					month = cal.NOVEMBER;
				} else if (monthList.getSelectedItem() == ("December")) {
					month = cal.DECEMBER;
				}

				FinancialFormEvent ev = new FinancialFormEvent(this,week,month);

				if (listener != null) {
					listener.saleWeekSelected(ev);
				}
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
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(submitBtn, gc);
	}

	// ////////////////////MonthlySale////////////////////////

	public void chooseMonthSalePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		monthLabel = new JLabel("Month: ");

		monthList = new JComboBox();

		DefaultComboBoxModel monthModel = new DefaultComboBoxModel();
		monthModel.addElement("January");
		monthModel.addElement("February");
		monthModel.addElement("March");
		monthModel.addElement("April");
		monthModel.addElement("May");
		monthModel.addElement("June");
		monthModel.addElement("July");
		monthModel.addElement("August");
		monthModel.addElement("September");
		monthModel.addElement("October");
		monthModel.addElement("November");
		monthModel.addElement("December");
		monthList.setModel(monthModel);

		submitBtn = new JButton("Submit");

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (monthList.getSelectedItem() == ("January")) {
					month = cal.JANUARY;
				} else if (monthList.getSelectedItem() == ("February")) {
					month = cal.FEBRUARY;
				} else if (monthList.getSelectedItem() == ("March")) {
					month = cal.MARCH;
				} else if (monthList.getSelectedItem() == ("April")) {
					month = cal.APRIL;
				} else if (monthList.getSelectedItem() == ("May")) {
					month = cal.MAY;
				} else if (monthList.getSelectedItem() == ("June")) {
					month = cal.JUNE;
				} else if (monthList.getSelectedItem() == ("July")) {
					month = cal.JULY;
				} else if (monthList.getSelectedItem() == ("August")) {
					month = cal.AUGUST;
				} else if (monthList.getSelectedItem() == ("September")) {
					month = cal.SEPTEMBER;
				} else if (monthList.getSelectedItem() == ("October")) {
					month = cal.OCTOBER;
				} else if (monthList.getSelectedItem() == ("November")) {
					month = cal.NOVEMBER;
				} else if (monthList.getSelectedItem() == ("December")) {
					month = cal.DECEMBER;
				}

				FinancialFormEvent ev = new FinancialFormEvent(this,month);

				if (listener != null) {
					listener.saleMonthSelected(ev);
				}
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
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(submitBtn, gc);
	}

	// ////////////////////DailyExpense////////////////////////

	public void chooseDayExpensePanel() {
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
		monthModel.addElement("September");
		monthModel.addElement("October");
		monthModel.addElement("November");
		monthModel.addElement("December");
		monthList.setModel(monthModel);

		submitBtn = new JButton("Submit");
		
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dayList.getSelectedItem() == ("Monday")) {
					day = cal.MONDAY;
				} else if (dayList.getSelectedItem() == ("Tuesday")) {
					day = cal.TUESDAY;
				} else if (dayList.getSelectedItem() == ("Wednesday")) {
					day = cal.WEDNESDAY;
				} else if (dayList.getSelectedItem() == ("Thursday")) {
					day = cal.THURSDAY;
				} else if (dayList.getSelectedItem() == ("Friday")) {
					day = cal.FRIDAY;
				} else if (dayList.getSelectedItem() == ("Saturday")) {
					day = cal.SATURDAY;
				} else if (dayList.getSelectedItem() == ("Sunday")) {
					day = cal.SUNDAY;
				}

				if (weekList.getSelectedItem() == ("Week1")) {
					week = 1;
				} else if (weekList.getSelectedItem() == ("Week2")) {
					week = 2;
				} else if (weekList.getSelectedItem() == ("Week3")) {
					week = 3;
				} else if (weekList.getSelectedItem() == ("Week4")) {
					week = 4;
				}

				if (monthList.getSelectedItem() == ("January")) {
					month = cal.JANUARY;
				} else if (monthList.getSelectedItem() == ("February")) {
					month = cal.FEBRUARY;
				} else if (monthList.getSelectedItem() == ("March")) {
					month = cal.MARCH;
				} else if (monthList.getSelectedItem() == ("April")) {
					month = cal.APRIL;
				} else if (monthList.getSelectedItem() == ("May")) {
					month = cal.MAY;
				} else if (monthList.getSelectedItem() == ("June")) {
					month = cal.JUNE;
				} else if (monthList.getSelectedItem() == ("July")) {
					month = cal.JULY;
				} else if (monthList.getSelectedItem() == ("August")) {
					month = cal.AUGUST;
				} else if (monthList.getSelectedItem() == ("September")) {
					month = cal.SEPTEMBER;
				} else if (monthList.getSelectedItem() == ("October")) {
					month = cal.OCTOBER;
				} else if (monthList.getSelectedItem() == ("November")) {
					month = cal.NOVEMBER;
				} else if (monthList.getSelectedItem() == ("December")) {
					month = cal.DECEMBER;
				}

				FinancialFormEvent ev = new FinancialFormEvent(this, day, week,month);

				if (listener != null) {
					listener.expenseDaySelected(ev);
				}
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
		add(dayList, gc);

		// /////// Fourth row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(submitBtn, gc);
	}

	// ////////////////////WeeklyExpense////////////////////////

	public void chooseWeekExpensePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		weekLabel = new JLabel("Week: ");
		monthLabel = new JLabel("Month: ");

		weekList = new JComboBox();
		monthList = new JComboBox();

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
		monthModel.addElement("September");
		monthModel.addElement("October");
		monthModel.addElement("November");
		monthModel.addElement("December");
		monthList.setModel(monthModel);

		submitBtn = new JButton("Submit");
		
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weekList.getSelectedItem() == ("Week1")) {
					week = 1;
				} else if (weekList.getSelectedItem() == ("Week2")) {
					week = 2;
				} else if (weekList.getSelectedItem() == ("Week3")) {
					week = 3;
				} else if (weekList.getSelectedItem() == ("Week4")) {
					week = 4;
				}

				if (monthList.getSelectedItem() == ("January")) {
					month = cal.JANUARY;
				} else if (monthList.getSelectedItem() == ("February")) {
					month = cal.FEBRUARY;
				} else if (monthList.getSelectedItem() == ("March")) {
					month = cal.MARCH;
				} else if (monthList.getSelectedItem() == ("April")) {
					month = cal.APRIL;
				} else if (monthList.getSelectedItem() == ("May")) {
					month = cal.MAY;
				} else if (monthList.getSelectedItem() == ("June")) {
					month = cal.JUNE;
				} else if (monthList.getSelectedItem() == ("July")) {
					month = cal.JULY;
				} else if (monthList.getSelectedItem() == ("August")) {
					month = cal.AUGUST;
				} else if (monthList.getSelectedItem() == ("September")) {
					month = cal.SEPTEMBER;
				} else if (monthList.getSelectedItem() == ("October")) {
					month = cal.OCTOBER;
				} else if (monthList.getSelectedItem() == ("November")) {
					month = cal.NOVEMBER;
				} else if (monthList.getSelectedItem() == ("December")) {
					month = cal.DECEMBER;
				}

				FinancialFormEvent ev = new FinancialFormEvent(this,week,month);

				if (listener != null) {
					listener.expenseWeekSelected(ev);
				}
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
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(submitBtn, gc);
	}

	// ////////////////////MonthlyExpense////////////////////////

	public void chooseMonthExpensePanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		monthLabel = new JLabel("Month: ");

		monthList = new JComboBox();

		DefaultComboBoxModel monthModel = new DefaultComboBoxModel();
		monthModel.addElement("January");
		monthModel.addElement("February");
		monthModel.addElement("March");
		monthModel.addElement("April");
		monthModel.addElement("May");
		monthModel.addElement("June");
		monthModel.addElement("July");
		monthModel.addElement("August");
		monthModel.addElement("September");
		monthModel.addElement("October");
		monthModel.addElement("November");
		monthModel.addElement("December");
		monthList.setModel(monthModel);

		submitBtn = new JButton("Submit");
		
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (monthList.getSelectedItem() == ("January")) {
					month = cal.JANUARY;
				} else if (monthList.getSelectedItem() == ("February")) {
					month = cal.FEBRUARY;
				} else if (monthList.getSelectedItem() == ("March")) {
					month = cal.MARCH;
				} else if (monthList.getSelectedItem() == ("April")) {
					month = cal.APRIL;
				} else if (monthList.getSelectedItem() == ("May")) {
					month = cal.MAY;
				} else if (monthList.getSelectedItem() == ("June")) {
					month = cal.JUNE;
				} else if (monthList.getSelectedItem() == ("July")) {
					month = cal.JULY;
				} else if (monthList.getSelectedItem() == ("August")) {
					month = cal.AUGUST;
				} else if (monthList.getSelectedItem() == ("September")) {
					month = cal.SEPTEMBER;
				} else if (monthList.getSelectedItem() == ("October")) {
					month = cal.OCTOBER;
				} else if (monthList.getSelectedItem() == ("November")) {
					month = cal.NOVEMBER;
				} else if (monthList.getSelectedItem() == ("December")) {
					month = cal.DECEMBER;
				}

				FinancialFormEvent ev = new FinancialFormEvent(this,month);

				if (listener != null) {
					listener.expenseMonthSelected(ev);
				}
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
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(submitBtn, gc);
	}

	// ////////////////////DailyProfit////////////////////////

	public void chooseDayProfitPanel() {
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
		monthModel.addElement("September");
		monthModel.addElement("October");
		monthModel.addElement("November");
		monthModel.addElement("December");
		monthList.setModel(monthModel);

		submitBtn = new JButton("Submit");
		
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (dayList.getSelectedItem() == ("Monday")) {
					day = cal.MONDAY;
				} else if (dayList.getSelectedItem() == ("Tuesday")) {
					day = cal.TUESDAY;
				} else if (dayList.getSelectedItem() == ("Wednesday")) {
					day = cal.WEDNESDAY;
				} else if (dayList.getSelectedItem() == ("Thursday")) {
					day = cal.THURSDAY;
				} else if (dayList.getSelectedItem() == ("Friday")) {
					day = cal.FRIDAY;
				} else if (dayList.getSelectedItem() == ("Saturday")) {
					day = cal.SATURDAY;
				} else if (dayList.getSelectedItem() == ("Sunday")) {
					day = cal.SUNDAY;
				}

				if (weekList.getSelectedItem() == ("Week1")) {
					week = 1;
				} else if (weekList.getSelectedItem() == ("Week2")) {
					week = 2;
				} else if (weekList.getSelectedItem() == ("Week3")) {
					week = 3;
				} else if (weekList.getSelectedItem() == ("Week4")) {
					week = 4;
				}

				if (monthList.getSelectedItem() == ("January")) {
					month = cal.JANUARY;
				} else if (monthList.getSelectedItem() == ("February")) {
					month = cal.FEBRUARY;
				} else if (monthList.getSelectedItem() == ("March")) {
					month = cal.MARCH;
				} else if (monthList.getSelectedItem() == ("April")) {
					month = cal.APRIL;
				} else if (monthList.getSelectedItem() == ("May")) {
					month = cal.MAY;
				} else if (monthList.getSelectedItem() == ("June")) {
					month = cal.JUNE;
				} else if (monthList.getSelectedItem() == ("July")) {
					month = cal.JULY;
				} else if (monthList.getSelectedItem() == ("August")) {
					month = cal.AUGUST;
				} else if (monthList.getSelectedItem() == ("September")) {
					month = cal.SEPTEMBER;
				} else if (monthList.getSelectedItem() == ("October")) {
					month = cal.OCTOBER;
				} else if (monthList.getSelectedItem() == ("November")) {
					month = cal.NOVEMBER;
				} else if (monthList.getSelectedItem() == ("December")) {
					month = cal.DECEMBER;
				}

				FinancialFormEvent ev = new FinancialFormEvent(this, day, week,month);

				if (listener != null) {
					listener.profitDaySelected(ev);
				}
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
		add(dayList, gc);

		// /////// Fourth row ////////

		gc.gridy++;

		gc.weightx = 1;
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(submitBtn, gc);
	}

	// ////////////////////WeeklyProfit////////////////////////

	public void chooseWeekProfitPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		weekLabel = new JLabel("Week: ");
		monthLabel = new JLabel("Month: ");

		weekList = new JComboBox();
		monthList = new JComboBox();

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
		monthModel.addElement("September");
		monthModel.addElement("October");
		monthModel.addElement("November");
		monthModel.addElement("December");
		monthList.setModel(monthModel);

		submitBtn = new JButton("Submit");
		
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (weekList.getSelectedItem() == ("Week1")) {
					week = 1;
				} else if (weekList.getSelectedItem() == ("Week2")) {
					week = 2;
				} else if (weekList.getSelectedItem() == ("Week3")) {
					week = 3;
				} else if (weekList.getSelectedItem() == ("Week4")) {
					week = 4;
				}

				if (monthList.getSelectedItem() == ("January")) {
					month = cal.JANUARY;
				} else if (monthList.getSelectedItem() == ("February")) {
					month = cal.FEBRUARY;
				} else if (monthList.getSelectedItem() == ("March")) {
					month = cal.MARCH;
				} else if (monthList.getSelectedItem() == ("April")) {
					month = cal.APRIL;
				} else if (monthList.getSelectedItem() == ("May")) {
					month = cal.MAY;
				} else if (monthList.getSelectedItem() == ("June")) {
					month = cal.JUNE;
				} else if (monthList.getSelectedItem() == ("July")) {
					month = cal.JULY;
				} else if (monthList.getSelectedItem() == ("August")) {
					month = cal.AUGUST;
				} else if (monthList.getSelectedItem() == ("September")) {
					month = cal.SEPTEMBER;
				} else if (monthList.getSelectedItem() == ("October")) {
					month = cal.OCTOBER;
				} else if (monthList.getSelectedItem() == ("November")) {
					month = cal.NOVEMBER;
				} else if (monthList.getSelectedItem() == ("December")) {
					month = cal.DECEMBER;
				}

				FinancialFormEvent ev = new FinancialFormEvent(this,week,month);

				if (listener != null) {
					listener.saleWeekSelected(ev);
				}
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
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(submitBtn, gc);
	}

	// ////////////////////MonthlyProfit////////////////////////

	public void chooseMonthProfitPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		monthLabel = new JLabel("Month: ");

		monthList = new JComboBox();

		DefaultComboBoxModel monthModel = new DefaultComboBoxModel();
		monthModel.addElement("January");
		monthModel.addElement("February");
		monthModel.addElement("March");
		monthModel.addElement("April");
		monthModel.addElement("May");
		monthModel.addElement("June");
		monthModel.addElement("July");
		monthModel.addElement("August");
		monthModel.addElement("September");
		monthModel.addElement("October");
		monthModel.addElement("November");
		monthModel.addElement("December");
		monthList.setModel(monthModel);

		submitBtn = new JButton("Submit");

		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (monthList.getSelectedItem() == ("January")) {
					month = cal.JANUARY;
				} else if (monthList.getSelectedItem() == ("February")) {
					month = cal.FEBRUARY;
				} else if (monthList.getSelectedItem() == ("March")) {
					month = cal.MARCH;
				} else if (monthList.getSelectedItem() == ("April")) {
					month = cal.APRIL;
				} else if (monthList.getSelectedItem() == ("May")) {
					month = cal.MAY;
				} else if (monthList.getSelectedItem() == ("June")) {
					month = cal.JUNE;
				} else if (monthList.getSelectedItem() == ("July")) {
					month = cal.JULY;
				} else if (monthList.getSelectedItem() == ("August")) {
					month = cal.AUGUST;
				} else if (monthList.getSelectedItem() == ("September")) {
					month = cal.SEPTEMBER;
				} else if (monthList.getSelectedItem() == ("October")) {
					month = cal.OCTOBER;
				} else if (monthList.getSelectedItem() == ("November")) {
					month = cal.NOVEMBER;
				} else if (monthList.getSelectedItem() == ("December")) {
					month = cal.DECEMBER;
				}

				FinancialFormEvent ev = new FinancialFormEvent(this,month);

				if (listener != null) {
					listener.profitMonthSelected(ev);
				}
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
		gc.weighty = 1;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;

		add(submitBtn, gc);
	}

}
