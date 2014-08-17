import java.util.ArrayList;

public class Order extends Invoice{

	private ArrayList<Supplier> suppliers = new ArrayList<Supplier>();
	private int id;
	boolean current;
	
	public Order(){
		super();
		this.id = 0;
	}
	
	public Order(int id, ArrayList<Stock> stocks, ArrayList<Supplier> suppliers) {
		super(stocks);
		this.id = id;
		this.suppliers = suppliers;
		current = true;
		calculatePrice();
	}
	
	public void calculatePrice(){
		double price = 0;
		//TODO - Loop to find cheapest price in list of suppliers
		for(Stock stock: super.getStocks()){
			price += stock.getSupplierPrice();
		}
		super.setTotalPrice(price);
	}

	public ArrayList<Supplier> getSuppliers() {
		return suppliers;
	}

	public void setSuppliers(ArrayList<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
