import java.util.ArrayList;

public class Order extends Invoice{

	private Supplier supplier;
	
	public Order(){
		super();
		this.supplier = new Supplier();
	}
	
	public Order(int id, ArrayList<Product> products, Supplier supplier) {
		super(id, products);
		this.supplier = supplier;
		calculatePrice();
	}

	public void calculatePrice(){
		double price = 0;
		for(Product product: super.getProducts()){
			price += product.getSupplierPrice();
		}
		super.setTotalPrice(price);
	}
	
	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
