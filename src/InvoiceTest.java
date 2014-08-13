import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class InvoiceTest {
	//TODO

	ArrayList<Stock> stocks = new ArrayList<Stock>();
	Invoice invoice;
	Stock s1 = new Stock("apple", .20, .40, 10);
	
	@Before
	public void setUp() throws Exception {
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
