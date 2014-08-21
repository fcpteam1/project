import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Product;
import model.Stock;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class StockTest 
{
	Product product= new Product ("Orange", .75,1.20, 1);
	private Stock stock = new Stock (product, 10);		

	@Before
	public void setUp() throws Exception {
	}	

		
	@Test
	public void testGetProduct()
	{
		assertEquals(product, stock.getProduct());
	}
	
	@Test
	public void testSetProduct()
	{
		Product product2= new Product ("Apple", 80, 1.40,2);
		stock.setProduct(product2);
		assertEquals(product2, stock.getProduct());
	}
	
	@Test
	public void testGetQuantity()
	{
		assertEquals(10, stock.getQuantity());
	}
	
	@Test
	public void testSetQuantity()
	{
		stock.setQuantity(20);
		assertEquals(20, stock.getQuantity());

	}
	
}
