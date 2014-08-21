package model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Stock extends Product {
	private static ArrayList<Stock> stockList;
	private Model stockModel;
	private double customerPrice;

	private int quantity;

	private Date date = new Date();
	private DateFormat format = DateFormat.getDateInstance();
	private static boolean inStock= false;
	private Product product;

	
	public Stock() {
		super();
		stockList = stockModel.getShop().getStock();
		this.customerPrice = 0;
		this.quantity = 0;
	}

	public Stock(String name, double supplierPrice, int quantity) {
		super(name, supplierPrice);
		this.customerPrice = calculatePrice();
	}
	
	
	public Stock(Product product, int quantity) {
		super (product.getName(), product.getId());
		this.product = product;
		DateFormat df= new SimpleDateFormat ("dd/MM/yyyy");
		this.date= new Date();

	}
	
	public Stock(String name, double supplierPrice, int quantity, double customerPrice) {
		super(name, supplierPrice);
		this.customerPrice = customerPrice;
		this.quantity = quantity;
		DateFormat df= new SimpleDateFormat ("dd/MM/yyyy");
		this.date= new Date();
	}

		
	public double calculatePrice(){
		double price = 0;
		if(super.getName().equals("apple")){
			price = 0.50;
		}
		else if(super.getName().equals("orange")){
			price = 0.20;
		}
		else if(super.getName().equals("banana")){
			price = 0.30;
		}
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getCustomerPrice() {
		return customerPrice;
	}

	public void setCustomerPrice(double customerPrice) {
		this.customerPrice = customerPrice;
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

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public static void checkStock(ArrayList <Stock> salesList, ArrayList <Stock> stockList, int quantity)
	{
		for (Stock temp: salesList)
		{
			if (!processSale(temp,stockList, quantity, 0))
			{
				System.out.println("Out of Stock Item: "+ temp.getName());
				//create an order
				//Order.makeOrder(temp, stockList, quantity);
			}
		}
	}

	public static boolean processSale (Stock sale, ArrayList <Stock> stockList, int quantity, int stockIndex)
	{
		boolean inStock=false;
		for (int i =stockIndex; i< stockList.size(); i++)
		{
			if (sale.getName().equals(stockList.get(i).getName()))
			{
				if (stockList.get(i).getQuantity()>quantity)
				{
					stockList.get(i).setQuantity(stockList.get(i).getQuantity()-quantity);
					inStock= true;
					i=stockList.size();
				}
				else if (stockList.get(i).getQuantity()==quantity)
				{
					stockList.remove(stockList.get(i));
					inStock= true;
					i=stockList.size();

				}
				else
				{
					quantity-= stockList.get(i).getQuantity();
					stockList.remove(stockList.get(i));
					processSale(sale, stockList, quantity, i);
				}
			}

		}
		return inStock;
	}

	public static void checkSellBy ()
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date current = new Date();

		long diff;
		long diffDays; 

		for (Stock temp: stockList)
		{
			diff= Math.abs(temp.getDate().getTime() - current.getTime());
			diffDays= diff / (24 * 60 * 60 * 1000);
			if (diffDays>=3)
			{
				stockList.remove(temp);
			}
		}
	}
	
	
	public static Map<String, Integer> stockLevels ()
	{
		Map<String, Integer> stockLevels = new HashMap<String, Integer>();
	
		for (int i= 0; i<stockList.size(); i++)
		{
			int quantity=0;
			for (int j= i; j<stockList.size(); j++)
			{
				boolean inMap =stockLevels.containsKey(stockList.get(i).getName());
				if(inMap && j==i)
				{
					j= stockList.size();
				}
				else if (stockList.get(i).getName().equals(stockList.get(j).getName()) )
				{
					quantity= quantity + stockList.get(j).getQuantity();
					stockLevels.put(stockList.get(i).getName(), quantity);
				}

			}
		}
		return stockLevels;
	}
	
}

