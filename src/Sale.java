import java.util.ArrayList;


public class Sale extends Invoice{

	private Customer customer;
	
	public Sale(){
		super();
		this.customer = new Customer();
	}
	
	public Sale(int id, ArrayList<Product> products, Customer customer) {
		super(id, products);
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
