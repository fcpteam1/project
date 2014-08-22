import static org.junit.Assert.*;
import model.Customer;

import org.junit.Before;
import org.junit.Test;

public class CustomerTest {
	Customer customer = new Customer("Shane Flynn", 1234, "087233222",
			"282 duncourt road");

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetName() {
		assertEquals("Shane Flynn", customer.getName());
	}

	@Test
	public void testSetName() {
		customer.setName("Darren Kane");
		assertEquals("Darren Kane", customer.getName());
	}

	@Test
	public void testGetId() {
		assertEquals(1234, customer.getId());
	}

	@Test
	public void testSetId() {
		customer.setId(5678);
		assertEquals(5678, customer.getId());
	}

	@Test
	public void testGetNumber() {
		assertEquals("087233222", customer.getNumber());
	}

	@Test
	public void testSetNumber() {
		customer.setNumber("086543210");
		assertEquals("086543210", customer.getNumber());
	}

	@Test
	public void testGetAddress() {
		assertEquals("282 duncourt road", customer.getAddress());
	}

	@Test
	public void testSetAddress() {
		customer.setAddress("286 duncourt road");
		assertEquals("286 duncourt road", customer.getAddress());
	}

}
