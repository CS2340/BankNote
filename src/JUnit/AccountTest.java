
package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.example.banknote.model.Account;

/**
 * @author jacksonkmillsaps
 *
 */
public class AccountTest {

	Account a;
	Account b;
	Account c;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception 
	{
		a = new Account();
		b = new Account("Franklin", "Frank", 100, 2.5);
		c = new Account();
		
	}

	/**
	 * Test method for {@link com.example.banknote.model.Account#Account(java.lang.String, java.lang.String, double, double)}.
	 */
	@Test
	public void testAccount() 
	{
		
	}

	/**
	 * Test method for {@link com.example.banknote.model.Account#setFullName(java.lang.String)}.
	 */
	@Test
	public void testSetFullName() 
	{
		a.setFullName("Wilson");
		c.setFullName("Peter");
	}

	/**
	 * Test method for {@link com.example.banknote.model.Account#setDisplayName(java.lang.String)}.
	 */
	@Test
	public void testSetDisplayName() 
	{
		a.setDisplayName("Will");
	}

	/**
	 * Test method for {@link com.example.banknote.model.Account#setBalance(double)}.
	 */
	@Test
	public void testSetBalance() 
	{
		a.setBalance(50);
	}

	/**
	 * Test method for {@link com.example.banknote.model.Account#setInterestRate(double)}.
	 */
	@Test
	public void testSetInterestRate() 
	{
		a.setInterestRate(4.4);
	}

	/**
	 * Test method for {@link com.example.banknote.model.Account#getFullName()}.
	 */
	@Test
	public void testGetFullName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.example.banknote.model.Account#getDisplayName()}.
	 */
	@Test
	public void testGetDisplayName() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.example.banknote.model.Account#getBalance()}.
	 */
	@Test
	public void testGetBalance() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.example.banknote.model.Account#getInterestRate()}.
	 */
	@Test
	public void testGetInterestRate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.example.banknote.model.Account#compareTo(com.example.banknote.model.Account)}.
	 */
	@Test
	public void testCompareTo() {
		fail("Not yet implemented");
	}

}
