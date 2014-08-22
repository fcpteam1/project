import static org.junit.Assert.*;

import java.util.ArrayList;

import model.Product;
import model.Supplier;

import org.junit.Before;
import org.junit.Test;


public class SupplierTest {

	Supplier supplier;
	ArrayList<Product> products = new ArrayList<Product>();
	Product p1 = new Product("Apple", 0.5);
	Product p2 = new Product("Banana", 0.4);
	Product p3 = new Product("Orange", 0.3);
	
	@Before
	public void setUp() throws Exception {
		products.add(p1);
		products.add(p2);
		products.add(p3);
		supplier = new Supplier("Shanes", 1, "0879876543", "Kildare", products);
	}

	@Test
	public void testGetName() {
		assertEquals("Shanes", supplier.getName());
	}

	@Test
	public void testSetName() {
		supplier.setName("Nialls");
		assertEquals("Nialls", supplier.getName());
	}

	@Test
	public void testGetNumber() {
		assertEquals("0879876543", supplier.getNumber());
	}

	@Test
	public void testSetNumber() {
		supplier.setNumber("0871234567");
		assertEquals("0871234567", supplier.getNumber());
	}

	@Test
	public void testGetAddress() {
		assertEquals("Kildare", supplier.getAddress());
	}

	@Test
	public void testSetAddress() {
		supplier.setAddress("Dublin");
		assertEquals("Dublin", supplier.getAddress());
	}
	@Test
	public void testGetId() {
		assertEquals(1, supplier.getId());
	}

	@Test
	public void testSetId() {
		supplier.setId(2);
		assertEquals(2, supplier.getId());
	}
	@Test
	public void testGetProducts() {
		assertEquals(products, supplier.getProducts());
	}

	@Test
	public void testSetProducts() {
		products.remove(0);
		supplier.setProducts(products);
		assertEquals(products, supplier.getProducts());
	}

}
