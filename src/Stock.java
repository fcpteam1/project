
public class Stock extends Product{
	
	private double customerPrice;
	private int quantity;
	
	public Stock() {
		super();
		this.customerPrice = 0;
		this.quantity = 0;
	}

	public Stock(String name, double supplierPrice, double customerPrice, int quantity) {
		super(name, supplierPrice);
		this.customerPrice = customerPrice;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCustomerPrice() {
		return customerPrice;
	}

	public void setCustomerPrice(double customerPrice) {
		this.customerPrice = customerPrice;
	}
	
}
