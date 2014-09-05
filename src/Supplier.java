import java.util.ArrayList;

public class Supplier {

	private String name;
	private int id;
	ArrayList<Stock> stocks = new ArrayList<Stock>();
	
	public Supplier(){
		this.name = "";
		this.id = 0;
	}
	
	public Supplier(String name, int id, ArrayList<Stock> stocks){
		this.name = name;
		this.id = id;
		this.stocks= stocks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name= name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Stock> getStocks() {
		return stocks;
	}

	public void setStocks(ArrayList<Stock> stockd) {
		this.stocks = stocks;
	}
	
	public boolean checkPrice (Stock stock, double minPrice)
	{
		boolean priceLess = false;
		for (Stock test:stocks)
		{
			if (test.getName().equals(stock.getName())&& 
					test.getSupplierPrice()<minPrice)
			{
				priceLess= true;
			}
		}
		return priceLess ;
		//main: Loop that goes through all suppliers checking their prices
		//if return true then suppier for product is set to that supplier
	}
}
