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


}
