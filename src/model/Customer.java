package model;

public class Customer {
	
	private static int count = 0;
	
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

	public Customer(String name,String number, String address) {
		this.name = name;
		this.id = count;
		this.number = number;
		this.address = address;
		
		count++;
	}
	
	public String toString() {
		return getName();
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

	public static int getCount() {
		return count;
	}

	public static void setCount(int count) {
		Customer.count = count;
	}
	

}
