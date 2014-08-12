import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class SupplierTest {

	public ArrayList<Product>products= new ArrayList <Product>();
	Supplier supplier= new Supplier ("Fruits & Veg", 1, products);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetId()
	{
		assertEquals(1, supplier.getId());
	}

	@Test
	public void testGetName()
	{
		assertEquals("Fruits & Veg", supplier.getName());
	}
	
	@Test
	public void testGetProduct()
	{
		assertEquals(products, supplier.getProducts());
	}
	
	@Test
	public void testSetId()
	{
		supplier.setId(2);
		assertEquals(2, supplier.getId());
	}
	
	@Test
	public void testSetName()
	{
		supplier.setName("VeggieFruit");
		assertEquals("VeggieFruit", supplier.getName());
	}
	
}
