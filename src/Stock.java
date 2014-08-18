
public class Stock extends Product{
	
	private double customerPrice;
	private int quantity;
	
	public Stock() {
		super();
		this.customerPrice = 0;
		this.quantity = 0;
	}

	public Stock(String name, double supplierPrice, int quantity) {
		super(name, supplierPrice);
		this.customerPrice = calculatePrice();
	}
	
	public Stock(String name, double supplierPrice, int quantity, double customerPrice) {
		super(name, supplierPrice);
		this.customerPrice = customerPrice;
		this.quantity = quantity;
	}
	
	public double calculatePrice(){
		double price = 0;
			if(super.getName().equals("apple")){
			price = 0.50;
			}
			else if(super.getName().equals("orange")){
			price = 0.20;
			}
			else if(super.getName().equals("banana")){
			price = 0.30;
			}
			return price;
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
