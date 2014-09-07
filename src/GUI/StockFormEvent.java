package GUI;

import java.util.EventObject;

import model.Stock;

public class StockFormEvent extends EventObject {
	
	private String name;
	private double price;
	
	public StockFormEvent(Object source){
		super(source);
	}
	
	public StockFormEvent(Object source, String name, double price){
		super(source);
		this.name = name;
		this.price = price;
	}
	
	public StockFormEvent(Object source, String name){
		super(source);
		this.name = name;
	}

	public StockFormEvent(Object source, double price){
		super(source);
		this.price = price;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
