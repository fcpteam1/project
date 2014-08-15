import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class OrderTest {

	private ArrayList<Product> products = new ArrayList<Product>();
	private Order order;
	Product p1 = new Product("apple", .20, 10);
	Product p2 = new Product("banana", .15, 12);
	Product p3 = new Product("orange", .10, 20);
	Supplier sup1 = new Supplier();
	Supplier sup2 = new Supplier();
	
	@Before
	public void setUp() throws Exception {
		products.add(p1);
		products.add(p2);
		products.add(p3);
		order = new Order(1, products, sup1);
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
	public void testGetProducts() {
		assertEquals(products, order.getProducts());
	}

	@Test
	public void testSetStocks() {
		products.remove(0);
		order.setProducts(products);
		assertEquals(products, order.getProducts());
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
