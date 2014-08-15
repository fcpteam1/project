import java.util.ArrayList;

public class Sale extends Invoice{

	private Customer customer;
	private int id;
	
	public Sale(){
		super();
		this.customer = new Customer();
		this.id = 0;
	}
	
	public Sale(int id, ArrayList<Stock> stocks, Customer customer) {
		super(stocks);
		this.id = id;
		this.customer = customer;
		calculatePrice();
	}

	public void calculatePrice(){
		double price = 0;
		for(Stock stock: super.getStocks()){
			price += stock.getCustomerPrice() * stock.getQuantity();
		}
		super.setTotalPrice(price);
	}
	
	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
