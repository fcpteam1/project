import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class InvoiceTest {

	ArrayList<Product> products = new ArrayList<Product>();
	Invoice invoice;
	
	@Before
	public void setUp() throws Exception {
		Product p1 = new Product("Apple", 50, 25, 1);
		Product p2 = new Product("Apple", 50, 25, 1);
		Product p3 = new Product("Banana", 40, 20, 2);
		products.add(p1);
		products.add(p2);
		products.add(p3);
		invoice = new Invoice(1, products);
	}
	
	@Test
	public void testGetTotalPrice() {
		assertEquals(0, invoice.getTotalPrice(), 0.0);
	}
	
	@Test
	public void testGetProducts() {
		assertEquals(products, invoice.getProducts());
	}
	
	@Test
	public void testGetId(){
		assertEquals(1, invoice.getId());
	}

}
