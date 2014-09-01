package GUI;

import java.util.EventObject;

public class FinancialFormEvent extends EventObject {
	private int day;
	private int week;
	private int month;

	public FinancialFormEvent(Object source) {
		super(source);
	}

	public FinancialFormEvent(Object source, int month) {
		super(source);

		this.month = month;
	}

	public FinancialFormEvent(Object source, int week, int month) {
		super(source);

		this.week = week;
		this.month = month;
	}

	public FinancialFormEvent(Object source, int day, int week, int month) {
		super(source);

		this.day = day;
		this.week = week;
		this.month = month;
	}

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
