package JUnit;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.example.banknote.model.User;

public class UserTest 
{
	User a;
	User b;
	User c;

	@Before
	public void setUp() throws Exception 
	{
		a = new User("Jonny","football");
		b = new User();
		c = new User();
	}

	@Test
	public void testGetName() 
	{
		String aName = a.getName();
		assertTrue(aName.equals("Jonny"));	
	}
	
	@Test
	public void testGetPassword()
	{
		String aPassword = a.getPassword();
		assertTrue(aPassword.equals("football"));
	}
	
	@Test
	public void testSetName()
	{
		b.setName("1234");
		assertTrue(b.getName().equals("1234"));
	}
	
	@Test
	public void setSetPassword()
	{
		b.setPassword("5678");
		assertTrue(b.getPassword().equals("5678"));
	}
}
