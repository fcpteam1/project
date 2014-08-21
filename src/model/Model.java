package model;
import java.io.IOException;

public class Model {

	private Shop shop;
	private Stock stock;
	
	public Model() throws IOException {
		// TODO Auto-generated constructor stub
		shop=Shop.getInstance();
		
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
	
	public Stock getStock() {
		return stock;
	}

	
	

}