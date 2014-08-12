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
		calculatePrice();
	}

	public void calculatePrice(){
		double price = 0;
		for(Product product: super.getProducts()){
			price += product.getCustomerPrice();
		}
		super.setTotalPrice(price);
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
