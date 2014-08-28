package model;
public class Product implements java.io.Serializable {

	private double supplierPrice,customerPrice;
	private String name;
	private int quantity;
	private int id;
	
	public Product() {
		this.name = "";
		this.supplierPrice = 0;
		this.quantity = 0;
		this.id = 0;
	}

	public Product(String name, double supplierPrice) {
		this.name = name;
		this.supplierPrice = supplierPrice;
		this.quantity = 0;
	}
	
	public Product(String name, double supplierPrice, int quantity) {
		this.name = name;
		this.supplierPrice = supplierPrice;
		this.quantity = quantity;
	}
	
	public Product(String name, double customerPrice, double supplierPrice, int id) {
		this.name = name;
		this.customerPrice = customerPrice;
		this.supplierPrice = supplierPrice;
		this.id = id;
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
