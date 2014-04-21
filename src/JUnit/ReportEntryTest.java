package JUnit;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.example.banknote.model.ReportEntry;

public class ReportEntryTest {

	ReportEntry r;
	String cat1;
	String cat2;
	
	
	
	@Before
	public void setUp() throws Exception 
	{
		cat1 = "cat1";
		cat2 = "cat2";
		r = new ReportEntry(cat1);
	}

	@Test
	public void testReportEntry() 
	{
		System.out.println(r);
	}

	@Test
	public void testGetCategory() 
	{
		System.out.println(r.getCategory());
		assertEquals(cat1, r.getCategory());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testGetAmount() {
		assertEquals(0, r.getAmount());
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testAddToAmount() {
		r.addToAmount(12.5);
		r.addToAmount(3);
		assertEquals(15.5, r.getAmount());
	}

	@Test
	public void testToString() 
	{
		r.addToAmount(12.5);
		r.addToAmount(3);
		System.out.println(r.toString());
	}

}
