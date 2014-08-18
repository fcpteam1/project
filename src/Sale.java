import java.util.ArrayList;

public class Sale extends Invoice{

	private Customer customer;
	private int id;
	private ArrayList<Stock> stocks = new ArrayList<Stock>();
	
	public Sale(){
		super();
		this.customer = new Customer();
		this.id = 0;
	}
	
	public Sale(int id, ArrayList<Stock> stocks, Customer customer) {
		this.stocks = stocks;
		this.id = id;
		this.customer = customer;
		calculatePrice();
	}

	public void calculatePrice(){
		double price = 0;
		
		for(Stock stock: stocks){
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

	public ArrayList<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(ArrayList<Stock> stocks) {
		this.stocks = stocks;
	}

}
