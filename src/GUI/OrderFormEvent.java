package GUI;
import java.util.ArrayList;
import java.util.EventObject;

import model.Product;
import model.Supplier;

public class OrderFormEvent extends EventObject {

	private int id;
	private Supplier supplier;
	private double totalPrice;
	private ArrayList<Product> products;
	
	public OrderFormEvent(Object source) {
		super(source);
	}
	
	public OrderFormEvent(Object source, int id, Supplier supplier, double totalPrice, ArrayList<Product> products) {
		super(source);
		this.id = id;
		this.supplier = supplier;
		this.totalPrice = totalPrice;
		this.products = products;
	}

	public OrderFormEvent(Object source, Supplier supplier) {
		super(source);
		this.supplier = supplier;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

}
