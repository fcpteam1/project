import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class InvoiceTest {
	//TODO
	Invoice invoice;
	
	@Before
	public void setUp() throws Exception {
		invoice = new Invoice();
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
}
