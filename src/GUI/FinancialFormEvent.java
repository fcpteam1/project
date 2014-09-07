package GUI;

import java.util.EventObject;
//Within the FinancialFormEvent we are storing the day,week and month
//These values will later be used to determine what date we want 
//For our Sales, Expenditures and Profit

public class FinancialFormEvent extends EventObject {
	private int day;
	private int week;
	private int month;

	public FinancialFormEvent(Object source) {
		super(source);
	}

	// For the months only
	public FinancialFormEvent(Object source, int month) {
		super(source);

		this.month = month;
	}

	// Week and Month
	public FinancialFormEvent(Object source, int week, int month) {
		super(source);

		this.week = week;
		this.month = month;
	}

	// Day,Week and Month
	public FinancialFormEvent(Object source, int day, int week, int month) {
		super(source);

		this.day = day;
		this.week = week;
		this.month = month;
	}

	// Getter and setters for day,week and month
	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}
