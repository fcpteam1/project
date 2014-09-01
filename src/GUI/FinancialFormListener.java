package GUI;

public interface FinancialFormListener {

	public void allSales();

	public void todaysSales();
	
	public void dailySales();
	
	public void weeklySales();

	public void monthlySales();

	public void allExpenses();

	public void todaysExpenses();
	
	public void dailyExpenses();

	public void weeklyExpenses();

	public void monthlyExpenses();

	public void allProfits();

	public void todaysProfits();
	
	public void dailyProfits();

	public void weeklyProfits();

	public void monthlyProfits();

	public void saleMonthSelected(FinancialFormEvent ev);

	public void saleWeekSelected(FinancialFormEvent ev);

	public void saleDaySelected(FinancialFormEvent ev);
	
	public void expenseMonthSelected(FinancialFormEvent ev);

	public void expenseWeekSelected(FinancialFormEvent ev);

	public void expenseDaySelected(FinancialFormEvent ev);
	
	public void profitMonthSelected(FinancialFormEvent ev);

	public void profitWeekSelected(FinancialFormEvent ev);

	public void profitDaySelected(FinancialFormEvent ev);
}
