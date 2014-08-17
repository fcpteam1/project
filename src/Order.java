import java.util.ArrayList;

public class Order extends Invoice{

	private Supplier supplier; 
	private int id;
	private ArrayList<Product> products = new ArrayList<Product>();
	boolean current;
	
	public Order(){
		super();
		this.id = 0;
	}
	
	public Order(int id, ArrayList<Product> products, Supplier supplier) {
		super();
		this.id = id;
		this.supplier = supplier;
		current = true;
		calculatePrice();
	}
	
	public void calculatePrice(){
		double price = 0;
		//TODO - Loop to find cheapest price in list of suppliers
		for(Product product: products){
			price += product.getSupplierPrice() * product.getQuantity();
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

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
}
