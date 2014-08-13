public class Product {

	private double supplierPrice;
	private String name;
	
	public Product() {
		this.name = "";
		this.supplierPrice = 0;
	}

	public Product(String name, double supplierPrice) {
		this.name = name;
		this.supplierPrice = supplierPrice;
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
}
