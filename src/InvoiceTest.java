import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class InvoiceTest {
	//TODO

	ArrayList<Stock> stocks = new ArrayList<Stock>();
	Invoice invoice;
	Stock s1 = new Stock("apple", .20, .40, 10);
	Stock s2 = new Stock("banana", .15, .30, 12);
	Stock s3 = new Stock("orange", .10, .20, 20);
	
	@Before
	public void setUp() throws Exception {
		stocks.add(s1);
		stocks.add(s2);
		stocks.add(s3);
		invoice = new Invoice(stocks);
	}
	
	@Test
	public void testGetTotalPrice() {
		assertEquals(0, invoice.getTotalPrice(), 0.0);
	}
	
	@Test
	public void testSetTotalPrice() {
		invoice.setTotalPrice(20);
		assertEquals(20, invoice.getTotalPrice(), 0.0);
	}
	
	@Test
	public void testGetStocks() {
		assertEquals(stocks, invoice.getStocks());
	}
	
	@Test
	public void testSetStocks() {
		stocks.remove(2);
		invoice.setStocks(stocks);
		assertEquals(stocks, invoice.getStocks());
	}
}
