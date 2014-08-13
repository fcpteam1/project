import static org.junit.Assert.*;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private ArrayList<Product> products = new ArrayList<Product>();
	private Order order;
	private Supplier supplier;
	@Before
	public void setUp() throws Exception {
		Product p1 = new Product("Apple", 50, 25, 1);
		Product p2 = new Product("Apple", 50, 25, 1);
		Product p3 = new Product("Banana", 40, 20, 2);
		products.add(p1);
		products.add(p2);
		products.add(p3);
		supplier = new Supplier("Grogans", 1, products);
		order = new Order(1, products, supplier);
	}
	
	@Test
	public void testGetSupplier() {
		assertEquals(supplier, order.getSupplier());
	}

	@Test
	public void testSetSupplier() {
		assertEquals(supplier, order.getSupplier());
	}
	
	@Test
	public void testGetId() {
		assertEquals(1, order.getId());
	}

	@Test
	public void testSetId() {
		assertEquals(1, order.getId());
	}
	
	@Test
	public void testGetProducts() {
		assertEquals(products, order.getProducts());
	}

	@Test
	public void testSetProducts() {
		assertEquals(products, order.getProducts());
	}
	
	@Test
	public void testGetTotalPrice() {
		assertEquals(70, order.getTotalPrice(), 0.0);
	}

	@Test
	public void testSetTotalPrice() {
		assertEquals(70, order.getTotalPrice(), 0.0);
	}
	
	@Test
	public void testCalculatePrice(){
		
	}
	
}
