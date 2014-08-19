
public class Product {

	private double supplierPrice;
	private String name;
	
	public Product() {
		this.name = "";
		this.supplierPrice = 0;
	}

	public Product(String name,double customerPrice) {
		this.name = name;
		this.supplierPrice= customerPrice;
	}
	
	public double getSupplierPrice() {
		return supplierPrice;
	}

	public void setSupplierPrice(double customerPrice) {
		this.supplierPrice = customerPrice;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
