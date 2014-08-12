import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	Product product = new Product("Apple", .50, 2.00, 232);

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetCustomerPrice() {
		assertEquals(.50, product.getCustomerPrice(), 00.00);
	}

	@Test
	public void testSetCustomerPrice() {
		product.setCustomerPrice(2.50);
		assertEquals(2.50, product.getCustomerPrice(), 00.00);
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

	@Test
	public void testGetId() {
		assertEquals(232, product.getId());
	}

	@Test
	public void testSetId() {
		product.setId(222);
		assertEquals(222, product.getId());

	}

}
