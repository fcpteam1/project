import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Invoice {

	private int id;
	private Date date = new Date();
	private DateFormat format = DateFormat.getDateInstance();
	private ArrayList<Product> products = new ArrayList<Product>();
	private double totalPrice;
	
	public Invoice(){
		this.id = 0;
		this.totalPrice = 0;
	}
	
	public Invoice(int id, ArrayList<Product> products){
		this.id = id;
		this.products = products;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
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
}
