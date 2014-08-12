import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Stock {
	
	private Product product;
	private int quantity;
	private Date date;
	private static boolean inStock= false;
	
	public Stock() {
		this.product = new Product();
		this.quantity = 0;
	}

	public Stock(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
		DateFormat df= new SimpleDateFormat ("dd/MM/yyyy");
		this.date= new Date();
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
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

	public static void checkSellBy (ArrayList <Stock> stocks)
	{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();

		long diff;
		long diffDays; 

		for (Stock temp:stocks)
		{
			diff= Math.abs(temp.getDate().getTime() - date.getTime());
			diffDays= diff / (24 * 60 * 60 * 1000);
			if (diffDays>=3)
			{
				stocks.remove(temp);
			}
		}
	}

	public static void stockLevels (ArrayList <Stock> stocks, int id)
	{
		String product= null;
		int productQuantity=0;

		if (id==0)
		{
			System.out.println ("Stock List"+
							"\n****************************");
		}
		
		boolean idFound= false;

		for (Stock temp: stocks)
		{
			if (temp.getProduct().getId()==id)
			{
				product= temp.getProduct().getName();
				productQuantity+= temp.getQuantity();
				idFound=true;
			}
		}
		
		if (idFound)
		{
			System.out.println("Product: "+product + 
					"  Quantity: "+ productQuantity +"\n");
			id++;
			stockLevels(stocks, id);
		}
	
		if (id==0)
		{
			System.out.println("Out of Stock+\n****************************");
		}
		else if (id==1)
		{
			System.out.println ("\n****************************");
		}
	}

}
