package GUI;

public interface StockFormListener {
	public void editPriceOccurred(StockFormEvent ev);
	public void predictWeekOccurredd();
	public void predictMonthOccurredd();
	public void viewCurrentLowStock();
	public void viewWeekLowStock();
	public void viewMonthLowStock();
}
