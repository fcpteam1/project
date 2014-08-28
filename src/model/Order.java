package model;
import java.util.ArrayList;

public class Order extends Invoice implements java.io.Serializable{

	private static int count = 0;
	private Supplier supplier; 
	private int id;
	private ArrayList<Product> products = new ArrayList<Product>();
	boolean current;
	

	public Order(){
		super();
		this.id = 0;
	}
	
	
	public Order(ArrayList<Product> products, Supplier supplier) {
		super();
		this.id = count;
		this.supplier = supplier;
		this.products = products;
		current = true;
		calculatePrice();
		count++;
	}
	
	public void calculatePrice(){
		double price = 0;
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
