import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	Product product = new Product("Apple", .50);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetSupplierPrice() {
		assertEquals(2.00, product.getSupplierPrice(), 00.00);
	}

	@Test
	public void testSetSupplierPrice() {
		product.setSupplierPrice(1.00);
		assertEquals(1.00, product.getSupplierPrice(), 00.00);
	}

	@Test
	public void testGetName() {
		assertEquals("Apple", product.getName());
	}

	@Test
	public void testSetName() {
		product.setName("Orange");
		assertEquals("Orange", product.getName());
	}
}
