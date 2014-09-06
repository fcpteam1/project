package GUI;

import java.util.EventObject;
/*When a button is clicked the form listener tells the CustoemrFormEven panel that an
 * event has occurred within the customer form panel and the data is passed
 * to the CustomerFormEvent. This data will be passes to the shop class to create a
 * new customer.  
 */
public class CustomerFormEvent extends EventObject {

	private String name;
	private String number;
	private String address;

	public CustomerFormEvent(Object source) {
		super(source);
	}
	// The constructor takes in the customer name, number and address
	public CustomerFormEvent(Object source, String name, String number,
			String address) {
		super(source);

		this.name = name;
		this.number = number;
		this.address = address;
	}
	
	//Getters and setters for the name,number and address

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
