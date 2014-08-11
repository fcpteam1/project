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
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

}
