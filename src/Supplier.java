import java.util.ArrayList;

public class Supplier {

	private String name;
	private String number;
	private int id;
	ArrayList<Product> products = new ArrayList<Product>();
	
	public Supplier(){
		this.name = "";
		this.id = 0;
	}
	
	public Supplier(String name, int id, ArrayList<Product> products){
		this.name = name;
		this.id = id;
		this.products = products;
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

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
}
