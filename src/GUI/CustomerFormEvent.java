package GUI;
import java.awt.event.ActionListener;
import java.util.EventObject;


public class CustomerFormEvent extends EventObject {
	
		private String name;
		private String number;
		private String address;

		public CustomerFormEvent(Object source) {
			super(source);
		}
		
		public CustomerFormEvent(Object source, String name, String number,String address) {
			super(source);
			
			this.name = name;
			this.number = number;
			this.address = address;
		}

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
	

