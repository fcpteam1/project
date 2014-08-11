import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Invoice {

	private int id;
	private Date date = new Date();
	private DateFormat format = DateFormat.getDateInstance();
	private Customer customer;
	private Supplier supplier;
	private ArrayList<Product> products = new ArrayList<Product>();
	private double totalPrice;
	
	public Invoice(){
		this.id = 0;
		this.customer = new Customer();
		this.totalPrice = 0;
	}
	
	//Customer Invoice
	public Invoice(int id, Customer customer, ArrayList<Product> products){
		this.id = id;
		this.customer = customer;
		this.products = products;
		this.totalPrice = customerPrice(products);
	}
	
	//Supplier Invoice
	public Invoice(int id, Supplier supplier, ArrayList<Product> products){
		this.id = id;
		this.supplier = supplier;
		this.products = products;
		this.totalPrice = supplierPrice(products);
	}
	
	public double customerPrice(ArrayList<Product> products){
		//TO-DO
		double price = products.get(0).getCustomerPrice();
		return price;
	}
	
	public double supplierPrice(ArrayList<Product> products){
		//TO-DO
		double price = products.get(0).getSupplierPrice();
		return price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
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
