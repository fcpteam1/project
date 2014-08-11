
public class Product {

	private double customerPrice;
	private double supplierPrice;
	private String name;
	private int id;
	
	public Product() {
		this.name = "";
		this.supplierPrice = 0;
		this.customerPrice = 0;
		this.id = 0;
	}

	public Product(String name, double customerPrice, double supplierPrice, int id) {
		this.name = name;
		this.customerPrice = customerPrice;
		this.supplierPrice = supplierPrice;
		this.id = id;
	}
	
	public double getCustomerPrice() {
		return customerPrice;
	}

	public void setCustomerPrice(double customerPrice) {
		this.customerPrice = customerPrice;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


}
