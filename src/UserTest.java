import static org.junit.Assert.*;
import model.User;

import org.junit.Before;
import org.junit.Test;


public class UserTest {
	User user = new User("flynnshane26","obliterated", true);
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetUsername() {
		assertEquals("flynnshane26", user.getUsername());
	}

	@Test
	public void testSetUsername() {
		user.setUsername("ChokeSlam31");
		assertEquals("ChokeSlam31", user.getUsername());
	}

	@Test
	public void testGetPassword() {
		assertEquals("obliterated", user.getPassword());
	}

	@Test
	public void testSetPassword() {
		user.setPassword("Password");
		assertEquals("Password", user.getPassword());
	}

	@Test
	public void testGetId() {
		assertEquals(2134, user.getId());
	}

	@Test
	public void testIsAdmin() {
		assertEquals(true,user.isAdmin());
	}

	@Test
	public void testSetAdmin() {
		user.setAdmin(false);
		assertEquals(false,user.isAdmin());
	}

}
