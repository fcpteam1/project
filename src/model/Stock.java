package model;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Stock extends Product{

		
	private double customerPrice;
	private int quantity;
	private Date date = new Date();
	private DateFormat format = DateFormat.getDateInstance();
	private static boolean inStock= false;
	private Product product;
	
	public Stock() {
		super();
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

	public static void checkSellBy (ArrayList <Stock> stockList)
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

	public static void stockLevels (ArrayList <Stock> stockList)
	{
		Map<String, Integer> stockLevels = new HashMap<String, Integer>();
		
		for (int i= 0; i<stockList.size(); i++)
		{
			int quantity=0;
			for (int j= 0; j< stockList.size(); j++)
			{
				boolean inMap =stockLevels.containsKey(stockList.get(i).getName());
				if (inMap)
				{
					j=stockList.size();
				}
				else if (stockList.get(i).getName().equals((stockList.get(j).getName())))
				{
					quantity+=stockList.get(j).getQuantity();
				}
				
				if (!inMap && !(j+1< stockLevels.size()))
				{
					stockLevels.put(stockList.get(i).getName(), quantity);
				}		
			}
		}
		
		System.out.println("Stock Levels\n*********************************");
		for(Map.Entry<String, Integer > current : stockLevels.entrySet()) 
		{
		    System.out.println(current.getKey()+": "+ current.getValue());
		}
		System.out.println("\n*********************************");

	}

	public static boolean processSale (ArrayList <Stock> stocks, Product product, int quantity, int index)
	{
		for (int i =index; i< stocks.size(); i++)
		{
			if (stocks.get(i).getProduct().getId()==product.getId())
			{
				if (stocks.get(i).getQuantity()>quantity)
				{
					stocks.get(i).setQuantity(stocks.get(i).getQuantity()-quantity);
					inStock= true;
					i=stocks.size();
				}
				else if (stocks.get(i).getQuantity()==quantity)
				{
					stocks.remove(stocks.get(i));
					inStock= true;
					i=stocks.size();

				}
				else
				{
					quantity-= stocks.get(i).getQuantity();
					stocks.remove(stocks.get(i));
					processSale(stocks, product, quantity, i);
				}
			}
		}
		return inStock;
	}

	


	public static void stockLevels (ArrayList <Stock> stocks, ArrayList <Product> products)
	{
		System.out.println("Stock Levels\n*********************************");
		for (int i= 0; i<products.size(); i++)
		{
			int quantity=0;
			for (int j= 0; j< stocks.size(); j++)
			{
				if (products.get(i).getId()== stocks.get(j).getProduct().getId())
				{
					quantity++;
				}
			}
			
			if(quantity>0)
			{
				System.out.println("\nProduct: "+products.get(i).getName()+
									" "+ quantity);
			}
		}
		System.out.println("\n*********************************");
	}

	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	
}
