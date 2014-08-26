
package GUI;
import java.util.ArrayList;
import java.util.EventObject;

import model.Customer;
import model.Stock;


public class SaleFormEvent extends EventObject{
	
	private Customer customer;
	private ArrayList<Stock> stockList;
	
	public SaleFormEvent(Object source) {
		
		super(source);
	}
	
	public SaleFormEvent(Object source, Customer customer) {
			
			super(source);
			this.customer = customer;
		}
	
	public SaleFormEvent(Object source, Customer customer, ArrayList<Stock> stockList) {
		
		super(source);
		this.customer = customer;
		this.stockList = stockList;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public ArrayList<Stock> getStockList() {
		return stockList;
	}

	public void setStockList(ArrayList<Stock> stockList) {
		this.stockList = stockList;
	}
	
}


