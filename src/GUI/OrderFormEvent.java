package GUI;

import java.util.ArrayList;
import java.util.EventObject;

import model.Product;
import model.Supplier;

public class OrderFormEvent extends EventObject {

	private Supplier supplier;
	private double totalPrice;
	private ArrayList<Product> products;

	public OrderFormEvent(Object source) {
		super(source);
	}

	public OrderFormEvent(Object source, Supplier supplier,
			ArrayList<Product> products) {
		super(source);
		this.supplier = supplier;
		this.products = products;
	}

	public OrderFormEvent(Object source, Supplier supplier) {
		super(source);
		this.supplier = supplier;
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
