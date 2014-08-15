import java.util.ArrayList;

public class Order extends Invoice{

	private Supplier supplier;
	private int id;
	
	public Order(){
		super();
		this.supplier = new Supplier();
		this.id = 0;
	}
	
	public Order(int id, ArrayList<Stock> stocks, Supplier supplier) {
		super(stocks);
		this.supplier = supplier;
		this.id = id;
		calculatePrice();
	}
	
	/*
	//TODO Sprint 2 possibly
	public Supplier getCheapestSupplier(){
		Supplier cheapestSupplier = new Supplier();
		int i = 0;
		for(Stock stock: super.getStocks()){
			for(Supplier supplier: suppliers){
				if(stock.getName().equals(supplier.getProducts().get(i).getName()) 
					&& supplier.getProducts().get(i).getSupplierPrice()<cheapestSupplier.getProducts().get(i).getSupplierPrice());
					cheapestSupplier = supplier;
			}
		}
		return cheapestSupplier;
	}*/
	
	public void calculatePrice(){
		double price = 0;
		for(Stock stock: super.getStocks()){
			price += stock.getSupplierPrice() * stock.getQuantity();
		}
		super.setTotalPrice(price);
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
