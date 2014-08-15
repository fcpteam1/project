import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private ArrayList<Stock> stocks = new ArrayList<Stock>();
	private Order order;
	Stock s1 = new Stock("apple", .20, .40, 10);
	Stock s2 = new Stock("banana", .15, .30, 12);
	Stock s3 = new Stock("orange", .10, .20, 20);
	Supplier sup1 = new Supplier();
	Supplier sup2 = new Supplier();
	
	@Before
	public void setUp() throws Exception {
		stocks.add(s1);
		stocks.add(s2);
		stocks.add(s3);
		order = new Order(1, stocks, sup1);
	}
	
	@Test
	public void testGetSupplier() {
		assertEquals(sup1, order.getSupplier());
	}

	@Test
	public void testSetSupplier() {
		order.setSupplier(sup2);
		assertEquals(sup2, order.getSupplier());
	}
	
	@Test
	public void testGetId() {
		assertEquals(1, order.getId());
	}

	@Test
	public void testSetId() {
		order.setId(7);
		assertEquals(7, order.getId());
	}
	
	@Test
	public void testGetStocks() {
		assertEquals(stocks, order.getStocks());
	}

	@Test
	public void testSetStocks() {
		stocks.remove(0);
		order.setStocks(stocks);
		assertEquals(stocks, order.getStocks());
	}
	
	@Test // Also tests calculatePrice()
	public void testGetTotalPrice() {
		assertEquals(5.8, order.getTotalPrice(), 0.0);
	}

	@Test
	public void testSetTotalPrice() {
		order.setTotalPrice(20);
		assertEquals(20, order.getTotalPrice(), 0.0);
	}
	
}
