package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Stock extends Product implements java.io.Serializable {

	private double customerPrice;
	private int quantity;
	private Date date = new Date();
	private DateFormat format = DateFormat.getDateInstance();
	private Product product;

	public Stock() {
		super();
		this.customerPrice = 0;
		this.quantity = 0;
	}

	public Stock(String name, double supplierPrice, int quantity) {
		super(name, supplierPrice);
		this.customerPrice = calculatePrice();
	}

	public Stock(Product product, int quantity) {

		super(product.getName(), product.getId());
		this.customerPrice = calculatePrice();
		this.quantity = quantity;
		this.product = product;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.date = new Date();

	}

	public Stock(String name, double supplierPrice, int quantity,
			double customerPrice) {
		super(name, supplierPrice);
		this.customerPrice = customerPrice;
		this.quantity = quantity;
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.date = new Date();
	}

	public double calculatePrice() {
		double price = 0;
		if (super.getName().equals("Apple")) {
			price = 0.80;
		} else if (super.getName().equals("Apples")) {
			price = 0.80;
		} else if (super.getName().equals("Orange")) {
			price = 0.30;
		} else if (super.getName().equals("Banana")) {
			price = 0.30;
		} else if (super.getName().equals("Avocado")) {
			price = 0.80;
		} else if (super.getName().equals("Melon")) {
			price = 1.00;
		} else if (super.getName().equals("Grapes")) {
			price = 0.90;
		} else if (super.getName().equals("Pear")) {
			price = 0.30;
		} else if (super.getName().equals("Pears")) {
			price = 0.30;
		} else if (super.getName().equals("Mango")) {
			price = 1.00;
		} else if (super.getName().equals("Plum")) {
			price = 0.60;
		} else if (super.getName().equals("Strawberries")) {
			price = 2.00;
		} else if (super.getName().equals("Raspberries")) {
			price = 2.00;
		} else if (super.getName().equals("Blueberries")) {
			price = 2.50;
		} else if (super.getName().equals("Mandarins")) {
			price = 0.20;
		}
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCustomerPrice() {
		return customerPrice;
	}

	public void setCustomerPrice(double customerPrice) {
		this.customerPrice = customerPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public DateFormat getFormat() {
		return format;
	}

	public void setFormat(DateFormat format) {
		this.format = format;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
