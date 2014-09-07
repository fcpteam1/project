package GUI;

import java.util.ArrayList;
import java.util.EventObject;

import model.Product;
import model.Supplier;
//The event associated with the order forms
public class OrderFormEvent extends EventObject {
	//supplier object set in the forms
	private Supplier supplier;
	//the totalprice of an order set in order form
	private double totalPrice;
	//list of products set in the edit order form
	private ArrayList<Product> products;

	//standard constructor
	public OrderFormEvent(Object source) {
		super(source);
	}

	//constructor used from the form panel
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

	//getters and setters for values
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
