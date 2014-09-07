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

//Creating the FinacialFormPanel within this class there are multiple panels methods
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

	/*
	 * The SalesFormPanel is made up of 5 buttons as seen below each button will
	 * have different results.
	 */

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

		// Adding an action listener to the allBtn that when it
		// is clicked the allSales method is called within the financial
		// listener.
		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.allSales();
			}
		});

		// todayBtn calls todaySales
		todayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.todaysSales();
			}
		});
		// dailyBtn calls dailySales
		dailyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.dailySales();
			}
		});
		// WeeklyBtn calls weeklySales
		weeklyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.weeklySales();

			}
		});
		// monthlyBtn calls monthlySales
		monthlyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.monthlySales();
			}
		});

		// Setting the layout for the panel using gridbaglayout
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
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(monthlyBtn, gc);
	}

	// ////////////////////Expenditures////////////////////////

	// Same structure as SaleFormPanel
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
		gc.weighty = 100;

		gc.gridx = 1;
		gc.anchor = GridBagConstraints.FIRST_LINE_START;
		add(monthlyBtn, gc);
	}

	// ////////////////////Profit////////////////////////

	// Same structure as SaleFormPanel
	public void ProfitFormPanel() {
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);

		allBtn = new JButton("All Profit");
		todayBtn = new JButton("Todays Profit");
		dailyBtn = new JButton("Daily Profit");
		weeklyBtn = new JButton("Weekly Profit");
		monthlyBtn = new JButton("Monthly Profit");

		allBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.allProfits();
			}
		});

		todayBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.todaysProfits();
			}
		});

		dailyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.dailyProfits();
			}
		});

		weeklyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.weeklyProfits();

			}
		});

		monthlyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listener.monthlyProfits();
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

	// ////////////////////DailySale////////////////////////

	// The chooseDaySalePanel is a panel that will display 3 combo boxes
	// along with a submitbtn.
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

		// Within the dayList combo box we have added each day of the week
		DefaultComboBoxModel dayModel = new DefaultComboBoxModel();
		dayModel.addElement("Monday");
		dayModel.addElement("Tuesday");
		dayModel.addElement("Wednesday");
		dayModel.addElement("Thursday");
		dayModel.addElement("Friday");
		dayModel.addElement("Saturday");
		dayModel.addElement("Sunday");
		dayList.setModel(dayModel);

		// add week 1 to 4 in the weekList combo box
		DefaultComboBoxModel weekModel = new DefaultComboBoxModel();
		weekModel.addElement("Week1");
		weekModel.addElement("Week2");
		weekModel.addElement("Week3");
		weekModel.addElement("Week4");
		weekList.setModel(weekModel);

		// add all the months to the monthList combo box
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

		/*
		 * To find out the correct month and day we decided to use calendar
		 * instead of date. To get a sale,Expenditure or profit of a given day,
		 * week or month the choice choosen within the combo boxes had to
		 * converted to integers so that we could match them against calendar to
		 * get the date we wanted. This is what is happending here. When the
		 * submit button is pressed whatever is selected will be converted into
		 * a integer and stored within the day,week and month variables.
		 */
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

				FinancialFormEvent ev = new FinancialFormEvent(this, day, week,
						month);
				// If an event has occurred the values are passed to the method
				// called below
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

	// Same setup as before just that the option to choose the day is removed
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

				FinancialFormEvent ev = new FinancialFormEvent(this, week,
						month);

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

	// Same setup as before just that the option to choose the day and week is
	// removed
	// These methods are then copied and changed to for Expenditures and Profit
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

				FinancialFormEvent ev = new FinancialFormEvent(this, month);

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

				FinancialFormEvent ev = new FinancialFormEvent(this, day, week,
						month);

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

				FinancialFormEvent ev = new FinancialFormEvent(this, week,
						month);

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

				FinancialFormEvent ev = new FinancialFormEvent(this, month);

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

				FinancialFormEvent ev = new FinancialFormEvent(this, day, week,
						month);

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

				FinancialFormEvent ev = new FinancialFormEvent(this, week,
						month);

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

				FinancialFormEvent ev = new FinancialFormEvent(this, month);

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
