package GUI;
import java.util.EventObject;

import model.Stock;


public class SaleFormEvent extends EventObject{
	
	private int customerId;
	private Stock stockItem;

	
	public SaleFormEvent(Object source) {
		
		super(source);
	}
	
	public SaleFormEvent(Object source, int customerId) {
			
			super(source);
			this.customerId = customerId;
		}
	
	public SaleFormEvent(Object source, int customerId, Stock stockItem) {
		
		super(source);
		this.customerId = customerId;
		this.stockItem = stockItem;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

}
