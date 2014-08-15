import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StockTest {

	Stock stock; 

	@Before
	public void setUp() throws Exception {
		stock = new Stock("apple", 0.50, 10);
	}

	@Test
	public void testGetCustomerPrice(){
		assertEquals(0.50, stock.getCustomerPrice(), 0.0);
	}
	
	@Test
	public void testSetCustomerPrice(){
		stock.setCustomerPrice(.80);
		assertEquals(0.80, stock.getCustomerPrice(), 0.0);		
	}
	
	@Test
	public void testGetQuantity() {
		assertEquals(10, stock.getQuantity());
	}

	@Test
	public void testSetQuantity() {
		stock.setQuantity(50);
		assertEquals(50,stock.getQuantity());
	}
	
	@Test
	public void testGetName(){
		assertEquals("apple", stock.getName());
	}
	@Test
	public void testSetName(){
		stock.setName("banana");
		assertEquals("banana", stock.getName());
	}
	
	@Test
	public void testGetSupplierPrice(){
		assertEquals(0.50, stock.getSupplierPrice(), 0.0);
	}
	
	@Test
	public void testSetSupplierPrice(){
		stock.setSupplierPrice(0.20);
		assertEquals(0.20, stock.getSupplierPrice(), 0.0);
	}
	
}
