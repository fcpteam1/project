import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Customer;
import model.Sale;
import model.Stock;

import org.junit.Before;
import org.junit.Test;



public class SaleTest {

	private ArrayList<Stock> stocks = new ArrayList<Stock>();
	private Sale sale;
	Stock s1 = new Stock("apple", .20, 10);
	Stock s2 = new Stock("banana", .15, 12);
	Stock s3 = new Stock("orange", .10, 20);
	Customer c1 = new Customer("Darren", 1, "0860547880", "Dublin");
	Customer c2 = new Customer("Shane", 2, "0877746283", "Kildare");
	
	@Before
	public void setUp() throws Exception {
		stocks.add(s1);
		stocks.add(s2);
		stocks.add(s3);
		sale = new Sale( stocks, c1);
	}

	@Test
	public void testGetCustomer() {
		assertEquals(c1, sale.getCustomer());
	}

	@Test
	public void testSetCustomer() {
		sale.setCustomer(c2);
		assertEquals(c2, sale.getCustomer());
	}

	@Test
	public void testGetId() {
		assertEquals(1, sale.getId());
	}

	@Test
	public void testSetId() {
		sale.setId(2);
		assertEquals(2, sale.getId());
	}

	@Test
	public void testGetStocks() {
		assertEquals(stocks, sale.getStocks());
	}

	@Test
	public void testSetStocks() {
		stocks.remove(0);
		sale.setStocks(stocks);
		assertEquals(stocks, sale.getStocks());
	}

	@Test
	public void testGetTotalPrice() {
		assertEquals(12.60, sale.getTotalPrice(), 0.0);
	}

	@Test
	public void testSetTotalPrice() {
		sale.setTotalPrice(20);
		assertEquals(20, sale.getTotalPrice(), 0.0);
	}

}
