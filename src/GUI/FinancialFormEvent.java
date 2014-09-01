package GUI;

import java.util.EventObject;

public class FinancialFormEvent extends EventObject {
	private int day;
	private String week;
	private int month;

	public FinancialFormEvent(Object source) {
		super(source);
	}

	public FinancialFormEvent(Object source, int day, int month) {
		super(source);

		this.day = day;
		this.month = month;
	}

	public FinancialFormEvent(Object source, int month) {
		super(source);

		this.month = month;
	}

	public FinancialFormEvent(Object source, String week, int month) {
		super(source);

		this.week = week;
		this.month = month;
	}

	public FinancialFormEvent(Object source, int day, String week, int month) {
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

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}
}
