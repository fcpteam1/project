import java.util.ArrayList;

public class Order extends Invoice{

	private Supplier supplier; 
	private int id;
	boolean current;
	
	public Order(){
		super();
		this.id = 0;
	}
	
	public Order(int id, ArrayList<Product> products, Supplier supplier) {
		super(products);
		this.id = id;
		this.supplier = supplier;
		current = true;
		calculatePrice();
	}
	
	public void calculatePrice(){
		double price = 0;
		//TODO - Loop to find cheapest price in list of suppliers
		for(Stock stock: super.getStocks()){
			price += stock.getSupplierPrice();
		}
		super.setTotalPrice(price);
	}

	

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public boolean isCurrent() {
		return current;
	}

	public void setCurrent(boolean current) {
		this.current = current;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
