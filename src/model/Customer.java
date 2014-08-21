package model;

public class Customer {
	
	private String name;
	private int id;
	private String number;
	private String address;
	
	public Customer() {
		this.name = "";
		this.id = 0;
		this.number = "";
		this.address = "";
	}

	public Customer(String name, int id, String number, String address) {
		this.name = name;
		this.id = id;
		this.number = number;
		this.address = address;
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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
