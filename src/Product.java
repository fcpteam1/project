public class Product {

	private double supplierPrice;
	private String name;
	private int quantity;
	
	public Product() {
		this.name = "";
		this.supplierPrice = 0;
	}

	public Product(String name, double supplierPrice) {
		this.name = name;
		this.supplierPrice = supplierPrice;
	}
	
	public Product(String name, double supplierPrice, int quantity) {
		this.name = name;
		this.supplierPrice = supplierPrice;
		this.quantity = quantity;
	}
	
	public double getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(double supplierPrice) {
		this.supplierPrice = supplierPrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
